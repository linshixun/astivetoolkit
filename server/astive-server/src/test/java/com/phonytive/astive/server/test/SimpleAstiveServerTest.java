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
