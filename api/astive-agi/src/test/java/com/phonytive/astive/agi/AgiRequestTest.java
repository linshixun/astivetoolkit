/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
 * http://astive.phonytive.com
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
package com.phonytive.astive.agi;


import java.util.ArrayList;
import junit.framework.TestCase;


public class AgiRequestTest extends TestCase {
    public AgiRequestTest(String testName) {
        super(testName);
    }

    public void testAgiRequest() throws AgiException {
        ArrayList<String> lines = new ArrayList();
        lines.add("agi_network:yes");
        lines.add("agi_network_script:/myAstivlet?ext=2");
        lines.add("agi_request:myAstivlet");
        lines.add("agi_channel:SIP/John-00000002");
        lines.add("agi_language:en");
        lines.add("agi_type:SIP");
        lines.add("agi_uniqueid:1325988028.2");
        lines.add("agi_callerid:john");
        lines.add("agi_calleridname:John Doe");
        lines.add("agi_callingpres:0");
        lines.add("agi_callingani2:0");
        lines.add("agi_callington:0");
        lines.add("agi_callingtns:0");
        lines.add("agi_dnid:101");
        lines.add("agi_rdnis:unknown");
        lines.add("agi_context:my-context");
        lines.add("agi_extension:101");
        lines.add("agi_priority:1");
        lines.add("agi_enhanced:0.0");
        lines.add("agi_accountcode:");        
        lines.add("agi_arg_1:John");
        lines.add("agi_arg_2:Doe");
        lines.add("agi_arg_3:101");
        lines.add("\n");

        AgiRequest ar = new AgiRequest(lines);

        assert(ar.isNetwork() == true);
        assert(ar.getScript().equals("/myAstivlet?ext=2"));
        assert(ar.getRequestURL().equals("myAstivlet"));                
        assert(ar.getChannel().equals("SIP/John-00000002"));
        assert(ar.getLanguage().equals("en"));
        assert(ar.getChannelType() == ChannelType.SIP);
        assert(ar.getCallId().equals("1325988028.2"));
        assert(ar.getCallerId().equals("john"));
        assert(ar.getCallerIdName().equals("John Doe"));
        assert(ar.getCallingPres().intValue() == 0);
        assert(ar.getCallingAni2().intValue() == 0);
        assert(ar.getCallingTon().intValue() == 0);
        assert(ar.getCallingTns().intValue() == 0);
        assert(ar.getDnId().equals("101"));
        assert(ar.getRdNis().equals("unknown"));
        assert(ar.getContext().equals("my-context"));
        assert(ar.getExtension().equals("101"));
        assert(ar.getPriority().equals("1"));        
        assert(ar.isEnhanced() == false);
        assert(ar.getAccountCode() == null);
        // TODO: Check parameters/arguments
    }
}
