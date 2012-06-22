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
public class MixMonitorMuteAction extends ActionMessage {
  private String channel;
  private String direction;
  private String state;

  /**
   * Creates a new MixMonitorMuteAction object.
   *
   * @param channel DOCUMENT ME!
   */
  public MixMonitorMuteAction(String channel) {
    super(ActionType.MIX_MONITOR_MUTE);
  }

  /**
   * Creates a new MixMonitorMuteAction object.
   *
   * @param channel DOCUMENT ME!
   * @param direction DOCUMENT ME!
   */
  public MixMonitorMuteAction(String channel, String direction) {
    super(ActionType.MIX_MONITOR_MUTE);
  }

  /**
   * Creates a new MixMonitorMuteAction object.
   *
   * @param channel DOCUMENT ME!
   * @param direction DOCUMENT ME!
   * @param state DOCUMENT ME!
   */
  public MixMonitorMuteAction(String channel, String direction, String state) {
    super(ActionType.MIX_MONITOR_MUTE);
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
  public String getDirection() {
    return direction;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getState() {
    return state;
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
   * @param direction DOCUMENT ME!
   */
  public void setDirection(String direction) {
    this.direction = direction;
  }

  /**
   * DOCUMENT ME!
   *
   * @param state DOCUMENT ME!
   */
  public void setState(String state) {
    this.state = state;
  }
}
