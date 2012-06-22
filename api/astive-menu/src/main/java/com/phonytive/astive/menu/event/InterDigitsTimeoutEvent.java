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
package com.phonytive.astive.menu.event;


/**
 *
 * @since 1.0.0
 * @see InterDigitsTimeoutListener
 * @see DigitsEvent
 */
public class InterDigitsTimeoutEvent extends DigitsEvent {
  /**
   * DOCUMENT ME!
   */
  protected int timeout;

  /**
   * Creates a new InterDigitsTimeoutEvent object.
   *
   * @param source DOCUMENT ME!
   * @param digit DOCUMENT ME!
   * @param timeout DOCUMENT ME!
   */
  public InterDigitsTimeoutEvent(Object source, String digit, int timeout) {
    super(source, digit);
    this.timeout = timeout;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getTimeout() {
    return timeout;
  }

  /**
   * DOCUMENT ME!
   *
   * @param timeout DOCUMENT ME!
   */
  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }
}
