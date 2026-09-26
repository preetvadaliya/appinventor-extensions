---
description: Build the AdMob App Open sample app step by step.
icon: graduation-cap
---

# AdMob App Open tutorial

App open ads appear when a user switches back to your app from another app or the home
screen. App Inventor has no block for "the user came back", so the extension watches for
it itself. With **ShowOnReturn** checked, which is the default, it needs **no blocks at
all**.

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-app-open/AdMobAppOpenDemo.aia" class="button primary" data-icon="box-open">Finished project (.aia)</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-app-open/de.preet.admob.appopen.aix" class="button secondary" data-icon="download">Extension (.aix)</a>

## Build the screen

Import the AdMob App Open extension (**Palette → Extension → Import extension**), then add:

| Component | Name | Change these properties |
|---|---|---|
| Label | TitleLabel | Text `AdMob App Open demo`, FontSize `20`, FontBold checked |
| Label | StatusLabel | Text `Loading a test ad...` |
| Label | HintLabel | Text `Leave the app and come back to see the ad.` |
| Button | ShowButton | Text `Show now`, Width **Fill parent** |
| AdMobAppOpen | AdMobAppOpen1 | Nothing: **ShowOnReturn** is already checked |

{% hint style="warning" %}
Put AdMob App Open on **Screen1** only. It watches the whole app, whichever screen is open.
{% endhint %}

That's the whole setup. Build it now and it already works. The blocks below only show
on screen what's happening.

## Add the blocks

### Follow the ad

The extension loads an ad as soon as the app starts. These events report each stage:
ready, failed, on screen, and closed (the next one is then already loading).

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-admobappopen1-adloaded.png" alt="when AdMobAppOpen1.AdLoaded, set StatusLabel to Ready. Leave the app and come back." width="594"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-admobappopen1-adfailedtoload.png" alt="when AdMobAppOpen1.AdFailedToLoad, set StatusLabel to errorCode" width="424"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-admobappopen1-adshowed.png" alt="when AdMobAppOpen1.AdShowed, set StatusLabel to Showing" width="400"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-admobappopen1-addismissed.png" alt="when AdMobAppOpen1.AdDismissed, set StatusLabel to Loading the next ad..." width="485"><figcaption></figcaption></figure></div>

### Show one on demand

`ShowAd` shows the loaded ad right away. Use it, for example, at startup behind your own
loading screen, which is the only way Google allows app open ads at launch.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-app-open/images/sample-showbutton-click.png" alt="when ShowButton.Click, if IsLoaded then ShowAd else set StatusLabel to Not loaded yet" width="488"><figcaption></figcaption></figure></div>

## Try it

Build the APK and open it (ads don't show in the Companion). Wait for **Ready.
Leave the app and come back.**, then press the phone's **Home** button and open the app
again: a full-screen test ad appears.

It does **not** appear:

* when the app first opens,
* when you move between your app's own screens,
* on top of another ad.

## How it decides

* It counts how many of your app's screens are visible. The ad shows only when that goes
  from none to one, which means the user came back from outside the app.
* Google says an app open ad expires 4 hours after loading. An older ad counts as not
  loaded, and a fresh one is loaded instead.
* Uncheck **ShowOnReturn** to turn all of this off and use `LoadAd` and `ShowAd` yourself.

Every block is described in the [AdMob App Open documentation](documentation.md).

***

{% columns %}
{% column %}
**Preet's App Inventor Extensions**

Free, MIT-licensed extensions for MIT App Inventor by
[Preet Vadaliya](https://github.com/preetvadaliya).

© 2026 Preet Vadaliya · [MIT License](https://github.com/preetvadaliya/appinventor-extensions/blob/master/LICENSE)
{% endcolumn %}

{% column %}
**Links**

* <i class="fa-github">:github:</i> [GitHub](https://github.com/preetvadaliya)
* <i class="fa-download">:download:</i> [Downloads](https://github.com/preetvadaliya/appinventor-extensions)
* <i class="fa-bug">:bug:</i> [Report a bug](https://github.com/preetvadaliya/appinventor-extensions/issues)
* <i class="fa-comments">:comments:</i> [MIT App Inventor Community](https://community.appinventor.mit.edu/t/free-admob-banner-extension/176230)
{% endcolumn %}
{% endcolumns %}

AdMob is a trademark of Google LLC. These extensions are not affiliated with or endorsed by Google.
