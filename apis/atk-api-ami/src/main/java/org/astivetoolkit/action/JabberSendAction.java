/*
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.action;


/**
 *
 * @since 1.1
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
