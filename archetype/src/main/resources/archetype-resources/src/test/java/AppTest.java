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
package ${packageName};

import org.astivetoolkit.server.*;
import org.astivetoolkit.astivlet.*;
import org.astivetoolkit.agi.*

import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase {
    /**
     * <p>Create the test case</p>
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( AppTest.class );
    }

    /**
     * <p>Rigourous Test :-)</p>
     */
    public void testApp() throws IOException {
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
    }
}
