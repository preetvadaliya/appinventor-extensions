---
description: Free extensions for MIT App Inventor.
icon: house
layout:
  width: wide
  title:
    visible: true
  description:
    visible: true
  tableOfContents:
    visible: false
  outline:
    visible: false
  pagination:
    visible: false
---

# Preet's App Inventor Extensions

Free, MIT-licensed extensions for [MIT App Inventor](https://appinventor.mit.edu), each
with full documentation and a step-by-step tutorial.

<a href="admob/README.md" class="button primary" data-icon="rectangle-ad">AdMob extensions</a> <a href="https://github.com/preetvadaliya/appinventor-extensions" class="button secondary" data-icon="github">GitHub</a>

## AdMob

Show Google AdMob ads in your app, one extension per ad format. Use one, or all five
together.

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
      <td>A banner inside your layout, or floating at the top or bottom of the screen.</td>
      <td><a href="admob/banner/README.md">banner</a></td>
    </tr>
    <tr>
      <td><i class="fa-window-maximize"></i></td>
      <td><strong>Interstitial</strong></td>
      <td>A full-screen ad at a natural break, such as between levels.</td>
      <td><a href="admob/interstitial/README.md">interstitial</a></td>
    </tr>
    <tr>
      <td><i class="fa-gift"></i></td>
      <td><strong>Rewarded</strong></td>
      <td>A full-screen ad the user chooses to watch for coins, a hint or an extra life.</td>
      <td><a href="admob/rewarded/README.md">rewarded</a></td>
    </tr>
    <tr>
      <td><i class="fa-door-open"></i></td>
      <td><strong>App Open</strong></td>
      <td>A full-screen ad when the user comes back to your app. Needs no blocks.</td>
      <td><a href="admob/app-open/README.md">app open</a></td>
    </tr>
    <tr>
      <td><i class="fa-coins"></i></td>
      <td><strong>Rewarded Interstitial</strong></td>
      <td>A rewarded ad at a natural break, after an intro screen the user can skip.</td>
      <td><a href="admob/rewarded-interstitial/README.md">rewarded interstitial</a></td>
    </tr>
  </tbody>
</table>

* **AppId is a Designer property:** no manifest editing, no helper extension.
* **Test ads on the first build:** the defaults are Google's test IDs.
* **Current SDK:** Google Mobile Ads SDK 25.3.0, supported by Google until June 30, 2028.

## Using an extension

Download the `.aix` file from the extension's page. In App Inventor, open
**Palette → Extension → Import extension**, choose the file, then drag the extension onto
your screen. Ads only show in a built app, not in the Companion.

***

Made with ❤️ by Preet
