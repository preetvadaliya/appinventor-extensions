---
description: Full-screen ads shown at natural breaks in your app.
icon: window-maximize
---

# AdMob Interstitial

A free extension that shows **full-screen AdMob interstitial ads** in MIT App Inventor
apps, built on **Google Mobile Ads SDK 25.3.0**, which Google supports until June 30, 2028.

- **AppId is a normal Designer property.** No manifest editing and no extra
  "manifest extension": paste your App ID and build.
- **Works out of the box:** the defaults are Google's test IDs, so you see a test ad
  on the first build.
- **Three blocks:** `LoadAd` loads an ad in the background, `ShowAd` shows it at a
  break in your app, and `IsLoaded` tells you when it is ready.

| | |
|---|---|
| **Extension** | AdMobInterstitial |
| **Package** | `de.preet.admob.interstitial` |
| **Version** | 1.1 |
| **Google Mobile Ads SDK** | 25.3.0 |
| **Minimum Android** | 6.0 (API 23) |
| **Size** | 11.8 MB |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/de.preet.admob.interstitial.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/AdMobInterstitialDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

## Designer properties

| Name | Description | Default |
|---|---|---|
| **AppId** | Your AdMob app ID from the AdMob console, the one with a `~`. Use the same value in every AdMob extension in the app. | `ca-app-pub-3940256099942544~3347511713` (Google test app ID) |
| **AdUnitId** | This interstitial's ad unit ID, the one with a `/`. The test default always fills and can't affect your account. | `ca-app-pub-3940256099942544/1033173712` (Google test interstitial) |
| **ChildDirected** | Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app. | Unchecked |

## Blocks

{% tabs %}
{% tab title="Properties" %}
| Name | Block | Description |
|---|---|---|
| **AppId** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/prop-appid-set.png" alt="set AppId"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/prop-appid-get.png" alt="AppId"> | Your AdMob app ID. Changing it after the first ad has loaded has no effect, so set it in the Designer or before the first `LoadAd`. |
| **AdUnitId** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/prop-adunitid-set.png" alt="set AdUnitId"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/prop-adunitid-get.png" alt="AdUnitId"> | This interstitial's ad unit ID. A change takes effect on the next `LoadAd`. |
| **ChildDirected** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/prop-childdirected-set.png" alt="set ChildDirected"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/prop-childdirected-get.png" alt="ChildDirected"> | Tags every ad request as directed at children and limits ads to content rated G. Setting it to false makes it unspecified again. |
| **TestDeviceIds** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/prop-testdeviceids-set.png" alt="set TestDeviceIds"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/prop-testdeviceids-get.png" alt="TestDeviceIds"> | A **list** of test device IDs. These devices get test ads even with your real IDs. Applies to every AdMob ad in the app. |
{% endtab %}

{% tab title="Functions" %}
| Name | Block | Description |
|---|---|---|
| **LoadAd** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/method-loadad.png" alt="LoadAd"> | Loads an interstitial in the background. `AdLoaded` or `AdFailedToLoad` follows. Ignored while a load is already running. |
| **ShowAd** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/method-showad.png" alt="ShowAd"> | Shows the loaded interstitial full screen. One loaded ad shows only once, so call `LoadAd` again in `AdDismissed`. With nothing loaded, `AdFailedToShow` fires with `Ad Not Ready`. |
| **IsLoaded** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/method-isloaded.png" alt="IsLoaded"> | Returns true when an interstitial is loaded and ready to show. |
{% endtab %}

{% tab title="Events" %}
| Name | Block | Description |
|---|---|---|
| **AdLoaded** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/event-adloaded.png" alt="AdLoaded"> | An interstitial loaded and is ready to show. |
| **AdFailedToLoad** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/event-adfailedtoload.png" alt="AdFailedToLoad"> | An interstitial could not load.<br>`errorCode`: why, as text such as `No Fill` or `Network Error`<br>`message`: Google's explanation<br>No Fill just means no ad was available, which is normal. |
| **AdShowed** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/event-adshowed.png" alt="AdShowed"> | The ad now covers the screen. Pause games or sound here. |
| **AdDismissed** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/event-addismissed.png" alt="AdDismissed"> | The user closed the ad. Resume your app and call `LoadAd` for the next one. |
| **AdFailedToShow** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/event-adfailedtoshow.png" alt="AdFailedToShow"> | The ad could not be shown.<br>`errorCode`: why, such as `Ad Not Ready` when nothing was loaded<br>`message`: the explanation |
{% endtab %}

{% tab title="Dropdowns" %}
| Name | Block | Options |
|---|---|---|
| **InterstitialError** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/1x/helper-interstitialerror.png" alt="InterstitialError"> | `NoFill`, `NetworkError`, `InvalidRequest`, `AppIdMissing`, `InternalError`, `MediationNoFill`, `RequestIdMismatch`, `InvalidAdString`, `AdNotReady`, `AdReused`, `AppNotInForeground`, `MediationShowError`, `Unknown`. Compare it with `errorCode` in `AdFailedToLoad` or `AdFailedToShow`. |
{% endtab %}
{% endtabs %}

## Learn more

* [Tutorial: build the sample step by step](../tutorials/interstitial.md)
* [Error codes](errors.md): what each `errorCode` means and what to do
* [Switch to real ads safely](../going-live/real-ads.md)

{% hint style="info" %}
Ads never show in the Companion. Build the APK to test them, as explained in
[Test on your phone](../../getting-started/testing.md).
{% endhint %}
