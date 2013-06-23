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
 * Say a given digit string, returning early if any of the given DTMF digits
 * are received on the channel.
 *
 * <p>Returns 0 if playback completes without a digit being pressed, or the ASCII
 * numerical value of the digit if one was pressed or -1 on error/hangup.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SAY DIGITS")
public class SayDigits implements Serializable {
  /**
   * Serial version identifier.
   */
  @Parameter(optional = false)
  private String digits;

  /**
   * Can be use to the interrupt the audio on a channel.
   */
  @Parameter(position = 1, optional = false)
  private String escapeDigits;

  /**
   * Create a new SayDigits object with the digits to say.
   *
   * @param digits digits to say.
   */
  public SayDigits(String digits) {
    this.digits = digits;
    this.escapeDigits = "";
  }

  /**
   * Create a new SayDigits object with the digits to say and escape digits.
   *
   * @param digits digits to say.
   * @param escapeDigits escape digits.
   */
  public SayDigits(String digits, String escapeDigits) {
    this.digits = digits;
    this.escapeDigits = escapeDigits;
  }

  /**
   * Get digits to say.
   *
   * @return digits to say.
   */
  public String getDigits() {
    return digits;
  }

  /**
   * Get the digits used to interrupt the audio.
   *
   * @return digits used to interrupt the audio.
   */
  public String getEscapeDigits() {
    return escapeDigits;
  }

  /**
   * Set digits to say.
   *
   * @param digits digits to say.
   */
  public void setDigits(String digits) {
    this.digits = digits;
  }

  /**
   * Set the digits to be use to interrupt the audio.
   *
   * @param escapeDigits digits to be use to interrupt the audio.
   */
  public void setEscapeDigits(String escapeDigits) {
    this.escapeDigits = escapeDigits;
  }
}
