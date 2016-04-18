/* 
 * Copyright (C) 2010-2016 by Fonoster Inc (http://fonoster.com)
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
 * @since 1.0
 * @see GetFullVariable
 */
@AgiCommand(command = "GET VARIABLE")
public class GetVariable implements Serializable {
  private static final long serialVersionUID = -3524554548766620910L;
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
