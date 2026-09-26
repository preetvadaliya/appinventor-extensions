---
description: Build the AdMob Rewarded sample app step by step.
icon: graduation-cap
---

# AdMob Rewarded tutorial

You'll build the rewarded sample app: a coin counter and a **Watch ad for coins** button.
Coins are added only when the user has watched enough of the ad.

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded/AdMobRewardedDemo.aia" class="button primary" data-icon="box-open">Finished project (.aia)</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded/de.preet.admob.rewarded.aix" class="button secondary" data-icon="download">Extension (.aix)</a>

## Build the screen

Import the AdMob Rewarded extension (**Palette → Extension → Import extension**), then add:

| Component | Name | Change these properties |
|---|---|---|
| Label | TitleLabel | Text `AdMob Rewarded demo`, FontSize `20`, FontBold checked |
| Label | StatusLabel | Text `Loading a test ad...` |
| HorizontalArrangement | CoinsRow | AlignHorizontal **Center** |
| Label (inside CoinsRow) | CoinsTitleLabel | Text `Coins:` |
| Label (inside CoinsRow) | CoinsLabel | Text `0`, FontBold checked |
| Button | WatchButton | Text `Watch ad for coins`, Width **Fill parent** |
| AdMobRewarded | AdMobRewarded1 | Nothing: the defaults are Google's test IDs |

## Add the blocks

### Load an ad when the app starts

So one is ready when the user asks for it.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-screen1-initialize.png" alt="when Screen1.Initialize, call AdMobRewarded1.LoadAd" width="306"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adloaded.png" alt="when AdMobRewarded1.AdLoaded, set StatusLabel to Ready. Tap Watch ad for coins." width="546"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adfailedtoload.png" alt="when AdMobRewarded1.AdFailedToLoad, set StatusLabel to errorCode" width="424"><figcaption></figcaption></figure></div>

### Show it when the user asks

The button checks `IsLoaded` first, so tapping too early just shows a message.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-watchbutton-click.png" alt="when WatchButton.Click, if IsLoaded then ShowAd else set StatusLabel to Not loaded yet" width="488"><figcaption></figcaption></figure></div>

### Give the reward

`UserEarnedReward` fires only when the user has watched enough of the ad. Add the reward
**here and nowhere else**: someone who closes the ad early still gets `AdDismissed`, but
not this event.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-userearnedreward.png" alt="when AdMobRewarded1.UserEarnedReward, add rewardAmount to CoinsLabel" width="712"><figcaption></figcaption></figure></div>

`rewardAmount` and `rewardType` come from the ad unit's settings in the AdMob console.
Google's test unit sends a small test reward.

### Load the next one

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-addismissed.png" alt="when AdMobRewarded1.AdDismissed, set StatusLabel and call LoadAd" width="485"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded/images/sample-admobrewarded1-adfailedtoshow.png" alt="when AdMobRewarded1.AdFailedToShow, set StatusLabel to errorCode" width="424"><figcaption></figcaption></figure></div>

## Try it

Build the APK and open it (ads don't show in the Companion). Tap **Watch ad for
coins** once the status says it's ready, and watch the test ad to the end: the coins go
up. Try again and close the ad early: no coins.

{% hint style="info" %}
Say what the user gets before the ad starts, like "Watch an ad for 10 coins". Google
requires rewarded ads to be the user's choice.
{% endhint %}

Every block is described in the [AdMob Rewarded documentation](documentation.md).
