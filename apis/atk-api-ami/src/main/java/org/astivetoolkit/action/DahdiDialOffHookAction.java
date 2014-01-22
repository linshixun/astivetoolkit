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
public class DahdiDialOffHookAction extends ActionMessage {
  private String dahdiChannel;
  private String number;

  /**
   * Creates a new DahdiDialOffHookAction object.
   *
   * @param dahdiChannel DOCUMENT ME!
   * @param number DOCUMENT ME!
   */
  public DahdiDialOffHookAction(String dahdiChannel, String number) {
    super(ActionType.DAHDI_DIAL_OFF_HOOK);
    this.dahdiChannel = dahdiChannel;
    this.number = number;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getDahdiChannel() {
    return dahdiChannel;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getNumber() {
    return number;
  }

  /**
   * DOCUMENT ME!
   *
   * @param dahdiChannel DOCUMENT ME!
   */
  public void setDahdiChannel(String dahdiChannel) {
    this.dahdiChannel = dahdiChannel;
  }

  /**
   * DOCUMENT ME!
   *
   * @param number DOCUMENT ME!
   */
  public void setNumber(String number) {
    this.number = number;
  }
}
