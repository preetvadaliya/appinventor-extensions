---
description: Build the AdMob Rewarded Interstitial sample app step by step.
icon: graduation-cap
---

# AdMob Rewarded Interstitial tutorial

A rewarded interstitial gives a reward like a rewarded ad, but appears at a natural break
instead of after a "watch" button. Google requires an **intro screen** before it that says
what the reward is and lets the user skip. This sample uses a Notifier dialog for that.

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/AdMobRewardedInterstitialDemo.aia" class="button primary" data-icon="box-open">Finished project (.aia)</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded-interstitial/de.preet.admob.rewardedinterstitial.aix" class="button secondary" data-icon="download">Extension (.aix)</a>

## Build the screen

Import the AdMob Rewarded Interstitial extension (**Palette → Extension → Import extension**), then
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

## Add the blocks

### Load an ad when the app starts

So one is ready at the next break.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-screen1-initialize.png" alt="when Screen1.Initialize, call AdMobRewardedInterstitial1.LoadAd" width="369"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-adloaded.png" alt="when AdMobRewardedInterstitial1.AdLoaded, set StatusLabel to Ready. Tap Finish level." width="499"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-adfailedtoload.png" alt="when AdMobRewardedInterstitial1.AdFailedToLoad, set StatusLabel to errorCode" width="424"><figcaption></figcaption></figure></div>

### Show the intro screen at the break

When the level ends and an ad is ready, a dialog says what the reward is and offers
**No thanks**. `cancelable` is false, so the user must pick one of the two.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-finishbutton-click.png" alt="when FinishButton.Click, if IsLoaded then Notifier1.ShowChooseDialog else set StatusLabel to Level finished" width="647"><figcaption></figcaption></figure></div>

### Show the ad only if the user agreed

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-notifier1-afterchoosing.png" alt="when Notifier1.AfterChoosing, if choice = Watch then ShowAd" width="422"><figcaption></figcaption></figure></div>

### Give the reward and load the next ad

As with rewarded ads, give the reward in `UserEarnedReward` only; closing the ad early
skips it.

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-userearnedreward.png" alt="when AdMobRewardedInterstitial1.UserEarnedReward, add rewardAmount to CoinsLabel" width="712"><figcaption></figcaption></figure></div>

<div align="left"><figure><img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/admob-rewarded-interstitial/images/sample-admobrewardedinterstitial1-addismissed.png" alt="when AdMobRewardedInterstitial1.AdDismissed, call LoadAd" width="379"><figcaption></figcaption></figure></div>

## Try it

Build the APK and open it (ads don't show in the Companion). Tap **Finish level**
once the ad is ready: the dialog appears. Choose **Watch** and watch to the end, and the
coins go up. Choose **No thanks**, and nothing is shown.

{% hint style="warning" %}
**Never skip the intro screen.** Google requires it for every rewarded interstitial: it
must say what the reward is and give a clear way to skip.
{% endhint %}

Every block is described in the [AdMob Rewarded Interstitial documentation](documentation.md).

***

{% columns %}
{% column %}
**Preet's App Inventor Extensions**

Free, MIT-licensed extensions for MIT App Inventor by
[Preet Vadaliya](https://github.com/preetvadaliya).

© 2026 Preet Vadaliya · [MIT License](https://github.com/preetvadaliya/appinventor-extensions/blob/master/LICENSE)
{% endcolumn %}

{% column %}
**Links**

* <i class="fa-github">:github:</i> [GitHub](https://github.com/preetvadaliya)
* <i class="fa-download">:download:</i> [Downloads](https://github.com/preetvadaliya/appinventor-extensions)
* <i class="fa-bug">:bug:</i> [Report a bug](https://github.com/preetvadaliya/appinventor-extensions/issues)
* <i class="fa-comments">:comments:</i> [MIT App Inventor Community](https://community.appinventor.mit.edu/t/free-admob-banner-extension/176230)
{% endcolumn %}
{% endcolumns %}

AdMob is a trademark of Google LLC. These extensions are not affiliated with or endorsed by Google.
