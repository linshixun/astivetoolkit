/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
 *
 * This file is part of Astive Toolkit
 *
 * Astive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Astive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Astive.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.phonytive.astive.ami.action;


/**
 *
 * @since 1.0.0
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
