---
description: Banner ads inside an arrangement or floating at the top or bottom.
icon: rectangle-ad
---

# AdMob Banner

| Extension | Version | Requires | Built on |
|---|---|---|---|
| <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/docs/images/admob.png" alt="" data-size="line"> AdMobBanner | 1.1 | Android 6.0 (API 23) | Google Mobile Ads SDK 25.3.0 |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/de.preet.admob.banner.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/AdMobBannerDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

## Overview

Shows an AdMob banner ad. Set AppId and AdUnitId, then call LoadAd to load a banner into an arrangement, or ShowAt to load one at the top or bottom of the screen. The defaults are Google's test IDs. Ads only work in a built app, never in the Companion.

One AdMobBanner shows one banner at a time: `LoadAd` puts it inside an arrangement, `ShowAt` floats it over the layout, and calling either again replaces the current banner.

App ID, test ads, going live and error codes are explained on the [AdMob](README.md) page.

**Permissions**

1. `android.permission.INTERNET`
2. `android.permission.ACCESS_NETWORK_STATE`
3. `com.google.android.gms.permission.AD_ID`

## Events

### AdClicked

The user tapped the banner.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/event-adclicked.png" alt="AdClicked" width="278"><figcaption></figcaption></figure></div>

### AdClosed

The user came back from a tapped ad.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/event-adclosed.png" alt="AdClosed" width="275"><figcaption></figcaption></figure></div>

### AdFailedToLoad

A banner could not load. No Fill just means no ad was available, which is normal.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/event-adfailedtoload.png" alt="AdFailedToLoad" width="317"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `errorCode` | BannerError | Why it failed, as text such as `No Fill`. Compare it with the dropdown block. |
| `message` | text | Google's explanation, useful when you ask for help. |

### AdImpression

The banner was counted as seen.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/event-adimpression.png" alt="AdImpression" width="301"><figcaption></figcaption></figure></div>

### AdLoaded

A banner loaded and is on screen.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/event-adloaded.png" alt="AdLoaded" width="278"><figcaption></figcaption></figure></div>

### AdOpened

A tapped ad opened over the app. Pause games or sound here.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/event-adopened.png" alt="AdOpened" width="282"><figcaption></figcaption></figure></div>

## Methods

### DestroyAd

Removes the banner and frees its memory. Call LoadAd or ShowAt to show a new one.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/method-destroyad.png" alt="DestroyAd" width="267"><figcaption></figcaption></figure></div>

### IsLoaded

True when a banner has loaded.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/method-isloaded.png" alt="IsLoaded" width="267"><figcaption></figcaption></figure></div>

Returns a boolean.

### LoadAd

Loads a banner into an arrangement on the screen. Plug in a HorizontalArrangement or VerticalArrangement and a BannerSize block; Adaptive fits the width and is what Google recommends. AdLoaded or AdFailedToLoad follows.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/method-loadad.png" alt="LoadAd" width="257"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `arrangement` | component | The HorizontalArrangement or VerticalArrangement the banner goes in. |
| `size` | BannerSize | The banner size. Adaptive is what Google recommends. |

### ShowAt

Loads a banner that floats over your layout at the top or bottom of the screen. Plug in a BannerPosition block and a BannerSize block. AdLoaded or AdFailedToLoad follows.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/method-showat.png" alt="ShowAt" width="257"><figcaption></figcaption></figure></div>

| Parameter | Type | Description |
|---|---|---|
| `position` | BannerPosition | Where the banner floats: Top or Bottom. |
| `size` | BannerSize | The banner size. Adaptive is what Google recommends. |

## Properties

### AdUnitId

`text` · Default: `ca-app-pub-3940256099942544/6300978111` · Read and write · Designer and blocks

This banner's ad unit ID, the one with a /. The test default always fills and can't affect your account. A change takes effect on the next LoadAd or ShowAt.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-adunitid-set.png" alt="set AdUnitId" width="310"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-adunitid-get.png" alt="AdUnitId" width="250"><figcaption></figcaption></figure></div>

