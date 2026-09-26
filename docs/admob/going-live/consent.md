---
description: What Google's consent rules for Europe mean for apps using these extensions.
icon: user-shield
---

# Privacy and consent (EEA/UK)

## Google's rule

To show **personalized** ads to users in the European Economic Area, the UK and
Switzerland, an app must ask for consent with a consent tool certified by Google. This
applies since 16 January 2024 in the EEA and UK, and since 31 July 2024 in Switzerland.

AdMob offers such a tool, the **Privacy & messaging** consent form, but it only works in
apps that include Google's User Messaging Platform (UMP) SDK.

## What that means for these extensions

{% hint style="warning" %}
The AdMob extensions **don't include** Google's UMP SDK, so they can't show a consent
form.
{% endhint %}

* **Users in the EEA, the UK and Switzerland** may still get **non-personalized or limited
  ads**, where Google supports them. Expect fewer ads and lower earnings from those
  regions.
* **Users everywhere else** are not affected.
* Your app must still follow Google's
  [EU user consent policy](https://www.google.com/about/company/user-consent-policy/).
  This page isn't legal advice; check what applies to your app.

Sources: [certified consent tools](https://support.google.com/admob/answer/13554116),
[ads without consent](https://support.google.com/admob/answer/10105530),
[Privacy & messaging](https://support.google.com/admob/answer/10113207).
