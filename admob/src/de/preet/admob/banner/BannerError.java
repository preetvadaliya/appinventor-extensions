// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2026 Preet Vadaliya
// Released under the MIT License

package de.preet.admob.banner;

import com.google.appinventor.components.common.OptionList;

import java.util.HashMap;
import java.util.Map;

/**
 * Why a banner failed to load.
 */
public enum BannerError implements OptionList<String> {
  NoFill("No Fill"),
  NetworkError("Network Error"),
  InvalidRequest("Invalid Request"),
  AppIdMissing("App Id Missing"),
  InternalError("Internal Error"),
  MediationNoFill("Mediation No Fill"),
  RequestIdMismatch("Request Id Mismatch"),
  InvalidAdString("Invalid Ad String"),
  Unknown("Unknown");

  private static final Map<String, BannerError> LOOKUP = new HashMap<>();

  static {
    for (BannerError error : values()) {
      LOOKUP.put(error.value, error);
    }
  }

  private final String value;

  BannerError(String value) {
    this.value = value;
  }

  @Override
  public String toUnderlyingValue() {
    return value;
  }

  public static BannerError fromUnderlyingValue(String value) {
    return LOOKUP.get(value);
  }
}
