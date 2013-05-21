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
 * Enable/Disable TDD transmission/reception on a channel.
 *
 * <p>Returns 1 if successful, or 0 if channel is not TDD-capable.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "TDD MODE")
public class TddMode implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0x47dfb2d79b894cecL;

  /**
   * Enable/Disable TDD transmission/reception on a channel.
   */
  @Parameter(optional = false)
  @ParamConverter
  @BooleanChoose
  private Boolean enable;

  /**
   * Create a new TddMode object.
   *
   * @param enable enable/disable TDD transmission/reception on a channel.
   * <code>true</code> to enable or <code>false</code> to disable TDD mode.
   */
  public TddMode(Boolean enable) {
    this.enable = enable;
  }

  /**
   * Whether or not TDD mode is enable.
   *
   * @return <code>true</code> to enable or <code>false</code> to disable
   * TDD mode.
   */
  public Boolean isEnable() {
    return enable;
  }

  /**
   * Enable/Disable TDD mode.
   *
   * @param enable set enable to <code>true</code> to enable or <code>false</code>
   * to disable TDD mode.
   */
  public void setEnable(Boolean enable) {
    this.enable = enable;
  }
}
