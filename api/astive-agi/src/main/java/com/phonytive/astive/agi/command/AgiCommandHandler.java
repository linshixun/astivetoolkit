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
package com.phonytive.astive.agi.command;

import com.phonytive.astive.agi.AgiCommandReply;
import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.AgiRequest;
import com.phonytive.astive.agi.Connection;
import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see AgiCommandFactory
 * @see AgiCommand
 */
public class AgiCommandHandler {
    private static final Logger logger = Logger.getLogger(AgiCommandHandler.class);
    private BufferedReader reader;
    private PrintWriter writer;
    private AgiRequest agiRequest;

    public AgiCommandHandler(Connection conn) throws AgiException {
        try {
            reader = conn.getReader();
            writer = conn.getWriter();
        } catch (IOException ex) {
            throw new AgiException(AppLocale.getI18n(
                    "unableToPerformIOWithAsterisk",
                    new Object[] { ex.getMessage() }));
        }
    }

    // Singleton
    public AgiRequest getAgiRequest() throws AgiException {
        if (agiRequest != null) {
            return agiRequest;
        }

        ArrayList<String> lines = new ArrayList();
        String line = null;

        try {
            while (!(line = reader.readLine()).equals("")) {
                lines.add(line);
            }
        } catch (IOException ex) {
            throw new AgiException(AppLocale.getI18n(
                    "unableToPerformIOWithAsterisk",
                    new Object[] { ex.getMessage() }));
        }

        return (agiRequest = new AgiRequest(lines));
    }

    public AgiCommandReply sendAgiCommand(AgiCommand command)
        throws AgiException {
        writer.println(command.buildCommand());
        writer.flush();
        return readAgiCommandReply();
    }

    private AgiCommandReply readAgiCommandReply() throws AgiException {
        AgiCommandReply reply;
        List<String> lines;
        String line = null;

        lines = new ArrayList<String>();

        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new AgiException(AppLocale.getI18n(
                    "theConnectionHasBeenClosed"));
        }

        if (line == null) {
            throw new AgiException();
        }

        if (line.startsWith("HANGUP")) {
            if (line.length() > 6) {
                line = line.substring(6);
            } else {
                return readAgiCommandReply();
            }
        }

        lines.add(line);

        if (line.startsWith(Integer.toString(
                        AgiCommandReply.SC_INVALID_COMMAND_SYNTAX))) {
            try {
                while ((line = reader.readLine()) != null) {
                    lines.add(line);

                    if (line.startsWith(Integer.toString(
                                    AgiCommandReply.SC_INVALID_COMMAND_SYNTAX))) {
                        break;
                    }
                }
            } catch (IOException ex) {
                throw new AgiException(AppLocale.getI18n(
                        "unableToReadReplyFromAsterisk"));
            }
        }

        reply = new AgiCommandReply(lines);

        // Special handling for gosub, see AJ-257
        if (reply.getStatus() == AgiCommandReply.SC_TRYING) {
            return readAgiCommandReply();
        } else {
            return reply;
        }
    }
}
