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


import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiResponse;
import com.phonytive.astive.menu.Engine;
import com.phonytive.astive.menu.Menu;
import com.phonytive.astive.menu.exception.MenuException;

/**
 *
 * @since 1.0.0
 * @see GoExt
 */
public class GoTo implements Action {
  private AgiResponse agiResponse;
  private Menu menu;

  /**
   * Creates a new GoTo object.
   * 
   * @param agiResponse agi response.
   * @param menu menu where to jump.
   */
  public GoTo(AgiResponse agiResponse, Menu menu) {
    this.agiResponse = agiResponse;
    this.menu = menu;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void doAction() {
    try {
      Engine e = new Engine(agiResponse);
      e.run(menu);
    } catch (AgiException ex) {
      // Manage this exception
    } catch (MenuException ex) {
      // Manage this exception
    }
  }    
}
