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
package org.astivetoolkit.ami.action;


/**
 *
 * @since 1.1
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
