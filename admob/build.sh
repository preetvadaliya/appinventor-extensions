#!/bin/bash
# Builds the AdMob .aix files into out/ using an App Inventor source checkout.
# Usage: admob/build.sh <path to appinventor-sources>   (needs JDK 17 and ant)
set -euo pipefail

HERE="$(cd "$(dirname "$0")" && pwd)"
AI="$(cd "${1:?usage: build.sh <path to appinventor-sources>}" && pwd)/appinventor"
if [ ! -f "$AI/components/build.xml" ]; then
  echo "Not an appinventor-sources checkout: $1" >&2
  exit 1
fi
DEPS="$AI/build/components/deps"
LINK="$AI/components/src/de/preet/admob"

ls "$HERE"/lib/*.aar >/dev/null 2>&1 || "$HERE/fetch.sh"

# App Inventor only processes components that sit inside components/src.
mkdir -p "$(dirname "$LINK")"
ln -sfn "$HERE/src/de/preet/admob" "$LINK"
trap 'rm -f "$LINK"; rmdir "$AI/components/src/de/preet" "$AI/components/src/de" 2>/dev/null || true' EXIT

cd "$AI/components"
ant CommonConstants
mkdir -p "$DEPS"
cp "$HERE"/lib/*.aar "$HERE"/lib/*.jar "$DEPS"/

# The annotation processor loads OptionList enums with Class.forName, so they have to
# be compiled onto the classpath before the components that use them.
ENUMS="$(mktemp -d)"
javac -nowarn -d "$ENUMS" -cp "$AI/build/components/CommonConstants.jar" \
  $(grep -rl "implements OptionList" "$HERE/src")
jar cf "$DEPS/admob-optionlists.jar" -C "$ENUMS" .
rm -rf "$ENUMS"

ant extensions
mkdir -p "$HERE/out"
cp "$AI"/components/build/extensions/de.preet.admob.*.aix "$HERE/out/"
echo
ls -lh "$HERE"/out/*.aix
