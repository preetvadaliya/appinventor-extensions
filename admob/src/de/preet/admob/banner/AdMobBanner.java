// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2026 Preet Vadaliya
// Released under the MIT License

package de.preet.admob.banner;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesActivities;
import com.google.appinventor.components.annotations.UsesApplicationMetadata;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.annotations.UsesQueries;
import com.google.appinventor.components.annotations.androidmanifest.ActionElement;
import com.google.appinventor.components.annotations.androidmanifest.ActivityElement;
import com.google.appinventor.components.annotations.androidmanifest.CategoryElement;
import com.google.appinventor.components.annotations.androidmanifest.DataElement;
import com.google.appinventor.components.annotations.androidmanifest.IntentFilterElement;
import com.google.appinventor.components.annotations.androidmanifest.MetaDataElement;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.HVArrangement;
import com.google.appinventor.components.runtime.OnDestroyListener;
import com.google.appinventor.components.runtime.OnPauseListener;
import com.google.appinventor.components.runtime.OnResumeListener;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.YailList;

import java.util.ArrayList;
import java.util.List;

/**
 * An AdMob banner ad. It is non-visible because the Designer cannot draw a visible
 * extension, so the banner is placed at run time with ShowIn or ShowAt.
 */
@DesignerComponent(version = 1,
    versionName = "1.0",
    category = ComponentCategory.EXTENSION,
    description = "Shows an AdMob banner ad. Set AppId and AdUnitId, call LoadAd, then "
        + "ShowIn an arrangement or ShowAt the top or bottom of the screen. The defaults "
        + "are Google's test IDs. Ads only work in a built app, never in the Companion.",
    androidMinSdk = 23,
    nonVisible = true,
    iconName = "aiwebres/icon.png")
