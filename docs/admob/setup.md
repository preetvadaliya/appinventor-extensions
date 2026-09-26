---
description: Create an AdMob account, add your app and create ad units, then paste the IDs into the extensions.
icon: gear
---

# Set up AdMob

You need your own AdMob IDs to earn money. Until you have them, keep the extensions'
defaults: they are Google's test IDs and always show test ads.

{% hint style="info" %}
You can set everything up before your app is on Google Play. Ads with your real IDs only
start serving fully after the app is published and reviewed, as explained below.
{% endhint %}

## Two kinds of ID

| ID | Looks like | Where it goes | How many |
|---|---|---|---|
| **App ID** | `ca-app-pub-1234567890123456~1234567890` (with a `~`) | **AppId** on every AdMob component | One per app |
| **Ad unit ID** | `ca-app-pub-1234567890123456/1234567890` (with a `/`) | **AdUnitId** on one component | One per ad placement |

Mixing them up is the most common setup mistake. If an ad fails with `Invalid Request`,
check that **AdUnitId** has the `/` and **AppId** the `~`.

## Steps

{% stepper %}
{% step %}
## Create an AdMob account

Sign in at [admob.google.com](https://admob.google.com) with a Google account and follow
the sign-up. You must be 18 or older; under 18, a parent or guardian can apply with their
own account. You don't need an AdSense account first. Google reviews new accounts,
usually within 24 hours.

[Google's sign-up guide](https://support.google.com/admob/answer/7356219)
{% endstep %}

{% step %}
## Add your app

In AdMob, choose **Apps → Add app**, pick **Android**, and answer whether the app is on
Google Play:

* **Already published:** choose **Yes** and search for it.
* **Not published yet:** choose **No** and enter a name. After you publish, come back and
  **link the app to its store listing**, or it won't get full ad serving.

AdMob then shows your **App ID**.

[Google's guide to adding an app](https://support.google.com/admob/answer/9989980)
{% endstep %}

{% step %}
## Create an ad unit for each placement

Open the app in AdMob, choose **Ad units → Add ad unit**, and pick the format: Banner,
Interstitial, Rewarded, Rewarded interstitial or App open. For rewarded formats you also
set the reward here, for example `10` `coins`. That's what `UserEarnedReward` reports.

Each ad unit has its own **ad unit ID**. Create one per place an ad appears: a banner on
the menu and a banner on the game screen should be two ad units.
{% endstep %}

{% step %}
## Add your phone as a test device

Before you put your real IDs in, tell AdMob which phone is yours, so tapping your own
ads doesn't get your account in trouble:
[Switch to real ads safely](going-live/real-ads.md).
{% endstep %}

{% step %}
## Paste the IDs into the Designer

Select each AdMob component and replace **AppId** and **AdUnitId** with your own values.
Build the app again.
{% endstep %}
{% endstepper %}

## Why real ads don't show yet

With real IDs, expect `No Fill` at first. That's normal:

* **New ad units** typically take up to an hour to start serving, and rarely a few days.
* **App readiness:** every new app is reviewed after it's published on Google Play and
  linked in AdMob. This typically takes 2–3 days. Until it's done, the app gets
  **limited ad serving**: Google caps how many ads it shows.
* **app-ads.txt:** new apps must be verified with an `app-ads.txt` file before they can
  fully serve ads. See [Publishing on Google Play](going-live/google-play.md).

The test IDs always fill, so if they work and your real IDs don't, the problem is one of
the above, not your blocks.

Sources: [app readiness](https://support.google.com/admob/answer/10564477),
[new ad units](https://support.google.com/admob/answer/9469204),
[limited ad serving](https://support.google.com/admob/answer/9493252).

## Getting paid

AdMob pays once your earnings reach the payment threshold, US$100 in most countries, after
you've added payment details and verified your identity and address. See
[Google's payment guide](https://support.google.com/admob/answer/2772208).