### AppId

`text` · Default: `ca-app-pub-3940256099942544~3347511713` · Read and write · Designer and blocks

Your AdMob app ID from the AdMob console, the one with a ~. Use the same value in every AdMob extension in the app. Changing it after the first ad has loaded has no effect.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-appid-set.png" alt="set AppId" width="292"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-appid-get.png" alt="AppId" width="232"><figcaption></figcaption></figure></div>

### ChildDirected

`boolean` · Default: `False` · Read and write · Designer and blocks

Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-childdirected-set.png" alt="set ChildDirected" width="342"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-childdirected-get.png" alt="ChildDirected" width="282"><figcaption></figcaption></figure></div>

### TestDeviceIds

`list` · Read and write · Blocks only

A list of test device IDs. These devices get test ads even with real IDs. Logcat prints the ID on the first ad request. Applies to every AdMob ad in the app.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-testdeviceids-set.png" alt="set TestDeviceIds" width="345"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-testdeviceids-get.png" alt="TestDeviceIds" width="285"><figcaption></figcaption></figure></div>

### Visible

`boolean` · Read and write · Blocks only

Whether the banner is on screen. Hiding it keeps the loaded ad, so showing it again costs nothing.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-visible-set.png" alt="set Visible" width="297"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/prop-visible-get.png" alt="Visible" width="237"><figcaption></figcaption></figure></div>

## Dropdowns

### BannerError

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/helper-bannererror.png" alt="BannerError" width="182"><figcaption></figcaption></figure></div>

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
| `Unknown` | `Unknown` | Anything else. The message explains it. |

### BannerSize

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/helper-bannersize.png" alt="BannerSize" width="197"><figcaption></figcaption></figure></div>

| Option | Meaning |
|---|---|
| `Adaptive` | As wide as the arrangement or screen, with the best height for it. Recommended. |
| `Banner` | 320×50 |
| `LargeBanner` | 320×100 |
| `MediumRectangle` | 300×250 |
| `FullBanner` | 468×60, for tablets |
| `Leaderboard` | 728×90, for tablets |

### BannerPosition

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/helper-bannerposition.png" alt="BannerPosition" width="210"><figcaption></figcaption></figure></div>

| Option | Meaning |
|---|---|
| `Top` | Floats at the top of the screen. |
| `Bottom` | Floats at the bottom of the screen. |

## Example

[AdMobBannerDemo.aia](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/AdMobBannerDemo.aia) is ready to build. Screen1 has a status
label, a detail label, a HorizontalArrangement called **BannerBox** (width: fill parent)
where the banner goes, four buttons, and **AdMobBanner1** with the default test IDs.

**Load a banner when the app starts.** `LoadAd` places it inside BannerBox with the
Adaptive size, which fits the width of the screen.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-screen1-initialize.png" alt="Screen1.Initialize" width="472"><figcaption></figcaption></figure></div>

**Show what happened.** `AdLoaded` confirms the ad is on screen. `AdFailedToLoad` shows
the error code and Google's message, and `AdImpression` shows when the ad was counted.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adloaded.png" alt="AdLoaded" width="410"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adfailedtoload.png" alt="AdFailedToLoad" width="424"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adimpression.png" alt="AdImpression" width="468"><figcaption></figcaption></figure></div>

**Load in the box** loads a fresh banner into BannerBox again.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-loadbutton-click.png" alt="LoadButton.Click" width="472"><figcaption></figcaption></figure></div>

**Float at the bottom** loads a standard 320×50 banner that floats at the bottom of
the screen, over the layout.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-showatbutton-click.png" alt="ShowAtButton.Click" width="485"><figcaption></figcaption></figure></div>

**Hide / show** flips `Visible`. The loaded ad is kept, so it comes back instantly.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-togglebutton-click.png" alt="ToggleButton.Click" width="600"><figcaption></figcaption></figure></div>

**Destroy** removes the banner and frees its memory.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-destroybutton-click.png" alt="DestroyButton.Click" width="411"><figcaption></figcaption></figure></div>
