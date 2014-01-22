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
public class DbPutAction extends ActionMessage {
  private String family;
  private String key;
  private String val;

  /**
   * Creates a new DbPutAction object.
   *
   * @param family DOCUMENT ME!
   * @param key DOCUMENT ME!
   */
  public DbPutAction(String family, String key) {
    super(ActionType.DB_PUT);
    this.family = family;
    this.key = key;
  }

  /**
   * Creates a new DbPutAction object.
   *
   * @param family DOCUMENT ME!
   * @param key DOCUMENT ME!
   * @param val DOCUMENT ME!
   */
  public DbPutAction(String family, String key, String val) {
    super(ActionType.DB_DEL);
    this.family = family;
    this.key = key;
    this.val = val;
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
   * @return DOCUMENT ME!
   */
  public String getVal() {
    return val;
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

  /**
   * DOCUMENT ME!
   *
   * @param val DOCUMENT ME!
   */
  public void setVal(String val) {
    this.val = val;
  }
}
