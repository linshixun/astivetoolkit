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

import org.astivetoolkit.menu.MenuItem;

/**
 *
 * @since 1.0.0
 * @see DigitsEvent
 * @see PositionChangeListener
 */
public class PositionChangeEvent extends DigitsEvent {
  /**
   * DOCUMENT ME!
   */
  protected Object newObject;

  /**
   * DOCUMENT ME!
   */
  protected int position;

  /** <p>Creates a new instance of PositionChangeEvent</p> */
  public PositionChangeEvent(Object source, Object newObject, int position) {
    super(source, ((MenuItem) source).getDigits());

    this.newObject = newObject;
    this.position = position;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Object getNewObject() {
    return newObject;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getPosition() {
    return position;
  }

  /**
   * DOCUMENT ME!
   *
   * @param newObject DOCUMENT ME!
   */
  public void setNewObject(Object newObject) {
    this.newObject = newObject;
  }

  /**
   * DOCUMENT ME!
   *
   * @param position DOCUMENT ME!
   */
  public void setPosition(int position) {
    this.position = position;
  }
}
