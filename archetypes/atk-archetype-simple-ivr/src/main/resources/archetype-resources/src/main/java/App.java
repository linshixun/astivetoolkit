package ${packageName};

import org.astivetoolkit.agi.AgiException;
import org.astivetoolkit.astivlet.Astivlet;
import org.astivetoolkit.astivlet.AstivletRequest;
import org.astivetoolkit.astivlet.AstivletResponse;

public class App extends Astivlet {

    public void service(AstivletRequest request, AstivletResponse response) {
        try {
            response.answer();
            response.streamFile("tt-monkeys");
            response.hangup();
        } catch (AgiException ex) {
            // Do something intersting here !
        }
    }
}
