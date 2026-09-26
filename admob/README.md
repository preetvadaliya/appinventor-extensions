# AdMob extensions for MIT App Inventor

Free AdMob ads on Google Mobile Ads SDK **24.4.0** (supported until June 30, 2028).
Each ad format is its own extension and works alone or together with the others.

| Extension | Status |
|---|---|
| AdMobBanner | ready to test: [`de.preet.admob.banner.aix` and `AdMobBannerDemo.aia`](../admob-banner/) |
| Interstitial | planned |
| Rewarded | planned |

`AdMobBannerDemo.aia` is a ready-made project with the extension already in it. Import
it, build the APK, and use its buttons to try ShowIn, ShowAt, Visible and DestroyAd.

## Banner quick start

1. Import `de.preet.admob.banner.aix` and drag **AdMobBanner** onto the screen.
2. Add a HorizontalArrangement where the ad should go.
3. In the blocks editor:

```
when Screen1.Initialize
  call AdMobBanner1.LoadAd  size = BannerSize Adaptive
  call AdMobBanner1.ShowIn  arrangement = HorizontalArrangement1
```

The defaults are Google's test IDs, so this shows a test ad straight away. For real
ads, set **AppId** (the one with `~`) and **AdUnitId** (the one with `/`) in the
Designer, and put your phone in **TestDeviceIds** first: tapping your own real ads can
get the AdMob account suspended.

**Designer:** AppId, AdUnitId, ChildDirected.
**Blocks:** Visible, TestDeviceIds, IsLoaded, LoadAd, ShowIn, ShowAt, DestroyAd.
**Events:** AdLoaded, AdFailedToLoad, AdClicked, AdImpression, AdOpened, AdClosed.

## Things to know

- **Ads never work in the Companion.** It loads an extension's code but not its
  libraries, so build the app to test.
- The project's minimum Android version becomes 6.0 (API 23).
- Use the same AppId in every AdMob extension in one app.

## Building from source

You need a checkout of [appinventor-sources](https://github.com/mit-cml/appinventor-sources),
JDK 17 and ant. Then run:

```
admob/build.sh ../appinventor-sources
```

The script downloads the SDK into `admob/lib/` on first run (`fetch.sh`), links
`src/` into the App Inventor tree for the build, and writes the `.aix` files to
`admob/out/`. The App Inventor checkout needs no changes.

## Licence

MIT, see [LICENSE](../LICENSE). The Google Mobile Ads SDK is redistributed under its own
terms. AdMob and its logo are trademarks of Google LLC; this project is not affiliated
with or endorsed by Google.
