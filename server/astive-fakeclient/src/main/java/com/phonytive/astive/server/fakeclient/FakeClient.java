package com.phonytive.astive.server.fakeclient;

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

import com.phonytive.astive.agi.DefaultAgiServerSettings;
import com.phonytive.astive.agi.AgiRequest;
import com.phonytive.astive.agi.HangupCause;
import com.phonytive.astive.agi.command.AgiCommand;
import com.phonytive.astive.agi.fastagi.FastAgiConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class FakeClient implements Client, DefaultAgiServerSettings {
    
    private FastAgiConnection client;
    private String host;
    private int port;
    private AgiRequest request;
    
    public FakeClient(AgiRequest request){
        this.host = DEFAULT_AGI_SERVER_BIND_ADDR;
        this.port = DEFAULT_AGI_SERVER_PORT;
        this.request = request;
    }        
    
    public FakeClient(String host, AgiRequest request){
        this.host = host;
        this.port = DEFAULT_AGI_SERVER_PORT;
        this.request = request;
    }    
    
    public FakeClient(String host, int port, AgiRequest request){
        this.host = host;
        this.port = port;
        this.request = request;
    }

    @Override
    public void call() {
        try {
            client = new FastAgiConnection(host, port);
            getWriter().write(request.toString());
            getWriter().flush();
        } catch (UnknownHostException ex) {
        } catch (IOException ex) {            
        }        
    }


    @Override
    public void hangup() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void hangup(HangupCause cause) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public AgiCommand waitForCommand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendDtmf(char digit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendDtmf(char digit, int time) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendDtmf(String digits) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendDtmf(String digits, int time) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private BufferedReader getReader() throws IOException {
        return client.getReader();
    }
    
    public PrintWriter getWriter() throws IOException {
        return client.getWriter();
    }

    @Override
    public void sendText(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendText(String text, int time) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
