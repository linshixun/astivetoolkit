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
public class LoginAction extends ActionMessage {
  private String secret;
  private String userName;

  /**
   * Creates a new LoginAction object.
   *
   * @param userName DOCUMENT ME!
   */
  public LoginAction(String userName) {
    super(ActionType.LOGIN);
    this.userName = userName;
  }

  /**
   * Creates a new LoginAction object.
   *
   * @param userName DOCUMENT ME!
   * @param secret DOCUMENT ME!
   */
  public LoginAction(String userName, String secret) {
    super(ActionType.LOGIN);
    this.userName = userName;
    this.secret = secret;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getSecret() {
    return secret;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getUserName() {
    return userName;
  }

  /**
   * DOCUMENT ME!
   *
   * @param secret DOCUMENT ME!
   */
  public void setSecret(String secret) {
    this.secret = secret;
  }

  /**
   * DOCUMENT ME!
   *
   * @param userName DOCUMENT ME!
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }
}
