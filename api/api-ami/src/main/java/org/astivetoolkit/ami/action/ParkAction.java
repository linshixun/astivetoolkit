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
 * DOCUMENT ME
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
