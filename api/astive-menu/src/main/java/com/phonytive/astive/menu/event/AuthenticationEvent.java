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
package com.phonytive.astive.menu.event;

import com.phonytive.astive.menu.Authenticator;

/**
 *
 * @since 1.0.0
 * @see AuthenticationListener
 */
public class AuthenticationEvent {
  private Authenticator authenticator;
  private Object source;

  /** <p>Creates a new instance of AuthenticationEvent</p> */
  public AuthenticationEvent(Object source, Authenticator authenticator) {
    this.authenticator = authenticator;
    this.source = source;
  }

  /**
   * @return the authenticator
   */
  public Authenticator getAuthenticator() {
    return authenticator;
  }

  /**
   * @return the source
   */
  public Object getSource() {
    return source;
  }

  /**
   * @param authenticator the authenticator to set
   */
  public void setAuthenticator(Authenticator authenticator) {
    this.authenticator = authenticator;
  }

  /**
   * @param source the source to set
   */
  public void setSource(Object source) {
    this.source = source;
  }
}
