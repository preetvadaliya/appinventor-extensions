---
description: Release history of the AdMob extensions.
icon: clock-rotate-left
---

# Changelog

Import a new `.aix` over the old one to update; your blocks stay unless an entry below
says a block changed.

{% updates format="full" %}
{% update date="2026-09-26" %}
## App Open 1.0 and Rewarded Interstitial 1.0

* **AdMob App Open:** full-screen ads when the user comes back to the app, shown
  automatically with the new **ShowOnReturn** property.
* **AdMob Rewarded Interstitial:** rewarded ads at natural breaks, after an intro screen.
{% endupdate %}

{% update date="2026-09-26" %}
## Rewarded 1.0

* **AdMob Rewarded:** full-screen ads the user chooses to watch, with the
  `UserEarnedReward` event.
{% endupdate %}

{% update date="2026-09-26" %}
## Banner 1.1 and Interstitial 1.1

* Updated to Google Mobile Ads SDK 25.3.0, which Google supports until June 30, 2028.
* No block changes.
{% endupdate %}

{% update date="2026-09-26" %}
## Interstitial 1.0

* **AdMob Interstitial:** full-screen ads at natural breaks.
{% endupdate %}

{% update date="2026-09-26" %}
## Banner 1.0

* **AdMob Banner:** banner ads with `LoadAd` into an arrangement or `ShowAt` the top or
  bottom of the screen. First release, on Google Mobile Ads SDK 24.4.0.
{% endupdate %}
{% endupdates %}
