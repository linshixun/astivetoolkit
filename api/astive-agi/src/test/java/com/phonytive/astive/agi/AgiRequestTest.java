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
package com.phonytive.astive.agi;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * DOCUMENT ME
 */
public class AgiRequestTest extends TestCase {
  /**
   * Create a new AgiRequestTest object with the name of the test.
   *
   * @param testName name of the test.
   */
  public AgiRequestTest(String testName) {
    super(testName);
  }

  /**
   * This test ensure that AgiRequest is parsing Asterisk request properly.
   *
   * @throws AgiException if missing a line thats part of the standard request.
   */
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

    assertTrue(ar.isNetwork());
    assertEquals(ar.getScript(), "/myAstivlet?ext=2");
    assertEquals(ar.getRequestURL(), "myAstivlet");
    assertEquals(ar.getChannel(), "SIP/John-00000002");
    assertEquals(ar.getLanguage(), "en");
    assertEquals(ar.getChannelType(), ChannelType.SIP);
    assertEquals(ar.getCallId(), "1325988028.2");
    assertEquals(ar.getCallerId(), "john");
    assertEquals(ar.getCallerIdName(), "John Doe");
    assertEquals(ar.getCallingPres(), 0x0);
    assertEquals(ar.getCallingAni2(), 0x0);
    assertEquals(ar.getCallingTon(), 0x0);
    assertEquals(ar.getCallingTns(), 0x0);
    assertEquals(ar.getDnId(), "101");
    assertEquals(ar.getRdNis(), "unknown");
    assertEquals(ar.getContext(), "my-context");
    assertEquals(ar.getExtension(), "101");
    assertEquals(ar.getPriority(), "1");
    assertFalse(ar.isEnhanced());
    assertNull(ar.getAccountCode());

    // TODO: Check parameters/arguments
  }
}
