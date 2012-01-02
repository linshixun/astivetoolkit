package com.phonytive.astive.server.fakeclient;


import com.phonytive.astive.agi.HangupCause;
import com.phonytive.astive.agi.command.AgiCommand;

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

/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
interface Client {
    
    void call();
    
    void hangup();
    
    void hangup(HangupCause cause);
    
    AgiCommand waitForCommand();
    
    void sendDtmf(char digit);
    
    void sendDtmf(char digit, int time);
            
    void sendDtmf(String digits);
    
    void sendDtmf(String digits, int time);
    
    void sendText(String text);
    
    void sendText(String text, int time);
}
