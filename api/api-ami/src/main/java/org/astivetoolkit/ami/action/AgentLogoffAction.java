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
public class AgentLogoffAction extends ActionMessage {
  private String agent;
  private boolean soft = true;

  /**
   * Creates a new AgentLogoffAction object.
   *
   * @param agent DOCUMENT ME!
   */
  public AgentLogoffAction(String agent) {
    super(ActionType.AGENT_LOGOFF);
    this.agent = agent;
  }

  /**
   * Creates a new AgentLogoffAction object.
   *
   * @param agent DOCUMENT ME!
   * @param soft DOCUMENT ME!
   */
  public AgentLogoffAction(String agent, boolean soft) {
    super(ActionType.AGENT_LOGOFF);
    this.agent = agent;
    this.soft = soft;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getAgent() {
    return agent;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isSoft() {
    return soft;
  }

  /**
   * DOCUMENT ME!
   *
   * @param agent DOCUMENT ME!
   */
  public void setAgent(String agent) {
    this.agent = agent;
  }

  /**
   * DOCUMENT ME!
   *
   * @param soft DOCUMENT ME!
   */
  public void setSoft(boolean soft) {
    this.soft = soft;
  }
}
