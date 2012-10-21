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

import com.phonytive.astive.AstiveException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.AstObj;
import java.io.File;
import junit.framework.TestCase;
import org.eclipse.jetty.toolchain.test.MavenTestingUtils;

/**
 *
 * @since 1.0.0
 */
public class AppObjTest extends TestCase {
  /**
   * Creates a new AppObjTest object.
   *
   * @param testName DOCUMENT ME!
   */
  public AppObjTest(String testName) {
    super(testName);
  }
  
  /**
   * DOCUMENT ME!
   *
   * @throws AstiveException DOCUMENT ME!
   */
  public void testAppObj() throws AstiveException {
    File file = MavenTestingUtils.getProjectFile("/src/test/resources/helloworld.jar");          
    AstObj astObj = new AstObj("helloworld.jar", file.getAbsolutePath());
    Astivlet ast = astObj.getAstivletByURLPattern("/examples/HelloWorld");
    assertNotNull(ast);
    
    ast = astObj.getAstivletByURLPattern("/wha?");
    assertNull(ast);
  }
}
