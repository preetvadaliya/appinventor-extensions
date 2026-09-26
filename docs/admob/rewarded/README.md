---
description: Full-screen ads the user chooses to watch for a reward.
icon: rectangle-ad
---

# AdMob Rewarded

| Extension | Version | Requires | Built on |
|---|---|---|---|
| <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/docs/images/admob.png" alt="" data-size="line"> AdMobRewarded | 1.0 | Android 6.0 (API 23) | Google Mobile Ads SDK 25.3.0 |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded/de.preet.admob.rewarded.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-rewarded/AdMobRewardedDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

Shows a full-screen AdMob rewarded ad that the user chooses to watch for a reward. Call LoadAd, wait for AdLoaded, then call ShowAd when the user asks for the reward, and give it in UserEarnedReward. The defaults are Google's test IDs. Ads only work in a built app, never in the Companion.

Show it only when the user asks for it, and give the reward in `UserEarnedReward` only: someone who closes the ad early still gets `AdDismissed`, but not the reward.

<table data-view="cards">
  <thead>
    <tr>
      <th></th>
      <th></th>
      <th data-hidden data-card-target data-type="content-ref"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Documentation</strong></td>
      <td>Every event, method, property and dropdown, with its block.</td>
      <td><a href="documentation.md">documentation</a></td>
    </tr>
    <tr>
      <td><strong>Tutorial</strong></td>
      <td>Build the sample app step by step.</td>
      <td><a href="tutorial.md">tutorial</a></td>
    </tr>
  </tbody>
</table>

App ID, test ads, going live and error codes are explained on the [AdMob](../README.md) page.

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
