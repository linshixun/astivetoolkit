package com.phonytive.astive.examples.ws;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;


public class App extends Astivlet {
    private String zip;

    @Override
    public void service(AstivletRequest request, AstivletResponse response) {
        try {
            response.answer();

            // Enter your zipcode

            // Invalid zip code

            // Valid zip code

            // Wait until we process the information

            // Get weather

            // Wants to know the weather for another location?

            // Them
            response.hangup();
        } catch (AgiException ex) {
            // TODO: Do something intersting here !
        }
    }
}
