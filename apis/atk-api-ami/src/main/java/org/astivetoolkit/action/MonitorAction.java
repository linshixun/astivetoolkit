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
public class MonitorAction extends ActionMessage {
  private String channel;
  private String file;
  private String format;
  private boolean mix;

  /**
   * Creates a new MonitorAction object.
   *
   * @param channel DOCUMENT ME!
   */
  public MonitorAction(String channel) {
    super(ActionType.MONITOR);
    this.channel = channel;
  }

  /**
   * Creates a new MonitorAction object.
   *
   * @param channel DOCUMENT ME!
   * @param file DOCUMENT ME!
   */
  public MonitorAction(String channel, String file) {
    super(ActionType.MONITOR);
    this.channel = channel;
    this.file = file;
  }

  /**
   * Creates a new MonitorAction object.
   *
   * @param channel DOCUMENT ME!
   * @param file DOCUMENT ME!
   * @param format DOCUMENT ME!
   */
  public MonitorAction(String channel, String file, String format) {
    super(ActionType.MONITOR);
    this.channel = channel;
    this.file = file;
    this.format = format;
  }

  /**
   * Creates a new MonitorAction object.
   *
   * @param channel DOCUMENT ME!
   * @param file DOCUMENT ME!
   * @param format DOCUMENT ME!
   * @param mix DOCUMENT ME!
   */
  public MonitorAction(String channel, String file, String format, boolean mix) {
    super(ActionType.MONITOR);
    this.channel = channel;
    this.file = file;
    this.format = format;
    this.mix = mix;
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
  public String getFile() {
    return file;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getFormat() {
    return format;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isMix() {
    return mix;
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
   * @param file DOCUMENT ME!
   */
  public void setFile(String file) {
    this.file = file;
  }

  /**
   * DOCUMENT ME!
   *
   * @param format DOCUMENT ME!
   */
  public void setFormat(String format) {
    this.format = format;
  }

  /**
   * DOCUMENT ME!
   *
   * @param mix DOCUMENT ME!
   */
  public void setMix(boolean mix) {
    this.mix = mix;
  }
}
