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
package com.phonytive.astive.ami.action;


public class QueueRuleAction extends ActionMessage {
  private String rule;

  /**
   * Creates a new QueueRuleAction object.
   */
  public QueueRuleAction() {
    super(ActionType.QUEUE_RULE);
  }

  /**
   * Creates a new QueueRuleAction object.
   *
   * @param rule DOCUMENT ME!
   */
  public QueueRuleAction(String rule) {
    super(ActionType.QUEUE_RULE);
    this.rule = rule;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getRule() {
    return rule;
  }

  /**
   * DOCUMENT ME!
   *
   * @param rule DOCUMENT ME!
   */
  public void setRule(String rule) {
    this.rule = rule;
  }
}
