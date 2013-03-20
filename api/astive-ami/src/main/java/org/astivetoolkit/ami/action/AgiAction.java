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
package com.phonytive.astive.ami.action;


/**
 *
 * @since 1.0.0
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
