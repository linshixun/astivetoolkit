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
import org.astivetoolkit.agi.annotation.BooleanChoose;
import org.astivetoolkit.agi.annotation.ParamConverter;
import org.astivetoolkit.agi.annotation.Parameter;

/**
 * Record to a file until a given DTMF digit in the sequence is received.
 *
 * <p>Returns -1 on hangup or error.  The format will specify what kind of file
 * will be recorded. The <code>timeout</code> is the maximum record time in milliseconds, or '-1'
 * for no timeout. <code>offset samples</code> is optional, and, if provided, will seek
 * to the offset without exceeding the end of the file. <code>silence</code> is the number
 * of seconds of silence allowed before the function returns despite the lack
 * of DTMF digits or reaching timeout. <code>silence</code> value must be preceded by
 * 's=' and is also optional.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "RECORD FILE")
public class RecordFile implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0x9ebf75ed7d724e7dL;

  /**
   * Whether a beep should be played before recording.
   */
  @Parameter(position = 0x5)
  @ParamConverter
  @BooleanChoose(valueOnTrue = "BEEP", valueOnFalse = "")
  private Boolean beep;

  /**
   * The amount of silence (in seconds) to allow before returning despite the
   * lack of DTMF digits or reaching timeout.
   */
  @Parameter(position = 0x6, prefix = "s=")
  private Integer maxSilence;

  /**
   * The offset samples to skip.
   */
  @Parameter(position = 0x4)
  private Integer offset;

  /**
   * Maximum record time in milliseconds. Use -1 for no timeout.
   */
  @Parameter(position = 0x3, optional = false)
  private Integer timeout;

  /**
   * Can be use to the interrupt the audio recording.
   */
  @Parameter(position = 0x2, optional = false)
  private String escapeDigits;

  /**
   * Audio to send to channel.
   */
  @Parameter(optional = false)
  private String file;

  /**
   * Format for the new audio.
   */
  @Parameter(position = 0x1, optional = false)
  private String format;

  /**
   * Create a new RecordFile object.
   *
   * @param file name for the new file.
   * @param format format for new file.
   */
  public RecordFile(String file, String format) {
    this.file = file;
    this.format = format;
    this.escapeDigits = "";
    this.timeout = 0xffffffff;
  }

  /**
   * Create a new RecordFile object.
   *
   * @param file file name.
   * @param format file format.
   * @param escapeDigits digits to interrupt the audio recording.
   */
  public RecordFile(String file, String format, String escapeDigits) {
    this.file = file;
    this.format = format;
    this.escapeDigits = escapeDigits;
    this.timeout = 0xffffffff;
    this.offset = 0x0;
    this.beep = false;
    this.maxSilence = 0x0;
  }

  /**
   * Create a new RecordFile object.
   *
   * @param file file name.
   * @param format file format.
   * @param escapeDigits digits to interrupt the audio recording.
   * @param timeout maximum time(in seconds) to record this file.
   */
  public RecordFile(String file, String format, String escapeDigits, Integer timeout) {
    this.file = file;
    this.format = format;
    this.escapeDigits = escapeDigits;
    this.timeout = timeout;
    this.offset = 0x0;
    this.beep = false;
    this.maxSilence = 0x0;
  }

  /**
   * Create a new Record object.
   *
   * @param file file name.
   * @param format file format.
   * @param escapeDigits digits to interrupt the audio recording.
   * @param timeout maximum time(in seconds) to record this file.
   * @param offset the offset samples to skip.
   * @param beep <code>true</code> if a beep should be played before recording.
   * @param maxSilence The amount of silence (in seconds) to allow before
   * returning despite the lack of DTMF digits or reaching timeout.
   */
  public RecordFile(String file, String format, String escapeDigits, Integer timeout,
                    Integer offset, Boolean beep, Integer maxSilence) {
    this.file = file;
    this.format = format;
    this.escapeDigits = escapeDigits;
    this.timeout = timeout;
    this.offset = offset;
    this.beep = beep;
    this.maxSilence = maxSilence;
  }

  /**
   * Get the digits used to interrupt the audio recording.
   *
   * @return digits used to interrupt the audio recording.
   */
  public String getEscapeDigits() {
    return escapeDigits;
  }

  /**
   * Get file name.
   *
   * @return file name.
   */
  public String getFile() {
    return file;
  }

  /**
   * Get file format.
   *
   * @return file format.
   */
  public String getFormat() {
    return format;
  }

  /**
   * Get the amount of silence (in seconds) to allow before returning despite the
   * lack of DTMF digits or reaching timeout.
   *
   * @return max silence.
   */
  public Integer getMaxSilence() {
    return maxSilence;
  }

  /**
   * Get offset.
   *
   * @return offset.
   */
  public Integer getOffset() {
    return offset;
  }

  /**
   * Get timeout. Maximum time to record the new file.
   *
   * @return timeout in seconds
   */
  public Integer getTimeout() {
    return timeout;
  }

  /**
   * Return <code>true</code> if beep should be played before recording.
   *
   * @return true for beep before recording, or false otherwise.
   */
  public boolean hasBeep() {
    return beep;
  }

  /**
   * Set whether or not a beep should be played before recording.
   *
   * @param beep true to play beep before recording, or false for no beep.
   */
  public void setBeep(boolean beep) {
    this.beep = beep;
  }

  /**
   * Set the digits to be use to interrupt the audio recording.
   *
   * @param escapeDigits digits to be use to interrupt the audio recording.
   */
  public void setEscapeDigits(String escapeDigits) {
    this.escapeDigits = escapeDigits;
  }

  /**
   * Set file name.
   *
   * @param file file name.
   */
  public void setFile(String file) {
    this.file = file;
  }

  /**
   * Set file format.
   *
   * @param format file format.
   */
  public void setFormat(String format) {
    this.format = format;
  }

  /**
   * Set max silence.
   *
   * @param maxSilence max silence.
   */
  public void setMaxSilence(Integer maxSilence) {
    this.maxSilence = maxSilence;
  }

  /**
   * Set offset.
   *
   * @param offset offset
   */
  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  /**
   * Set timeout(in seconds) to record the new file.
   *
   * @param timeout time(in seconds) to record the new file.
   */
  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }
}
