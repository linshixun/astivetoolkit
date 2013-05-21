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
 * Stream the given <code>file</code>, and receive DTMF data.
 *
 * <p>Returns the digits received from the channel at the other end.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "GET DATA")
public class GetData implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0xa857a610017b3676L;

  /**
   * Default max digits.
   */
  private static final int DEFAULT_MAX_DIGITS = 0x400;

  /**
   * Default max timeout.
   */
  private static final int DEFAULT_TIMEOUT = 0x0;

  /**
   * Max digits to enter.
   */
  @Parameter(position = 0x2)
  private Integer maxDigits;

  /**
   * Time in milliseconds to wait for DTMF. If a digit is pressed the wait
   * time is reset. <p>With timeout set to -1 this command wait forever.
   */
  @Parameter(position = 0x1)
  private Integer timeout;

  /**
   * Audio to send to channel.
   */
  @Parameter(optional = false)
  private String file;

  /**
   * Create a new GetData object with file as parameter.
   *
   * @param file audio to stream.
   */
  public GetData(String file) {
    this.file = file;
    this.timeout = DEFAULT_TIMEOUT;
    this.maxDigits = DEFAULT_MAX_DIGITS;
  }

  /**
   * Create a new GetData object with timeout.
   *
   * @param file audio to stream.
   * @param timeout time in milliseconds to wait for a new DTMF digit.
   */
  public GetData(String file, Integer timeout) {
    this.file = file;
    this.timeout = timeout;
    this.maxDigits = DEFAULT_MAX_DIGITS;
  }

  /**
   * Create a new GetData object with timeout and maxDigits.
   *
   * @param file audio to stream.
   * @param timeout time in milliseconds to wait for a new DTMF digit.
   * @param maxDigits maximum amount digits accepted.
   */
  public GetData(String file, Integer timeout, Integer maxDigits) {
    this.file = file;
    this.timeout = timeout;
    this.maxDigits = maxDigits;
  }

  /**
   * Get audio file.
   *
   * @return audio file.
   */
  public String getFile() {
    return file;
  }

  /**
   * Get maximum amount of digits.
   *
   * @return maximum amount of digits.
   */
  public Integer getMaxDigits() {
    return maxDigits;
  }

  /**
   * Get timeout(in milliseconds).
   *
   * @return time in milliseconds.
   */
  public Integer getTimeout() {
    return timeout;
  }

  /**
   * Set audio file
   *
   * @param file audio file.
   */
  public void setFile(String file) {
    this.file = file;
  }

  /**
   * Set maximum amount of digits.
   *
   * @param maxDigits maximum amount of digits.
   */
  public void setMaxDigits(Integer maxDigits) {
    this.maxDigits = maxDigits;
  }

  /**
   * Set timeout(in milliseconds).
   *
   * @param timeout time in milliseconds
   */
  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }
}
