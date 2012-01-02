// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.ami;

import com.phonytive.astive.ami.event.ManagerEvent;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.Socket;

import java.util.ArrayList;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
class MessageHandler implements Runnable {
    private static final Logger logger = Logger.getLogger(MessageHandler.class);
    private final BufferedReader reader;
    private final PrintWriter writer;
    private final ResponseQuee responseQuee;
    private final Manager manager;
    private boolean threadDone = false;
    private final String protocolVersion;

    public MessageHandler(Manager manager, Socket client)
        throws AmiException {
        try {
            this.manager = manager;
            reader = new BufferedReader(new InputStreamReader(
                        client.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(
                        client.getOutputStream()));
            // Get manager version
            protocolVersion = reader.readLine();
            responseQuee = new ResponseQuee();
        } catch (IOException ex) {
            // send the msg
            throw new AmiException();
        }
    }

    public void sendMessage(Message msg) {
        getWriter().println(msg);
        getWriter().flush();
    }

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
                ManagerEvent event = ManagerEventFactory.getInstance()
                                                        .getEvent(manager, msg);
                manager.fireEvent(event);
            } else {
                // TODO: Unexpected messageType
                throw new AmiException(AppLocale.getI18n(
                        "unhandledResponsePacket"));
            }
        } catch (AmiException ex) {
            //
        }
    }

    @Override
    public void run() {
        while (!threadDone) {
            checkInPacket();
        }
    }

    public void done() {
        threadDone = true;
    }

    private BufferedReader getReader() {
        return reader;
    }

    private PrintWriter getWriter() {
        return writer;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }
}
