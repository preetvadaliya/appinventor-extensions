---
description: Use a banner, an interstitial and a rewarded ad in the same app, and the few rules that keep them working together.
icon: layer-group
---

# Several ad formats in one app

All five AdMob extensions can be in one app. They share a single copy of Google's ads
SDK, so each extra format adds almost nothing to the app's size.

This page builds the most common mix: a **banner** that is always visible, an
**interstitial** at breaks, and a **rewarded** ad the user can ask for.

## 1. Add the extensions

[Import](../../getting-started/install.md) AdMob Banner, AdMob Interstitial and AdMob
Rewarded, and drag one of each onto Screen1. Add a HorizontalArrangement named
**BannerBox** with Width **Fill parent** for the banner.

## 2. Set the shared properties once

Some settings belong to the whole app, not to one ad:

| Property | Where to set it |
|---|---|
| **AppId** | The **same** value on every AdMob component. Your app has one App ID. |
| **AdUnitId** | A **different** ad unit on each component, one per format, all from the same app in AdMob. |
| **ChildDirected** | On any one component; it applies to every ad in the app. |
| **TestDeviceIds** | On any one component; it applies to every ad in the app. |

## 3. Load everything at the start

Each format loads on its own. Start them all when the screen opens, so each is ready when
it's needed:

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/docs/images/several-formats-initialize.png" alt="when Screen1.Initialize, load the banner into BannerBox, then load the interstitial and the rewarded ad" width="472"></figure>

Then use each one as in its own tutorial:

* the interstitial at breaks, reloading in `AdDismissed`:
  [Interstitial between levels](interstitial.md)
* the rewarded ad when the user taps a "watch" button, rewarding in `UserEarnedReward`:
  [Rewarded: coins for watching an ad](rewarded.md)

## Rules for mixing formats

* **One full-screen ad at a time.** Never show an interstitial right after a rewarded ad or
  another interstitial. Google forbids back-to-back full-screen ads.
* **App open knows about the others.** AdMob App Open never shows on top of another ad, so
  it can sit next to any of them.
* **Pause the banner under a full-screen ad?** Not needed: the full-screen ad covers it,
  and the banner carries on afterwards.
* **Each screen needs its own components.** An AdMob component works on the screen it's
  on. For a banner on Screen2, add an AdMobBanner to Screen2 too. App Open is the
  exception: put it on Screen1 only.

{% hint style="info" %}
More formats don't always mean more money. Two formats used well usually beat five that
annoy users. See [AdMob policies](../going-live/policies.md) for the limits.
{% endhint %}
