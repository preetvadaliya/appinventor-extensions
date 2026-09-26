---
description: Show a test banner in a new app in five steps. No AdMob account needed.
icon: bolt
---

# Quick start: your first banner

This shows a Google test banner in a new App Inventor app, in about ten minutes. You don't
need an AdMob account yet: the extension's defaults are Google's test IDs.

{% stepper %}
{% step %}
## Start a project and import the extension

Create a new project. Download
[de.preet.admob.banner.aix](https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-banner/de.preet.admob.banner.aix)
and import it: **Palette → Extension → Import extension**.
[Install an extension](../getting-started/install.md) shows each step.
{% endstep %}

{% step %}
## Make room for the banner

From **Layout**, drag a **HorizontalArrangement** onto Screen1. In its properties, set
**Width** to **Fill parent**, and rename it **BannerBox** so it's easy to find in the
blocks. The banner will appear inside it.

{% hint style="info" %}
Put BannerBox where you want the ad: at the bottom of the screen is the usual place.
{% endhint %}
{% endstep %}

{% step %}
## Add the extension

From **Extension**, drag **AdMobBanner** onto the screen. It appears under
**Non-visible components** as **AdMobBanner1**. Leave its properties as they are.
{% endstep %}

{% step %}
## Add one block

Open **Blocks**. Build this:

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-screen1-initialize.png" alt="when Screen1.Initialize call AdMobBanner1.LoadAd arrangement BannerBox size Adaptive" width="472"></figure>

1. From **Screen1**, drag out **when Screen1.Initialize**.
2. From **AdMobBanner1**, drag **call AdMobBanner1.LoadAd** into it. It comes with a
   **BannerSize** block already set to **Adaptive**, the size Google recommends.
3. From **BannerBox**, drag the plain **BannerBox** block (at the bottom of its drawer)
   into the **arrangement** socket.
{% endstep %}

{% step %}
## Build and open the app

Choose **Build → Android App (.apk)**, install it on your phone and open it. After a
second or two a banner labelled **Test Ad** appears in BannerBox.

The Companion won't show it; see [Test on your phone](../getting-started/testing.md).
{% endstep %}
{% endstepper %}

## Next steps

* See what went wrong when no ad appears: add the `AdFailedToLoad` event, as in the
  [banner tutorial](tutorials/banner.md).
* Get your own IDs in [Set up AdMob](setup.md). Until then, keep the test IDs.
* Try another format: [Which ad format should I use?](formats.md)
