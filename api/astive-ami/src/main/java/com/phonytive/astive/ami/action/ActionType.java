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
public enum ActionType {WAIT_EVENT,
    QUEUE_RESET,
    QUEUE_RELOAD,
    QUEUE_RULE,
    QUEUE_PENALTY,
    QUEUE_LOG,
    QUEUE_PAUSE,
    QUEUE_REMOVE,
    QUEUE_ADD,
    QUEUE_SUMMARY,
    QUEUE_STATUS,
    QUEUES,
    AGENT_LOGOFF,
    AGENTS,
    IAX_REGISTRY,
    IAX_NETSTATS,
    IAX_PEER_LIST,
    IAX_PEERS,
    DAHDI_RESTART,
    DAHDI_SHOW_CHANNELS,
    DAHDID_ND_OFF,
    DAHDID_ND_ON,
    DAHDI_DIAL_OFF_HOOK,
    DAHDI_HANGUP,
    DAHDI_TRANSFER,
    DATA_GET,
    SIP_NOTIFY,
    SIP_SHOW_REGISTRY,
    SIP_QUALIFY_PEER,
    SIP_SHOW_PEER,
    SIP_PEERS,
    VOICE_MAIL_USERS_LIST,
    PLAY_DTMF,
    SKINNY_SHOW_LINE,
    SKINNY_LINES,
    SKINNY_SHOW_DEVICE,
    SKINNY_DEVICES,
    MEETME_LIST,
    MEETME_UNMUTE,
    MEETME_MUTE,
    MIX_MONITOR_MUTE,
    UNPAUSE_MONITOR,
    PAUSE_MONITOR,
    CHANGE_MONITOR,
    STOP_MONITOR,
    MONITOR,
    AGI,
    AOC_MESSAGE,
    JABBER_SEND,
    DB_DEL_TREE,
    DB_DEL,
    DB_PUT,
    DB_GET,
    BRIDGE,
    PARK,
    PARKED_CALLS,
    SHOW_DIAL_PLAN,
    MODULE_CHECK,
    MODULE_LOAD,
    CORE_SHOW_CHANNELS,
    RELOAD,
    CORE_STATUS,
    CORE_SETTINGS,
    USER_EVENT,
    UPDATE_CONFIG,
    SEND_TEXT,
    LIST_COMMANDS,
    MAILBOX_COUNT,
    MAILBOX_STATUS,
    ABSOLUTE_TIMEOUT,
    EXTENSION_STATE,
    COMMAND,
    ORIGINATE,
    ATXFER,
    REDIRECT,
    LIST_CATEGORIES,
    CREATE_CONFIG,
    STATUS,
    GET_CONFIG_JSON,
    GET_CONFIG,
    GETVAR,
    SETVAR,
    PING,
    HANGUP,
    CHALLENGE,
    LOGIN,
    LOGOFF,
    LOCAL_OPTIMIZE_AWAY,
    EVENTS;
}
