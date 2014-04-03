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
public class OriginateAction extends ActionMessage {
  private String account;
  private String application;
  private String callerId;
  private String channel;
  private String codecs;
  private String context;
  private String data;
  private String exten;
  private String variable;
  private int priority;
  private int timeout;

  /**
   * Creates a new OriginateAction object.
   *
   * @param channel DOCUMENT ME!
   */
  public OriginateAction(String channel) {
    super(ActionType.ORIGINATE);
  }

  /**
   * Creates a new OriginateAction object.
   *
   * @param channel DOCUMENT ME!
   * @param exten DOCUMENT ME!
   * @param context DOCUMENT ME!
   * @param priority DOCUMENT ME!
   */
  public OriginateAction(String channel, String exten, String context, int priority) {
    super(ActionType.ORIGINATE);
    this.channel = channel;
    this.exten = exten;
    this.context = context;
    this.priority = priority;
  }

  /**
   * Creates a new OriginateAction object.
   *
   * @param channel DOCUMENT ME!
   * @param application DOCUMENT ME!
   */
  public OriginateAction(String channel, String application) {
    super(ActionType.ORIGINATE);
    this.application = application;
  }

  /**
   * Creates a new OriginateAction object.
   *
   * @param channel DOCUMENT ME!
   * @param application DOCUMENT ME!
   * @param data DOCUMENT ME!
   */
  public OriginateAction(String channel, String application, String data) {
    super(ActionType.ORIGINATE);
    this.application = application;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getAccount() {
    return account;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getApplication() {
    return application;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getCallerId() {
    return callerId;
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
  public String getCodecs() {
    return codecs;
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
  public String getData() {
    return data;
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
  public int getPriority() {
    return priority;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getTimeout() {
    return timeout;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getVariable() {
    return variable;
  }

  /**
   * DOCUMENT ME!
   *
   * @param account DOCUMENT ME!
   */
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * DOCUMENT ME!
   *
   * @param application DOCUMENT ME!
   */
  public void setApplication(String application) {
    this.application = application;
  }

  /**
   * DOCUMENT ME!
   *
   * @param callerId DOCUMENT ME!
   */
  public void setCallerId(String callerId) {
    this.callerId = callerId;
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
   * @param codecs DOCUMENT ME!
   */
  public void setCodecs(String codecs) {
    this.codecs = codecs;
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
   * @param data DOCUMENT ME!
   */
  public void setData(String data) {
    this.data = data;
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
   * @param priority DOCUMENT ME!
   */
  public void setPriority(int priority) {
    this.priority = priority;
  }

  /**
   * DOCUMENT ME!
   *
   * @param timeout DOCUMENT ME!
   */
  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  /**
   * DOCUMENT ME!
   *
   * @param variable DOCUMENT ME!
   */
  public void setVariable(String variable) {
    this.variable = variable;
  }
}
