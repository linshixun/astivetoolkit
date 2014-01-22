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
