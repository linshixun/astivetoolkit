/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonytive.astive.server.test;

import com.phonytive.astive.astivlet.AstivletRequest;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author psanders
 */
public class AstivletRequestTest extends TestCase {
    
    public AstivletRequestTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testRequest() {
        ArrayList<String> request = new ArrayList();
        request.add("agi_network: yes");
        request.add("agi_network_script: com.phonytive.astive.helloworld? name = Pedro Sanders & age =28");
        request.add("agi_request: agi://127.0.0.1/com.phonytive.astive.helloworld? name = Pedro Sanders & age =28");
        request.add("agi_channel: SIP/astive-00000002");
        request.add("agi_language: en");
        request.add("agi_type: SIP");
        request.add("agi_uniqueid: 1325988028.2");
        request.add("agi_callerid: astive");
        request.add("agi_calleridname: Astive Test");
        request.add("agi_callingpres: 0");
        request.add("agi_callingani2: 0");
        request.add("agi_callington: 0");
        request.add("agi_callingtns: 0");
        request.add("agi_dnid: 101");
        request.add("agi_rdnis: unknown");
        request.add("agi_context: astive-context");
        request.add("agi_extension: 101");
        request.add("agi_priority: 1");
        request.add("agi_enhanced: 0.0");
        request.add("agi_accountcode: ");
        request.add("");    
    
        AstivletRequest ar = new AstivletRequest(request, null);
        
        assert(ar.getAccountCode().equals(""));
        assert(ar.isNetwork() == true);
        assert(ar.isEnhanced() == false);
        assert(ar.getRequestURL().equals("agi://127.0.0.1/com.phonytive.astive.helloworld? name = Pedro Sanders & age =28"));
        assert(ar.getScript().equals("com.phonytive.astive.helloworld? name = Pedro Sanders & age =28"));
               
        assert(ar.getParameter("age").equals("28"));
        assert(ar.getParameter("name").equals("Pedro Sanders"));        
    }
}
