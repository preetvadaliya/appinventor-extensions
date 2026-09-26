---
description: Full-screen ads at natural breaks in your app.
icon: rectangle-ad
---

# AdMob Interstitial

| Extension | Version | Requires | Built on |
|---|---|---|---|
| <img src="https://raw.githubusercontent.com/preetvadaliya/appinventor-extensions/master/docs/images/admob.png" alt="" data-size="line"> AdMobInterstitial | 1.1 | Android 6.0 (API 23) | Google Mobile Ads SDK 25.3.0 |

<a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/de.preet.admob.interstitial.aix" class="button primary" data-icon="download">Download .aix</a> <a href="https://github.com/preetvadaliya/appinventor-extensions/raw/master/admob-interstitial/AdMobInterstitialDemo.aia" class="button secondary" data-icon="box-open">Sample project (.aia)</a>

Shows a full-screen AdMob interstitial ad. Call LoadAd, wait for AdLoaded, then call ShowAd at a natural break in your app. The defaults are Google's test IDs. Ads only work in a built app, never in the Companion.

Load early and show the ad only at a natural break, such as between levels. Each loaded ad shows once, so call `LoadAd` again in `AdDismissed`.

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
