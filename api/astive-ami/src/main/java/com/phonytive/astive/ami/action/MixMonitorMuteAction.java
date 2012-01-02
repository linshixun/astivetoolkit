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
public class MixMonitorMuteAction extends ActionMessage {
    private String channel;
    private String direction;
    private String state;

    public MixMonitorMuteAction(String channel) {
        super(ActionType.MIX_MONITOR_MUTE);
    }

    public MixMonitorMuteAction(String channel, String direction) {
        super(ActionType.MIX_MONITOR_MUTE);
    }

    public MixMonitorMuteAction(String channel, String direction, String state) {
        super(ActionType.MIX_MONITOR_MUTE);
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
