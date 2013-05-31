/* 
 * Copyright (C) 2010-2013 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.astivetoolkit.agi;


/**
 * Enum that map the presentation type for the callerId (@link AgiRequest).
 *
 * @since 1.0.0
 */
public enum PresentationType {ALLOWED(0x0, "allowed", "allowed"),
  ALLOWED_NOT_SCREENED(0x1, "allowed_not_screened", "allowed not screened"),
  ALLOWED_PASSED_SCREEN(0x2, "allowed_passed_screen", "allowed passed screen"),
  ALLOWED_FAILED_SCREEN(0x3, "allowed_failed_screen", "allowed failed screen"),
  PROHIB_NOT_SCREENED(0x4, "prohib_not_screened", "prohib not screened"),
  PROHIB_PASSED_SCREEN(0x5, "prohib_passed_screen", "prohib passed screen"),
  PROHIB_FAILED_SCREEN(0x6, "prohib_failed_screen", "prohib failed screen"),
  PROHIB(0x7, "prohib", "prohib"),
  UNAVAILABLE(0x8, "unavailable", "unavailable");

  /**
   * PresentationType value.
   */
  private int value;

  /**
   * PresentationType name
   */
  private String name;

  /**
   * PresentationType description.
   */
  private String literal;

  /**ADOC_COMME */
  private PresentationType(final int value, final String name, final String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * DOCUMENT ME!
   *
   * @param value DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static PresentationType get(final int value) {
    return null;
  }

  /**
   * DOCUMENT ME!
   *
   * @param name DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static PresentationType get(final String name) {
    return null;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getLiteral() {
    return literal;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getValue() {
    return value;
  }
}
