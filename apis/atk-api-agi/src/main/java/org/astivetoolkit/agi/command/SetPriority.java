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
 * Changes the priority for continuation upon exiting the application. The
 * priority must be a valid priority or label.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SET PRIORITY")
public class SetPriority implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = -7927872930023068529L;

  /**
   * The priority or label for continuation upon exiting the application.
   */
  @Parameter(optional = false)
  private String priority;

  /**
   * Create a new SetPriority object.
   *
   * @param priority priority or label for continuation upon exiting the
   * application.
   */
  public SetPriority(String priority) {
    this.priority = priority;
  }

  /**
   * Get priority.
   *
   * @return priority.
   */
  public String getPriority() {
    return priority;
  }

  /**
   * Set priority or label for continuation upon exiting the application.
   *
   * @param priority priority or label for continuation upon exiting the
   * application.
   */
  public void setPriority(String priority) {
    this.priority = priority;
  }
}
