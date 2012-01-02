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
package com.phonytive.astive.ami.action;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class OriginateAction extends ActionMessage {
    private String channel;
    private String exten;
    private String context;
    private int priority;
    private String application;
    private String data;
    private int timeout;
    private String callerId;
    private String variable;
    private String account;
    private String codecs;

    public OriginateAction(String channel) {
        super(ActionType.ORIGINATE);
    }

    public OriginateAction(String channel, String exten, String context,
        int priority) {
        super(ActionType.ORIGINATE);
        this.channel = channel;
        this.exten = exten;
        this.context = context;
        this.priority = priority;
    }

    public OriginateAction(String channel, String application) {
        super(ActionType.ORIGINATE);
        this.application = application;
    }

    public OriginateAction(String channel, String application, String data) {
        super(ActionType.ORIGINATE);
        this.application = application;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCodecs() {
        return codecs;
    }

    public void setCodecs(String codecs) {
        this.codecs = codecs;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExten() {
        return exten;
    }

    public void setExten(String exten) {
        this.exten = exten;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
