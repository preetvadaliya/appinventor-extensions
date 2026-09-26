---
description: Build the AdMob Interstitial sample app step by step.
icon: graduation-cap
---

# AdMob Interstitial tutorial

You'll build the interstitial sample app: it loads a full-screen ad when it starts, shows
it when you tap a button, and loads the next one after it closes. In a real app, the
button would be the end of a level or a finished task.

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/AdMobInterstitialDemo.aia" class="button primary" data-icon="box-open">Finished project (.aia)</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/de.preet.admob.interstitial.aix" class="button secondary" data-icon="download">Extension (.aix)</a>

## Build the screen

Import the AdMob Interstitial extension (**Palette → Extension → Import extension**), then add:

| Component | Name | Change these properties |
|---|---|---|
| Label | TitleLabel | Text `AdMob Interstitial demo`, FontSize `20`, FontBold checked |
| Label | StatusLabel | Text `Loading a test ad...` |
| Button | LoadButton | Text `Load ad`, Width **Fill parent** |
| Button | ShowButton | Text `Show ad`, Width **Fill parent** |
| AdMobInterstitial | AdMobInterstitial1 | Nothing: the defaults are Google's test IDs |

## Add the blocks

### Load an ad when the app starts

Loading takes a few seconds, so start early. The ad then waits, ready to show.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-screen1-initialize.png" alt="when Screen1.Initialize, call AdMobInterstitial1.LoadAd" width="302"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-loadbutton-click.png" alt="when LoadButton.Click, call AdMobInterstitial1.LoadAd" width="302"><figcaption></figcaption></figure></div>

### Show whether it loaded

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-adloaded.png" alt="when AdMobInterstitial1.AdLoaded, set StatusLabel to Ready. Tap Show ad." width="483"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-adfailedtoload.png" alt="when AdMobInterstitial1.AdFailedToLoad, set StatusLabel to errorCode" width="424"><figcaption></figcaption></figure></div>

### Show it at the break

Check `IsLoaded` first. If the ad isn't ready yet, the app just carries on; never make a
user wait for an ad.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-showbutton-click.png" alt="when ShowButton.Click, if IsLoaded then ShowAd else set StatusLabel to Not loaded yet" width="488"><figcaption></figcaption></figure></div>

### Load the next one after it closes

Each loaded ad shows only once. `AdDismissed` fires when the user closes it: that's the
moment to resume your app and load the next ad.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-adshowed.png" alt="when AdMobInterstitial1.AdShowed, set StatusLabel to Showing" width="400"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-addismissed.png" alt="when AdMobInterstitial1.AdDismissed, set StatusLabel and call LoadAd" width="485"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-interstitial/images/sample-admobinterstitial1-adfailedtoshow.png" alt="when AdMobInterstitial1.AdFailedToShow, set StatusLabel to errorCode" width="424"><figcaption></figcaption></figure></div>

## Try it

Build the APK and open it (ads don't show in the Companion). The status changes to
**Ready. Tap Show ad.** Tap **Show ad**: a full-screen test ad appears. Close it, and the
status says **Loading the next ad...** until the next one is ready.

{% hint style="warning" %}
**Don't overdo it.** Show interstitials only at real breaks, not every time a button is
tapped, and never while someone is in the middle of something. See
[AdMob policies](https://support.google.com/admob/answer/6128543).
{% endhint %}

Every block is described in the [AdMob Interstitial documentation](documentation.md).
