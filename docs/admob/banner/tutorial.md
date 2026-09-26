---
description: Build the AdMob Banner sample app step by step.
icon: graduation-cap
---

# AdMob Banner tutorial

You'll build the banner sample app. It shows a banner inside the layout, can move it to
float at the bottom of the screen, and hides or removes it with buttons.

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/AdMobBannerDemo.aia" class="button primary" data-icon="box-open">Finished project (.aia)</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/de.preet.admob.banner.aix" class="button secondary" data-icon="download">Extension (.aix)</a>

## Build the screen

Import the AdMob Banner extension (**Palette → Extension → Import extension**), then add these
components to Screen1, from top to bottom:

| Component | Name | Change these properties |
|---|---|---|
| Label | TitleLabel | Text `AdMob Banner demo`, FontSize `20`, FontBold checked |
| Label | StatusLabel | Text `Loading a test ad...` |
| Label | DetailLabel | Text empty |
| HorizontalArrangement | BannerBox | Width **Fill parent**, AlignHorizontal **Center** |
| Button | LoadButton | Text `Load in the box`, Width **Fill parent** |
| Button | ShowAtButton | Text `Float at the bottom`, Width **Fill parent** |
| Button | ToggleButton | Text `Hide / show`, Width **Fill parent** |
| Button | DestroyButton | Text `Destroy`, Width **Fill parent** |
| AdMobBanner | AdMobBanner1 | Nothing: the defaults are Google's test IDs |

BannerBox is where the banner goes. The sample keeps it under the labels so you can see
it move; in your own app, the bottom of the screen is the usual place.

## Add the blocks

### Load a banner when the app starts

`LoadAd` puts a banner inside BannerBox. **Adaptive** makes it as wide as the box, which
is the size Google recommends.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-screen1-initialize.png" alt="when Screen1.Initialize, call AdMobBanner1.LoadAd with BannerBox and Adaptive" width="472"><figcaption></figcaption></figure></div>

### Show what happened

`AdLoaded` fires when the banner is on screen. `AdFailedToLoad` gives the reason when it
isn't, as an `errorCode` like `No Fill` and Google's `message`. `AdImpression` fires when
Google counts the ad as seen.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adloaded.png" alt="when AdMobBanner1.AdLoaded, set StatusLabel to Ad loaded" width="410"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adfailedtoload.png" alt="when AdMobBanner1.AdFailedToLoad, show errorCode and message" width="424"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adimpression.png" alt="when AdMobBanner1.AdImpression, set DetailLabel to Impression counted" width="468"><figcaption></figcaption></figure></div>

### Load a new banner on demand

**Load in the box** runs the same `LoadAd` again. One AdMobBanner component shows one
banner at a time, so this replaces the current banner with a fresh one.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-loadbutton-click.png" alt="when LoadButton.Click, call AdMobBanner1.LoadAd" width="472"><figcaption></figcaption></figure></div>

### Float it at the bottom

`ShowAt` puts the banner over your layout, at the **Top** or **Bottom** of the screen,
instead of inside an arrangement. The banner leaves BannerBox and moves there. This one
uses the fixed **Banner** size, 320×50.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-showatbutton-click.png" alt="when ShowAtButton.Click, call AdMobBanner1.ShowAt with Bottom and Banner" width="485"><figcaption></figcaption></figure></div>

{% hint style="warning" %}
A floating banner covers whatever is under it. Leave empty space at that edge of your
screen so it doesn't hide a button.
{% endhint %}

### Hide and show it

Setting `Visible` to false hides the banner but keeps the ad, so it comes back instantly.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-togglebutton-click.png" alt="when ToggleButton.Click, set AdMobBanner1.Visible to not AdMobBanner1.Visible" width="600"><figcaption></figcaption></figure></div>

### Remove it

`DestroyAd` removes the banner and frees its memory. `LoadAd` or `ShowAt` brings a new
one.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-destroybutton-click.png" alt="when DestroyButton.Click, call AdMobBanner1.DestroyAd and set StatusLabel to Destroyed" width="411"><figcaption></figcaption></figure></div>

## Try it

Build the APK and open it on your phone (ads don't show in the Companion).

* A test banner appears under the labels, and the status says **Ad loaded**.
* **Float at the bottom** moves it to the bottom edge of the screen.
* **Hide / show** makes it disappear and come back.
* **Destroy** removes it; **Load in the box** brings a new one.

Every block is described in the [AdMob Banner documentation](documentation.md).
