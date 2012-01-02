package com.phonytive.astive.server.test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.phonytive.astive.server.SimpleAstiveServer;
import com.phonytive.astive.server.SystemException;
import java.io.IOException;
import junit.framework.TestCase;

/**
 *
 * @author psanders
 */
public class SimpleAstiveServerTest extends TestCase {

    public SimpleAstiveServerTest(String testName) {
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

    public void testSimpleAstiveServer() throws SystemException, IOException {
        // Creating a test astivlet
        MyAstivlet ma = new MyAstivlet();
        SimpleAstiveServer server = new SimpleAstiveServer(ma);
        // Starting the simple server
        server.start();
    }
}
