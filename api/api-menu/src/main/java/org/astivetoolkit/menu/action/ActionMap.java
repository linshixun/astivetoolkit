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
package org.astivetoolkit.menu.action;

import java.util.HashMap;

/**
 *
 * @since 1.0.0
 * @see ActionEvent
 * @see Action
 */
public class ActionMap {
  private ActionMap parent;
  private HashMap actions;

  /**
   * Creates a new ActionMap object.
   */
  public ActionMap() {
    actions = new HashMap();
  }

  /**
   * @return Returns an array of the keys defined in this ActionMap and its parent.
   */
  public Object[] allKeys() {
    // to be implemented
    return null;
  }

  /**
   * DOCUMENT ME!
   */
  public void clear() {
    actions.clear();
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Action get(Object key) {
    return (Action) actions.get(key);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public ActionMap getParent() {
    return parent;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Object[] keys() {
    return actions.entrySet().toArray();
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   * @param action DOCUMENT ME!
   */
  public void put(Object key, Action action) {
    actions.put(key, action);
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   */
  public void remove(Object key) {
    actions.remove(key);
  }

  /**
   * DOCUMENT ME!
   *
   * @param map DOCUMENT ME!
   */
  public void setParent(ActionMap map) {
    parent = map;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int size() {
    return actions.size();
  }
}
