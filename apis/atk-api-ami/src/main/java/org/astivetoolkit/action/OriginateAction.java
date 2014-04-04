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

  public OriginateAction(String channel, String exten, String context, int priority) {
    super(ActionType.ORIGINATE);
    this.channel = channel;
    this.exten = exten;
    this.context = context;
    this.priority = priority;
  }

  public OriginateAction(String channel, String application) {
    super(ActionType.ORIGINATE);
    this.application = application;
  }

  public OriginateAction(String channel, String application, String data) {
    super(ActionType.ORIGINATE);
    this.application = application;
  }

  public String getAccount() {
    return account;
  }

  public String getApplication() {
    return application;
  }

  public String getCallerId() {
    return callerId;
  }

  public String getChannel() {
    return channel;
  }

  public String getCodecs() {
    return codecs;
  }

  public String getContext() {
    return context;
  }

  public String getData() {
    return data;
  }

  public String getExten() {
    return exten;
  }

  public int getPriority() {
    return priority;
  }

  public int getTimeout() {
    return timeout;
  }

  public String getVariable() {
    return variable;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  public void setCallerId(String callerId) {
    this.callerId = callerId;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public void setCodecs(String codecs) {
    this.codecs = codecs;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public void setData(String data) {
    this.data = data;
  }

  public void setExten(String exten) {
    this.exten = exten;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  public void setVariable(String variable) {
    this.variable = variable;
  }
}
