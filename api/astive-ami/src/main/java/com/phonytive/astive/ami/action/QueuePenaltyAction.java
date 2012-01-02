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
public class QueuePenaltyAction extends ActionMessage {
    private String iface;
    private int penalty;
    private String queue;

    public QueuePenaltyAction(String iface, int penalty) {
        super(ActionType.QUEUE_PENALTY);
        this.iface = iface;
        this.penalty = penalty;
    }

    public String getInterface() {
        return iface;
    }

    public void setInterface(String iface) {
        this.iface = iface;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }
}
