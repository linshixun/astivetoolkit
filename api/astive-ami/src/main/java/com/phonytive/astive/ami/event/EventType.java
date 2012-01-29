/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://www.phonytive.com/astive
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
package com.phonytive.astive.ami.event;

/**
 *
 * @since 1.0.0
 */
public enum EventType {ABSTRACT_AGENT,
  ABSTRACT_PARKED_CALL,
  ABSTRACT_QUEUE_MEMBER,
  AGENT_CALLBACK_LOGIN,
  AGENT_CALLBACK_LOGOFF,
  AGENT_CALLED,
  AGENT_COMPLETE,
  AGENT_CONNECT,
  AGENT_DUMP,
  AGENT_LOGIN,
  AGENT_LOGOFF,
  AGENTS_COMPLETE,
  AGENTS,
  ALARM_CLEAR,
  ALARM,
  CDR,
  CHANNEL,
  CONNECT,
  DBGET_RESPONSE,
  DIAL,
  DISCONNECT,
  DND_STATE,
  EXTENSION_STATUS,
  FAX_RECEIVED,
  HANGUP,
  HOLDED_CALL,
  HOLD,
  JOIN,
  LEAVE,
  LINK,
  LOGCHANNELEVENT,
  MANAGER,
  MEET_ME,
  MEET_ME_JOIN,
  MEET_ME_LEAVE,
  MEET_ME_STOP_TALKING,
  MEET_ME_TALKING,
  MESSAGE_WAITING,
  NEW_CALLER_ID,
  NEW_CHANNEL,
  NEW_EXTEN,
  NEW_STATE,
  ORIGINATE,
  ORIGINATE_FAILURE,
  ORIGINATE_SUCCESS,
  PARKED_CALL,
  PARKED_CALL_GIVE_UP,
  PARKED_CALLS_COMPLETE,
  PARKED_CALL_TIMEOUT,
  PEER_ENTRY,
  PEERLIST_COMPLETE,
  PEER_STATUS,
  QUEUE_ENTRY,
  QUEUE,
  QUEUE_MEMBER,
  QUEUE_MEMBER_PAUSED,
  QUEUE_MEMBER_REMOVED,
  QUEUE_MEMBER_STATUS,
  QUEUE_PARAMS,
  QUEUE_STATUS_COMPLETE,
  REGISTRY,
  RELOAD,
  RENAME,
  RESPONSE,
  SHUTDOWN,
  STATUS_COMPLETE,
  STATUS,
  UNHOLD,
  UNLINK,
  UNPARKED_CALL,
  USER,
  ZAP_SHOW_CHANNELS_COMPLETE,
  ZAP_SHOW_CHANNELS,
  UNKNOWN;
}
