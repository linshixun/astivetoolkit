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
public class ParkAction extends ActionMessage {
  private String channel;
  private String channel2;
  private long timeout;

  // TODO: Include this parameter
  /**
   * Creates a new ParkAction object.
   *
   * @param channel DOCUMENT ME!
   * @param channel2 DOCUMENT ME!
   */
  public ParkAction(String channel, String channel2) {
    super(ActionType.PARK);
    this.channel = channel;
    this.channel2 = channel2;
  }

  /**
   * Creates a new ParkAction object.
   *
   * @param channel DOCUMENT ME!
   * @param channel2 DOCUMENT ME!
   * @param timeout DOCUMENT ME!
   */
  public ParkAction(String channel, String channel2, long timeout) {
    super(ActionType.PARK);
    this.channel = channel;
    this.channel2 = channel2;
    this.timeout = timeout;
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
  public String getChannel2() {
    return channel2;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public long getTimeout() {
    return timeout;
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
   * @param channel2 DOCUMENT ME!
   */
  public void setChannel2(String channel2) {
    this.channel2 = channel2;
  }

  /**
   * DOCUMENT ME!
   *
   * @param timeout DOCUMENT ME!
   */
  public void setTimeout(long timeout) {
    this.timeout = timeout;
  }
}
