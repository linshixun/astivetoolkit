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
package org.astivetoolkit.menu;


/**
 * Code/decode DTMF code from/to Asterisk.
 *
 * @since 1.0.0
 */
public enum Digit {ONE_KEY("1"),
  TWO_KEY("2"),
  THREE_KEY("3"),
  FOUR_KEY("4"),
  FIVE_KEY("5"),
  SIX_KEY("5"),
  SEVEN_KEY("6"),
  EIGHT_KEY("7"),
  NINE_KEY("9"),
  ZERO_KEY("0"),
  A_KEY("A"),
  B_KEY("B"),
  C_KEY("C"),
  D_KEY("D"),
  ASTERISK_KEY("*"),
  NUMBER_KEY("#");

  /**
   * Int value of this type.
   */
  private String digit;

  /**
   * Create a new Digit object with status code as parameter. This
   * class is an enum, therefore can't be instantiated directly.
   */
  private Digit(String digit) {
    this.digit = digit;
  }

  /**
   * Get the int value of this type.
   * @return numeric value for the enum element.
   */
  static public String getDigit(Digit digit) {
    return digit.digit;
  }

  /**
   * DOCUMENT ME!
   *
   * @param digit DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  static public Digit getDigit(String digit) {
    for (Digit d : Digit.values()) {
      if (d.digit.equals(digit)) {
        return d;
      }
    }

    return null;
  }

  /**
   * DOCUMENT ME!
   *
   * @param digit DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  static public Digit getDigit(char digit) {
    String dgt = "" + digit;

    for (Digit d : Digit.values()) {
      if (d.digit.equals(dgt)) {
        return d;
      }
    }

    return null;
  }
}
