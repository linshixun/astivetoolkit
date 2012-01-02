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
public class RedirectAction extends ActionMessage {
    private String channel;
    private String exten;
    private String context;
    private int priority;
    private String extraChannel;
    private String extraExten;
    private String extraContext;
    private int extraPriority;

    public RedirectAction(String channel, String exten, int priority) {
        super(ActionType.REDIRECT);
        this.channel = channel;
        this.exten = exten;
        this.priority = priority;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getExten() {
        return exten;
    }

    public void setExten(String exten) {
        this.exten = exten;
    }

    public String getExtraChannel() {
        return extraChannel;
    }

    public void setExtraChannel(String extraChannel) {
        this.extraChannel = extraChannel;
    }

    public String getExtraContext() {
        return extraContext;
    }

    public void setExtraContext(String extraContext) {
        this.extraContext = extraContext;
    }

    public String getExtraExten() {
        return extraExten;
    }

    public void setExtraExten(String extraExten) {
        this.extraExten = extraExten;
    }

    public int getExtraPriority() {
        return extraPriority;
    }

    public void setExtraPriority(int extraPriority) {
        this.extraPriority = extraPriority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
