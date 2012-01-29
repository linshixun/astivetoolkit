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
package com.phonytive.astive.server.fakeclient;

import com.phonytive.astive.agi.AgiRequest;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    static public void main(String... args) throws IOException {
        ArrayList<String> request = new ArrayList();
        request.add("agi_network:yes");
        request.add("agi_network_script:agitdd");
        request.add("agi_request:agitdd");
        request.add("agi_channel:SIP/astive-00000002");
        request.add("agi_language:en");
        request.add("agi_type:SIP");
        request.add("agi_uniqueid:1325988028.2");
        request.add("agi_callerid:astive");
        request.add("agi_calleridname:Astive Test");
        request.add("agi_callingpres:0");
        request.add("agi_callingani2:0");
        request.add("agi_callington:0");
        request.add("agi_callingtns:0");
        request.add("agi_dnid:101");
        request.add("agi_rdnis:unknown");
        request.add("agi_context:astive-context");
        request.add("agi_extension:101");
        request.add("agi_priority:1");
        request.add("agi_enhanced:0.0");
        request.add("agi_accountcode:");
        request.add("\n");        

        FakeClient fc = new FakeClient("127.0.0.1", new AgiRequest(request));
        fc.call();
        /* TODO: FIX THIS !!
        // Wait for ANSWER command
        fc.waitForCommand();
        
        // STREAM FILE
        fc.waitForCommand();
        fc.sendDtmf(' ');
        
        // STREAM FILE
        fc.waitForCommand();
        fc.sendDtmf('1');

        // STREAM FILE
        fc.waitForCommand();
        fc.sendDtmf('#');

        // STREAM FILE
        fc.waitForCommand();
        fc.sendDtmf('*');

        // CONTROL STREAM FILE
        fc.waitForCommand();
        fc.sendDtmf('1');        

        // CHANNELSTATUS
        fc.waitForCommand();
        fc.sendChannelStatus(ChannelStatus.LINE_IS_UP);

        // GETDATA
        fc.waitForCommand();
        fc.sendDtmf("1532");

        // GETDATA
        fc.waitForCommand();
        fc.sendDtmf("2351");
        
        // HANGUP
        fc.waitForCommand();*/
    }
}
