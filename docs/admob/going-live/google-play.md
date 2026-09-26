---
description: The Play Console declarations, Data safety answers and app-ads.txt file an app with AdMob ads needs.
icon: google-play
---

# Publishing on Google Play

An app with ads needs a few extra answers in Google Play Console, and a small file on a
website. Build the app for Play with **Build → Android App Bundle (.aab)**.

## Declare that the app contains ads

In Play Console, open **Policy and programs → App content → Ads**, answer **Yes**, and
save. Play then shows a **Contains ads** label on your store listing.

[Google's guide](https://support.google.com/googleplay/android-developer/answer/9859455)

## Advertising ID

Ads on Android 13 and newer need the `AD_ID` permission. Every AdMob extension already
adds it to your app. When Play Console asks under **App content** whether the app uses an
advertising ID, answer **Yes**, for advertising.

[About the advertising ID](https://support.google.com/googleplay/android-developer/answer/6048248)

## Data safety

The Data safety form must include data collected by SDKs in your app, and the AdMob
extensions contain Google's ads SDK. Google lists what it collects and shares, for
advertising, analytics and fraud prevention:

| Data | Examples |
|---|---|
| IP address | May be used to estimate the general location |
| App interactions | App launches, taps, video views |
| Diagnostics | App launch time, hang rate, energy use |
| Device or other IDs | Advertising ID, app set ID |

All of it is encrypted in transit. Add these to your own app's answers. Google's page
is the reference, and it changes over time:
[Google Mobile Ads SDK data disclosure](https://developers.google.com/admob/android/privacy/play-data-disclosure).

## app-ads.txt

New AdMob apps must be verified with an `app-ads.txt` file before they can fully serve
ads. The file proves that you, the app's developer, allow Google to sell its ad space.

{% stepper %}
{% step %}
## Have a website

Play Console needs a developer website: enter it in your store listing's contact details.
No website? A free one works. Google suggests Firebase Hosting, and a GitHub Pages user
site (`yourname.github.io`) works too.
{% endstep %}

{% step %}
## Put the file at the root of the site

In AdMob, open your app's **app-ads.txt** instructions and copy the line it gives you.
It looks like this, with your own publisher ID:

```
google.com, pub-0000000000000000, DIRECT, f08c47fec0942fa0
```

Save it as `app-ads.txt` so it opens at `https://yoursite.com/app-ads.txt`, directly on
the domain, not in a folder.
{% endstep %}

{% step %}
## Wait for AdMob to check it

AdMob can take up to 24 hours to find the file. The app's app-ads.txt status in AdMob
then changes to verified.
{% endstep %}
{% endstepper %}

Sources: [app-ads.txt requirement](https://support.google.com/admob/answer/14538460),
[setting it up](https://support.google.com/admob/answer/9363762).

## Link the app in AdMob

If you added the app to AdMob before publishing, go back and link it to its Play listing
now. Its review (app readiness) starts only after that. See
[Set up AdMob](../setup.md#why-real-ads-dont-show-yet).
