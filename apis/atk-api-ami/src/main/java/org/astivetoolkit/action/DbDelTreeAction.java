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
package org.astivetoolkit.ami.action;


/**
 *
 * @since 1.1
 */
public class DbDelTreeAction extends ActionMessage {
  private String family;
  private String key;

  /**
   * Creates a new DbDelTreeAction object.
   *
   * @param family DOCUMENT ME!
   */
  public DbDelTreeAction(String family) {
    super(ActionType.DB_DEL_TREE);
    this.family = family;
  }

  /**
   * Creates a new DbDelTreeAction object.
   *
   * @param family DOCUMENT ME!
   * @param key DOCUMENT ME!
   */
  public DbDelTreeAction(String family, String key) {
    super(ActionType.DB_DEL_TREE);
    this.family = family;
    this.key = key;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getFamily() {
    return family;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getKey() {
    return key;
  }

  /**
   * DOCUMENT ME!
   *
   * @param family DOCUMENT ME!
   */
  public void setFamily(String family) {
    this.family = family;
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   */
  public void setKey(String key) {
    this.key = key;
  }
}
