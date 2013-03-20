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
 * Say a given character string with phonetics, returning early if any of the
 * given DTMF digits are received on the channel.
 *
 * <p>Returns 0 if playback completes without a digit pressed, the ASCII
 * numerical value of the digit if one was pressed, or -1 on error/hangup.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SAY PHONETIC")
public class SayPhonetic implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0xb0b517aa25938669L;

  /**
   * Can be use to the interrupt the audio on a channel.
   */
  @Parameter(position = 0x1, optional = false)
  private String escapeDigits;

  /**
   * Text to say.
   */
  @Parameter(optional = false)
  private String text;

  /**
   * Create a new SayPhonetic object with the text to say.
   *
   * @param text number to say.
   */
  public SayPhonetic(String text) {
    this.text = text;
    this.escapeDigits = "";
  }

  /**
   * Create a new SayPhonetic object with the text to say and escape digits.
   *
   * @param text text to say.
   * @param escapeDigits escape digits.
   */
  public SayPhonetic(String text, String escapeDigits) {
    this.text = text;
    this.escapeDigits = escapeDigits;
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
   * Get text to say.
   *
   * @return text to say.
   */
  public String getText() {
    return text;
  }

  /**
   * Set the digits to be use to interrupt the audio.
   *
   * @param escapeDigits digits to be use to interrupt the audio.
   */
  public void setEscapeDigits(String escapeDigits) {
    this.escapeDigits = escapeDigits;
  }

  /**
   * Set text to say.
   *
   * @param text text to say.
   */
  public void setText(String text) {
    this.text = text;
  }
}
