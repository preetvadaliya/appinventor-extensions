---
description: Full-screen ads when the user comes back to your app.
icon: rectangle-ad
---

# AdMob App Open

| Extension | Version | Requires | Built on |
|---|---|---|---|
| <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/docs/images/admob.png" alt="" data-size="line"> AdMobAppOpen | 1.0 | Android 6.0 (API 23) | Google Mobile Ads SDK 25.3.0 |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-app-open/de.preet.admob.appopen.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-app-open/AdMobAppOpenDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

## Overview

Shows an AdMob app open ad when the user comes back to your app. With ShowOnReturn checked it loads, shows and reloads ads by itself; use LoadAd and ShowAd for anything else, like showing one at startup. Put it on Screen1. The defaults are Google's test IDs. Ads only work in a built app, never in the Companion.

The ad shows only when the user comes back to the app from another app or the home screen: not when the app first opens, not when switching between your own screens, and never over another ad.

App ID, test ads, going live and error codes are explained on the [AdMob](README.md) page.

**Permissions**

1. `android.permission.INTERNET`
2. `android.permission.ACCESS_NETWORK_STATE`
3. `com.google.android.gms.permission.AD_ID`

## Events

### AdDismissed

The user closed the ad. With ShowOnReturn checked, the next one is already loading.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/event-addismissed.png" alt="AdDismissed" width="312"><figcaption></figcaption></figure></div>

### AdFailedToLoad

An app open ad could not load. No Fill just means no ad was available, which is normal.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/event-adfailedtoload.png" alt="AdFailedToLoad" width="332"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | AppOpenError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdFailedToShow

The ad could not be shown, for example AdNotReady when nothing was loaded.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/event-adfailedtoshow.png" alt="AdFailedToShow" width="336"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | AppOpenError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdLoaded

An app open ad loaded and is ready to show.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/event-adloaded.png" alt="AdLoaded" width="293"><figcaption></figcaption></figure></div>

### AdShowed

The ad now covers the screen.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/event-adshowed.png" alt="AdShowed" width="297"><figcaption></figcaption></figure></div>

## Methods

### IsLoaded

True when an app open ad is loaded and not expired. Google says an app open ad expires 4 hours after loading.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/method-isloaded.png" alt="IsLoaded" width="281"><figcaption></figcaption></figure></div>

Returns a boolean.

### LoadAd

Loads an app open ad in the background. AdLoaded or AdFailedToLoad follows. Ignored while a load is already running.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/method-loadad.png" alt="LoadAd" width="264"><figcaption></figcaption></figure></div>

### ShowAd

Shows the loaded app open ad now, for example at startup. With nothing loaded, AdFailedToShow fires with AdNotReady.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/method-showad.png" alt="ShowAd" width="268"><figcaption></figcaption></figure></div>

## Properties

### AdUnitId

`text` · Default: `ca-app-pub-3940256099942544/9257395921` · Read and write · Designer and blocks

This app open ad's unit ID, the one with a /. The test default always fills and can't affect your account. A change takes effect on the next load.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-adunitid-set.png" alt="set AdUnitId" width="325"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-adunitid-get.png" alt="AdUnitId" width="265"><figcaption></figcaption></figure></div>

### AppId

`text` · Default: `ca-app-pub-3940256099942544~3347511713` · Read and write · Designer and blocks

Your AdMob app ID from the AdMob console, the one with a ~. Use the same value in every AdMob extension in the app. Changing it after the first ad has loaded has no effect.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-appid-set.png" alt="set AppId" width="307"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-appid-get.png" alt="AppId" width="247"><figcaption></figcaption></figure></div>

### ChildDirected

`boolean` · Default: `False` · Read and write · Designer and blocks

Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-childdirected-set.png" alt="set ChildDirected" width="356"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-childdirected-get.png" alt="ChildDirected" width="296"><figcaption></figcaption></figure></div>

### ShowOnReturn

`boolean` · Default: `True` · Read and write · Designer and blocks

Loads an ad when the screen starts, shows it whenever the user comes back to the app from the background, then loads the next one. Uncheck it to control everything with blocks.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-showonreturn-set.png" alt="set ShowOnReturn" width="369"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-showonreturn-get.png" alt="ShowOnReturn" width="309"><figcaption></figcaption></figure></div>

### TestDeviceIds

`list` · Read and write · Blocks only

A list of test device IDs. These devices get test ads even with real IDs. Logcat prints the ID on the first ad request. Applies to every AdMob ad in the app.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-testdeviceids-set.png" alt="set TestDeviceIds" width="360"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/prop-testdeviceids-get.png" alt="TestDeviceIds" width="300"><figcaption></figcaption></figure></div>

## Dropdowns

### AppOpenError

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/helper-appopenerror.png" alt="AppOpenError" width="196"><figcaption></figcaption></figure></div>

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

[AdMobAppOpenDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-app-open/AdMobAppOpenDemo.aia) is ready to build. With `ShowOnReturn`
checked, the extension needs no blocks at all; these only show what is happening. Build
it, press the home button, then open the app again.

**Status of the ad.** The label shows when an ad is ready, what went wrong, when it is on
screen, and that the next one is loading after it closes.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-admobappopen1-adloaded.png" alt="AdLoaded" width="594"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-admobappopen1-adfailedtoload.png" alt="AdFailedToLoad" width="424"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-admobappopen1-adshowed.png" alt="AdShowed" width="400"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-admobappopen1-addismissed.png" alt="AdDismissed" width="485"><figcaption></figcaption></figure></div>

**Show now** shows the loaded ad on demand, which is how you would use `ShowAd` yourself.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-showbutton-click.png" alt="ShowButton.Click" width="488"><figcaption></figcaption></figure></div>
