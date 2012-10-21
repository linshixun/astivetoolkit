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
package com.phonytive.astive.agi.command;

import java.io.Serializable;
import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.annotation.Parameter;

/**
 * Returns 0 if <code>variablename</code> is not set or channel does not exist.
 *
 * <p>Returns 1 if variablename is set and returns the variable in parenthesis.
 * Understands complex variable names and builtin variables, unlike GET VARIABLE.
 *
 * <p>Ex.: return code: 200 result=1 (testvariable)
 *
 * @since 1.0.0
 */
@AgiCommand(command = "GET FULL VARIABLE")
public class GetFullVariable implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0x89475b375dc3e426L;

  /**
   * Channel name.
   */
  @Parameter(position = 0x1)
  private String channel;

  /**
   * Channel variable.
   */
  @Parameter(optional = false)
  private String variable;

  /**
   * Create a new GetFullVariable object to get the variable on the current
   * <code>channel</code>.
   *
   * @param variable channel variable.
   */
  public GetFullVariable(String variable) {
    this.variable = variable;
  }

  /**
   * Create a new GetFullVariable object to get the variable on
   * <code>channel</code>.
   *
   * @param variable channel variable.
   * @param channel channel name.
   */
  public GetFullVariable(String variable, String channel) {
    this.variable = variable;
    this.channel = channel;
  }

  /**
   * Get channel name or null for current channel.
   *
   * @return channel name.
   */
  public String getChannel() {
    return channel;
  }

  /**
   * Get channel variable.
   *
   * @return channel variable.
   */
  public String getVariable() {
    return variable;
  }

  /**
   * Set channel name. Use null for current channel.
   *
   * @param channel channel name.
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  /**
   * Set channel variable.
   *
   * @param variable channel variable.
   */
  public void setVariable(String variable) {
    this.variable = variable;
  }
}
