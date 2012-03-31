package ${packageName};

import com.phonytive.astive.server.*;
import com.phonytive.astive.astivlet.*;
import com.phonytive.astive.agi.*

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
