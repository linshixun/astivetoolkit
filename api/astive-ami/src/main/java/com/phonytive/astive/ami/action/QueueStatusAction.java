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
public class QueueStatusAction extends ActionMessage {
  private String member;
  private String queue;

  /**
   * Creates a new QueueStatusAction object.
   */
  public QueueStatusAction() {
    super(ActionType.QUEUE_STATUS);
  }

  /**
   * Creates a new QueueStatusAction object.
   *
   * @param queue DOCUMENT ME!
   */
  public QueueStatusAction(String queue) {
    super(ActionType.QUEUE_STATUS);
    this.queue = queue;
  }

  /**
   * Creates a new QueueStatusAction object.
   *
   * @param queue DOCUMENT ME!
   * @param member DOCUMENT ME!
   */
  public QueueStatusAction(String queue, String member) {
    super(ActionType.QUEUE_STATUS);
    this.queue = queue;
    this.member = member;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getMember() {
    return member;
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
   * @param member DOCUMENT ME!
   */
  public void setMember(String member) {
    this.member = member;
  }

  /**
   * DOCUMENT ME!
   *
   * @param queue DOCUMENT ME!
   */
  public void setQueue(String queue) {
    this.queue = queue;
  }
}
