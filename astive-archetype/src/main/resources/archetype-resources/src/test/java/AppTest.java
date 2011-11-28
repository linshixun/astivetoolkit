package ${packageName};

import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>Unit test for simple App.</p>
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
        // TODO: Remove this
        //DefaultAgiServer server = new DefaultAgiServer();
        server.startup();
    }
}
