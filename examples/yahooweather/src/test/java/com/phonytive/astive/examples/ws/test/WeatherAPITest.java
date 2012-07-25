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
package com.phonytive.astive.examples.ws.test;

import com.phonytive.astive.examples.ws.Weather;
import com.phonytive.astive.examples.ws.WeatherAPI;
import junit.framework.TestCase;

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
