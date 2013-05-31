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
package org.astivetoolkit.agi;


/**
 * Enum that handle the hangup cause for a <code>channel</code>.
 *
 * @since 1.0.0
 */
public enum HangupCause { // TODO: Define all enum elements below this comment.
  UNKNOWN(0xffffffff);

  /**
   * Int value of this type.
   */
  private int code;

  /**
   * Create a new {@link HangupCause} object. This class is an enum,
   * therefore can't be instantiated directly.
   *
   * @param code hangup cause int.
   */
  private HangupCause(final int code) {
    this.code = code;
  }

  /**
   * Get int code of hangup cause.
   *
   * @return code of hangup cause.
   */
  public int getCode() {
    return code;
  }
}
