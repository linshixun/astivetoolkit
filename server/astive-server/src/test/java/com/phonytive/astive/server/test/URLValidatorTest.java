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
package com.phonytive.astive.server.test;

import com.phonytive.astive.server.utils.URLValidator;
import junit.framework.TestCase;

/**
 *
 * @since 1.0.0
 */
public class URLValidatorTest extends TestCase {
  /**
   * Creates a new URLValidatorTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public URLValidatorTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   */
  public void testValidateURLs() {
    assertTrue(URLValidator.isValidURL("/"));
    assertFalse(URLValidator.isValidURL("/*"));
    assertFalse(URLValidator.isValidURL("/2"));
    assertTrue(URLValidator.isValidURL("/myproject"));
    assertFalse(URLValidator.isValidURL("/_abc"));
    assertTrue(URLValidator.isValidURL("/myproject/"));
    assertTrue(URLValidator.isValidURL("/myproject/*"));
    assertTrue(URLValidator.isValidURL("/myproject/myAstivlet"));
    assertTrue(URLValidator.isValidURL("*.ast"));
    assertTrue(URLValidator.isValidURL("*.ast2"));
    assertTrue(URLValidator.isValidURL("*.ast?%$"));
    assertFalse(URLValidator.isValidURL("abc.ast?%$"));
  }
}
