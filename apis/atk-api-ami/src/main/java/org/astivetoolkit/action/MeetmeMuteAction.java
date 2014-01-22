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
package org.astivetoolkit.ami.action;


/**
 *
 * @since 1.1
 */
public class MeetmeMuteAction extends ActionMessage {
  private String meetme;
  private String userNum;

  /**
   * Creates a new MeetmeMuteAction object.
   *
   * @param meetme DOCUMENT ME!
   * @param userNum DOCUMENT ME!
   */
  public MeetmeMuteAction(String meetme, String userNum) {
    super(ActionType.MEETME_MUTE);
    this.meetme = meetme;
    this.userNum = userNum;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getMeetme() {
    return meetme;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getUserNum() {
    return userNum;
  }

  /**
   * DOCUMENT ME!
   *
   * @param meetme DOCUMENT ME!
   */
  public void setMeetme(String meetme) {
    this.meetme = meetme;
  }

  /**
   * DOCUMENT ME!
   *
   * @param userNum DOCUMENT ME!
   */
  public void setUserNum(String userNum) {
    this.userNum = userNum;
  }
}
