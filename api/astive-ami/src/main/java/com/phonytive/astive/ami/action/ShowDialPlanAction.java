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
public class ShowDialPlanAction extends ActionMessage {
  private String context;
  private String extension;

  /**
   * Creates a new ShowDialPlanAction object.
   */
  public ShowDialPlanAction() {
    super(ActionType.SHOW_DIAL_PLAN);
  }

  /**
   * Creates a new ShowDialPlanAction object.
   *
   * @param context DOCUMENT ME!
   */
  public ShowDialPlanAction(String context) {
    super(ActionType.SHOW_DIAL_PLAN);
    this.context = context;
  }

  /**
   * Creates a new ShowDialPlanAction object.
   *
   * @param context DOCUMENT ME!
   * @param extension DOCUMENT ME!
   */
  public ShowDialPlanAction(String context, String extension) {
    super(ActionType.SHOW_DIAL_PLAN);
    this.context = context;
    this.extension = extension;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getContext() {
    return context;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getExtension() {
    return extension;
  }

  /**
   * DOCUMENT ME!
   *
   * @param context DOCUMENT ME!
   */
  public void setContext(String context) {
    this.context = context;
  }

  /**
   * DOCUMENT ME!
   *
   * @param extension DOCUMENT ME!
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }
}
