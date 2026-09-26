---
description: Full-screen ads at natural breaks in your app.
icon: rectangle-ad
---

# AdMob Interstitial

| Extension | Version | Requires | Built on |
|---|---|---|---|
| <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/docs/images/admob.png" alt="" data-size="line"> AdMobInterstitial | 1.1 | Android 6.0 (API 23) | Google Mobile Ads SDK 25.3.0 |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/de.preet.admob.interstitial.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/AdMobInterstitialDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

## Overview

Shows a full-screen AdMob interstitial ad. Call LoadAd, wait for AdLoaded, then call ShowAd at a natural break in your app. The defaults are Google's test IDs. Ads only work in a built app, never in the Companion.

Load early and show the ad only at a natural break, such as between levels. Each loaded ad shows once, so call `LoadAd` again in `AdDismissed`.

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

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-addismissed.png" alt="AdDismissed" width="313"></figure>

### AdFailedToLoad

An interstitial could not load. No Fill just means no ad was available, which is normal.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-adfailedtoload.png" alt="AdFailedToLoad" width="333"></figure>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | InterstitialError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdFailedToShow

The ad could not be shown, for example AdNotReady when nothing was loaded.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-adfailedtoshow.png" alt="AdFailedToShow" width="337"></figure>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | InterstitialError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdLoaded

An interstitial loaded and is ready to show.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-adloaded.png" alt="AdLoaded" width="294"></figure>

### AdShowed

The ad now covers the screen. Pause games or sound here.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-adshowed.png" alt="AdShowed" width="298"></figure>

## Methods

### IsLoaded

True when an interstitial is loaded and ready to show.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/method-isloaded.png" alt="IsLoaded" width="282"></figure>

Returns a boolean.

### LoadAd

Loads an interstitial in the background. AdLoaded or AdFailedToLoad follows. Ignored while a load is already running.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/method-loadad.png" alt="LoadAd" width="264"></figure>

### ShowAd

Shows the loaded interstitial full screen. One loaded ad shows only once, so call LoadAd again in AdDismissed. With nothing loaded, AdFailedToShow fires with AdNotReady.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/method-showad.png" alt="ShowAd" width="269"></figure>

## Properties

### AdUnitId

`text` · Default: `ca-app-pub-3940256099942544/1033173712` · Read and write · Designer and blocks

This interstitial's ad unit ID, the one with a /. The test default always fills and can't affect your account. A change takes effect on the next LoadAd.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-adunitid-set.png" alt="set AdUnitId" width="325"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-adunitid-get.png" alt="AdUnitId" width="266"></figure>

### AppId

`text` · Default: `ca-app-pub-3940256099942544~3347511713` · Read and write · Designer and blocks

Your AdMob app ID from the AdMob console, the one with a ~. Use the same value in every AdMob extension in the app. Changing it after the first ad has loaded has no effect.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-appid-set.png" alt="set AppId" width="308"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-appid-get.png" alt="AppId" width="248"></figure>

### ChildDirected

`boolean` · Default: `False` · Read and write · Designer and blocks

Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-childdirected-set.png" alt="set ChildDirected" width="357"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-childdirected-get.png" alt="ChildDirected" width="297"></figure>

### TestDeviceIds

`list` · Read and write · Blocks only

A list of test device IDs. These devices get test ads even with real IDs. Logcat prints the ID on the first ad request. Applies to every AdMob ad in the app.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-testdeviceids-set.png" alt="set TestDeviceIds" width="360"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-testdeviceids-get.png" alt="TestDeviceIds" width="301"></figure>

## Dropdowns

### InterstitialError

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/helper-interstitialerror.png" alt="InterstitialError" width="197"></figure>

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

[AdMobInterstitialDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/AdMobInterstitialDemo.aia) is ready to build. Screen1
has a status label, a **Load ad** and a **Show ad** button, and **AdMobInterstitial1**
with the default test IDs.

**Load an ad as soon as the app starts,** so one is ready when you need it.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-screen1-initialize.png" alt="Screen1.Initialize" width="302"></figure>

**Show whether it loaded.** `AdLoaded` says the ad is ready, `AdFailedToLoad` shows why
it isn't.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-adloaded.png" alt="AdLoaded" width="483"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-adfailedtoload.png" alt="AdFailedToLoad" width="424"></figure>

**Load ad** requests one by hand.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-loadbutton-click.png" alt="LoadButton.Click" width="302"></figure>

**Show ad** checks `IsLoaded` first, so tapping it too early just shows a message.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-showbutton-click.png" alt="ShowButton.Click" width="488"></figure>

**While the ad is up and after it closes.** `AdShowed` is where a game would pause.
`AdDismissed` loads the next ad right away, because each loaded ad shows only once.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-adshowed.png" alt="AdShowed" width="400"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-addismissed.png" alt="AdDismissed" width="485"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-adfailedtoshow.png" alt="AdFailedToShow" width="424"></figure>
