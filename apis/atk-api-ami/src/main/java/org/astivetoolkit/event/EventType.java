/*
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.astivetoolkit.ami.event;


/**
 *
 * @since 1.1
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
