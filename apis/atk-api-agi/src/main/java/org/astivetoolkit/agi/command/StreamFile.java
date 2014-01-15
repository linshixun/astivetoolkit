/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
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
 * Send the given file, allowing playback to be interrupted by the given digits,
 * if any.
 *
 * <p>Returns 0 if playback completes without a digit being pressed, or
 * the ASCII numerical value of the digit if one was pressed, or -1 on error
 * or if the channel was disconnected.
 *
 * @since 1.0.0
 * @see ControlStreamFile
 */
@AgiCommand(command = "STREAM FILE")
public class StreamFile implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = -2252108911003941739L;

  /**
   * Silence time in milliseconds after audio finished. The default value
   * is '0' (no silence).
   */
  @Parameter(position = 2, optional = false)
  private Integer offset;

  /**
   * Can be use to the interrupt the audio on a channel.
   */
  @Parameter(position = 1, optional = false)
  private String escapeDigits;

  /**
   * Audio to send to channel.
   */
  @Parameter(optional = false)
  private String file;

  /**
   * Create a new StreamFile object for a file. Audio can not be
   * interrupted when use this constructor.
   *
   * @param file audio to play.
   */
  public StreamFile(String file) {
    this.file = file;
    this.escapeDigits = "";
    this.offset = 0;
  }

  /**
   * Create a new StreamFile object that can interrupt the audio by press
   * a digit present in escapeDigits.
   *
   * @param file audio to play.
   * @param escapeDigits digits to interrupt the audio.
   */
  public StreamFile(String file, String escapeDigits) {
    this.file = file;
    this.escapeDigits = escapeDigits;
    this.offset = 0;
  }

  /**
   * Create a new StreamFile object that can interrupt the audio by
   * press a digit present in escapeDigits. The offset(in milliseconds)
   * indicate a silence time after audio finished.
   *
   * @param file audio to play.
   * @param escapeDigits digits to interrupt the audio.
   * @param offset silence time in milliseconds after audio finished.
   */
  public StreamFile(String file, String escapeDigits, Integer offset) {
    this.file = file;
    this.escapeDigits = escapeDigits;
    this.offset = offset;
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
   * Get audio to be send to <code>channel</code>.
   *
   * @return audio to be send to <code>channel</code>.
   */
  public String getFile() {
    return file;
  }

  /**
   * Get time in milliseconds for silence after audio finished.
   *
   * @return time in milliseconds for silence after audio finished.
   */
  public Integer getOffset() {
    return offset;
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
   * Set audio to be send to <code>channel</code>. Keep in mind that
   * the audio must not contain any extension.
   *
   * @param file audio to be send to <code>channel</code>
   */
  public void setFile(String file) {
    this.file = file;
  }

  /**
   * Set time in milliseconds for silence after audio finished.
   *
   * @param offset time in milliseconds after audio finished. If this is set null
   * any subsequent parameter will be ignore.
   */
  public void setOffset(Integer offset) {
    this.offset = offset;
  }
}
