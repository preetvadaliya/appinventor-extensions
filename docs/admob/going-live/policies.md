---
description: The AdMob rules that matter most for App Inventor apps, per ad format.
icon: scale-balanced
---

# AdMob policies: avoid a ban

Google can limit or close an AdMob account that breaks its rules. These are the ones
beginners run into most. The full rules are in the
[AdMob program policies](https://support.google.com/admob/answer/6128543).

{% hint style="danger" %}
**Don't click your own ads.** Testing by tapping your own real ads is not allowed, and
neither is asking others to tap them. Use test ads or a
[test device](real-ads.md).
{% endhint %}

## Every format

* Never encourage taps: no "click the ad" text, arrows or rewards for clicking.
* Keep ads away from buttons so nobody taps them by accident.
* If the app is for children, check **ChildDirected** and follow Google Play's Families
  policy.

## Banner

* Don't cover your app's content or buttons with a floating banner.
* One banner per screen is plenty.

## Interstitial

* **Never when the app opens or closes.**
* **Only at natural breaks**, never while the user is in the middle of something.
* At most one interstitial every two user actions, and never two full-screen ads in a
  row.
* Load it early so it doesn't pop up late.

[Google's interstitial guidance](https://support.google.com/admob/answer/6201362)

## Rewarded

* **Only when the user asks for it**, for example with a "Watch an ad for 10 coins"
  button that says what they get.
* The user must be able to decline.

## Rewarded interstitial

* **Always show an intro screen first** that says what the reward is, with a clear way to
  say no and enough time to do it.

[Google's rewarded ads policy](https://support.google.com/admob/answer/7313578)

## App open

* Google expects app open ads while the user is waiting, for example on a loading screen
  or when coming back to the app. AdMob App Open with **ShowOnReturn** follows this: it
  never shows on first launch or between your own screens.
* If you show one at startup with `ShowAd`, put your own loading screen behind it.

[Google's app open guidance](https://developers.google.com/admob/android/app-open)
