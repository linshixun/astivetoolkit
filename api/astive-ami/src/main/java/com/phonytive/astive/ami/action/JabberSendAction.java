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
public class JabberSendAction extends ActionMessage {
  private String jId;
  private String jabber;
  private String message;

  /**
   * Creates a new JabberSendAction object.
   *
   * @param jabber DOCUMENT ME!
   * @param jId DOCUMENT ME!
   * @param message DOCUMENT ME!
   */
  public JabberSendAction(String jabber, String jId, String message) {
    super(ActionType.JABBER_SEND);
    this.jabber = jabber;
    this.jId = jId;
    this.message = message;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getJabber() {
    return jabber;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getMessage() {
    return message;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getjId() {
    return jId;
  }

  /**
   * DOCUMENT ME!
   *
   * @param jabber DOCUMENT ME!
   */
  public void setJabber(String jabber) {
    this.jabber = jabber;
  }

  /**
   * DOCUMENT ME!
   *
   * @param message DOCUMENT ME!
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * DOCUMENT ME!
   *
   * @param jId DOCUMENT ME!
   */
  public void setjId(String jId) {
    this.jId = jId;
  }
}
