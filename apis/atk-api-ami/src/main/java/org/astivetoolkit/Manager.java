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
package org.astivetoolkit;

import java.util.ArrayList;

import org.astivetoolkit.action.ActionMessage;
import org.astivetoolkit.action.ResponseMessage;
import org.astivetoolkit.event.ManagerEvent;

/**
 *
 * @since 1.1
 */
public abstract class Manager {
  public static int DEFAULT_PORT = 5038;
  private ArrayList<ManagerEventListener> managerEventListenerList = new ArrayList<ManagerEventListener>();

  public void addManagerEventListener(ManagerEventListener listener) {
    managerEventListenerList.add(listener);
  }

  protected void fireEvent(ManagerEvent evt) {
    for (ManagerEventListener listener : managerEventListenerList) {
      listener.handleEvent(evt);
    }
  }

  public abstract String getVersion();

  public abstract void login() throws AmiException;

  public abstract void logout() throws AmiException;

  public void removeManagerEventListener(ManagerEventListener listener) {
    managerEventListenerList.remove(listener);
  }

  public abstract ResponseMessage sendAction(ActionMessage action)
                               throws AmiException;
}