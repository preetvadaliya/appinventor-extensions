---
description: Every Designer property, block and dropdown of the five AdMob extensions.
icon: puzzle-piece
---

# Extensions

One page per extension, with its download, Designer properties, and every block with a
picture and a description.

| Extension | Package | Version | What it shows |
|---|---|---|---|
| [AdMob Banner](banner.md) | `de.preet.admob.banner` | 1.1 | Banner ads in an arrangement, or floating at the top or bottom |
| [AdMob Interstitial](interstitial.md) | `de.preet.admob.interstitial` | 1.1 | Full-screen ads at natural breaks |
| [AdMob Rewarded](rewarded.md) | `de.preet.admob.rewarded` | 1.0 | Full-screen ads the user chooses to watch for a reward |
| [AdMob App Open](app-open.md) | `de.preet.admob.appopen` | 1.0 | Full-screen ads when the user comes back to the app |
| [AdMob Rewarded Interstitial](rewarded-interstitial.md) | `de.preet.admob.rewardedinterstitial` | 1.0 | Rewarded ads at natural breaks, after an intro screen |

All five are built on Google Mobile Ads SDK 25.3.0, need Android 6.0 or newer, and can be
used together in one app.

## What they have in common

* **The same three Designer properties:** `AppId`, `AdUnitId` and `ChildDirected`.
  App Open adds `ShowOnReturn`.
* **The same `TestDeviceIds` block**, which takes a list.
* **The same error codes.** Every failure event gives an `errorCode` from one shared list:
  see [Error codes](errors.md).
* **Google's test IDs as defaults**, so a new component shows test ads straight away.
