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
package org.astivetoolkit.ami.action;


/**
 *
 * @since 1.0.0
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
