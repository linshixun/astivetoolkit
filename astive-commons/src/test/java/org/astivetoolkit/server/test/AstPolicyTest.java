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
package com.phonytive.astive.server.test;

import java.net.SocketPermission;
import com.phonytive.astive.server.security.AstPolicy;
import com.phonytive.astive.server.security.AstPolicyUtil;
import junit.framework.TestCase;

/**
 * This test attempts to validate the security manager implemented by {@link Service}
 * and the objects {@link AstPolicy} and {@link AstPolicyUtil}.
 *
 * @see AstPolicy
 * @see AstPolicyUtil
 * @since 1.0.0
 */
public class AstPolicyTest extends TestCase {
  /**
   * Create a new AstPolicyTest object with the name of the test.
   *
   * @param testName name of the test.
   */
  public AstPolicyTest(String testName) {
    super(testName);
  }

  /**
   * This test add a permission to the collection in {@link AstPolicy}, an
   * then check if that permission is avaliable using {@link AstPolicyUtil.hasPermission()}.
   */
  public void testAstPolicy() {
    AstPolicy ast = AstPolicy.getInstance();
    ast.addPermission(new SocketPermission("127.0.0.1:4444", AstPolicy.DEFAULT_ACTION));

    SocketPermission sp1 = new SocketPermission("127.0.0.1:4444", AstPolicy.DEFAULT_ACTION);
    SocketPermission sp2 = new SocketPermission("127.0.0.2:4444", AstPolicy.DEFAULT_ACTION);

    assertTrue(AstPolicyUtil.hasPermission(sp1));
    assertFalse(AstPolicyUtil.hasPermission(sp2));
  }
}
