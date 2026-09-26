---
description: Banner ads inside an arrangement or floating at the top or bottom.
icon: rectangle-ad
---

# AdMob Banner

A free extension that shows **AdMob banner ads** in MIT App Inventor apps, built on
**Google Mobile Ads SDK 25.3.0**, which Google supports until June 30, 2028.

- **AppId is a normal Designer property.** No manifest editing and no extra
  "manifest extension": paste your App ID and build.
- **Works out of the box:** the defaults are Google's test IDs, so you see a test ad
  on the first build.
- **Two blocks to show an ad:** `LoadAd` puts a banner inside an arrangement,
  `ShowAt` floats one at the top or bottom of the screen.

| | |
|---|---|
| **Extension** | AdMobBanner |
| **Package** | `de.preet.admob.banner` |
| **Version** | 1.1 |
| **Google Mobile Ads SDK** | 25.3.0 |
| **Minimum Android** | 6.0 (API 23) |
| **Size** | 11.9 MB |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/de.preet.admob.banner.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/AdMobBannerDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

## Designer properties

| Name | Description | Default |
|---|---|---|
| **AppId** | Your AdMob app ID from the AdMob console, the one with a `~`. Use the same value in every AdMob extension in the app. | `ca-app-pub-3940256099942544~3347511713` (Google test app ID) |
| **AdUnitId** | This banner's ad unit ID, the one with a `/`. The test default always fills and can't affect your account. | `ca-app-pub-3940256099942544/6300978111` (Google test banner) |
| **ChildDirected** | Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app. | Unchecked |

## Blocks

{% tabs %}
{% tab title="Properties" %}
| Name | Block | Description |
|---|---|---|
| **AppId** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-appid-set.png" alt="set AppId"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-appid-get.png" alt="AppId"> | Your AdMob app ID. Changing it after the first ad has loaded has no effect, so set it in the Designer or before the first `LoadAd`. |
| **AdUnitId** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-adunitid-set.png" alt="set AdUnitId"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-adunitid-get.png" alt="AdUnitId"> | This banner's ad unit ID. A change takes effect on the next `LoadAd` or `ShowAt`. |
| **ChildDirected** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-childdirected-set.png" alt="set ChildDirected"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-childdirected-get.png" alt="ChildDirected"> | Tags every ad request as directed at children and limits ads to content rated G. Setting it to false makes it unspecified again. |
| **Visible** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-visible-set.png" alt="set Visible"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-visible-get.png" alt="Visible"> | Whether the banner is on screen. Hiding it keeps the loaded ad, so showing it again costs nothing. |
| **TestDeviceIds** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-testdeviceids-set.png" alt="set TestDeviceIds"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/prop-testdeviceids-get.png" alt="TestDeviceIds"> | A **list** of test device IDs. These devices get test ads even with your real IDs. Applies to every AdMob ad in the app. |
{% endtab %}

{% tab title="Functions" %}
| Name | Block | Description |
|---|---|---|
| **LoadAd** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/method-loadad.png" alt="LoadAd"> | Loads a banner into an arrangement on the screen.<br>`arrangement`: a HorizontalArrangement or VerticalArrangement<br>`size`: a `BannerSize` block (Adaptive is what Google recommends)<br>`AdLoaded` or `AdFailedToLoad` follows. |
| **ShowAt** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/method-showat.png" alt="ShowAt"> | Loads a banner that floats over your layout.<br>`position`: a `BannerPosition` block (Top or Bottom)<br>`size`: a `BannerSize` block<br>`AdLoaded` or `AdFailedToLoad` follows. |
| **IsLoaded** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/method-isloaded.png" alt="IsLoaded"> | Returns true when a banner has loaded. |
| **DestroyAd** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/method-destroyad.png" alt="DestroyAd"> | Removes the banner and frees its memory. Call `LoadAd` or `ShowAt` to show a new one. |
{% endtab %}

{% tab title="Events" %}
| Name | Block | Description |
|---|---|---|
| **AdLoaded** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/event-adloaded.png" alt="AdLoaded"> | A banner loaded and is on screen. |
| **AdFailedToLoad** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/event-adfailedtoload.png" alt="AdFailedToLoad"> | A banner could not load.<br>`errorCode`: why, as text such as `No Fill` or `Network Error`<br>`message`: Google's explanation<br>No Fill just means no ad was available, which is normal. |
| **AdClicked** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/event-adclicked.png" alt="AdClicked"> | The user tapped the banner. |
| **AdImpression** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/event-adimpression.png" alt="AdImpression"> | The banner was counted as seen. |
| **AdOpened** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/event-adopened.png" alt="AdOpened"> | A tapped ad opened over the app. Pause games or sound here. |
| **AdClosed** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/event-adclosed.png" alt="AdClosed"> | The user came back from a tapped ad. |
{% endtab %}

{% tab title="Dropdowns" %}
| Name | Block | Options |
|---|---|---|
| **BannerSize** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/helper-bannersize.png" alt="BannerSize"> | `Adaptive` (fits the width, recommended), `Banner` 320×50, `LargeBanner` 320×100, `MediumRectangle` 300×250, `FullBanner` 468×60 (tablets), `Leaderboard` 728×90 (tablets) |
| **BannerPosition** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/helper-bannerposition.png" alt="BannerPosition"> | `Top`, `Bottom` |
| **BannerError** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/1x/helper-bannererror.png" alt="BannerError"> | `NoFill`, `NetworkError`, `InvalidRequest`, `AppIdMissing`, `InternalError`, `MediationNoFill`, `RequestIdMismatch`, `InvalidAdString`, `Unknown`. Compare it with `errorCode` in `AdFailedToLoad`. |
{% endtab %}
{% endtabs %}

## Learn more

* [Tutorial: build the sample step by step](../tutorials/banner.md)
* [Error codes](errors.md): what each `errorCode` means and what to do
* [Switch to real ads safely](../going-live/real-ads.md)

{% hint style="info" %}
Ads never show in the Companion. Build the APK to test them, as explained in
[Test on your phone](../../getting-started/testing.md).
{% endhint %}
