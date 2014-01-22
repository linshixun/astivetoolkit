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
package org.astivetoolkit.ami.action;


/**
 *
 * @since 1.1
 */
public class WaitEventAction extends ActionMessage {
  private int timeout = -1;

  /**
   * Creates a new WaitEventAction object.
   */
  public WaitEventAction() {
    super(ActionType.WAIT_EVENT);
  }

  /**
   * Creates a new WaitEventAction object.
   *
   * @param timeout DOCUMENT ME!
   */
  public WaitEventAction(int timeout) {
    super(ActionType.WAIT_EVENT);
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
