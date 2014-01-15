/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.astivetoolkit.examples.ws;

import java.io.InputStream;

/**
 * Yahoo Weather example.
 *
 * @since 1.0.0
 */
public class WeatherAPI {

    public static Weather getWeather(String zip) throws Exception {
        // Retrieve Data
        InputStream dataIn = new YahooRetriever().retrieve(zip);

        // Parse Data
        Weather weather = new YahooParser().parse(dataIn);

        return weather;
    }
}
