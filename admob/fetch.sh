#!/bin/bash
# Fetches Google Mobile Ads SDK 24.4.0 and the dependencies App Inventor does not
# already ship into lib/. Google sunsets old SDK majors (a sunset version gets no fill
# at all); 24.x is supported until 2028-06-30.
#
# Skipped on purpose: everything in App Inventor's lib/android/support (a second copy
# collides at dex time), androidx.work with its room/sqlite/startup/tracing subtree
# (only used for offline ad buffering), and guava, which the standalone
# listenablefuture replaces.
set -euo pipefail
mkdir -p "$(dirname "$0")/lib"
cd "$(dirname "$0")/lib"

GOOGLE=https://dl.google.com/dl/android/maven2
CENTRAL=https://repo1.maven.org/maven2

# <local name>|<group path>|<artifact>|<version>|<packaging>
read -r -d '' ARTIFACTS <<'EOF' || true
admob-activity|androidx/activity|activity|1.0.0|aar
admob-browser|androidx/browser|browser|1.8.0|aar
admob-concurrent-futures|androidx/concurrent|concurrent-futures|1.1.0|jar
admob-core-ktx|androidx/core|core-ktx|1.8.0|aar
admob-ads-adservices|androidx/privacysandbox/ads|ads-adservices|1.0.0-beta05|aar
admob-ads-adservices-java|androidx/privacysandbox/ads|ads-adservices-java|1.0.0-beta05|aar
admob-savedstate|androidx/savedstate|savedstate|1.0.0|aar
admob-webkit|androidx/webkit|webkit|1.11.0-alpha02|aar
admob-play-services-ads|com/google/android/gms|play-services-ads|24.4.0|aar
admob-play-services-ads-api|com/google/android/gms|play-services-ads-api|24.4.0|aar
admob-play-services-ads-identifier|com/google/android/gms|play-services-ads-identifier|18.0.0|aar
admob-play-services-appset|com/google/android/gms|play-services-appset|16.0.1|aar
admob-play-services-base|com/google/android/gms|play-services-base|18.0.0|aar
admob-play-services-basement|com/google/android/gms|play-services-basement|18.4.0|aar
admob-play-services-measurement-base|com/google/android/gms|play-services-measurement-base|20.1.2|aar
admob-play-services-measurement-sdk-api|com/google/android/gms|play-services-measurement-sdk-api|20.1.2|aar
admob-play-services-tasks|com/google/android/gms|play-services-tasks|18.2.0|aar
admob-user-messaging-platform|com/google/android/ump|user-messaging-platform|3.2.0|aar
admob-listenablefuture|com/google/guava|listenablefuture|1.0|jar
admob-kotlin-stdlib|org/jetbrains/kotlin|kotlin-stdlib|1.8.21|jar
admob-kotlinx-coroutines-core-jvm|org/jetbrains/kotlinx|kotlinx-coroutines-core-jvm|1.7.1|jar
admob-annotations|org/jetbrains|annotations|23.0.0|jar
EOF

# Plain jars are rewrapped as AARs with these manifest packages. The extension build
# unzips every .jar library into the extension's own classes, so two AdMob extensions
# in one app would each carry Kotlin and fail to dex. AARs stay separate, and the build
# server keeps only one AAR per package.
# <local name>|<manifest package>
read -r -d '' WRAPPED <<'EOF' || true
admob-concurrent-futures|androidx.concurrent.futures
admob-listenablefuture|com.google.common.util.concurrent.listenablefuture
admob-kotlin-stdlib|org.jetbrains.kotlin.stdlib
admob-kotlinx-coroutines-core-jvm|org.jetbrains.kotlinx.coroutines
admob-annotations|org.jetbrains.annotations
EOF

count=0
while IFS='|' read -r name group artifact version packaging; do
  [ -z "${name:-}" ] && continue
  url="$GOOGLE/$group/$artifact/$version/$artifact-$version.$packaging"
  if ! curl -sfL --max-time 180 "$url" -o "$name.$packaging"; then
    url="$CENTRAL/$group/$artifact/$version/$artifact-$version.$packaging"
    if ! curl -sfL --max-time 180 "$url" -o "$name.$packaging"; then
      echo "  FAILED: $artifact $version" >&2
      exit 1
    fi
  fi
  printf '  %-46s %-16s %7s KB\n' "$artifact" "$version" "$(( $(wc -c < "$name.$packaging") / 1024 ))"
  count=$((count + 1))

  # javac needs every AAR's classes.jar on the classpath as <name>.jar.
  if [ "$packaging" = "aar" ]; then
    rm -rf ".unpack-$name"; mkdir -p ".unpack-$name"
    (cd ".unpack-$name" && unzip -o -q "../$name.aar" classes.jar 2>/dev/null) || true
    [ -f ".unpack-$name/classes.jar" ] && mv ".unpack-$name/classes.jar" "$name.jar"
    rm -rf ".unpack-$name"
  fi
done <<< "$ARTIFACTS"

while IFS='|' read -r name package; do
  [ -z "${name:-}" ] && continue
  rm -rf ".wrap-$name"; mkdir -p ".wrap-$name"
  cp "$name.jar" ".wrap-$name/classes.jar"
  cat > ".wrap-$name/AndroidManifest.xml" <<EOF
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="$package">
  <uses-sdk android:minSdkVersion="14" />
</manifest>
EOF
  rm -f "$name.aar"
  (cd ".wrap-$name" && zip -q -X "../$name.aar" AndroidManifest.xml classes.jar)
  rm -rf ".wrap-$name"
  echo "  wrapped $name.jar as $name.aar ($package)"
done <<< "$WRAPPED"

echo
echo "Fetched $count artifacts into $(pwd)"
