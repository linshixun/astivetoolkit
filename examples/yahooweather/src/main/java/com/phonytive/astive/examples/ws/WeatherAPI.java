package com.phonytive.astive.examples.ws;

import java.io.InputStream;

/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class WeatherAPI {

    static public Weather getWeather(String zip) throws Exception {
        // Retrieve Data
        InputStream dataIn = new YahooRetriever().retrieve(zip);
        // Parse Data
        Weather weather = new YahooParser().parse(dataIn);
        
        return weather;
    }    
}
