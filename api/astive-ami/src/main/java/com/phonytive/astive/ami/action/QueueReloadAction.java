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
public class QueueReloadAction extends ActionMessage {
  private String queue;
  private YesNo members;
  private YesNo parameters;
  private YesNo rules;

  /**
   * Creates a new QueueReloadAction object.
   */
  public QueueReloadAction() {
    super(ActionType.QUEUE_RELOAD);
    members = YesNo.NO;
    rules = YesNo.NO;
    parameters = YesNo.NO;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public YesNo getMembers() {
    return members;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public YesNo getParameters() {
    return parameters;
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
  public YesNo getRules() {
    return rules;
  }

  /**
   * DOCUMENT ME!
   *
   * @param members DOCUMENT ME!
   */
  public void setMembers(YesNo members) {
    this.members = members;
  }

  /**
   * DOCUMENT ME!
   *
   * @param parameters DOCUMENT ME!
   */
  public void setParameters(YesNo parameters) {
    this.parameters = parameters;
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
   * @param rules DOCUMENT ME!
   */
  public void setRules(YesNo rules) {
    this.rules = rules;
  }
}
