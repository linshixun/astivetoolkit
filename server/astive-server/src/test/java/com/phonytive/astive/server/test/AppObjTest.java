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

import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.server.AstObj;
import com.phonytive.astive.server.AstiveException;
import static java.lang.System.out;
import junit.framework.TestCase;

/**
 *
 * @author psanders
 */
public class AppObjTest extends TestCase {
    
    public AppObjTest(String testName) {
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
        
    public void testAppObj() throws AstiveException {
        AstObj astObj = 
                new AstObj("helloworld-1.0.0-M1.jar","/home/psanders/Projects/PhonyTive"
                        + "/astive/examples/helloworld/target"
                            + "/helloworld-1.0.0-M1.jar");
        Astivlet ast = astObj.getAstivletByURLPattern("/examp2les2/2/HelloWorld3");
        
        out.println("ast = " + ast);
    }
}
