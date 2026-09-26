---
description: Five free AdMob extensions for App Inventor, and what they have in common.
icon: rectangle-ad
---

# AdMob

Five extensions that show Google AdMob ads, one per ad format. Each works alone, and all
five can be used in the same app: they share one copy of Google's ads SDK.

| Extension | Shows | Version |
|---|---|---|
| [AdMob Banner](banner/README.md) | A banner inside an arrangement, or floating at the top or bottom | 1.1 |
| [AdMob Interstitial](interstitial/README.md) | A full-screen ad at a natural break | 1.1 |
| [AdMob Rewarded](rewarded/README.md) | A full-screen ad the user chooses to watch for a reward | 1.0 |
| [AdMob App Open](app-open/README.md) | A full-screen ad when the user comes back to the app | 1.0 |
| [AdMob Rewarded Interstitial](rewarded-interstitial/README.md) | A rewarded ad at a natural break, after an intro screen | 1.0 |

All five are built on Google Mobile Ads SDK 25.3.0, which Google supports until June 30,
2028, and need Android 6.0 or newer.

## IDs

Every AdMob component has two IDs, both from your [AdMob](https://admob.google.com)
account:

| Property | Looks like | Notes |
|---|---|---|
| **AppId** | `ca-app-pub-…~…` (with a `~`) | One per app. Use the same value on every AdMob component. |
| **AdUnitId** | `ca-app-pub-…/…` (with a `/`) | One per ad placement, created under **Ad units** in AdMob. |

Both default to Google's test IDs, which always show test ads and are safe to tap. Keep
them while you build. **ChildDirected** and **TestDeviceIds** apply to every AdMob ad in
the app, so set them on any one component.

{% hint style="warning" %}
Ads never show in the AI2 Companion. Build the APK to test them.
{% endhint %}

## Going live

1. **Register your phone as a test device** before using real IDs: AdMob → **Settings →
   Test devices**, with the advertising ID from the phone's **Settings → Google → Ads**.
   Never tap your own real ads.
   [Google's guide](https://support.google.com/admob/answer/9691433)
2. **Paste your real AppId and AdUnitId** into each component and build again.
3. **Declare the ads on Google Play:** App content → Ads, the advertising ID question, and
   the [Data safety answers](https://developers.google.com/admob/android/privacy/play-data-disclosure)
   for Google's ads SDK.
4. **Add an app-ads.txt file** to your developer website. New apps can't fully serve ads
   without it. [Google's guide](https://support.google.com/admob/answer/9363762)
5. **Follow the ad rules:** interstitials only at natural breaks, rewarded ads only when
   the user asks, an intro screen before each rewarded interstitial.
   [AdMob policies](https://support.google.com/admob/answer/6128543)

Expect `No Fill` for the first hours or days: new ad units take time, and new apps get
limited ads until Google has reviewed them after publishing.

{% hint style="info" %}
The extensions don't include Google's consent form, so users in the EEA, the UK and
Switzerland only get limited or non-personalized ads.
[Google's consent requirements](https://support.google.com/admob/answer/13554116)
{% endhint %}

## Error codes

`AdFailedToLoad` and `AdFailedToShow` give an `errorCode` from one shared list. Each
extension has a dropdown block with these options to compare against.

| `errorCode` | When | Meaning and what to do |
|---|---|---|
| `No Fill` | Load | No ad was available right now. Normal; try again later. |
| `Network Error` | Load | The phone couldn't reach Google. Try again when online. |
| `Invalid Request` | Load | Usually a wrong **AdUnitId**. Copy it again from AdMob. |
| `App Id Missing` | Load | No valid **AppId**. Check it has the `~`. |
| `Internal Error` | Load, show | A problem inside Google's SDK or servers. Try again later. |
| `Mediation No Fill` | Load | No ad from a mediation partner. Treat it like No Fill. |
| `Request Id Mismatch` | Load | An internal mix-up. Try again. |
| `Invalid Ad String` | Load | An internal ad format problem. Try again. |
| `Ad Not Ready` | Show | `ShowAd` was called with no ad loaded. Check `IsLoaded` first. |
| `Ad Reused` | Show | This ad was already shown. Call `LoadAd` in `AdDismissed`. |
| `App Not In Foreground` | Show | `ShowAd` was called while the app wasn't on screen. |
| `Mediation Show Error` | Show | A mediation partner failed to show its ad. Load a new one. |
| `Unknown` | Load, show | Anything else. The `message` explains it. |

Without an `AdFailedToLoad` event in your blocks, `Invalid Request` and `App Id Missing`
show as an App Inventor error, so setup mistakes get noticed; other codes are only
logged.

***

AdMob is a trademark of Google LLC. These extensions are not affiliated with or endorsed
by Google.
