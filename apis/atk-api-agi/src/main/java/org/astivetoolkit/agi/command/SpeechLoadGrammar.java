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
 * Unloads the specified grammar.
 *
 * @since 1.0.0
 * @see SpeechUnloadGrammar
 */
@AgiCommand(command = "SPEECH LOAD GRAMMAR")
public class SpeechLoadGrammar implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 8635683833403820211L;

  /**
   * Grammar name.
   */
  @Parameter(optional = false)
  private String name;

  /**
   * Path to grammar.
   */
  @Parameter(position = 1, optional = false)
  private String path;

  /**
   * Create a new SpeechLoadGrammar object.
   *
   * @param name grammar name.
   * @param path path to grammar.
   */
  public SpeechLoadGrammar(String name, String path) {
    this.name = name;
    this.path = path;
  }

  /**
   * Get grammar name.
   *
   * @return grammar name.
   */
  public String getName() {
    return name;
  }

  /**
   * Get path to grammar.
   *
   * @return path to grammar.
   */
  public String getPath() {
    return path;
  }

  /**
   * Set grammar name.
   *
   * @param name grammar name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set path to grammar.
   *
   * @param path path to grammar.
   */
  public void setPath(String path) {
    this.path = path;
  }
}
