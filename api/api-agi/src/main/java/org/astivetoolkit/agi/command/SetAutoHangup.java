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
 * Cause the channel to automatically hangup at <code>time</code> seconds in
 * the future. Of course it can be hungup before then as well. Setting to 0 will
 * cause the autohangup feature to be disabled on this channel.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SET AUTOHANGUP")
public class SetAutoHangup implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = -5343593827052978984L;

  /**
   * Time in seconds to automatically hangup channel.
   */
  @Parameter(optional = false)
  private Integer time;

  /**
   * Create a new SetAutoHangup object with time.
   *
   * @param time time in seconds to automatically hangup channel.
   */
  public SetAutoHangup(Integer time) {
    this.time = time;
  }

  /**
   * Get time to autohangup channel.
   *
   * @return time in seconds to autohangup channel.
   */
  public Integer getTime() {
    return time;
  }

  /**
   * Set time to autohangup channel.
   *
   * @param time time in seconds to autohangup channel.
   */
  public void setTime(Integer time) {
    this.time = time;
  }
}
