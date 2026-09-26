---
description: Ads only appear in a built app. How to build it, install it and read errors.
icon: mobile-screen
---

# Test on your phone

{% hint style="warning" %}
**Ads never show in the AI2 Companion.** The Companion can load an extension's blocks, but
not the Google libraries inside it. Build the app to test ads.
{% endhint %}

The rest of your app keeps working in the Companion, so keep using it for your layout and
logic, and build an APK whenever you want to see the ads.

## Build and install the app

{% stepper %}
{% step %}
## Build the APK

In App Inventor, choose **Build → Android App (.apk)**. Building an app with an AdMob
extension takes a little longer than usual, because the ads SDK is added to it.
{% endstep %}

{% step %}
## Put it on your phone

Scan the QR code App Inventor shows with the **MIT AI2 Companion** app, or download the
`.apk` on your computer and copy it to the phone.
{% endstep %}

{% step %}
## Install and open it

Open the downloaded file on the phone. Android may ask you to allow installs from this
source the first time. Then open the app.
{% endstep %}
{% endstepper %}

## What a test ad looks like

With the default IDs you get Google's test ads. They look like real ads but carry a
**Test Ad** label, and tapping them is safe: they earn nothing, charge no advertiser, and
don't put your AdMob account at risk. Use them while you build.

## When no ad appears

Show the reason on screen. Every extension has an `AdFailedToLoad` event with an
`errorCode` and a `message`; put both into a Label:

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-banner/images/sample-admobbanner1-adfailedtoload.png" alt="AdFailedToLoad shows the error in two labels" width="424"></figure>

Then look the code up in [Error codes](../admob/extensions/errors.md). The most common
reasons:

| What you see | Why | What to do |
|---|---|---|
| Nothing at all | You're in the Companion | Build the APK |
| `Network Error` | The phone is offline | Connect to the internet and try again |
| `No Fill` with the test IDs | Rare; usually a network hiccup | Try again in a minute |
| `No Fill` with your real IDs | New ad units take time, or no ad matched | Normal at first; see [Set up AdMob](../admob/setup.md) |

More in [Troubleshooting and FAQ](../help/troubleshooting.md).
