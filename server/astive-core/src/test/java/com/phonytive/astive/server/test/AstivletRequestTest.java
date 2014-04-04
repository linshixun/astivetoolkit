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
