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
package org.astivetoolkit.ami;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.astivetoolkit.ami.event.ManagerEvent;
import org.astivetoolkit.util.AppLocale;

/**
 *
 * @since 1.1
 */
class MessageHandler implements Runnable {
  private static final Logger logger = Logger.getLogger(MessageHandler.class);
  private final BufferedReader reader;
  private final Manager manager;
  private final PrintWriter writer;
  private final ResponseQuee responseQuee;
  private final String protocolVersion;
  private boolean threadDone = false;

  /**
   * Creates a new MessageHandler object.
   *
   * @param manager DOCUMENT ME!
   * @param client DOCUMENT ME!
   *
   * @throws AmiException DOCUMENT ME!
   */
  public MessageHandler(Manager manager, Socket client)
                 throws AmiException {
    try {
      this.manager = manager;
      reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
      writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
      // Get manager version
      protocolVersion = reader.readLine();
      responseQuee = new ResponseQuee();
    } catch (IOException ex) {
      // send the msg
      throw new AmiException();
    }
  }

  /**
   * DOCUMENT ME!
   */
  public void checkInPacket() {
    ArrayList<String> lines = new ArrayList();

    try {
      String s;

      while (!(s = getReader().readLine()).equals("")) {
        lines.add(s);
      }
    } catch (IOException ex) {
      // TODO: Report AmiException            
    }

    if (lines.isEmpty()) {
      return;
    }

    try {
      Message msg = new Message(lines);

      if (msg.getType().equals(MessageType.RESPONSE)) {
        // Pushing message into the response inbox
        System.out.println(msg);

        String actionId = msg.getParameter("ActionID");

        synchronized (responseQuee) {
          responseQuee.pushMessage(actionId, msg);
          // Notify the method getMessage that this object is available
          responseQuee.notify();
        }
      } else if (msg.getType().equals(MessageType.EVENT)) {
        // Dispatching events to the manager
        // TODO: Think about the manager as event source?
        ManagerEvent event = ManagerEventFactory.getInstance().getEvent(manager, msg);
        manager.fireEvent(event);
      } else {
        // TODO: Unexpected messageType
        throw new AmiException(AppLocale.getI18n("unhandledResponsePacket"));
      }
    } catch (AmiException ex) {
      //
    }
  }

  /**
   * DOCUMENT ME!
   */
  public void done() {
    threadDone = true;
  }

  /**
   * DOCUMENT ME!
   *
   * @param actionId DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws AmiException DOCUMENT ME!
   */
  public Message getMessage(long actionId) throws AmiException {
    synchronized (responseQuee) {
      while (!responseQuee.messageExist("" + actionId)) {
        try {
          responseQuee.wait();
        } catch (InterruptedException ex) {
        }
      }
    }

    return responseQuee.pullMessage("" + actionId);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getProtocolVersion() {
    return protocolVersion;
  }

  private BufferedReader getReader() {
    return reader;
  }

  private PrintWriter getWriter() {
    return writer;
  }

  /**
   * DOCUMENT ME!
   */
  @Override
  public void run() {
    while (!threadDone) {
      checkInPacket();
    }
  }

  /**
   * DOCUMENT ME!
   *
   * @param msg DOCUMENT ME!
   */
  public void sendMessage(Message msg) {
    getWriter().println(msg);
    getWriter().flush();
  }
}
