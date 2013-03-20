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
public class BridgeAction extends ActionMessage {
  private String channel1;
  private String channel2;
  private YesNo tone = YesNo.NO;

  /**
   * Creates a new BridgeAction object.
   *
   * @param channel1 DOCUMENT ME!
   * @param channel2 DOCUMENT ME!
   */
  public BridgeAction(String channel1, String channel2) {
    super(ActionType.BRIDGE);
    this.channel1 = channel1;
    this.channel2 = channel2;
  }

  /**
   * Creates a new BridgeAction object.
   *
   * @param channel1 DOCUMENT ME!
   * @param channel2 DOCUMENT ME!
   * @param tone DOCUMENT ME!
   */
  public BridgeAction(String channel1, String channel2, YesNo tone) {
    super(ActionType.BRIDGE);
    this.channel1 = channel1;
    this.channel2 = channel2;
    this.tone = tone;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getChannel1() {
    return channel1;
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
  public YesNo getTone() {
    return tone;
  }

  /**
   * DOCUMENT ME!
   *
   * @param channel1 DOCUMENT ME!
   */
  public void setChannel1(String channel1) {
    this.channel1 = channel1;
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
   * @param tone DOCUMENT ME!
   */
  public void setTone(YesNo tone) {
    this.tone = tone;
  }
}
