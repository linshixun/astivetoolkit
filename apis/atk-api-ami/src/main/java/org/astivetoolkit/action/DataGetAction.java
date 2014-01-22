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
public class DataGetAction extends ActionMessage {
  private String filter;
  private String path;
  private String search;

  /**
   * Creates a new DataGetAction object.
   *
   * @param path DOCUMENT ME!
   */
  public DataGetAction(String path) {
    super(ActionType.DATA_GET);
    this.path = path;
  }

  /**
   * Creates a new DataGetAction object.
   *
   * @param path DOCUMENT ME!
   * @param search DOCUMENT ME!
   */
  public DataGetAction(String path, String search) {
    super(ActionType.DATA_GET);
    this.path = path;
    this.search = search;
  }

  /**
   * Creates a new DataGetAction object.
   *
   * @param path DOCUMENT ME!
   * @param search DOCUMENT ME!
   * @param filter DOCUMENT ME!
   */
  public DataGetAction(String path, String search, String filter) {
    super(ActionType.DATA_GET);
    this.path = path;
    this.search = search;
    this.filter = filter;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getFilter() {
    return filter;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getPath() {
    return path;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getSearch() {
    return search;
  }

  /**
   * DOCUMENT ME!
   *
   * @param filter DOCUMENT ME!
   */
  public void setFilter(String filter) {
    this.filter = filter;
  }

  /**
   * DOCUMENT ME!
   *
   * @param path DOCUMENT ME!
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * DOCUMENT ME!
   *
   * @param search DOCUMENT ME!
   */
  public void setSearch(String search) {
    this.search = search;
  }
}
