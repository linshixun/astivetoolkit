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
 * Enum that map the ton type for an incoming call.
 *
 * @since 1.0.0
 */
public enum TonType {UNKNOWN(0x0, "Unknown", "Unknown"),
  INTERNATIONAL(0x1, "International", "International"),
  NATIONAL(0x2, "National", "National"),
  NETWORK_SPECIFIC(0x3, "NetworkSpecific", "Network specific"),
  SUBSCRIBER_NUMBER(0x4, "SubscriberNumber", "Subscriber number"),
  ALPHA_NUMERIC(0x5, "AlphaNumberic", "Alpha numeric"),
  ABBREVIATED(0x6, "Abbreviated", "Abbreviated");

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
  private TonType(final int value, final String name, final String literal) {
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
  public static TonType get(final int value) {
    return null;
  }

  /**
   * DOCUMENT ME!
   *
   * @param name DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static TonType getByName(final String name) {
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
