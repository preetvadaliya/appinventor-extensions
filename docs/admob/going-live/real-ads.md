---
description: Register your phone as a test device, then switch the extensions to your real AdMob IDs.
icon: shield-halved
---

# Switch to real ads safely

{% hint style="danger" %}
**Never tap your own real ads, and never ask friends to.** Google counts these clicks as
invalid traffic, and it can limit or close your AdMob account.
{% endhint %}

While you build, the default test IDs keep you safe. Once you paste in your real IDs,
your own phone will get real ads, so first tell AdMob which phone is yours.

## Add your phone as a test device

{% stepper %}
{% step %}
## Find your phone's advertising ID

On the phone, open **Settings → Google → Ads**. On some phones it's under
**Settings → Privacy → Ads** instead. Copy the advertising ID shown there.
{% endstep %}

{% step %}
## Add it in AdMob

In AdMob, open **Settings → Test devices → Add test device**. Enter a name, choose
**Android**, paste the advertising ID, and save.

[Google's guide to test devices](https://support.google.com/admob/answer/9691433)
{% endstep %}

{% step %}
## Wait, then check

It typically takes about 15 minutes, and can take up to 24 hours. After that, ads on your
phone carry a **Test mode** label. Google treats them as test ads, so tapping them is safe.
{% endstep %}
{% endstepper %}

Test devices work with the extensions as they are: nothing to change in your blocks. The
setting follows your phone, so it covers every app in your AdMob account.

## Switch to your real IDs

1. Select each AdMob component in the Designer.
2. Replace **AppId** with your App ID (the one with a `~`). It's the same on every
   component.
3. Replace **AdUnitId** with that component's ad unit ID (the one with a `/`).
4. Build the app and open it on your phone. You should see ads labelled **Test mode**.

Seeing `No Fill` instead is normal at first; see
[Why real ads don't show yet](../setup.md#why-real-ads-dont-show-yet).

<details>

<summary>Advanced: the TestDeviceIds block</summary>

Each extension also has a `TestDeviceIds` block that takes a list of device IDs. These
are **not** the advertising ID: they're a code Google writes to the phone's log (logcat)
on the first ad request, in a line like:

```
Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("33BE2250B43518CCDA7DE426D04EE231"))
```

Reading logcat needs a computer with Android's `adb` tool, so the AdMob console method
above is easier. If you do use the block, set it on any one AdMob component before the
first `LoadAd`; it applies to every AdMob ad in the app.

</details>
