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
 * Adds or updates an entry in the Asterisk database for a given <code>family></code>,
 * <code>key</code>, <code>value</code>
 *
 * <p>Returns 1 if successful, 0 otherwise.
 *
 * @since 1.0
 * @see DatabaseDel
 */
@AgiCommand(command = "DATABASE PUT")
public class DatabasePut implements Serializable {
  private static final long serialVersionUID = -8536786322579439275L;
  @Parameter(optional = false)
  private String family;
  @Parameter(position = 1, optional = false)
  private String key;
  @Parameter(position = 2, optional = false)
  private String value;

  /**
   * Create a new DatabasePut object with family, key and value as parameters.
   *
   * @param family database family.
   * @param key family element.
   * @param value family element value.
   */
  public DatabasePut(final String family, final String key, final String value) {
    this.family = family;
    this.key = key;
    this.value = value;
  }

  /**
   * Database family.
   *
   * @return database family.
   */
  public String getFamily() {
    return family;
  }

  /**
   * Get family element.
   *
   * @return family element.
   */
  public String getKey() {
    return key;
  }

  /**
   * Get family element value.
   *
   * @return family element value.
   */
  public String getValue() {
    return value;
  }

  /**
   * Set database family.
   *
   * @param family database family.
   */
  public void setFamily(final String family) {
    this.family = family;
  }

  /**
   * Set family element.
   *
   * @param key
   */
  public void setKey(final String key) {
    this.key = key;
  }

  /**
   * Set family element value.
   *
   * @param value family element value.
   */
  public void setValue(String value) {
    this.value = value;
  }
}
