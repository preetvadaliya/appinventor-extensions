---
description: Full-screen ads the user chooses to watch for a reward.
icon: rectangle-ad
---

# AdMob Rewarded

| Extension | Version | Requires | Built on |
|---|---|---|---|
| <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/docs/images/admob.png" alt="" data-size="line"> AdMobRewarded | 1.0 | Android 6.0 (API 23) | Google Mobile Ads SDK 25.3.0 |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded/de.preet.admob.rewarded.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded/AdMobRewardedDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

## Overview

Shows a full-screen AdMob rewarded ad that the user chooses to watch for a reward. Call LoadAd, wait for AdLoaded, then call ShowAd when the user asks for the reward, and give it in UserEarnedReward. The defaults are Google's test IDs. Ads only work in a built app, never in the Companion.

Show it only when the user asks for it, and give the reward in `UserEarnedReward` only: someone who closes the ad early still gets `AdDismissed`, but not the reward.

App ID, test ads, going live and error codes are explained on the [AdMob](README.md) page.

<details>

<summary>Permissions</summary>

* `android.permission.INTERNET`
* `android.permission.ACCESS_NETWORK_STATE`
* `com.google.android.gms.permission.AD_ID`

</details>

## Events

### AdDismissed

The user closed the ad. Resume your app and call LoadAd for the next one.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/event-addismissed.png" alt="AdDismissed" width="317"></figure>

### AdFailedToLoad

A rewarded ad could not load. No Fill just means no ad was available, which is normal.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/event-adfailedtoload.png" alt="AdFailedToLoad" width="337"></figure>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | RewardedError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdFailedToShow

The ad could not be shown, for example AdNotReady when nothing was loaded.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/event-adfailedtoshow.png" alt="AdFailedToShow" width="341"></figure>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | RewardedError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdLoaded

A rewarded ad loaded and is ready to show.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/event-adloaded.png" alt="AdLoaded" width="298"></figure>

### AdShowed

The ad now covers the screen. Pause games or sound here.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/event-adshowed.png" alt="AdShowed" width="302"></figure>

### UserEarnedReward

The user watched enough of the ad to earn the reward. Give the reward here and only here: someone who closes the ad early still gets AdDismissed. rewardType and rewardAmount come from the ad unit's settings in the AdMob console.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/event-userearnedreward.png" alt="UserEarnedReward" width="360"></figure>

| Parameter | Type | Description |
|---|---|---|
| `rewardType` | text | The reward's name, set on the ad unit in AdMob, such as `coins`. |
| `rewardAmount` | number | How many, set on the ad unit in AdMob. |

## Methods

### IsLoaded

True when a rewarded ad is loaded and ready to show.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/method-isloaded.png" alt="IsLoaded" width="286"></figure>

Returns a boolean.

### LoadAd

Loads a rewarded ad in the background. AdLoaded or AdFailedToLoad follows. Ignored while a load is already running.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/method-loadad.png" alt="LoadAd" width="269"></figure>

### ShowAd

Shows the loaded rewarded ad full screen. Give the reward in UserEarnedReward. One loaded ad shows only once, so call LoadAd again in AdDismissed. With nothing loaded, AdFailedToShow fires with AdNotReady.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/method-showad.png" alt="ShowAd" width="273"></figure>

## Properties

### AdUnitId

`text` · Default: `ca-app-pub-3940256099942544/5224354917` · Read and write · Designer and blocks

This rewarded ad's unit ID, the one with a /. The test default always fills and can't affect your account. A change takes effect on the next LoadAd.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/prop-adunitid-set.png" alt="set AdUnitId" width="330"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/prop-adunitid-get.png" alt="AdUnitId" width="270"></figure>

### AppId

`text` · Default: `ca-app-pub-3940256099942544~3347511713` · Read and write · Designer and blocks

Your AdMob app ID from the AdMob console, the one with a ~. Use the same value in every AdMob extension in the app. Changing it after the first ad has loaded has no effect.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/prop-appid-set.png" alt="set AppId" width="312"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/prop-appid-get.png" alt="AppId" width="252"></figure>

### ChildDirected

`boolean` · Default: `False` · Read and write · Designer and blocks

Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/prop-childdirected-set.png" alt="set ChildDirected" width="361"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/prop-childdirected-get.png" alt="ChildDirected" width="301"></figure>

### TestDeviceIds

`list` · Read and write · Blocks only

A list of test device IDs. These devices get test ads even with real IDs. Logcat prints the ID on the first ad request. Applies to every AdMob ad in the app.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/prop-testdeviceids-set.png" alt="set TestDeviceIds" width="365"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/prop-testdeviceids-get.png" alt="TestDeviceIds" width="305"></figure>

## Dropdowns

### RewardedError

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/helper-rewardederror.png" alt="RewardedError" width="201"></figure>

| Option | `errorCode` text | Meaning |
|---|---|---|
| `NoFill` | `No Fill` | No ad was available right now. Normal, not a mistake. |
| `NetworkError` | `Network Error` | The phone couldn't reach Google. |
| `InvalidRequest` | `Invalid Request` | Google rejected the request, usually because AdUnitId is wrong. |
| `AppIdMissing` | `App Id Missing` | No valid App ID. Check AppId. |
| `InternalError` | `Internal Error` | A problem inside Google's SDK or servers. Try again later. |
| `MediationNoFill` | `Mediation No Fill` | No ad from a mediation partner. Treat it like No Fill. |
| `RequestIdMismatch` | `Request Id Mismatch` | An internal mix-up between request and response. Try again. |
| `InvalidAdString` | `Invalid Ad String` | An internal ad format problem. Try again. |
| `AdNotReady` | `Ad Not Ready` | ShowAd was called with no ad loaded. Check IsLoaded first. |
| `AdReused` | `Ad Reused` | This ad was already shown. Call LoadAd for a new one. |
| `AppNotInForeground` | `App Not In Foreground` | ShowAd was called while the app wasn't on screen. |
| `MediationShowError` | `Mediation Show Error` | A mediation partner failed to show its ad. |
| `Unknown` | `Unknown` | Anything else. The message explains it. |

## Example

[AdMobRewardedDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded/AdMobRewardedDemo.aia) is ready to build. Screen1 has a
status label, a coin counter, a **Watch ad for coins** button, and **AdMobRewarded1** with
the default test IDs.

**Load an ad as soon as the app starts,** so one is ready when the user asks for it.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-screen1-initialize.png" alt="Screen1.Initialize" width="306"></figure>

**Show whether it loaded.** `AdLoaded` says the ad is ready, `AdFailedToLoad` shows why
it isn't.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adloaded.png" alt="AdLoaded" width="546"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adfailedtoload.png" alt="AdFailedToLoad" width="424"></figure>

**Watch ad for coins** checks `IsLoaded` first, so tapping it too early just shows a
message.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-watchbutton-click.png" alt="WatchButton.Click" width="488"></figure>

**Give the reward.** `UserEarnedReward` adds `rewardAmount` to the coin counter. It fires
only when the user has watched enough of the ad.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-userearnedreward.png" alt="UserEarnedReward" width="712"></figure>

**After the ad closes,** `AdDismissed` loads the next one right away, because each loaded
ad shows only once. `AdFailedToShow` shows what went wrong.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-addismissed.png" alt="AdDismissed" width="485"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adfailedtoshow.png" alt="AdFailedToShow" width="424"></figure>
