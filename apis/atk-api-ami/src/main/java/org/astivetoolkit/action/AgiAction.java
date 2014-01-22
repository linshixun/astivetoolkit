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
public class AgiAction extends ActionMessage {
  private String channel;
  private String command;
  private String commandId;

  /**
   * Creates a new AgiAction object.
   *
   * @param channel DOCUMENT ME!
   * @param command DOCUMENT ME!
   */
  public AgiAction(String channel, String command) {
    super(ActionType.AGI);
    this.channel = channel;
    this.command = command;
  }

  /**
   * Creates a new AgiAction object.
   *
   * @param channel DOCUMENT ME!
   * @param command DOCUMENT ME!
   * @param commandId DOCUMENT ME!
   */
  public AgiAction(String channel, String command, String commandId) {
    super(ActionType.AGI);
    this.channel = channel;
    this.command = command;
    this.commandId = commandId;
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
  public String getCommand() {
    return command;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getCommandId() {
    return commandId;
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
   * @param command DOCUMENT ME!
   */
  public void setCommand(String command) {
    this.command = command;
  }

  /**
   * DOCUMENT ME!
   *
   * @param commandId DOCUMENT ME!
   */
  public void setCommandId(String commandId) {
    this.commandId = commandId;
  }
}
