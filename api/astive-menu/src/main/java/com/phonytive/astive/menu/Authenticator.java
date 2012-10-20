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
package com.phonytive.astive.menu;


/**
 *
 * @since 1.0.0
 */
public abstract class Authenticator {
  private boolean authenticated = false;
  private int maxAuth = 0x3;

  /** 
   * Creates a new Authenticator object.
   */
  public Authenticator() {
  }

  /**
   * @return the maxAuth
   */
  public int getMaxAuth() {
    return maxAuth;
  }

  /**
   * @return the authenticated
   */
  public boolean isAuthenticated() {
    return authenticated;
  }

  /**
   * @param authenticated the authenticated to set
   */
  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }

  /**
   * @param maxAuth the maxAuth to set
   */
  public void setMaxAuth(int maxAuth) {
    this.maxAuth = maxAuth;
  }

  /**
   * <p>This method must be implemented in the concrete class. If
   * athentication meet your criteria you must set authenticated as true.</p>
   */
  public abstract void signIn();

  /**
   * <p>Set's the variable authenticated as false.</p>
   */
  public void signOut() {
    setAuthenticated(false);
  }
}
