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
package org.astivetoolkit.astive.ami;

import java.util.ArrayList;
import org.astivetoolkit.ami.action.ActionMessage;
import org.astivetoolkit.ami.action.ResponseMessage;
import org.astivetoolkit.ami.event.ManagerEvent;

/**
 *
 * @since 1.0.0
 */
public abstract class Manager {
  public static int DEFAULT_PORT = 5038;
  private ArrayList<ManagerEventListener> managerEventListenerList = new ArrayList();

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void addManagerEventListener(ManagerEventListener listener) {
    managerEventListenerList.add(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param evt DOCUMENT ME!
   */
  protected void fireEvent(ManagerEvent evt) {
    for (ManagerEventListener listener : managerEventListenerList) {
      listener.handleEvent(evt);
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  abstract String getVersion();

  /**
   * DOCUMENT ME!
   *
   * @throws AmiException DOCUMENT ME!
   */
  abstract void login() throws AmiException;

  /**
   * DOCUMENT ME!
   *
   * @throws AmiException DOCUMENT ME!
   */
  abstract void logout() throws AmiException;

  /**
   * DOCUMENT ME!
   *
   * @param listener DOCUMENT ME!
   */
  public void removeManagerEventListener(ManagerEventListener listener) {
    managerEventListenerList.remove(listener);
  }

  /**
   * DOCUMENT ME!
   *
   * @param action DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws AmiException DOCUMENT ME!
   */
  abstract ResponseMessage sendAction(ActionMessage action)
                               throws AmiException;
}
