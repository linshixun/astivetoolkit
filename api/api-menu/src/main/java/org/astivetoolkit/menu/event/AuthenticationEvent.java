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
package org.astivetoolkit.menu.event;

import org.astivetoolkit.menu.Authenticator;

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
