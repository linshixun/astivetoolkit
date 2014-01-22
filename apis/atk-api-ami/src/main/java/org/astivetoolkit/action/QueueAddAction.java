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
public class QueueAddAction extends ActionMessage {
  private String iface;
  private String memberName;
  private String queue;
  private String stateInterface;
  private boolean paused;
  private int penalty;

  /**
   * Creates a new QueueAddAction object.
   *
   * @param quee DOCUMENT ME!
   * @param iface DOCUMENT ME!
   */
  public QueueAddAction(String quee, String iface) {
    super(ActionType.QUEUE_ADD);
    this.queue = quee;
    this.iface = iface;
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
  public String getMemberName() {
    return memberName;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean getPaused() {
    return paused;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getPenalty() {
    return penalty;
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
  public String getStateInterface() {
    return stateInterface;
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
   * @param memberName DOCUMENT ME!
   */
  public void setMemberName(String memberName) {
    this.memberName = memberName;
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
   * @param penalty DOCUMENT ME!
   */
  public void setPenalty(int penalty) {
    this.penalty = penalty;
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
   * @param stateInterface DOCUMENT ME!
   */
  public void setStateInterface(String stateInterface) {
    this.stateInterface = stateInterface;
  }
}
