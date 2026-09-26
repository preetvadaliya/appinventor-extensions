---
description: Free extensions for MIT App Inventor, starting with Google AdMob ads.
icon: house
---

# Preet's App Inventor Extensions

Free extensions for [MIT App Inventor](https://appinventor.mit.edu). The first set shows
**Google AdMob ads**, so the apps you build with blocks can earn money.

<a href="admob/quick-start.md" class="button primary" data-icon="rocket">Show your first ad</a> <a href="admob/formats.md" class="button secondary" data-icon="table-columns">Compare the ad formats</a>

## AdMob extensions

<table data-view="cards">
  <thead>
    <tr>
      <th width="48"></th>
      <th></th>
      <th></th>
      <th data-hidden data-card-target data-type="content-ref"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><i class="fa-rectangle-ad"></i></td>
      <td><strong>Banner</strong></td>
      <td>A strip ad inside your layout, or floating at the top or bottom of the screen.</td>
      <td><a href="admob/extensions/banner.md">banner</a></td>
    </tr>
    <tr>
      <td><i class="fa-window-maximize"></i></td>
      <td><strong>Interstitial</strong></td>
      <td>A full-screen ad at a natural break, such as between levels.</td>
      <td><a href="admob/extensions/interstitial.md">interstitial</a></td>
    </tr>
    <tr>
      <td><i class="fa-gift"></i></td>
      <td><strong>Rewarded</strong></td>
      <td>A full-screen ad the user chooses to watch for coins, a hint or an extra life.</td>
      <td><a href="admob/extensions/rewarded.md">rewarded</a></td>
    </tr>
    <tr>
      <td><i class="fa-door-open"></i></td>
      <td><strong>App Open</strong></td>
      <td>A full-screen ad when the user comes back to your app. Needs no blocks.</td>
      <td><a href="admob/extensions/app-open.md">app open</a></td>
    </tr>
    <tr>
      <td><i class="fa-coins"></i></td>
      <td><strong>Rewarded Interstitial</strong></td>
      <td>A rewarded ad at a natural break, after an intro screen the user can skip.</td>
      <td><a href="admob/extensions/rewarded-interstitial.md">rewarded interstitial</a></td>
    </tr>
  </tbody>
</table>

## Why these extensions

* **Free and open.** MIT licence, no paid version.
* **AppId is a normal Designer property.** No manifest editing and no helper extension:
  paste your App ID and build.
* **Current SDK.** Built on Google Mobile Ads SDK 25.3.0, which Google supports until
  June 30, 2028.
* **Test ads on the first build.** The defaults are Google's test IDs, so you see an ad
  before you even have an AdMob account.
* **Few blocks.** Most apps need two or three blocks per extension.
* **Use one or all five.** They share one copy of Google's ads SDK, so the app doesn't grow
  with each one.

## New here? Follow this path

{% stepper %}
{% step %}
## Pick a format

[Which ad format should I use?](admob/formats.md) explains what each ad looks like and
when to show it.
{% endstep %}

{% step %}
## Show a test ad

[Install the extension](getting-started/install.md), then follow the
[Quick start](admob/quick-start.md). About ten minutes, no AdMob account needed.
{% endstep %}

{% step %}
## Learn the blocks

The [Tutorials](admob/tutorials/README.md) walk through a ready-made sample project for
each format.
{% endstep %}

{% step %}
## Go live

[Set up AdMob](admob/setup.md) to get your own IDs, then read
[Going live](admob/going-live/README.md) before you publish.
{% endstep %}
{% endstepper %}

***

AdMob is a trademark of Google LLC. These extensions are not affiliated with or endorsed
by Google.

Made with ❤️ by Preet
