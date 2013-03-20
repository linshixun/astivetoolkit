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
package org.astivetoolkit.ami.action;


/**
 *
 * @since 1.0.0
 */
public class AtxferAction extends ActionMessage {
  private String channel;
  private String context;
  private String exten;
  private int priority;

  /**
   * Creates a new AtxferAction object.
   *
   * @param channel DOCUMENT ME!
   * @param exten DOCUMENT ME!
   * @param context DOCUMENT ME!
   * @param priority DOCUMENT ME!
   */
  public AtxferAction(String channel, String exten, String context, int priority) {
    super(ActionType.ATXFER);
    this.channel = channel;
    this.exten = exten;
    this.context = context;
    this.priority = priority;
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
  public String getContext() {
    return context;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getExten() {
    return exten;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getPriority() {
    return priority;
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
   * @param context DOCUMENT ME!
   */
  public void setContext(String context) {
    this.context = context;
  }

  /**
   * DOCUMENT ME!
   *
   * @param exten DOCUMENT ME!
   */
  public void setExten(String exten) {
    this.exten = exten;
  }

  /**
   * DOCUMENT ME!
   *
   * @param priority DOCUMENT ME!
   */
  public void setPriority(int priority) {
    this.priority = priority;
  }
}
