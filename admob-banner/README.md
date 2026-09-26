# AdMob Banner

Free AdMob banner ads for MIT App Inventor, on Google Mobile Ads SDK **24.4.0**
(supported until June 30, 2028).

| File | What it is |
|---|---|
| `de.preet.admob.banner.aix` | The extension |
| `AdMobBannerDemo.aia` | A ready-made project with the extension already in it. Import it, build the APK, and use its buttons to try ShowIn, ShowAt, Visible and DestroyAd. |

## Quick start

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

AdMob and its logo are trademarks of Google LLC; this project is not affiliated with or
endorsed by Google. The Google Mobile Ads SDK is redistributed under its own terms.
