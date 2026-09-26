---
description: Rewarded ads at natural breaks, after an intro screen.
icon: rectangle-ad
---

# AdMob Rewarded Interstitial

| Extension | Version | Requires | Built on |
|---|---|---|---|
| <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/docs/images/admob.png" alt="" data-size="line"> AdMobRewardedInterstitial | 1.0 | Android 6.0 (API 23) | Google Mobile Ads SDK 25.3.0 |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/de.preet.admob.rewardedinterstitial.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/AdMobRewardedInterstitialDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

## Overview

Shows a full-screen AdMob rewarded interstitial ad at a natural break, without the user tapping a button first. Google requires an intro screen before it that says what the reward is and lets the user skip. Give the reward in UserEarnedReward. The defaults are Google's test IDs. Ads only work in a built app, never in the Companion.

Google requires an intro screen before each ad that says what the reward is and lets the user skip. Give the reward in `UserEarnedReward` only.

App ID, test ads, going live and error codes are explained on the [AdMob](README.md) page.

**Permissions**

1. `android.permission.INTERNET`
2. `android.permission.ACCESS_NETWORK_STATE`
3. `com.google.android.gms.permission.AD_ID`

## Events

### AdDismissed

The user closed the ad. Resume your app and call LoadAd for the next one.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/event-addismissed.png" alt="AdDismissed" width="379"><figcaption></figcaption></figure></div>

### AdFailedToLoad

A rewarded interstitial ad could not load. No Fill just means no ad was available, which is normal.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/event-adfailedtoload.png" alt="AdFailedToLoad" width="400"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | RewardedInterstitialError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdFailedToShow

The ad could not be shown, for example AdNotReady when nothing was loaded.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/event-adfailedtoshow.png" alt="AdFailedToShow" width="404"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | RewardedInterstitialError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdLoaded

A rewarded interstitial ad loaded and is ready to show.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/event-adloaded.png" alt="AdLoaded" width="361"><figcaption></figcaption></figure></div>

### AdShowed

The ad now covers the screen. Pause games or sound here.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/event-adshowed.png" alt="AdShowed" width="365"><figcaption></figcaption></figure></div>

### UserEarnedReward

The user watched enough of the ad to earn the reward. Give the reward here and only here: someone who closes the ad early still gets AdDismissed. rewardType and rewardAmount come from the ad unit's settings in the AdMob console.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/event-userearnedreward.png" alt="UserEarnedReward" width="423"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `rewardType` | text | The reward's name, set on the ad unit in AdMob, such as `coins`. |
| `rewardAmount` | number | How many, set on the ad unit in AdMob. |

## Methods

### IsLoaded

True when a rewarded interstitial ad is loaded and ready to show.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/method-isloaded.png" alt="IsLoaded" width="349"><figcaption></figcaption></figure></div>

Returns a boolean.

### LoadAd

Loads a rewarded interstitial ad in the background. AdLoaded or AdFailedToLoad follows. Ignored while a load is already running.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/method-loadad.png" alt="LoadAd" width="331"><figcaption></figcaption></figure></div>

### ShowAd

Shows the loaded rewarded interstitial ad full screen. Show your intro screen first: Google requires one that says what the reward is and lets the user skip. Give the reward in UserEarnedReward. One loaded ad shows only once, so call LoadAd again in AdDismissed. With nothing loaded, AdFailedToShow fires with AdNotReady.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/method-showad.png" alt="ShowAd" width="335"><figcaption></figcaption></figure></div>

## Properties

### AdUnitId

`text` · Default: `ca-app-pub-3940256099942544/5354046379` · Read and write · Designer and blocks

This rewarded interstitial ad's unit ID, the one with a /. The test default always fills and can't affect your account. A change takes effect on the next LoadAd.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/prop-adunitid-set.png" alt="set AdUnitId" width="392"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/prop-adunitid-get.png" alt="AdUnitId" width="332"><figcaption></figcaption></figure></div>

### AppId

`text` · Default: `ca-app-pub-3940256099942544~3347511713` · Read and write · Designer and blocks

Your AdMob app ID from the AdMob console, the one with a ~. Use the same value in every AdMob extension in the app. Changing it after the first ad has loaded has no effect.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/prop-appid-set.png" alt="set AppId" width="374"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/prop-appid-get.png" alt="AppId" width="314"><figcaption></figcaption></figure></div>

### ChildDirected

`boolean` · Default: `False` · Read and write · Designer and blocks

Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/prop-childdirected-set.png" alt="set ChildDirected" width="424"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/prop-childdirected-get.png" alt="ChildDirected" width="364"><figcaption></figcaption></figure></div>

### TestDeviceIds

`list` · Read and write · Blocks only

A list of test device IDs. These devices get test ads even with real IDs. Logcat prints the ID on the first ad request. Applies to every AdMob ad in the app.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/prop-testdeviceids-set.png" alt="set TestDeviceIds" width="427"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/prop-testdeviceids-get.png" alt="TestDeviceIds" width="367"><figcaption></figcaption></figure></div>

## Dropdowns

### RewardedInterstitialError

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/helper-rewardedinterstitialerror.png" alt="RewardedInterstitialError" width="264"><figcaption></figcaption></figure></div>

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

[AdMobRewardedInterstitialDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/AdMobRewardedInterstitialDemo.aia) is ready to
build. Screen1 has a status label, a coin counter, a **Finish level** button (the natural
break), a Notifier for the intro screen, and **AdMobRewardedInterstitial1** with the
default test IDs.

**Load an ad as soon as the app starts,** so one is ready at the next break.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-screen1-initialize.png" alt="Screen1.Initialize" width="369"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-adloaded.png" alt="AdLoaded" width="499"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-adfailedtoload.png" alt="AdFailedToLoad" width="424"><figcaption></figcaption></figure></div>

**The intro screen.** When the level ends and an ad is ready, a dialog says what the
reward is and offers **No thanks**, as Google requires.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-finishbutton-click.png" alt="FinishButton.Click" width="647"><figcaption></figcaption></figure></div>

**Show the ad only if the user agreed.**

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-notifier1-afterchoosing.png" alt="Notifier1.AfterChoosing" width="422"><figcaption></figcaption></figure></div>

**Give the reward** in `UserEarnedReward`, and load the next ad after this one closes.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-userearnedreward.png" alt="UserEarnedReward" width="712"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-addismissed.png" alt="AdDismissed" width="379"><figcaption></figcaption></figure></div>
