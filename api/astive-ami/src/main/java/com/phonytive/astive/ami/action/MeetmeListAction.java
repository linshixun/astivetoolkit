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
public class MeetmeListAction extends ActionMessage {
  private String conference;

  /**
   * Creates a new MeetmeListAction object.
   */
  public MeetmeListAction() {
    super(ActionType.MEETME_LIST);
  }

  /**
   * Creates a new MeetmeListAction object.
   *
   * @param conference DOCUMENT ME!
   */
  public MeetmeListAction(String conference) {
    super(ActionType.MEETME_LIST);
    this.conference = conference;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getConference() {
    return conference;
  }

  /**
   * DOCUMENT ME!
   *
   * @param conference DOCUMENT ME!
   */
  public void setConference(String conference) {
    this.conference = conference;
  }
}
