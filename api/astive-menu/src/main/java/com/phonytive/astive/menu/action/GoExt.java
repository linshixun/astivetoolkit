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
package com.phonytive.astive.menu.action;

import org.apache.log4j.Logger;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiResponse;

/**
 *
 * @since 1.0.0
 * @see Action
 */
public class GoExt implements Action {
  // A usual logging class
  private static final Logger logger = Logger.getLogger(GoExt.class);
  private AgiResponse agiResponse;
  private String context;
  private String extension;
  private String priority;

  /** Creates a new instance of GoExt */
  public GoExt(AgiResponse agiResponse, String context, String extension, String priority) {
    this.agiResponse = agiResponse;
    this.context = context;
    this.extension = extension;
    this.priority = priority;
  }

  /**
   * DOCUMENT ME!
   */
  @Override
  public void doAction() {
    try {
      agiResponse.setContext(context);
      agiResponse.setExtension(extension);
      agiResponse.setPriority(priority);
    } catch (AgiException ex) {
      logger.warn(ex.getMessage());
    }
  }
}
