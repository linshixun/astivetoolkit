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
