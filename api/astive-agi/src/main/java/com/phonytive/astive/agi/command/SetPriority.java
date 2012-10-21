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
package com.phonytive.astive.agi.command;

import java.io.Serializable;
import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.annotation.Parameter;

/**
 * Changes the priority for continuation upon exiting the application. The
 * priority must be a valid priority or label.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "SET PRIORITY")
public class SetPriority implements Serializable {
  /**
   * Serial version identifier.
   */
  private static final long serialVersionUID = 0x91fa8992e58a2c8fL;

  /**
   * The priority or label for continuation upon exiting the application.
   */
  @Parameter(optional = false)
  private String priority;

  /**
   * Create a new SetPriority object.
   *
   * @param priority priority or label for continuation upon exiting the
   * application.
   */
  public SetPriority(String priority) {
    this.priority = priority;
  }

  /**
   * Get priority.
   *
   * @return priority.
   */
  public String getPriority() {
    return priority;
  }

  /**
   * Set priority or label for continuation upon exiting the application.
   *
   * @param priority priority or label for continuation upon exiting the
   * application.
   */
  public void setPriority(String priority) {
    this.priority = priority;
  }
}
