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
package org.astivetoolkit.ami.event;

import java.util.HashMap;

/**
 *
 * @since 1.0.0
 */
public class ManagerEvent extends EventMessage {
  private Object source;

  /**
   * Creates a new ManagerEvent object.
   *
   * @param source DOCUMENT ME!
   * @param eventType DOCUMENT ME!
   */
  public ManagerEvent(Object source, EventType eventType) {
    super(eventType);
  }

  /**
   * Creates a new ManagerEvent object.
   *
   * @param source DOCUMENT ME!
   * @param eventType DOCUMENT ME!
   * @param parameters DOCUMENT ME!
   */
  public ManagerEvent(Object source, EventType eventType, HashMap parameters) {
    super(eventType, parameters);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Object getSource() {
    return source;
  }

  /**
   * DOCUMENT ME!
   *
   * @param source DOCUMENT ME!
   */
  public void setSource(Object source) {
    this.source = source;
  }
}
