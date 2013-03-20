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
package org.astivetoolkit.menu.event;


/**
 *
 * @since 1.0.0
 * @see FailListener
 * @see DigitsEvent
 */
public class FailEvent extends DigitsEvent {
  /**
   * DOCUMENT ME!
   */
  protected int failCount;

  /**
   * Creates a new FailEvent object.
   *
   * @param source DOCUMENT ME!
   * @param digit DOCUMENT ME!
   * @param failCount DOCUMENT ME!
   */
  public FailEvent(Object source, String digit, int failCount) {
    super(source, digit);
    this.failCount = failCount;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getFailCount() {
    return failCount;
  }

  /**
   * DOCUMENT ME!
   *
   * @param failCount DOCUMENT ME!
   */
  public void setFailCount(int failCount) {
    this.failCount = failCount;
  }
}
