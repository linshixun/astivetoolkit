/* 
 * Copyright (C) 2010-2016 by Fonoster Inc (http://fonoster.com)
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
 * Changes the extension for continuation upon exiting the application.
 *
 * @since 1.0
 */
@AgiCommand(command = "SET EXTENSION")
public class SetExtension implements Serializable {
  private static final long serialVersionUID = -7607143769226787251L;
  @Parameter(optional = false)
  private String extension;

  /**
   * Create a new SetExtension object.
   *
   * @param extension new extension for channel.
   */
  public SetExtension(String extension) {
    this.extension = extension;
  }

  /**
   * Get extension.
   *
   * @return extension.
   */
  public String getExtension() {
    return extension;
  }

  /**
   * Set new extension.
   *
   * @param extension new extension.
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }
}
