/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.ami;

import org.astivetoolkit.ami.action.ActionMessage;
import org.astivetoolkit.ami.action.ResponseMessage;
import org.astivetoolkit.ami.event.ManagerEvent;
import java.util.ArrayList;

/**
 *
 * @since 1.1
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
