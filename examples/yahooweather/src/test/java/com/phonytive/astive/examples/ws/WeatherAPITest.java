package com.phonytive.astive.examples.ws;

import junit.framework.TestCase;

/**
 *
 * @author psanders
 */
public class WeatherAPITest extends TestCase {
    
    private String zip;
    
    public WeatherAPITest(String testName) {
        super(testName);
        zip = "10977";
    }
    
    public void testWeatherAPI() throws Exception {
        String city = WeatherAPI.getWeather("10977").getCity();
        System.out.println("city: " + city);
    }
}
