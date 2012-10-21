/*
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://astive.phonytive.com
 *
 * This file is part of Astive Toolkit
 *
 * Astive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Astive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Astive.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.phonytive.astive.server.utils;

import java.util.regex.Pattern;

/**
 * Use to check if a URL pattern is valid.
 *
 * @since 1.0.0
 */
public class URLValidator {
  /**
   * Use for exact match.
   */
  public static final Pattern SLASH_SLASH_ASTIVLET =
    Pattern.compile("^\\/[-a-zA-Z0-9][-a-zA-Z0-9+&@#/%?=~_|!:,.;]");

  /**
   * Match an string starting with '/' and ending with '/*'.
   */
  public static final Pattern SLASH_SLASH_ASTERISK = Pattern.compile("^\\/[-a-zA-Z0-9_](\\/\\*)");

  /**
   * Match an string with form '*.extension'.
   */
  public static final Pattern ASTERISK_EXTENSION =
    Pattern.compile("^\\*.[-a-zA-Z0-9+&@#/%?=~_|!:,.;]");

  private URLValidator() {
  }

  /**
   * Check if an URL match with the following criteria.
   *
   * A string beginning with a ‘/’ character and ending with a ‘/*’ suffix is used for path mapping.
   * A string beginning with a ‘*.’ prefix is used as an extension mapping.
   * A string containing only the ’/’ character indicates the "default" servlet of the application. In this case the servlet path is the request URI minus the context path and the path info is null.
   * All other strings are used for exact matches only.
   *
   * @param url URL to validate.
   * @return if match with a valid pattern.
   */
  static public Boolean isValidURL(String url) {
    if (url.trim().equals("/")) {
      return true;
    }

    Boolean match = SLASH_SLASH_ASTIVLET.matcher(url).find();

    if (match) {
      return true;
    }

    match = SLASH_SLASH_ASTERISK.matcher(url).find();

    if (match) {
      return true;
    }

    match = ASTERISK_EXTENSION.matcher(url).find();

    if (match) {
      return true;
    }

    return false;
  }
}
