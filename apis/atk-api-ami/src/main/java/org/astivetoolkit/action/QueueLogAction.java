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
public class QueueLogAction extends ActionMessage {
  private String event;
  private String iface;
  private String message;
  private String queue;
  private String uniqueId;

  /**
   * Creates a new QueueLogAction object.
   *
   * @param queue DOCUMENT ME!
   * @param event DOCUMENT ME!
   */
  public QueueLogAction(String queue, String event) {
    super(ActionType.QUEUE_LOG);
    this.queue = queue;
    this.event = event;
  }

  /**
   * Creates a new QueueLogAction object.
   *
   * @param queue DOCUMENT ME!
   * @param event DOCUMENT ME!
   * @param message DOCUMENT ME!
   */
  public QueueLogAction(String queue, String event, String message) {
    super(ActionType.QUEUE_LOG);
    this.queue = queue;
    this.event = event;
    this.message = message;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getEvent() {
    return event;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getInterface() {
    return iface;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getMessage() {
    return message;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getQueue() {
    return queue;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getUniqueId() {
    return uniqueId;
  }

  /**
   * DOCUMENT ME!
   *
   * @param event DOCUMENT ME!
   */
  public void setEvent(String event) {
    this.event = event;
  }

  /**
   * DOCUMENT ME!
   *
   * @param iface DOCUMENT ME!
   */
  public void setInterface(String iface) {
    this.iface = iface;
  }

  /**
   * DOCUMENT ME!
   *
   * @param message DOCUMENT ME!
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * DOCUMENT ME!
   *
   * @param queue DOCUMENT ME!
   */
  public void setQueue(String queue) {
    this.queue = queue;
  }

  /**
   * DOCUMENT ME!
   *
   * @param uniqueId DOCUMENT ME!
   */
  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }
}
