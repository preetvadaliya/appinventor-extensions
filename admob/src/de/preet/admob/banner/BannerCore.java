// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2026 Preet Vadaliya
// Released under the MIT License

package de.preet.admob.banner;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.List;

/**
 * Mobile Ads SDK setup for this extension. The interstitial and rewarded extensions
 * carry their own copy, so SDK-wide settings are always read back from the SDK rather
 * than kept here.
 */
final class BannerCore {

  static final String TEST_APP_ID = "ca-app-pub-3940256099942544~3347511713";
  static final String TEST_BANNER_UNIT = "ca-app-pub-3940256099942544/6300978111";

  private static final String LOG_TAG = "AdMobBanner";
  private static final String METADATA_APP_ID = "com.google.android.gms.ads.APPLICATION_ID";

  private static boolean initialized = false;

  private BannerCore() {
  }

  static boolean isInitialized() {
    return initialized;
  }

  /**
   * Starts the SDK once per process. The SDK reads its App ID from the application's
   * metadata bundle, not from the manifest file, so writing the AppId property into
   * that bundle first replaces the test ID compiled into the manifest. This only works
   * because App Inventor drops the SDK's MobileAdsInitProvider, which would otherwise
   * start the SDK before any component exists. Another AdMob extension that got here
   * first has already written a real ID, and that one is kept.
   */
  static synchronized void initialize(Context context, String appId) {
    if (initialized) {
      return;
    }
    Context appContext = context.getApplicationContext();
    try {
      ApplicationInfo info = appContext.getPackageManager().getApplicationInfo(
          appContext.getPackageName(), PackageManager.GET_META_DATA);
      Bundle metaData = info.metaData;
      if (metaData != null && TEST_APP_ID.equals(metaData.getString(METADATA_APP_ID))
          && !appId.isEmpty()) {
        metaData.putString(METADATA_APP_ID, appId);
      }
    } catch (PackageManager.NameNotFoundException e) {
      Log.w(LOG_TAG, "Could not read application metadata", e);
    }
    MobileAds.initialize(appContext);
    initialized = true;
  }

  static List<String> getTestDeviceIds() {
    return MobileAds.getRequestConfiguration().getTestDeviceIds();
  }

  static void setTestDeviceIds(List<String> ids) {
    MobileAds.setRequestConfiguration(
        MobileAds.getRequestConfiguration().toBuilder().setTestDeviceIds(ids).build());
  }

  static boolean isChildDirected() {
    return MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment()
        == RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE;
  }

  static void setChildDirected(boolean childDirected) {
    MobileAds.setRequestConfiguration(MobileAds.getRequestConfiguration().toBuilder()
        .setTagForChildDirectedTreatment(childDirected
            ? RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE
            : RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED)
        .setMaxAdContentRating(childDirected
            ? RequestConfiguration.MAX_AD_CONTENT_RATING_G
            : RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)
        .build());
  }

  static AdRequest newRequest() {
    return new AdRequest.Builder().build();
  }

  static BannerError errorOf(LoadAdError error) {
    switch (error.getCode()) {
      case AdRequest.ERROR_CODE_NO_FILL:
        return BannerError.NoFill;
      case AdRequest.ERROR_CODE_NETWORK_ERROR:
        return BannerError.NetworkError;
      case AdRequest.ERROR_CODE_INVALID_REQUEST:
        return BannerError.InvalidRequest;
      case AdRequest.ERROR_CODE_APP_ID_MISSING:
        return BannerError.AppIdMissing;
      case AdRequest.ERROR_CODE_INTERNAL_ERROR:
        return BannerError.InternalError;
      case AdRequest.ERROR_CODE_MEDIATION_NO_FILL:
        return BannerError.MediationNoFill;
      case AdRequest.ERROR_CODE_REQUEST_ID_MISMATCH:
        return BannerError.RequestIdMismatch;
      case AdRequest.ERROR_CODE_INVALID_AD_STRING:
        return BannerError.InvalidAdString;
      default:
        return BannerError.Unknown;
    }
  }
}
