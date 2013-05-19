/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
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
package com.phonytive.astive.menu.event;


/**
 *
 * @since 1.0.0
 * @see MaxTimeoutListener
 * @see DigitsEvent
 */
public class MaxTimeoutEvent extends DigitsEvent {
  /**
   * DOCUMENT ME!
   */
  protected int maxTimeout;

  /** <p>Creates a new instance of MaxTimeoutEvent</p> */
  public MaxTimeoutEvent(Object source, String digit, int maxTimeout) {
    super(source, digit);
    this.maxTimeout = maxTimeout;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getMaxTimeout() {
    return maxTimeout;
  }

  /**
   * DOCUMENT ME!
   *
   * @param maxTimeout DOCUMENT ME!
   */
  public void setMaxTimeout(int maxTimeout) {
    this.maxTimeout = maxTimeout;
  }
}
