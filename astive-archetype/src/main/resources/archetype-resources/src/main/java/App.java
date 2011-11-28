package ${packageName};

import com.phonytive.astive.api.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;

public class App implements Astivlet {

    public void onModuleLoad(AstivletRequest request, AstivletResponse response) {
        try {
            response.answer();
            response.streamFile("hello-world");
            response.hangup();
        } catch (AgiException ex) {
            // TODO: Do something intersting here !
        }
    }
}
