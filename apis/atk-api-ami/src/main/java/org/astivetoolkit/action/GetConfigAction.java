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
package org.astivetoolkit.action;


/**
 *
 * @since 1.1
 */
public class GetConfigAction extends ActionMessage {
  private String category;
  private String filename;

  /**
   * Creates a new GetConfigAction object.
   *
   * @param filename DOCUMENT ME!
   */
  public GetConfigAction(String filename) {
    super(ActionType.GET_CONFIG);
    this.filename = filename;
  }

  /**
   * Creates a new GetConfigAction object.
   *
   * @param filename DOCUMENT ME!
   * @param category DOCUMENT ME!
   */
  public GetConfigAction(String filename, String category) {
    super(ActionType.GET_CONFIG);
    this.filename = filename;
    this.category = category;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getCategory() {
    return category;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getFilename() {
    return filename;
  }

  /**
   * DOCUMENT ME!
   *
   * @param category DOCUMENT ME!
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * DOCUMENT ME!
   *
   * @param filename DOCUMENT ME!
   */
  public void setFilename(String filename) {
    this.filename = filename;
  }
}
