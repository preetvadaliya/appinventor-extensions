---
description: Build the rewarded interstitial sample app. Offer a reward at the end of a level with an intro dialog the user can skip.
icon: coins
---

# Rewarded interstitial with an intro dialog

A rewarded interstitial gives a reward like a rewarded ad, but appears at a natural break
instead of after a "watch" button. Google requires an **intro screen** before it that says
what the reward is and lets the user skip. This sample uses a Notifier dialog for that.

**You'll learn to:**

* offer the ad at a break with an intro dialog
* show it only if the user agreed
* give the reward in `UserEarnedReward`

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/AdMobRewardedInterstitialDemo.aia" class="button primary" data-icon="box-open">Download the finished project</a>

## 1. Build the screen

[Import the AdMob Rewarded Interstitial extension](../../getting-started/install.md), then
add:

| Component | Name | Change these properties |
|---|---|---|
| Label | TitleLabel | Text `AdMob Rewarded Interstitial demo`, FontSize `20`, FontBold checked |
| Label | StatusLabel | Text `Loading a test ad...` |
| HorizontalArrangement | CoinsRow | AlignHorizontal **Center** |
| Label (inside CoinsRow) | CoinsTitleLabel | Text `Coins:` |
| Label (inside CoinsRow) | CoinsLabel | Text `0`, FontBold checked |
| Button | FinishButton | Text `Finish level`, Width **Fill parent** |
| Notifier | Notifier1 | Nothing (from **User Interface**) |
| AdMobRewardedInterstitial | AdMobRewardedInterstitial1 | Nothing: the defaults are Google's test IDs |

## 2. Add the blocks

{% stepper %}
{% step %}
## Load an ad when the app starts

So one is ready at the next break.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-screen1-initialize.png" alt="when Screen1.Initialize, call AdMobRewardedInterstitial1.LoadAd" width="369"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-adloaded.png" alt="when AdMobRewardedInterstitial1.AdLoaded, set StatusLabel to Ready. Tap Finish level." width="499"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-adfailedtoload.png" alt="when AdMobRewardedInterstitial1.AdFailedToLoad, set StatusLabel to errorCode" width="424"></figure>
{% endstep %}

{% step %}
## Show the intro screen at the break

When the level ends and an ad is ready, a dialog says what the reward is and offers
**No thanks**. `cancelable` is false, so the user must pick one of the two.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-finishbutton-click.png" alt="when FinishButton.Click, if IsLoaded then Notifier1.ShowChooseDialog else set StatusLabel to Level finished" width="647"></figure>
{% endstep %}

{% step %}
## Show the ad only if the user agreed

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-notifier1-afterchoosing.png" alt="when Notifier1.AfterChoosing, if choice = Watch then ShowAd" width="422"></figure>
{% endstep %}

{% step %}
## Give the reward and load the next ad

As with rewarded ads, give the reward in `UserEarnedReward` only; closing the ad early
skips it.

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-userearnedreward.png" alt="when AdMobRewardedInterstitial1.UserEarnedReward, add rewardAmount to CoinsLabel" width="712"></figure>

<figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-addismissed.png" alt="when AdMobRewardedInterstitial1.AdDismissed, call LoadAd" width="379"></figure>
{% endstep %}
{% endstepper %}

## 3. Try it

Build the APK and open it ([how](../../getting-started/testing.md)). Tap **Finish level**
once the ad is ready: the dialog appears. Choose **Watch** and watch to the end, and the
coins go up. Choose **No thanks**, and nothing is shown.

{% hint style="warning" %}
**Never skip the intro screen.** Google requires it for every rewarded interstitial: it
must say what the reward is and give a clear way to skip.
{% endhint %}

## What next

* All blocks: [AdMob Rewarded Interstitial](../extensions/rewarded-interstitial.md).
* Use it next to other formats: [Several ad formats in one app](several-formats.md).
