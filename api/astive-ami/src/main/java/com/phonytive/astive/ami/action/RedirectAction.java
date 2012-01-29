/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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
public class RedirectAction extends ActionMessage {
  private String channel;
  private String context;
  private String exten;
  private String extraChannel;
  private String extraContext;
  private String extraExten;
  private int extraPriority;
  private int priority;

  /**
   * Creates a new RedirectAction object.
   *
   * @param channel DOCUMENT ME!
   * @param exten DOCUMENT ME!
   * @param priority DOCUMENT ME!
   */
  public RedirectAction(String channel, String exten, int priority) {
    super(ActionType.REDIRECT);
    this.channel = channel;
    this.exten = exten;
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
  public String getExtraChannel() {
    return extraChannel;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getExtraContext() {
    return extraContext;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getExtraExten() {
    return extraExten;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getExtraPriority() {
    return extraPriority;
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
   * @param extraChannel DOCUMENT ME!
   */
  public void setExtraChannel(String extraChannel) {
    this.extraChannel = extraChannel;
  }

  /**
   * DOCUMENT ME!
   *
   * @param extraContext DOCUMENT ME!
   */
  public void setExtraContext(String extraContext) {
    this.extraContext = extraContext;
  }

  /**
   * DOCUMENT ME!
   *
   * @param extraExten DOCUMENT ME!
   */
  public void setExtraExten(String extraExten) {
    this.extraExten = extraExten;
  }

  /**
   * DOCUMENT ME!
   *
   * @param extraPriority DOCUMENT ME!
   */
  public void setExtraPriority(int extraPriority) {
    this.extraPriority = extraPriority;
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
