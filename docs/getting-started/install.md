---
description: Add an extension to your App Inventor project in four steps.
icon: download
---

# Install an extension

An App Inventor extension is one file that ends in `.aix`. You import it into a project,
and it then sits in the Designer palette like any other component. Each project imports
its own extensions, so a new project needs the import again.

{% stepper %}
{% step %}
## Download the .aix file

Every extension page has a **Download .aix** button:
[Banner](../admob/extensions/banner.md), [Interstitial](../admob/extensions/interstitial.md),
[Rewarded](../admob/extensions/rewarded.md), [App Open](../admob/extensions/app-open.md)
and [Rewarded Interstitial](../admob/extensions/rewarded-interstitial.md).

Each AdMob file is about 12 MB, because it carries Google's ads SDK.
{% endstep %}

{% step %}
## Import it into your project

Open your project in App Inventor. At the bottom of the **Palette**, open **Extension**
and click **Import extension**. Choose **From my computer**, pick the `.aix` file, and
click **Import**.

{% hint style="info" %}
You can skip the download: choose **URL** instead and paste the link of the
**Download .aix** button.
{% endhint %}
{% endstep %}

{% step %}
## Drag it onto the screen

The extension now shows under **Extension** in the palette, for example **AdMobBanner**.
Drag it onto Screen1. It has no look of its own, so it appears below the phone preview
under **Non-visible components**, named **AdMobBanner1**.

Click it to see its Designer properties on the right. For a first test you don't need to
change anything: the defaults are Google's test IDs.
{% endstep %}

{% step %}
## Use its blocks

Open the **Blocks** editor and click **AdMobBanner1** in the list on the left. Its events,
functions and properties appear like those of any built-in component.
{% endstep %}
{% endstepper %}

## Updating to a new version

Import the new `.aix` the same way. App Inventor replaces the old one and shows
**Extension Upgraded**. Your blocks stay; the [changelog](../help/changelog.md) says if a
new version renamed or removed any block.

## Good to know

* The extensions work on apps built with MIT's App Inventor server. They need Android 6.0
  or newer, and importing one raises the project's minimum Android version to 6.0.
* Projects with extensions can't be published to the App Inventor Gallery. That is an App
  Inventor rule for all extensions.

Next: [Test on your phone](testing.md), because ads don't show in the Companion.
