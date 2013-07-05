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
 * Waits up to <code>timeout</code> milliseconds for channel to receive a DTMF
 * digit.
 *
 * <p>Returns -1 on channel failure, 0 if no digit is received in the timeout,
 * or the numerical value of the ASCII of the digit if one is received.
 *
 * <p>Use -1 for the <code>timeout</code> value if you desire the call to block
 * indefinitely.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "WAIT FOR DIGIT")
public class WaitForDigit implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 1274177415080200306L;

  /**
   * Timeout in milliseconds.
   */
  @Parameter(optional = false)
  private Integer timeout;

  /**
   * Create a new WaitForDigit object.
   */
  public WaitForDigit() {
  }

  /**
   * Create a new WaitForDigit object with timeout.
   *
   * @param timeout time in milliseconds to wait for a digit.
   */
  public WaitForDigit(Integer timeout) {
    this.timeout = timeout;
  }

  /**
   * Get time to wait for a digit.
   *
   * @return time(in milliseconds) to wait for a digit.
   */
  public Integer getTimeout() {
    return timeout;
  }

  /**
   * Set time to wait for a digit or null to wait forever.
   *
   * @param timeout time(in milliseconds) to wait for a digit.
   */
  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }
}
