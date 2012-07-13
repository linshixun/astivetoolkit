package com.phonytive.astive.examples.ws.test;

import com.phonytive.astive.examples.ws.Weather;
import com.phonytive.astive.examples.ws.WeatherAPI;
import junit.framework.TestCase;

/**
 *
 * @author psanders
 */
public class WeatherAPITest extends TestCase {

    private String zip;

    public WeatherAPITest(String testName) {
        super(testName);
        // Spring Valley, NY.
        zip = "10977";
    }

    public void testWeatherAPI() throws Exception {        
        Weather w  = WeatherAPI.getWeather(zip);
        String country = w.getCountry();
        String region = w.getRegion();
        String city = w.getCity();        
        
        assert(country.equals("US"));
        assert(region.equals("NY"));
        assert(city.equals("Spring Valley"));
    }
}
