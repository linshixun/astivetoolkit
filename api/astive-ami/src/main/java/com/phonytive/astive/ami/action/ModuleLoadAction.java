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
public class ModuleLoadAction extends ActionMessage {
  private LoadType loadType;
  private String module;

  /**
   * Creates a new ModuleLoadAction object.
   *
   * @param loadType DOCUMENT ME!
   */
  public ModuleLoadAction(LoadType loadType) {
    super(ActionType.MODULE_LOAD);
    this.loadType = loadType;
  }

  /**
   * Creates a new ModuleLoadAction object.
   *
   * @param module DOCUMENT ME!
   * @param loadType DOCUMENT ME!
   */
  public ModuleLoadAction(String module, LoadType loadType) {
    super(ActionType.MODULE_LOAD);
    this.module = module;
    this.loadType = loadType;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public LoadType getLoadType() {
    return loadType;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getModule() {
    return module;
  }

  /**
   * DOCUMENT ME!
   *
   * @param loadType DOCUMENT ME!
   */
  public void setLoadType(LoadType loadType) {
    this.loadType = loadType;
  }

  /**
   * DOCUMENT ME!
   *
   * @param module DOCUMENT ME!
   */
  public void setModule(String module) {
    this.module = module;
  }
}
