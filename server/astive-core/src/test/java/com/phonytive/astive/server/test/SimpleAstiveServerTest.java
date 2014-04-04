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
package com.phonytive.astive.server.test;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import com.phonytive.astive.server.SimpleAstiveServer;
import com.phonytive.astive.server.SystemException;
import java.io.IOException;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 */
public class SimpleAstiveServerTest extends TestCase {  
  private static final Logger logger = Logger.getLogger(SimpleAstiveServer.class);
  {BasicConfigurator.configure();}  
  
  /**
   * Creates a new SimpleAstiveServerTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public SimpleAstiveServerTest(String testName) {
    super(testName);
  }

  /**
   * DOCUMENT ME!
   *
   * @throws Exception DOCUMENT ME!
   */
  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  /**
   * DOCUMENT ME!
   *
   * @throws Exception DOCUMENT ME!
   */
  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * DOCUMENT ME!
   *
   * @throws SystemException DOCUMENT ME!
   * @throws IOException DOCUMENT ME!
   */
  public void testSimpleAstiveServer() throws SystemException, IOException {
      
      
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    SimpleAstiveServer server = new SimpleAstiveServer(new Astivlet() {

                        @Override
                        public void service(AstivletRequest request, AstivletResponse response) {
                            try {                                
                                response.answer();
                                response.streamFile("hello-world");
                                response.hangup();
                            } catch (AgiException ex) {
                            }
                        }
                    });
                    server.start();
                } catch (SystemException ex) {                    
                } catch (IOException ex) {
                }
            }
        });
        t.start();

        ArrayList<String> request = new ArrayList();
        request.add("agi_network: yes");
        request.add("agi_network_script: com.phonytive.astive.helloworld");
        request.add("agi_request: agi://127.0.0.1/com.phonytive.astive.helloworld");
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
        
        try {
            Thread.sleep(12000);
        } catch (InterruptedException ex) {
        }
  }
}
