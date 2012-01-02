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
public class ParkAction extends ActionMessage {
    private String channel;
    private String channel2;
    private long timeout;

    // TODO: Include this parameter
    //private ? parkinglot;
    public ParkAction(String channel, String channel2) {
        super(ActionType.PARK);
        this.channel = channel;
        this.channel2 = channel2;
    }

    public ParkAction(String channel, String channel2, long timeout) {
        super(ActionType.PARK);
        this.channel = channel;
        this.channel2 = channel2;
        this.timeout = timeout;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel2() {
        return channel2;
    }

    public void setChannel2(String channel2) {
        this.channel2 = channel2;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
