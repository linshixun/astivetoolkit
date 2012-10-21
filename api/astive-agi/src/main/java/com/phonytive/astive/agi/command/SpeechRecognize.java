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
 * Plays back given <code>prompt</code> while listening for speech and DTMF.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SPEECH RECOGNIZE")
public class SpeechRecognize implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0x5f5b2b116d8d48efL;

  /**
   *  Maximum recognition time(in milliseconds).
   */
  @Parameter(position = 0x1, optional = false)
  private Integer timeout;  

  /**
   * Prompt to play.
   */
  @Parameter(optional = false)
  private String prompt;  

  /**
   * Offset samples to skip when playing the prompt.
   */
  @Parameter(position = 0x2)
  private Integer offset;  
  
  /**
   * Creates a new SpeechRecognizeCommand object that plays the given prompt
   * and listens for for speech and DTMF.
   *
   * @param prompt the prompt to play.
   * @param timeout the maximum recognition time in milliseconds.
   */
  public SpeechRecognize(String prompt, Integer timeout) {
    this.prompt = prompt;
    this.timeout = timeout;
  }

  /**
   * Creates a new SpeechRecognizeCommand object that plays the given prompt
   * and listens for for speech and DTMF.
   *
   * @param prompt the prompt to play.
   * @param timeout the maximum recognition time in milliseconds.
   * @param offset the offset samples to skip when playing the prompt.
   */
  public SpeechRecognize(String prompt, Integer timeout, Integer offset) {
    this.prompt = prompt;
    this.timeout = timeout;
    this.offset = offset;
  }

  /**
   * Returns the offset samples to skip when playing the prompt.
   *
   * @return the offset samples to skip when playing the prompt.
   */
  public int getOffset() {
    return offset;
  }

  /**
   * Get prompt to play.
   *
   * @return prompt to play.
   */
  public String getPrompt() {
    return prompt;
  }

  /**
   * Returns the maximum recognition time in milliseconds.
   *
   * @return the maximum recognition time in milliseconds.
   */
  public Integer getTimeout() {
    return timeout;
  }

  /**
   * Sets the offset samples to skip when playing the prompt.
   *
   * @param offset the offset samples to skip when playing the prompt.
   */
  public void setOffset(int offset) {
    this.offset = offset;
  }

  /**
   * Set prompt to play.
   *
   * @param prompt prompt to play.
   */
  public void setPrompt(String prompt) {
    this.prompt = prompt;
  }

  /**
   * Sets the maximum recognition time in milliseconds.
   *
   * @param timeout the maximum recognition time in milliseconds,
   * or -1 for no timeout.
   */
  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }
}
