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
package com.phonytive.astive.examples.ws;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import org.apache.log4j.Logger;

/**
 * Yahoo Weather example.
 *
 * @since 1.0.0
 */
public class App extends Astivlet {
    private static final Logger LOG = Logger.getLogger(App.class);
    private int maxFail = 3;
    private String zip;
    private String enterZip = "enter-zip";
    private String invalidZipCode = "invalid-zip-code";
    private String pleaseWait = "please-wait";
    private String newZip = "new-zip";
    private String forZipcode = "for-zip-code";
    private String theHumidity = "the-humidity";
    private String theTemperature = "the-temp";

    @Override
    public void service(AstivletRequest request, AstivletResponse response) {
        try {
            response.answer();

            int failCount = 0;

            while (true) {
                // Wait three seconds in beetween digits
                zip = response.getData(enterZip, 3000, 5);
                // Wait ws response.
                response.streamFile(pleaseWait);

                if ((zip != null) && (zip.length() == 5)) {
                    // Invoking Yahoo Weather api.
                    Weather weather = WeatherAPI.getWeather(zip);

                    // For the zip code: ...
                    response.streamFile(forZipcode);
                    response.sayDigits(zip);
                    response.streamFile("silence/2");

                    // The temp is
                    response.streamFile(theTemperature);
                    response.sayDigits(weather.getTemp());
                    response.streamFile("silence/2");

                    // The humidity is                    
                    response.streamFile(theHumidity);
                    response.sayDigits(weather.getHumidity());
                    response.streamFile("silence/2");
                } else {
                    response.streamFile(invalidZipCode);
                    failCount++;

                    if (failCount == maxFail) {
                        break;
                    }

                    continue;
                }

                // The only available option is '1'                
                String answer = response.getData(newZip, 5000, 1);                                                       

                if (answer.equals("1")) {
                    failCount = 0;

                    continue;
                } else {
                    break;
                }
            }

            // Ends the call
            response.hangup();
        } catch (AgiException ex) {
            LOG.error(ex.getMessage());
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
    }
}
