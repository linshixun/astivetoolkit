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
    this.channel = channel;
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
