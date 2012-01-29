/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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
package com.phonytive.astive.menu.event;


/**
 *
 * @since 1.0.0
 * @see Event
 * @see DigitsListener
 */
public class DigitsEvent extends Event {
  private String digits;

  /**
   * Creates a new DigitsEvent object.
   *
   * @param source DOCUMENT ME!
   * @param digits DOCUMENT ME!
   */
  public DigitsEvent(Object source, String digits) {
    super(source);
    this.digits = digits;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getDigits() {
    return digits;
  }

  /**
   * DOCUMENT ME!
   *
   * @param digits DOCUMENT ME!
   */
  public void setDigits(String digits) {
    this.digits = digits;
  }
}
