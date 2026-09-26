---
description: Build the banner sample app step by step, with a banner in a box and one floating at the bottom.
icon: rectangle-ad
---

# Banner: in your layout or floating

You'll build the banner sample app. It shows a banner inside the layout, can move it to
float at the bottom of the screen, and hides or removes it with buttons.

**You'll learn to:**

* put a banner inside an arrangement with `LoadAd`
* float a banner over the layout with `ShowAt`
* show whether an ad loaded, and why not
* hide, show and remove a banner

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/AdMobBannerDemo.aia" class="button primary" data-icon="box-open">Download the finished project</a>

{% hint style="info" %}
Short on time? Import the finished project with **Projects → Import project (.aia) from
my computer**, then read along.
{% endhint %}

## 1. Build the screen

[Import the AdMob Banner extension](../../getting-started/install.md), then add these
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

## 2. Add the blocks

{% stepper %}
{% step %}
## Load a banner when the app starts

`LoadAd` puts a banner inside BannerBox. **Adaptive** makes it as wide as the box, which
is the size Google recommends.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-screen1-initialize.png" alt="when Screen1.Initialize, call AdMobBanner1.LoadAd with BannerBox and Adaptive" width="472"></figure>
{% endstep %}

{% step %}
## Show what happened

`AdLoaded` fires when the banner is on screen. `AdFailedToLoad` gives the reason when it
isn't, as an `errorCode` like `No Fill` and Google's `message`. `AdImpression` fires when
Google counts the ad as seen.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adloaded.png" alt="when AdMobBanner1.AdLoaded, set StatusLabel to Ad loaded" width="410"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adfailedtoload.png" alt="when AdMobBanner1.AdFailedToLoad, show errorCode and message" width="424"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adimpression.png" alt="when AdMobBanner1.AdImpression, set DetailLabel to Impression counted" width="468"></figure>
{% endstep %}

{% step %}
## Load a new banner on demand

**Load in the box** runs the same `LoadAd` again. One AdMobBanner component shows one
banner at a time, so this replaces the current banner with a fresh one.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-loadbutton-click.png" alt="when LoadButton.Click, call AdMobBanner1.LoadAd" width="472"></figure>
{% endstep %}

{% step %}
## Float it at the bottom

`ShowAt` puts the banner over your layout, at the **Top** or **Bottom** of the screen,
instead of inside an arrangement. The banner leaves BannerBox and moves there. This one
uses the fixed **Banner** size, 320×50.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-showatbutton-click.png" alt="when ShowAtButton.Click, call AdMobBanner1.ShowAt with Bottom and Banner" width="485"></figure>

{% hint style="warning" %}
A floating banner covers whatever is under it. Leave empty space at that edge of your
screen so it doesn't hide a button.
{% endhint %}
{% endstep %}

{% step %}
## Hide and show it

Setting `Visible` to false hides the banner but keeps the ad, so it comes back instantly.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-togglebutton-click.png" alt="when ToggleButton.Click, set AdMobBanner1.Visible to not AdMobBanner1.Visible" width="600"></figure>
{% endstep %}

{% step %}
## Remove it

`DestroyAd` removes the banner and frees its memory. `LoadAd` or `ShowAt` brings a new
one.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-destroybutton-click.png" alt="when DestroyButton.Click, call AdMobBanner1.DestroyAd and set StatusLabel to Destroyed" width="411"></figure>
{% endstep %}
{% endstepper %}

## 3. Try it

Build the APK and open it on your phone ([how](../../getting-started/testing.md)).

* A test banner appears under the labels, and the status says **Ad loaded**.
* **Float at the bottom** moves it to the bottom edge of the screen.
* **Hide / show** makes it disappear and come back.
* **Destroy** removes it; **Load in the box** brings a new one.

## What next

* Every block and size is listed on the [AdMob Banner](../extensions/banner.md) page.
* Add a full-screen ad: [Interstitial between levels](interstitial.md).
