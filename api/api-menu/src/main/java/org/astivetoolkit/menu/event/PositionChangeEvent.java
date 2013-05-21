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
