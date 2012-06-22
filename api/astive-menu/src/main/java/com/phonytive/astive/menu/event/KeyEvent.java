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

import com.phonytive.astive.menu.Digit;

/**
 *
 * @since 1.0.0
 * @see KeyListener
 */
public class KeyEvent extends Event {
  /**
   * DOCUMENT ME!
   */
  protected Digit key;

  /**
   * Creates a new KeyEvent object.
   *
   * @param source DOCUMENT ME!
   * @param key DOCUMENT ME!
   */
  public KeyEvent(Object source, Digit key) {
    super(source);
    this.source = source;
    this.key = key;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Digit getKey() {
    return key;
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   */
  public void setKey(Digit key) {
    this.key = key;
  }
}
