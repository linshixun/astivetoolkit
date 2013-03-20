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