@SimpleObject(external = true)
@UsesPermissions({
    "android.permission.INTERNET",
    "android.permission.ACCESS_NETWORK_STATE",
    "com.google.android.gms.permission.AD_ID"
})
// Without these, Android 11+ hides the browser from the app and tapped ads do nothing.
@UsesQueries(intents = {
    @IntentFilterElement(
        actionElements = {@ActionElement(name = "android.intent.action.VIEW")},
        categoryElements = {@CategoryElement(name = "android.intent.category.BROWSABLE")},
        dataElements = {@DataElement(scheme = "https")}),
    @IntentFilterElement(actionElements = {
        @ActionElement(name = "android.support.customtabs.action.CustomTabsService")
    })
})
@UsesActivities(activities = {
    @ActivityElement(
        name = "com.google.android.gms.ads.AdActivity",
        configChanges = "keyboard|keyboardHidden|orientation|screenLayout|uiMode"
            + "|screenSize|smallestScreenSize",
        theme = "@android:style/Theme.Translucent",
        exported = "false"),
    @ActivityElement(
        name = "com.google.android.gms.common.api.GoogleApiActivity",
        theme = "@android:style/Theme.Translucent.NoTitleBar",
        exported = "false")
})
@UsesApplicationMetadata(metaDataElements = {
    // Placeholder that BannerCore.initialize replaces with the AppId property.
    @MetaDataElement(
        name = "com.google.android.gms.ads.APPLICATION_ID",
        value = BannerCore.TEST_APP_ID),
    // App Inventor merges no AAR manifest, so basement's
    // @integer/google_play_services_version is written out as its literal value.
    @MetaDataElement(
        name = "com.google.android.gms.version",
        value = "12451000")
})
@UsesLibraries({
    "admob-activity.aar",
    "admob-ads-adservices.aar",
    "admob-ads-adservices-java.aar",
    "admob-annotations.aar",
    "admob-browser.aar",
    "admob-concurrent-futures.aar",
    "admob-core-ktx.aar",
    "admob-kotlin-stdlib.aar",
    "admob-kotlinx-coroutines-core-jvm.aar",
    "admob-listenablefuture.aar",
    "admob-play-services-ads.aar",
    "admob-play-services-ads-api.aar",
    "admob-play-services-ads-identifier.aar",
    "admob-play-services-appset.aar",
    "admob-play-services-base.aar",
    "admob-play-services-basement.aar",
    "admob-play-services-measurement-base.aar",
    "admob-play-services-measurement-sdk-api.aar",
    "admob-play-services-tasks.aar",
    "admob-savedstate.aar",
    "admob-user-messaging-platform.aar",
    "admob-webkit.aar"
})
public final class AdMobBanner extends AndroidNonvisibleComponent
    implements OnPauseListener, OnResumeListener, OnDestroyListener {

  private static final String LOG_TAG = "AdMobBanner";

  private final ComponentContainer container;

  // A fixed parent for the AdView, which is recreated on every load because its size
  // and unit ID can only be set once.
  private final FrameLayout host;

  private AdView adView;
  private String appId = BannerCore.TEST_APP_ID;
  private String adUnitId = BannerCore.TEST_BANNER_UNIT;
  private BannerPosition position = BannerPosition.Bottom;
  private HVArrangement arrangement;
  private boolean visible = true;
  private boolean loaded = false;
  private boolean attached = false;
  private boolean destroyed = false;

  public AdMobBanner(ComponentContainer container) {
    super(container.$form());
    this.container = container;
    this.host = new FrameLayout(container.$context());
    form.registerForOnPause(this);
    form.registerForOnResume(this);
    form.registerForOnDestroy(this);
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
      defaultValue = BannerCore.TEST_APP_ID)
  @SimpleProperty
  public void AppId(String id) {
    appId = id == null ? "" : id.trim();
  }

  @SimpleProperty(category = PropertyCategory.BEHAVIOR,
      description = "Your AdMob app ID from the AdMob console, the one with a ~. Use the "
          + "same value in every AdMob extension in the app. Changing it after the first "
          + "ad has loaded has no effect.")
  public String AppId() {
    return appId;
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
      defaultValue = BannerCore.TEST_BANNER_UNIT)
  @SimpleProperty
  public void AdUnitId(String id) {
    adUnitId = id == null ? "" : id.trim();
  }

  @SimpleProperty(category = PropertyCategory.BEHAVIOR,
      description = "This banner's ad unit ID, the one with a /. The test default always "
          + "fills and can't affect your account. A change takes effect on the next "
          + "LoadAd.")
  public String AdUnitId() {
    return adUnitId;
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
      defaultValue = "False")
  @SimpleProperty
  public void ChildDirected(boolean childDirected) {
    BannerCore.setChildDirected(childDirected);
  }

  @SimpleProperty(category = PropertyCategory.BEHAVIOR,
      description = "Check this if the app is for children (Google Play Families "
          + "policy). It also limits ads to content rated G. Unchecked leaves the setting "
          + "unspecified. Applies to every AdMob ad in the app.")
  public boolean ChildDirected() {
    return BannerCore.isChildDirected();
  }

  @SimpleProperty(category = PropertyCategory.APPEARANCE,
      description = "Whether the banner is on screen. Hiding it keeps the loaded ad, so "
          + "showing it again costs nothing.")
  public void Visible(boolean show) {
    visible = show;
    host.setVisibility(show ? View.VISIBLE : View.GONE);
  }

  @SimpleProperty
  public boolean Visible() {
    return visible;
  }

  @SimpleProperty(category = PropertyCategory.BEHAVIOR,
      description = "A list of test device IDs. These devices get test ads even with real "
          + "IDs. Logcat prints the ID on the first ad request. Applies to every AdMob ad "
          + "in the app.")
  public void TestDeviceIds(YailList ids) {
    List<String> list = new ArrayList<>();
    for (Object id : ids.toArray()) {
      String trimmed = id.toString().trim();
      if (!trimmed.isEmpty()) {
        list.add(trimmed);
      }
    }
    BannerCore.setTestDeviceIds(list);
  }

  @SimpleProperty
  public YailList TestDeviceIds() {
    return YailList.makeList(BannerCore.getTestDeviceIds());
  }

  @SimpleFunction(description = "True when a banner has loaded.")
  public boolean IsLoaded() {
    return loaded;
  }

  @SimpleFunction(description = "Requests a banner of the given size. Plug in a "
      + "BannerSize block; Adaptive fits the screen width and is what Google recommends. "
      + "AdLoaded or AdFailedToLoad follows. Without an earlier ShowIn or ShowAt, the "
      + "banner floats at the bottom.")
  public void LoadAd(@Options(BannerSize.class) String size) {
    if (destroyed) {
      return;
    }
    BannerSize parsed = BannerSize.fromUnderlyingValue(size);
    BannerCore.initialize(form, appId);
    attachHost();
    removeAdView();
    loaded = false;
    adView = new AdView(container.$context());
    adView.setAdUnitId(adUnitId);
    adView.setAdSize(adSizeOf(parsed == null ? BannerSize.Adaptive : parsed));
    adView.setAdListener(new BannerListener());
    host.addView(adView, new FrameLayout.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
        Gravity.CENTER_HORIZONTAL));
    adView.loadAd(BannerCore.newRequest());
  }

  @SimpleFunction(description = "Puts the banner inside the arrangement you plug in, a "
      + "HorizontalArrangement or VerticalArrangement on the screen.")
  public void ShowIn(AndroidViewComponent arrangement) {
    if (destroyed) {
      return;
    }
    // Component sockets are not type-checked, so any component can arrive here.
    if (!(arrangement instanceof HVArrangement)) {
      form.dispatchErrorOccurredEvent(this, "ShowIn", ErrorMessages.ERROR_EXTENSION_ERROR,
          0, LOG_TAG, "ShowIn needs a HorizontalArrangement or VerticalArrangement.");
      return;
    }
    detachHost();
    this.arrangement = (HVArrangement) arrangement;
    attachHost();
    Visible(true);
  }

  @SimpleFunction(description = "Pins the banner to the position you plug in, the top "
      + "or bottom of the screen, over your layout.")
  public void ShowAt(@Options(BannerPosition.class) String position) {
    if (destroyed) {
      return;
    }
    BannerPosition parsed = BannerPosition.fromUnderlyingValue(position);
    detachHost();
    arrangement = null;
    this.position = parsed == null ? BannerPosition.Bottom : parsed;
    attachHost();
    Visible(true);
  }

  @SimpleFunction(description = "Removes the banner and frees its memory. Call LoadAd to "
      + "show a new one.")
  public void DestroyAd() {
    loaded = false;
    removeAdView();
  }

  @SimpleEvent(description = "A banner loaded and is on screen.")
  public void AdLoaded() {
    EventDispatcher.dispatchEvent(this, "AdLoaded");
  }

  @SimpleEvent(description = "A banner could not load. No Fill just means no ad was "
      + "available, which is normal.")
  public void AdFailedToLoad(@Options(BannerError.class) String errorCode, String message) {
    if (EventDispatcher.dispatchEvent(this, "AdFailedToLoad", errorCode, message)) {
      return;
    }
    // Only setup mistakes reach the screen; a No Fill popup would hit app users.
    if (BannerError.InvalidRequest.toUnderlyingValue().equals(errorCode)
        || BannerError.AppIdMissing.toUnderlyingValue().equals(errorCode)) {
      form.dispatchErrorOccurredEvent(this, "LoadAd", ErrorMessages.ERROR_EXTENSION_ERROR,
          0, LOG_TAG, errorCode + ": " + message);
    } else {
      Log.w(LOG_TAG, errorCode + ": " + message);
    }
  }

  @SimpleEvent(description = "The user tapped the banner.")
  public void AdClicked() {
    EventDispatcher.dispatchEvent(this, "AdClicked");
  }

  @SimpleEvent(description = "The banner was counted as seen.")
  public void AdImpression() {
    EventDispatcher.dispatchEvent(this, "AdImpression");
  }

  @SimpleEvent(description = "A tapped ad opened over the app. Pause games or sound "
      + "here.")
  public void AdOpened() {
    EventDispatcher.dispatchEvent(this, "AdOpened");
  }

  @SimpleEvent(description = "The user came back from a tapped ad.")
  public void AdClosed() {
    EventDispatcher.dispatchEvent(this, "AdClosed");
  }

  @Override
  public void onPause() {
    if (adView != null) {
      adView.pause();
    }
  }

  @Override
  public void onResume() {
    if (adView != null && !destroyed) {
      adView.resume();
    }
  }

  @Override
  public void onDestroy() {
    destroyed = true;
    DestroyAd();
    detachHost();
  }

  private AdSize adSizeOf(BannerSize size) {
    switch (size) {
      case Banner:
        return AdSize.BANNER;
      case LargeBanner:
        return AdSize.LARGE_BANNER;
      case MediumRectangle:
        return AdSize.MEDIUM_RECTANGLE;
      case FullBanner:
        return AdSize.FULL_BANNER;
      case Leaderboard:
        return AdSize.LEADERBOARD;
      case Adaptive:
      default:
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(
            container.$context(), availableWidthDp());
    }
  }

  private int availableWidthDp() {
    DisplayMetrics metrics = form.getResources().getDisplayMetrics();
    int widthPixels = metrics.widthPixels;
    if (arrangement != null && arrangement.getView().getWidth() > 0) {
      widthPixels = arrangement.getView().getWidth();
    }
    return Math.max(1, Math.round(widthPixels / metrics.density));
  }

  private void removeAdView() {
    if (adView != null) {
      host.removeView(adView);
      adView.destroy();
      adView = null;
    }
  }

  private void attachHost() {
    if (attached || destroyed) {
      return;
    }
    if (arrangement != null) {
      // $add goes through the arrangement's layout, so the banner flows like any child.
      arrangement.$add(new BannerView(arrangement));
    } else {
      ViewGroup root = (ViewGroup) form.findViewById(android.R.id.content);
      if (root == null) {
        return;
      }
      root.addView(host, new FrameLayout.LayoutParams(
          ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
          (position == BannerPosition.Top ? Gravity.TOP : Gravity.BOTTOM)
              | Gravity.CENTER_HORIZONTAL));
    }
    host.setVisibility(visible ? View.VISIBLE : View.GONE);
    attached = true;
  }

  private void detachHost() {
    if (!attached) {
      return;
    }
    ViewGroup parent = (ViewGroup) host.getParent();
    if (parent != null) {
      parent.removeView(host);
    }
    attached = false;
  }

  // Lets an arrangement accept the host view through $add. It has no component
  // annotations, so it never appears in the palette.
  private final class BannerView extends AndroidViewComponent {
    BannerView(ComponentContainer container) {
      super(container);
    }

    @Override
    public View getView() {
      return host;
    }
  }

  private final class BannerListener extends AdListener {
    @Override
    public void onAdLoaded() {
      loaded = true;
      AdLoaded();
    }

    @Override
    public void onAdFailedToLoad(LoadAdError error) {
      loaded = false;
      AdFailedToLoad(BannerCore.errorOf(error).toUnderlyingValue(), error.getMessage());
    }

    @Override
    public void onAdClicked() {
      AdClicked();
    }

    @Override
    public void onAdImpression() {
      AdImpression();
    }

    @Override
    public void onAdOpened() {
      AdOpened();
    }

    @Override
    public void onAdClosed() {
      AdClosed();
    }
  }
}
