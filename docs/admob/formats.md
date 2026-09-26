---
description: What each AdMob format looks like, when to show it, and which extension it needs.
icon: table-columns
---

# Which ad format should I use?

AdMob has five ad formats that work in App Inventor apps, and there is one extension for
each. They can all be used in the same app.

| Format | What the user sees | When it shows | Does the user choose? | Extension |
|---|---|---|---|---|
| **Banner** | A strip ad that stays on screen while the app is used | On any screen with room for it | No | [AdMob Banner](extensions/banner.md) |
| **Interstitial** | A full-screen ad the user closes after a few seconds | At a natural break: between levels, after a task is done | No | [AdMob Interstitial](extensions/interstitial.md) |
| **Rewarded** | A full-screen ad, usually a video, that gives a reward when watched | When the user taps something like "Watch an ad for 10 coins" | Yes, they ask for it | [AdMob Rewarded](extensions/rewarded.md) |
| **Rewarded interstitial** | A full-screen ad with a reward, after an intro screen the user can skip | At a natural break, such as the end of a level | Yes, they can skip the intro | [AdMob Rewarded Interstitial](extensions/rewarded-interstitial.md) |
| **App open** | A full-screen ad when the user comes back to the app | Automatically when the app returns from the background | No | [AdMob App Open](extensions/app-open.md) |

## Pick this if...

* **You're new to ads:** start with a **banner**. It needs two blocks and can't interrupt
  anyone.
* **Your app has levels, rounds or finished tasks:** add an **interstitial** at those
  breaks.
* **Your app has something to give** (coins, hints, lives, extra time): a **rewarded** ad
  lets users earn it, and users tend to like ads they choose.
* **You want rewarded ads without a "watch" button:** use a **rewarded interstitial** at a
  break, with its intro screen.
* **People open your app many times a day** (utilities, tools): an **app open** ad earns
  from those returns without any blocks.

{% hint style="info" %}
Full-screen formats usually earn more per view than banners, but too many of them drive
users away. Google also limits where they may appear; see
[AdMob policies](going-live/policies.md).
{% endhint %}

## A common setup

A game often uses three: a **banner** on the menu screen, an **interstitial** every few
levels, and a **rewarded** ad for an extra life. See
[Several ad formats in one app](tutorials/several-formats.md).
