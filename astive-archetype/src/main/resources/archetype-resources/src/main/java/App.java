package ${packageName};

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;

public class App extends Astivlet {

    public void service(AstivletRequest request, AstivletResponse response) {
        try {
            response.answer();
            response.streamFile("tt-monkeys");
            response.hangup();
        } catch (AgiException ex) {
            // TODO: Do something intersting here !
        }
    }
}
