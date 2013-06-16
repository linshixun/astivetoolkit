/* 
 * Copyright (C) 2010-2013 by PhonyTive LLC (http://phonytive.com)
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
 * Changes the <code>callerid</code> of the current <code>channel.</code>
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SET CALLERID")
public class SetCallerId implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = -920453570097230648L;

  /**
   * Caller Id.
   */
  @Parameter(optional = false)
  private String callerId;

  /**
   * Create a new SetCallerId object to change the caller id for the
   * current channel.
   *
   * @param callerId caller id for the current channel.
   */
  public SetCallerId(String callerId) {
    this.callerId = callerId;
  }

  /**
   * Get caller id.
   *
   * @return caller id.
   */
  public String getCallerId() {
    return callerId;
  }

  /**
   * Set caller id for the current channel.
   *
   * @param callerId caller id.
   */
  public void setCallerId(String callerId) {
    this.callerId = callerId;
  }
}
