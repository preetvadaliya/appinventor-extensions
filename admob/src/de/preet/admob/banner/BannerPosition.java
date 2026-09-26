// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2026 Preet Vadaliya
// Released under the MIT License

package de.preet.admob.banner;

import com.google.appinventor.components.common.Default;
import com.google.appinventor.components.common.OptionList;

import java.util.HashMap;
import java.util.Map;

/**
 * Where a floating banner is pinned.
 */
public enum BannerPosition implements OptionList<String> {
  Top("Top"),
  @Default
  Bottom("Bottom");

  private static final Map<String, BannerPosition> LOOKUP = new HashMap<>();

  static {
    for (BannerPosition position : values()) {
      LOOKUP.put(position.value, position);
    }
  }

  private final String value;

  BannerPosition(String value) {
    this.value = value;
  }

  @Override
  public String toUnderlyingValue() {
    return value;
  }

  public static BannerPosition fromUnderlyingValue(String value) {
    return LOOKUP.get(value);
  }
}
