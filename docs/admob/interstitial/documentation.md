---
description: Every block of the AdMob Interstitial extension.
icon: book
---

# AdMob Interstitial documentation

Every event, method, property and dropdown of **AdMobInterstitial**, in alphabetical order.

**Permissions**

1. `android.permission.INTERNET`
2. `android.permission.ACCESS_NETWORK_STATE`
3. `com.google.android.gms.permission.AD_ID`

## Events

### AdDismissed

The user closed the ad. Resume your app and call LoadAd for the next one.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-addismissed.png" alt="AdDismissed" width="313"><figcaption></figcaption></figure></div>

### AdFailedToLoad

An interstitial could not load. No Fill just means no ad was available, which is normal.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-adfailedtoload.png" alt="AdFailedToLoad" width="333"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | InterstitialError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdFailedToShow

The ad could not be shown, for example AdNotReady when nothing was loaded.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-adfailedtoshow.png" alt="AdFailedToShow" width="337"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | InterstitialError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdLoaded

An interstitial loaded and is ready to show.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-adloaded.png" alt="AdLoaded" width="294"><figcaption></figcaption></figure></div>

### AdShowed

The ad now covers the screen. Pause games or sound here.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/event-adshowed.png" alt="AdShowed" width="298"><figcaption></figcaption></figure></div>

## Methods

### IsLoaded

True when an interstitial is loaded and ready to show.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/method-isloaded.png" alt="IsLoaded" width="282"><figcaption></figcaption></figure></div>

Returns a boolean.

### LoadAd

Loads an interstitial in the background. AdLoaded or AdFailedToLoad follows. Ignored while a load is already running.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/method-loadad.png" alt="LoadAd" width="264"><figcaption></figcaption></figure></div>

### ShowAd

Shows the loaded interstitial full screen. One loaded ad shows only once, so call LoadAd again in AdDismissed. With nothing loaded, AdFailedToShow fires with AdNotReady.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/method-showad.png" alt="ShowAd" width="269"><figcaption></figcaption></figure></div>

## Properties

### AdUnitId

`text` · Default: `ca-app-pub-3940256099942544/1033173712` · Read and write · Designer and blocks

This interstitial's ad unit ID, the one with a /. The test default always fills and can't affect your account. A change takes effect on the next LoadAd.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-adunitid-set.png" alt="set AdUnitId" width="325"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-adunitid-get.png" alt="AdUnitId" width="266"><figcaption></figcaption></figure></div>

### AppId

`text` · Default: `ca-app-pub-3940256099942544~3347511713` · Read and write · Designer and blocks

Your AdMob app ID from the AdMob console, the one with a ~. Use the same value in every AdMob extension in the app. Changing it after the first ad has loaded has no effect.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-appid-set.png" alt="set AppId" width="308"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-appid-get.png" alt="AppId" width="248"><figcaption></figcaption></figure></div>

### ChildDirected

`boolean` · Default: `False` · Read and write · Designer and blocks

Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-childdirected-set.png" alt="set ChildDirected" width="357"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-childdirected-get.png" alt="ChildDirected" width="297"><figcaption></figcaption></figure></div>

### TestDeviceIds

`list` · Read and write · Blocks only

A list of test device IDs. These devices get test ads even with real IDs. Logcat prints the ID on the first ad request. Applies to every AdMob ad in the app.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-testdeviceids-set.png" alt="set TestDeviceIds" width="360"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/prop-testdeviceids-get.png" alt="TestDeviceIds" width="301"><figcaption></figcaption></figure></div>

## Dropdowns

### InterstitialError

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/helper-interstitialerror.png" alt="InterstitialError" width="197"><figcaption></figcaption></figure></div>

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

To see these blocks working together, follow the [tutorial](tutorial.md).
