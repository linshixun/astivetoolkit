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
package org.astivetoolkit.agi.command;

import java.io.Serializable;
import org.astivetoolkit.agi.annotation.AgiCommand;
import org.astivetoolkit.agi.annotation.Parameter;

/**
 * Returns 0 if <code>variablename</code> is not set.
 *
 * <p>Returns 1 if variablename is set and returns the variable in parentheses.
 *
 * <p>Eg.: return code: 200 result=1 (testvariable)
 *
 * @since 1.0.0
 * @see GetFullVariable
 */
@AgiCommand(command = "GET VARIABLE")
public class GetVariable implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0xcf16444fd1474312L;

  /**
   * Variable name.
   */
  @Parameter(optional = false)
  private String variable;

  /**
   * Create a new GetVariable object to get the variable on the current
   * <code>channel</code>.
   *
   * @param variable variable name.
   */
  public GetVariable(String variable) {
    this.variable = variable;
  }

  /**
   * Get variable name.
   *
   * @return variable name.
   */
  public String getVariable() {
    return variable;
  }

  /**
   * Set variable name.
   *
   * @param variable variable name.
   */
  public void setVariable(String variable) {
    this.variable = variable;
  }
}
