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
 * Activates the specified grammar on the speech object.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SPEECH ACTIVATE GRAMMAR")
public class SpeechActivateGrammar implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = -2361008693647555696L;

  /**
   * Grammar name.
   */
  @Parameter
  private String name;

  /**
   * Create a new SpeechActivateGrammar object.
   *
   * @param name grammar name.
   */
  public SpeechActivateGrammar(String name) {
    this.name = name;
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
   * Set grammar name.
   *
   * @param name grammar name.
   */
  public void setName(String name) {
    this.name = name;
  }
}
