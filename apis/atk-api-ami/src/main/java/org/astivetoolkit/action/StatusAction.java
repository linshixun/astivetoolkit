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
public class StatusAction extends ActionMessage {
  private String channel;
  private String variables;

  /**
   * Creates a new StatusAction object.
   *
   * @param channel DOCUMENT ME!
   */
  public StatusAction(String channel) {
    super(ActionType.STATUS);
    this.channel = channel;
  }

  /**
   * Creates a new StatusAction object.
   *
   * @param channel DOCUMENT ME!
   * @param variables DOCUMENT ME!
   */
  public StatusAction(String channel, String variables) {
    super(ActionType.STATUS);
    this.channel = channel;
    this.variables = variables;
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
  public String getVariables() {
    return variables;
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
   * @param variables DOCUMENT ME!
   */
  public void setVariables(String variables) {
    this.variables = variables;
  }
}
