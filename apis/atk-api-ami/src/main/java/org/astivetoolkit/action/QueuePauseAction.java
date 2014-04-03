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
public class QueuePauseAction extends ActionMessage {
  private String iface;
  private String queue;
  private String reason;
  private boolean paused;

  /**
   * Creates a new QueuePauseAction object.
   *
   * @param iface DOCUMENT ME!
   * @param paused DOCUMENT ME!
   */
  public QueuePauseAction(String iface, boolean paused) {
    super(ActionType.QUEUE_PAUSE);
    this.iface = iface;
    this.paused = paused;
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
  public String getQueue() {
    return queue;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getReason() {
    return reason;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isPaused() {
    return paused;
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
   * @param paused DOCUMENT ME!
   */
  public void setPaused(boolean paused) {
    this.paused = paused;
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
   * @param reason DOCUMENT ME!
   */
  public void setReason(String reason) {
    this.reason = reason;
  }
}
