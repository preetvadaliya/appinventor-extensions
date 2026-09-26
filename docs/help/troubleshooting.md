---
description: Answers to the problems people hit most with the AdMob extensions.
icon: circle-question
---

# Troubleshooting and FAQ

First step for any ad problem: show `errorCode` and `message` from `AdFailedToLoad` in a
Label, then look the code up in [Error codes](../admob/extensions/errors.md).

## Ads don't appear

<details>

<summary>No ad in the Companion</summary>

Ads never show in the AI2 Companion: it can't load the Google libraries inside the
extension. Build the APK and install it. See [Test on your phone](../getting-started/testing.md).

</details>

<details>

<summary>Test ads work, but my real IDs give No Fill</summary>

That's normal for a new app. New ad units take up to an hour, new apps get limited ad
serving until Google has reviewed them after publishing, and new apps need a verified
`app-ads.txt`. See [Why real ads don't show yet](../admob/setup.md#why-real-ads-dont-show-yet).

</details>

<details>

<summary>Invalid Request</summary>

The ad unit ID is wrong. Copy it again from AdMob: it contains a `/`. A common mistake is
pasting the App ID (with a `~`) into **AdUnitId**.

</details>

<details>

<summary>The banner loads but I can't see it</summary>

Check the arrangement you pass to `LoadAd`: it must be visible and not squeezed to zero
height. Give it Width **Fill parent** and leave Height **Automatic**. For a floating
banner, remember `ShowAt` puts it at the very top or bottom edge of the screen.

</details>

<details>

<summary>After switching to real IDs, my phone shows "Test mode" ads</summary>

That's right: your phone is registered as a test device, so it gets real ads marked as
test ads. Other people's phones get normal ads.

</details>

## Building

<details>

<summary>The build fails after adding the extension</summary>

Check whether the project also has **another AdMob or Google ads extension**. Two
extensions that each carry their own copy of Google's ads SDK clash when the app is
built. Remove the other one; these five extensions are made to work together.

</details>

<details>

<summary>How much bigger does my app get?</summary>

The `.aix` files are about 12 MB each, but most of that is shared: Google's ads SDK is
added to your app only once, however many of the five extensions you use.

</details>

<details>

<summary>Why did my project's minimum Android version change?</summary>

Google's ads SDK needs Android 6.0 (API 23) or newer, so importing an AdMob extension
raises the project's minimum to 6.0.

</details>

## Other questions

<details>

<summary>Can I use more than one AdMob extension in one app?</summary>

Yes, all five together if you like. Use the same **AppId** on each. See
[Several ad formats in one app](../admob/tutorials/several-formats.md).

</details>

<details>

<summary>Do they work in Kodular, Niotron or other App Inventor versions?</summary>

They're made and tested for apps built on MIT App Inventor. Other builders based on App
Inventor may work, but aren't tested.

</details>

<details>

<summary>iPhone?</summary>

No. App Inventor extensions are Android only.

</details>

<details>

<summary>Can I publish a project with these extensions to the App Inventor Gallery?</summary>

No. App Inventor doesn't allow projects with any extension in the Gallery. Share the
`.aia` file instead.

</details>

<details>

<summary>Do they show a GDPR consent form?</summary>

No. See [Privacy and consent](../admob/going-live/consent.md) for what that means.

</details>

Still stuck? Ask in [Support](support.md).
