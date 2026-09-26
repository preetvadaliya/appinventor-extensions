---
description: Build the rewarded sample app step by step. Users tap a button, watch an ad and earn coins.
icon: gift
---

# Rewarded: coins for watching an ad

You'll build the rewarded sample app: a coin counter and a **Watch ad for coins** button.
Coins are added only when the user has watched enough of the ad.

**You'll learn to:**

* show a rewarded ad when the user asks for it
* give the reward in `UserEarnedReward`, the only safe place
* load the next ad after each one

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded/AdMobRewardedDemo.aia" class="button primary" data-icon="box-open">Download the finished project</a>

## 1. Build the screen

[Import the AdMob Rewarded extension](../../getting-started/install.md), then add:

| Component | Name | Change these properties |
|---|---|---|
| Label | TitleLabel | Text `AdMob Rewarded demo`, FontSize `20`, FontBold checked |
| Label | StatusLabel | Text `Loading a test ad...` |
| HorizontalArrangement | CoinsRow | AlignHorizontal **Center** |
| Label (inside CoinsRow) | CoinsTitleLabel | Text `Coins:` |
| Label (inside CoinsRow) | CoinsLabel | Text `0`, FontBold checked |
| Button | WatchButton | Text `Watch ad for coins`, Width **Fill parent** |
| AdMobRewarded | AdMobRewarded1 | Nothing: the defaults are Google's test IDs |

## 2. Add the blocks

{% stepper %}
{% step %}
## Load an ad when the app starts

So one is ready when the user asks for it.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-screen1-initialize.png" alt="when Screen1.Initialize, call AdMobRewarded1.LoadAd" width="306"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adloaded.png" alt="when AdMobRewarded1.AdLoaded, set StatusLabel to Ready. Tap Watch ad for coins." width="546"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adfailedtoload.png" alt="when AdMobRewarded1.AdFailedToLoad, set StatusLabel to errorCode" width="424"></figure>
{% endstep %}

{% step %}
## Show it when the user asks

The button checks `IsLoaded` first, so tapping too early just shows a message.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-watchbutton-click.png" alt="when WatchButton.Click, if IsLoaded then ShowAd else set StatusLabel to Not loaded yet" width="488"></figure>
{% endstep %}

{% step %}
## Give the reward

`UserEarnedReward` fires only when the user has watched enough of the ad. Add the reward
**here and nowhere else**: someone who closes the ad early still gets `AdDismissed`, but
not this event.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-userearnedreward.png" alt="when AdMobRewarded1.UserEarnedReward, add rewardAmount to CoinsLabel" width="712"></figure>

`rewardAmount` and `rewardType` come from the ad unit's settings in the AdMob console.
Google's test unit sends a small test reward.
{% endstep %}

{% step %}
## Load the next one

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-addismissed.png" alt="when AdMobRewarded1.AdDismissed, set StatusLabel and call LoadAd" width="485"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adfailedtoshow.png" alt="when AdMobRewarded1.AdFailedToShow, set StatusLabel to errorCode" width="424"></figure>
{% endstep %}
{% endstepper %}

## 3. Try it

Build the APK and open it ([how](../../getting-started/testing.md)). Tap **Watch ad for
coins** once the status says it's ready, and watch the test ad to the end: the coins go
up. Try again and close the ad early: no coins.

{% hint style="info" %}
Say what the user gets before the ad starts, like "Watch an ad for 10 coins". Google
requires rewarded ads to be the user's choice.
{% endhint %}

## What next

* All blocks: [AdMob Rewarded](../extensions/rewarded.md).
* Offer rewards at breaks, without a button:
  [Rewarded interstitial with an intro dialog](rewarded-interstitial.md).
