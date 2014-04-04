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
package org.astivetoolkit.action;


/**
 *
 * @since 1.1
 */
public class SetvarAction extends ActionMessage {
  private String channel;
  private String value;
  private String variable;

  /**
   * Creates a new SetvarAction object.
   *
   * @param variable DOCUMENT ME!
   * @param value DOCUMENT ME!
   */
  public SetvarAction(String variable, String value) {
    super(ActionType.SETVAR);
    this.variable = variable;
    this.value = value;
  }

  /**
   * Creates a new SetvarAction object.
   *
   * @param channel DOCUMENT ME!
   * @param variable DOCUMENT ME!
   * @param value DOCUMENT ME!
   */
  public SetvarAction(String channel, String variable, String value) {
    super(ActionType.SETVAR);
    this.channel = channel;
    this.variable = variable;
    this.value = value;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getChannel() {
    return channel;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getValue() {
    return value;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getVariable() {
    return variable;
  }

  /**
   * DOCUMENT ME!
   *
   * @param channel DOCUMENT ME!
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  /**
   * DOCUMENT ME!
   *
   * @param value DOCUMENT ME!
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * DOCUMENT ME!
   *
   * @param variable DOCUMENT ME!
   */
  public void setVariable(String variable) {
    this.variable = variable;
  }
}
