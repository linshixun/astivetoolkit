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
