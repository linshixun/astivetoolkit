/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://astive.phonytive.com
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

import com.phonytive.astive.agi.AgiRequest;
import com.phonytive.astive.agi.ChannelStatus;
import com.phonytive.astive.agi.DefaultAgiServerSettings;
import com.phonytive.astive.agi.HangupCause;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;

import java.io.IOException;

import java.net.UnknownHostException;

import java.util.Iterator;


/**
 *
 * @since 1.0.0
 */
public class FakeClient implements Client, DefaultAgiServerSettings {
    private AgiRequest request;
    private FastAgiConnection client;
    private String host;
    private int port;

    /**
     * Creates a new FakeClient object.
     *
     * @param request DOCUMENT ME!
     */
    public FakeClient(AgiRequest request) {
        this.host = DEFAULT_AGI_SERVER_BIND_ADDR;
        this.port = DEFAULT_AGI_SERVER_PORT;
        this.request = request;
    }

    /**
     * Creates a new FakeClient object.
     *
     * @param host DOCUMENT ME!
     * @param request DOCUMENT ME!
     */
    public FakeClient(String host, AgiRequest request) {
        this.host = host;
        this.port = DEFAULT_AGI_SERVER_PORT;
        this.request = request;
    }

    /**
     * Creates a new FakeClient object.
     *
     * @param host DOCUMENT ME!
     * @param port DOCUMENT ME!
     * @param request DOCUMENT ME!
     */
    public FakeClient(String host, int port, AgiRequest request) {
        this.host = host;
        this.port = port;
        this.request = request;
    }

    /**
     * DOCUMENT ME!
     */
    @Override
    public void call() {
        try {
            client = new FastAgiConnection(host, port);

            Iterator i = request.getLines().iterator();

            while (i.hasNext()) {
                String line = (String) i.next();
                write(line);
                System.out.println("line -> " + line);
            }
        } catch (UnknownHostException ex) {
        } catch (IOException ex) {
        }
    }

    /**
     * DOCUMENT ME!
     */
    @Override
    public void hangup() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * DOCUMENT ME!
     *
     * @param cause DOCUMENT ME!
     */
    @Override
    public void hangup(HangupCause cause) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * DOCUMENT ME!
     *
     * @param digit DOCUMENT ME!
     */
    @Override
    public void sendDtmf(char digit) throws IOException {
        write("" + digit);
    }

    /**
     * DOCUMENT ME!
     *
     * @param digit DOCUMENT ME!
     * @param time DOCUMENT ME!
     */
    @Override
    public void sendDtmf(char digit, int time) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * DOCUMENT ME!
     *
     * @param digits DOCUMENT ME!
     */
    @Override
    public void sendDtmf(String digits) throws IOException {
        write(digits);
    }

    /**
     * DOCUMENT ME!
     *
     * @param digits DOCUMENT ME!
     * @param time DOCUMENT ME!
     */
    @Override
    public void sendDtmf(String digits, int time) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * DOCUMENT ME!
     *
     * @param text DOCUMENT ME!
     */
    @Override
    public void sendText(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * DOCUMENT ME!
     *
     * @param text DOCUMENT ME!
     * @param time DOCUMENT ME!
     */
    @Override
    public void sendText(String text, int time) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */

    /* TODO: TO remove
    //    @Override
    //    public AgiCommand waitForCommand() {
        try {
            System.out.println("cmd = " + client.getReader().readLine());
            // Espero por comando
            // Lo codifico
            // De acuerdo al comando veo si regresar la respuesta de inmediato
            // o si esp
        } catch (IOException ex) {
        }
        return null;
    }*/
    private void write(String msg) throws IOException {
        client.write(msg);
    }

    @Override
    public void sendChannelStatus(ChannelStatus status)
        throws IOException {
        StringBuilder sb = new StringBuilder(status.getCode());
        write(sb.toString());
    }
}
