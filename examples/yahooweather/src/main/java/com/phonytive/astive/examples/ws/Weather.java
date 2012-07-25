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


/**
 *
 * @since 1.0.0
 */
public class Weather {
    private String city;
    private String region;
    private String country;
    private String condition;
    private String temp;
    private String chill;
    private String humidity;

    public Weather() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("weather info:");
        sb.append("country: ");
        sb.append(getCountry());
        sb.append("\n");
        sb.append("city: ");
        sb.append(getCity());
        sb.append("\n");        
        sb.append("region: ");
        sb.append(getRegion());
        sb.append("\n");
        sb.append("condition: ");
        sb.append(getCondition());
        sb.append("\n");        
        sb.append("chill: ");
        sb.append(getChill());
        sb.append("\n");        
        sb.append("temp: ");
        sb.append(getTemp());
        sb.append("\n");    
        sb.append("humidity: ");
        sb.append(getHumidity());
        sb.append("\n");    
        return sb.toString();
    }
}
