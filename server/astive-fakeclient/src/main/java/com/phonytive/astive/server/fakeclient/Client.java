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
package com.phonytive.astive.server.fakeclient;

import com.phonytive.astive.agi.ChannelStatus;
import com.phonytive.astive.agi.HangupCause;
import java.io.IOException;

/**
 *
 * @since 1.0.0
 */
interface Client {
  /**
   * DOCUMENT ME!
   */
  void call() throws IOException;

  void sendChannelStatus(ChannelStatus status) throws IOException;
  
  /**
   * DOCUMENT ME!
   */
  void hangup() throws IOException;

  /**
   * DOCUMENT ME!
   *
   * @param cause DOCUMENT ME!
   */
  void hangup(HangupCause cause) throws IOException;

  /**
   * DOCUMENT ME!
   *
   * @param digit DOCUMENT ME!
   */
  void sendDtmf(char digit) throws IOException;

  /**
   * DOCUMENT ME!
   *
   * @param digit DOCUMENT ME!
   * @param time DOCUMENT ME!
   */
  void sendDtmf(char digit, int time) throws IOException;

  /**
   * DOCUMENT ME!
   *
   * @param digits DOCUMENT ME!
   */
  void sendDtmf(String digits) throws IOException;

  /**
   * DOCUMENT ME!
   *
   * @param digits DOCUMENT ME!
   * @param time DOCUMENT ME!
   */
  void sendDtmf(String digits, int time) throws IOException;

  /**
   * DOCUMENT ME!
   *
   * @param text DOCUMENT ME!
   */
  void sendText(String text) throws IOException;

  /**
   * DOCUMENT ME!
   *
   * @param text DOCUMENT ME!
   * @param time DOCUMENT ME!
   */
  void sendText(String text, int time) throws IOException;

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  // TODO: REMOVE !!!
  //AgiCommand waitForCommand();
}
