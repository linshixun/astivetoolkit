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
package com.phonytive.astive.menu;


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
