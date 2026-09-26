---
description: What each errorCode from AdFailedToLoad and AdFailedToShow means, and what to do about it.
icon: triangle-exclamation
---

# Error codes

When an ad can't load or can't be shown, the extension fires `AdFailedToLoad` or
`AdFailedToShow` with two values:

* `errorCode`: the reason as short text, such as `No Fill`
* `message`: Google's longer explanation, useful when you ask for help

The five extensions share the same codes. Each has a dropdown block with them
(`BannerError`, `InterstitialError`, `RewardedError`, `AppOpenError`,
`RewardedInterstitialError`) so you can compare without typing: plug `errorCode` and the
dropdown into an **=** block from **Logic**.

## Loading errors

These come in `AdFailedToLoad`.

| errorCode | Dropdown option | What it means | What to do |
|---|---|---|---|
| `No Fill` | `NoFill` | The request worked, but Google had no ad for it right now. **This is normal** and not a mistake in your app. | Nothing. Try again later, for example at the next break. New apps and ad units get few ads at first; see [Set up AdMob](../setup.md). |
| `Network Error` | `NetworkError` | The phone couldn't reach Google: no internet, or a timeout. | Try again when the phone is online. |
| `Invalid Request` | `InvalidRequest` | Google rejected the request, most often because the **AdUnitId is wrong**: a typo, an extra space, or the App ID pasted by mistake. | Copy the ad unit ID (with a `/`) again from AdMob. |
| `App Id Missing` | `AppIdMissing` | Google found no valid App ID. | Check **AppId**: your App ID with a `~`, the same on every AdMob component. |
| `Internal Error` | `InternalError` | Something went wrong inside Google's SDK or servers. | Try again later. If it keeps happening, report it with the `message`. |
| `Mediation No Fill` | `MediationNoFill` | Like No Fill, from a mediation partner. | Treat it like No Fill. |
| `Request Id Mismatch` | `RequestIdMismatch` | An internal mix-up between request and response. | Try again. |
| `Invalid Ad String` | `InvalidAdString` | An internal ad format problem. | Try again. |

## Showing errors

These come in `AdFailedToShow`, from the full-screen formats: Interstitial, Rewarded, App
Open and Rewarded Interstitial.

| errorCode | Dropdown option | What it means | What to do |
|---|---|---|---|
| `Ad Not Ready` | `AdNotReady` | `ShowAd` was called with no ad loaded. | Check `IsLoaded` before `ShowAd`, and call `LoadAd` early. |
| `Ad Reused` | `AdReused` | This ad was already shown. Each loaded ad shows once. | Call `LoadAd` in `AdDismissed`. |
| `App Not In Foreground` | `AppNotInForeground` | `ShowAd` was called while the app wasn't on screen. | Show ads only while the user is in the app. |
| `Mediation Show Error` | `MediationShowError` | A mediation partner failed to show its ad. | Load a new ad. |
| `Internal Error` | `InternalError` | Something went wrong inside Google's SDK. | Load a new ad. |

`Unknown` (`Unknown`) can appear in both events for anything Google hasn't named. The
`message` then tells you more.

## When you don't handle the event

If your blocks have no `AdFailedToLoad` event, the extension decides for you:

* `Invalid Request` and `App Id Missing` are setup mistakes, so they appear as an App
  Inventor error popup, where you'll notice them while testing. If you handle
  `Screen1.ErrorOccurred`, they go there instead.
* Every other code is only written to the log. Your users never see a popup just because
  no ad was available.
