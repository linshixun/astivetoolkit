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
