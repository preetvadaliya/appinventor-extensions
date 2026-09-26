# AdMob Rewarded Interstitial

A free extension that shows **AdMob rewarded interstitial ads** in MIT App Inventor
apps: a full-screen ad at a natural break that gives the user a reward, without them
having to tap a "watch ad" button first. Built on **Google Mobile Ads SDK 25.3.0**,
which Google supports until June 30, 2028.

- **AppId is a normal Designer property.** No manifest editing and no extra
  "manifest extension": paste your App ID and build.
- **Works out of the box:** the defaults are Google's test IDs, so you see a test ad
  on the first build.
- **Simple:** `LoadAd`, show your intro screen at a break, then `ShowAd`, and give the
  reward in `UserEarnedReward`.
- **Part of a set:** [Banner, Interstitial, Rewarded, App Open and Rewarded Interstitial](https://github.com/preetvadaliya/appinventor-extensions)
  are all free, and each works alone or together with the others.

| | |
|---|---|
| **Extension** | AdMobRewardedInterstitial |
| **Package** | `de.preet.admob.rewardedinterstitial` |
| **Version** | 1.0 |
| **Google Mobile Ads SDK** | 25.3.0 |
| **Minimum Android** | 6.0 (API 23) |
| **Size** | 11.8 MB |

## Download

- Extension: [de.preet.admob.rewardedinterstitial.aix](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/de.preet.admob.rewardedinterstitial.aix)
- Sample project: [AdMobRewardedInterstitialDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/AdMobRewardedInterstitialDemo.aia)

---

## Designer properties

| Name | Description | Default |
|---|---|---|
| **AppId** | Your AdMob app ID from the AdMob console, the one with a `~`. Use the same value in every AdMob extension in the app. | `ca-app-pub-3940256099942544~3347511713` (Google test app ID) |
| **AdUnitId** | This rewarded interstitial ad's unit ID, the one with a `/`. The test default always fills and can't affect your account. | `ca-app-pub-3940256099942544/5354046379` (Google test rewarded interstitial) |
| **ChildDirected** | Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app. | Unchecked |

## Properties

| Name | Block | Description |
|---|---|---|
| **AppId** | <img src="images/prop-appid-set.png" alt="set AppId" width="374"><br><img src="images/prop-appid-get.png" alt="AppId" width="314"> | Your AdMob app ID. Changing it after the first ad has loaded has no effect, so set it in the Designer or before the first `LoadAd`. |
| **AdUnitId** | <img src="images/prop-adunitid-set.png" alt="set AdUnitId" width="392"><br><img src="images/prop-adunitid-get.png" alt="AdUnitId" width="332"> | This rewarded interstitial ad's unit ID. A change takes effect on the next `LoadAd`. |
| **ChildDirected** | <img src="images/prop-childdirected-set.png" alt="set ChildDirected" width="424"><br><img src="images/prop-childdirected-get.png" alt="ChildDirected" width="364"> | Tags every ad request as directed at children and limits ads to content rated G. Setting it to false makes it unspecified again. |
| **TestDeviceIds** | <img src="images/prop-testdeviceids-set.png" alt="set TestDeviceIds" width="427"><br><img src="images/prop-testdeviceids-get.png" alt="TestDeviceIds" width="367"> | A **list** of test device IDs. These devices get test ads even with your real IDs. Applies to every AdMob ad in the app. |

## Functions

| Name | Block | Description |
|---|---|---|
| **LoadAd** | <img src="images/method-loadad.png" alt="LoadAd" width="331"> | Loads a rewarded interstitial ad in the background. `AdLoaded` or `AdFailedToLoad` follows. Ignored while a load is already running. |
| **ShowAd** | <img src="images/method-showad.png" alt="ShowAd" width="335"> | Shows the loaded ad full screen. **Show your intro screen first:** Google requires one that says what the reward is and lets the user skip. Give the reward in `UserEarnedReward`. One loaded ad shows only once. |
| **IsLoaded** | <img src="images/method-isloaded.png" alt="IsLoaded" width="349"> | Returns true when a rewarded interstitial ad is loaded and ready to show. |

## Events

| Name | Block | Description |
|---|---|---|
| **AdLoaded** | <img src="images/event-adloaded.png" alt="AdLoaded" width="361"> | A rewarded interstitial ad loaded and is ready to show. |
| **AdFailedToLoad** | <img src="images/event-adfailedtoload.png" alt="AdFailedToLoad" width="400"> | The ad could not load.<br>`errorCode`: why, as text such as `No Fill` or `Network Error`<br>`message`: Google's explanation<br>No Fill just means no ad was available, which is normal. |
| **AdShowed** | <img src="images/event-adshowed.png" alt="AdShowed" width="365"> | The ad now covers the screen. Pause games or sound here. |
| **UserEarnedReward** | <img src="images/event-userearnedreward.png" alt="UserEarnedReward" width="423"> | The user watched enough of the ad to earn the reward. **Give the reward here and only here**: someone who closes the ad early still gets `AdDismissed`.<br>`rewardType`: the reward's name, such as `coins`<br>`rewardAmount`: how many<br>Both come from the ad unit's settings in the AdMob console. |
| **AdDismissed** | <img src="images/event-addismissed.png" alt="AdDismissed" width="379"> | The user closed the ad. Resume your app and call `LoadAd` for the next one. |
| **AdFailedToShow** | <img src="images/event-adfailedtoshow.png" alt="AdFailedToShow" width="404"> | The ad could not be shown.<br>`errorCode`: why, such as `Ad Not Ready` when nothing was loaded<br>`message`: the explanation |

## Dropdown blocks

| Name | Block | Options |
|---|---|---|
| **RewardedInterstitialError** | <img src="images/helper-rewardedinterstitialerror.png" alt="RewardedInterstitialError" width="264"> | `NoFill`, `NetworkError`, `InvalidRequest`, `AppIdMissing`, `InternalError`, `MediationNoFill`, `RequestIdMismatch`, `InvalidAdString`, `AdNotReady`, `AdReused`, `AppNotInForeground`, `MediationShowError`, `Unknown`. Compare it with `errorCode` in `AdFailedToLoad` or `AdFailedToShow`. |

---

## Sample project

[AdMobRewardedInterstitialDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/AdMobRewardedInterstitialDemo.aia) is ready to
build. Screen1 has a status label, a coin counter, a **Finish level** button (the natural
break), a Notifier for the intro screen, and **AdMobRewardedInterstitial1** with the
default test IDs.

**Load an ad as soon as the app starts,** so one is ready at the next break.

<img src="images/sample-screen1-initialize.png" alt="Screen1.Initialize" width="369">

<img src="images/sample-admobrewardedinterstitial1-adloaded.png" alt="AdLoaded" width="499">

<img src="images/sample-admobrewardedinterstitial1-adfailedtoload.png" alt="AdFailedToLoad" width="424">

**The intro screen.** When the level ends and an ad is ready, a dialog says what the
reward is and offers **No thanks**, as Google requires.

<img src="images/sample-finishbutton-click.png" alt="FinishButton.Click" width="647">

**Show the ad only if the user agreed.**

<img src="images/sample-notifier1-afterchoosing.png" alt="Notifier1.AfterChoosing" width="422">

**Give the reward** in `UserEarnedReward`, and load the next ad after this one closes.

<img src="images/sample-admobrewardedinterstitial1-userearnedreward.png" alt="UserEarnedReward" width="712">

<img src="images/sample-admobrewardedinterstitial1-addismissed.png" alt="AdDismissed" width="379">

---

## Using it with the other AdMob extensions

All five AdMob extensions can be in the same app. They share one copy of Google's ads
SDK, so the app doesn't grow with each one. Set the same **AppId** on each, and set
**TestDeviceIds** and **ChildDirected** on any one of them: they apply to every AdMob ad
in the app.

## Going live with real ads

1. Set **AppId** (the one with `~`) and **AdUnitId** (the one with `/`) from your AdMob
   console in the Designer. The reward's name and amount are set on that ad unit in the
   console.
2. **Add your phone to TestDeviceIds first.** Tapping your own real ads can get your
   AdMob account suspended. The ID appears in logcat on the first ad request, in a line
   like `setTestDeviceIds(Arrays.asList("33BE2250B43518CCDA7DE426D04EE231"))`.
3. **Always show the intro screen** with the reward and a way to skip, and show the ad
   only at a natural break, such as between levels.
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
