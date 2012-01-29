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
public class MailboxCountAction extends ActionMessage {
  private String mailBox;

  /**
   * Creates a new MailboxCountAction object.
   *
   * @param mailBox DOCUMENT ME!
   */
  public MailboxCountAction(String mailBox) {
    super(ActionType.MAILBOX_COUNT);
    this.mailBox = mailBox;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getMailBox() {
    return mailBox;
  }

  /**
   * DOCUMENT ME!
   *
   * @param mailBox DOCUMENT ME!
   */
  public void setMailBox(String mailBox) {
    this.mailBox = mailBox;
  }
}
