# AdMob Interstitial

A free extension that shows **full-screen AdMob interstitial ads** in MIT App Inventor
apps, built on **Google Mobile Ads SDK 25.3.0**, which Google supports until June 30, 2028.

- **AppId is a normal Designer property.** No manifest editing and no extra
  "manifest extension": paste your App ID and build.
- **Works out of the box:** the defaults are Google's test IDs, so you see a test ad
  on the first build.
- **Three blocks:** `LoadAd` loads an ad in the background, `ShowAd` shows it at a
  break in your app, and `IsLoaded` tells you when it is ready.
- **Part of a set:** [Banner, Interstitial, Rewarded, App Open and Rewarded Interstitial](https://github.com/preetvadaliya/appinventor-extensions)
  are all free, and each works alone or together with the others.

| | |
|---|---|
| **Extension** | AdMobInterstitial |
| **Package** | `de.preet.admob.interstitial` |
| **Version** | 1.1 |
| **Google Mobile Ads SDK** | 25.3.0 |
| **Minimum Android** | 6.0 (API 23) |
| **Size** | 11.8 MB |

## Download

- Extension: [de.preet.admob.interstitial.aix](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/de.preet.admob.interstitial.aix)
- Sample project: [AdMobInterstitialDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/AdMobInterstitialDemo.aia)

---

## Designer properties

| Name | Description | Default |
|---|---|---|
| **AppId** | Your AdMob app ID from the AdMob console, the one with a `~`. Use the same value in every AdMob extension in the app. | `ca-app-pub-3940256099942544~3347511713` (Google test app ID) |
| **AdUnitId** | This interstitial's ad unit ID, the one with a `/`. The test default always fills and can't affect your account. | `ca-app-pub-3940256099942544/1033173712` (Google test interstitial) |
| **ChildDirected** | Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app. | Unchecked |

## Properties

| Name | Block | Description |
|---|---|---|
| **AppId** | <img src="images/prop-appid-set.png" alt="set AppId" width="308"><br><img src="images/prop-appid-get.png" alt="AppId" width="248"> | Your AdMob app ID. Changing it after the first ad has loaded has no effect, so set it in the Designer or before the first `LoadAd`. |
| **AdUnitId** | <img src="images/prop-adunitid-set.png" alt="set AdUnitId" width="325"><br><img src="images/prop-adunitid-get.png" alt="AdUnitId" width="266"> | This interstitial's ad unit ID. A change takes effect on the next `LoadAd`. |
| **ChildDirected** | <img src="images/prop-childdirected-set.png" alt="set ChildDirected" width="357"><br><img src="images/prop-childdirected-get.png" alt="ChildDirected" width="297"> | Tags every ad request as directed at children and limits ads to content rated G. Setting it to false makes it unspecified again. |
| **TestDeviceIds** | <img src="images/prop-testdeviceids-set.png" alt="set TestDeviceIds" width="360"><br><img src="images/prop-testdeviceids-get.png" alt="TestDeviceIds" width="301"> | A **list** of test device IDs. These devices get test ads even with your real IDs. Applies to every AdMob ad in the app. |

## Functions

| Name | Block | Description |
|---|---|---|
| **LoadAd** | <img src="images/method-loadad.png" alt="LoadAd" width="264"> | Loads an interstitial in the background. `AdLoaded` or `AdFailedToLoad` follows. Ignored while a load is already running. |
| **ShowAd** | <img src="images/method-showad.png" alt="ShowAd" width="269"> | Shows the loaded interstitial full screen. One loaded ad shows only once, so call `LoadAd` again in `AdDismissed`. With nothing loaded, `AdFailedToShow` fires with `Ad Not Ready`. |
| **IsLoaded** | <img src="images/method-isloaded.png" alt="IsLoaded" width="282"> | Returns true when an interstitial is loaded and ready to show. |

## Events

| Name | Block | Description |
|---|---|---|
| **AdLoaded** | <img src="images/event-adloaded.png" alt="AdLoaded" width="294"> | An interstitial loaded and is ready to show. |
| **AdFailedToLoad** | <img src="images/event-adfailedtoload.png" alt="AdFailedToLoad" width="333"> | An interstitial could not load.<br>`errorCode`: why, as text such as `No Fill` or `Network Error`<br>`message`: Google's explanation<br>No Fill just means no ad was available, which is normal. |
| **AdShowed** | <img src="images/event-adshowed.png" alt="AdShowed" width="298"> | The ad now covers the screen. Pause games or sound here. |
| **AdDismissed** | <img src="images/event-addismissed.png" alt="AdDismissed" width="313"> | The user closed the ad. Resume your app and call `LoadAd` for the next one. |
| **AdFailedToShow** | <img src="images/event-adfailedtoshow.png" alt="AdFailedToShow" width="337"> | The ad could not be shown.<br>`errorCode`: why, such as `Ad Not Ready` when nothing was loaded<br>`message`: the explanation |

## Dropdown blocks

| Name | Block | Options |
|---|---|---|
| **InterstitialError** | <img src="images/helper-interstitialerror.png" alt="InterstitialError" width="197"> | `NoFill`, `NetworkError`, `InvalidRequest`, `AppIdMissing`, `InternalError`, `MediationNoFill`, `RequestIdMismatch`, `InvalidAdString`, `AdNotReady`, `AdReused`, `AppNotInForeground`, `MediationShowError`, `Unknown`. Compare it with `errorCode` in `AdFailedToLoad` or `AdFailedToShow`. |

---

## Sample project

[AdMobInterstitialDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/AdMobInterstitialDemo.aia) is ready to build. Screen1
has a status label, a **Load ad** and a **Show ad** button, and **AdMobInterstitial1**
with the default test IDs.

**Load an ad as soon as the app starts,** so one is ready when you need it.

<img src="images/sample-screen1-initialize.png" alt="Screen1.Initialize" width="302">

**Show whether it loaded.** `AdLoaded` says the ad is ready, `AdFailedToLoad` shows why
it isn't.

<img src="images/sample-admobinterstitial1-adloaded.png" alt="AdLoaded" width="483">

<img src="images/sample-admobinterstitial1-adfailedtoload.png" alt="AdFailedToLoad" width="424">

**Load ad** requests one by hand.

<img src="images/sample-loadbutton-click.png" alt="LoadButton.Click" width="302">

**Show ad** checks `IsLoaded` first, so tapping it too early just shows a message.

<img src="images/sample-showbutton-click.png" alt="ShowButton.Click" width="488">

**While the ad is up and after it closes.** `AdShowed` is where a game would pause.
`AdDismissed` loads the next ad right away, because each loaded ad shows only once.

<img src="images/sample-admobinterstitial1-adshowed.png" alt="AdShowed" width="400">

<img src="images/sample-admobinterstitial1-addismissed.png" alt="AdDismissed" width="485">

<img src="images/sample-admobinterstitial1-adfailedtoshow.png" alt="AdFailedToShow" width="424">

---

## Using it with the other AdMob extensions

All five AdMob extensions can be in the same app. They share one copy of Google's ads
SDK, so the app doesn't grow with each one. Set the same **AppId** on each, and set
**TestDeviceIds** and **ChildDirected** on any one of them: they apply to every AdMob ad
in the app.

## Going live with real ads

1. Set **AppId** (the one with `~`) and **AdUnitId** (the one with `/`) from your AdMob
   console in the Designer.
2. **Add your phone to TestDeviceIds first.** Tapping your own real ads can get your
   AdMob account suspended. The ID appears in logcat on the first ad request, in a line
   like `setTestDeviceIds(Arrays.asList("33BE2250B43518CCDA7DE426D04EE231"))`.
3. **Show interstitials at natural breaks,** such as between levels or after a task is
   finished. Google's policy doesn't allow interstitials that appear while the app is
   opening or closing, or after every tap.
4. A new ad unit often returns `No Fill` for a few hours to a few days while Google
   reviews it. The test IDs always fill, so use them to tell a setup problem apart from
   a lack of ads.

## Things to know

- **Ads never show in the Companion.** It loads the extension's code but not the ads
  SDK, so build the APK to test.
- The project's minimum Android version becomes 6.0 (API 23).
- Use the same AppId in every AdMob extension in one app.

AdMob and its logo are trademarks of Google LLC. This extension is not affiliated with or
endorsed by Google.

Feedback and bug reports are welcome as a GitHub issue.

---

<p align="center">Made with ❤️ by Preet</p>
