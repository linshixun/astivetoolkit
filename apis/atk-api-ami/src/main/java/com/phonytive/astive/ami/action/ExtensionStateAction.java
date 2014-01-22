/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://astive.phonytive.com
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
public class ExtensionStateAction extends ActionMessage {
  private String context;
  private String exten;

  /**
   * Creates a new ExtensionStateAction object.
   *
   * @param exten DOCUMENT ME!
   * @param context DOCUMENT ME!
   */
  public ExtensionStateAction(String exten, String context) {
    super(ActionType.EXTENSION_STATE);
    this.exten = exten;
    this.context = context;
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
  public String getExten() {
    return exten;
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
   * @param exten DOCUMENT ME!
   */
  public void setExten(String exten) {
    this.exten = exten;
  }
}
