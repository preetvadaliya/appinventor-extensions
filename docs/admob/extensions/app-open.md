---
description: Full-screen ads shown when the user comes back to your app.
icon: door-open
---

# AdMob App Open

A free extension that shows **AdMob app open ads** in MIT App Inventor apps: a
full-screen ad when the user comes back to your app. It does that **by itself**, which
App Inventor blocks can't detect on their own. Built on **Google Mobile Ads SDK 25.3.0**,
which Google supports until June 30, 2028.

- **No blocks needed:** with `ShowOnReturn` checked it loads an ad, shows it when the
  user returns to the app, and loads the next one.
- **AppId is a normal Designer property.** No manifest editing and no extra
  "manifest extension": paste your App ID and build.
- **Works out of the box:** the defaults are Google's test IDs.

| | |
|---|---|
| **Extension** | AdMobAppOpen |
| **Package** | `de.preet.admob.appopen` |
| **Version** | 1.0 |
| **Google Mobile Ads SDK** | 25.3.0 |
| **Minimum Android** | 6.0 (API 23) |
| **Size** | 11.9 MB |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-app-open/de.preet.admob.appopen.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-app-open/AdMobAppOpenDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

## Designer properties

| Name | Description | Default |
|---|---|---|
| **AppId** | Your AdMob app ID from the AdMob console, the one with a `~`. Use the same value in every AdMob extension in the app. | `ca-app-pub-3940256099942544~3347511713` (Google test app ID) |
| **AdUnitId** | This app open ad's unit ID, the one with a `/`. The test default always fills and can't affect your account. | `ca-app-pub-3940256099942544/9257395921` (Google test app open) |
| **ChildDirected** | Check this if the app is for children (Google Play Families policy). It also limits ads to content rated G. Unchecked leaves the setting unspecified. Applies to every AdMob ad in the app. | Unchecked |
| **ShowOnReturn** | Loads an ad when the screen starts, shows it whenever the user comes back to the app from the background, then loads the next one. Uncheck it to control everything with blocks. | Checked |

## Blocks

{% tabs %}
{% tab title="Properties" %}
| Name | Block | Description |
|---|---|---|
| **AppId** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-appid-set.png" alt="set AppId"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-appid-get.png" alt="AppId"> | Your AdMob app ID. Changing it after the first ad has loaded has no effect. |
| **AdUnitId** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-adunitid-set.png" alt="set AdUnitId"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-adunitid-get.png" alt="AdUnitId"> | This app open ad's unit ID. A change takes effect on the next load. |
| **ChildDirected** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-childdirected-set.png" alt="set ChildDirected"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-childdirected-get.png" alt="ChildDirected"> | Tags every ad request as directed at children and limits ads to content rated G. Setting it to false makes it unspecified again. |
| **ShowOnReturn** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-showonreturn-set.png" alt="set ShowOnReturn"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-showonreturn-get.png" alt="ShowOnReturn"> | Turns the automatic load-show-reload on or off. |
| **TestDeviceIds** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-testdeviceids-set.png" alt="set TestDeviceIds"><br><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/prop-testdeviceids-get.png" alt="TestDeviceIds"> | A **list** of test device IDs. These devices get test ads even with your real IDs. Applies to every AdMob ad in the app. |
{% endtab %}

{% tab title="Functions" %}
| Name | Block | Description |
|---|---|---|
| **LoadAd** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/method-loadad.png" alt="LoadAd"> | Loads an app open ad in the background. `AdLoaded` or `AdFailedToLoad` follows. Not needed with `ShowOnReturn` checked. |
| **ShowAd** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/method-showad.png" alt="ShowAd"> | Shows the loaded ad now, for example at startup behind your own loading screen. With nothing loaded, `AdFailedToShow` fires with `Ad Not Ready`. |
| **IsLoaded** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/method-isloaded.png" alt="IsLoaded"> | Returns true when an ad is loaded and not expired. Google says an app open ad expires 4 hours after loading. |
{% endtab %}

{% tab title="Events" %}
| Name | Block | Description |
|---|---|---|
| **AdLoaded** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/event-adloaded.png" alt="AdLoaded"> | An app open ad loaded and is ready to show. |
| **AdFailedToLoad** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/event-adfailedtoload.png" alt="AdFailedToLoad"> | An app open ad could not load.<br>`errorCode`: why, as text such as `No Fill` or `Network Error`<br>`message`: Google's explanation |
| **AdShowed** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/event-adshowed.png" alt="AdShowed"> | The ad now covers the screen. |
| **AdDismissed** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/event-addismissed.png" alt="AdDismissed"> | The user closed the ad. With `ShowOnReturn` checked, the next one is already loading. |
| **AdFailedToShow** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/event-adfailedtoshow.png" alt="AdFailedToShow"> | The ad could not be shown.<br>`errorCode`: why, such as `Ad Not Ready` when nothing was loaded<br>`message`: the explanation |
{% endtab %}

{% tab title="Dropdowns" %}
| Name | Block | Options |
|---|---|---|
| **AppOpenError** | <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/1x/helper-appopenerror.png" alt="AppOpenError"> | `NoFill`, `NetworkError`, `InvalidRequest`, `AppIdMissing`, `InternalError`, `MediationNoFill`, `RequestIdMismatch`, `InvalidAdString`, `AdNotReady`, `AdReused`, `AppNotInForeground`, `MediationShowError`, `Unknown`. Compare it with `errorCode` in `AdFailedToLoad` or `AdFailedToShow`. |
{% endtab %}
{% endtabs %}

## When does it show?

Only when the user **comes back to the app** from another app or the home screen. It
does not show when your app first opens, when you switch between your own screens, or
over another ad. Put the extension on **Screen1**, since it watches the whole app.

## Learn more

* [Tutorial: build the sample step by step](../tutorials/app-open.md)
* [Error codes](errors.md): what each `errorCode` means and what to do
* [Switch to real ads safely](../going-live/real-ads.md)

{% hint style="info" %}
Ads never show in the Companion. Build the APK to test them, as explained in
[Test on your phone](../../getting-started/testing.md).
{% endhint %}
