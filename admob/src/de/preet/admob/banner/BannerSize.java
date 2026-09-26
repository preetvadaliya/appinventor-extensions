// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2026 Preet Vadaliya
// Released under the MIT License

package de.preet.admob.banner;

import com.google.appinventor.components.common.Default;
import com.google.appinventor.components.common.OptionList;

import java.util.HashMap;
import java.util.Map;

/**
 * The size of a banner ad.
 *
 * <p>Underlying values are what saved projects store, so never rename one.
 */
public enum BannerSize implements OptionList<String> {
  @Default
  Adaptive("Adaptive"),
  Banner("Banner"),
  LargeBanner("Large Banner"),
  MediumRectangle("Medium Rectangle"),
  FullBanner("Full Banner"),
  Leaderboard("Leaderboard");

  private static final Map<String, BannerSize> LOOKUP = new HashMap<>();

  static {
    for (BannerSize size : values()) {
      LOOKUP.put(size.value, size);
    }
  }

  private final String value;

  BannerSize(String value) {
    this.value = value;
  }

  @Override
  public String toUnderlyingValue() {
    return value;
  }

  public static BannerSize fromUnderlyingValue(String value) {
    return LOOKUP.get(value);
  }
}
