package com.phonytive.astive.examples.handlingevents;

import com.phonytive.astive.server.SimpleAstiveServer;
import com.phonytive.astive.server.SystemException;
import java.io.IOException;

public class Main {

    static public void main(String... args) {
        try {
            SimpleAstiveServer server = new SimpleAstiveServer(new App());
            server.start();
        } catch (SystemException ex) {
        } catch (IOException ex) {                        
        }
    }
}
