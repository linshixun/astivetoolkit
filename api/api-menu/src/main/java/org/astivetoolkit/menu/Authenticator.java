/* 
 * Copyright (C) 2010-2013 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.menu;


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
