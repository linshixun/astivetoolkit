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

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;


public class YahooParser {
    private static Logger log = Logger.getLogger(YahooParser.class);

    public Weather parse(InputStream inputStream) throws DocumentException  {
        Weather weather = new Weather();

        log.info("Creating XML Reader");
                
        SAXReader xmlReader = createXmlReader();
        Document doc = xmlReader.read(inputStream);
        
        log.info("Parsing XML Response");

        weather.setCity(doc.valueOf("/rss/channel/yweather:location/@city"));
        weather.setRegion(doc.valueOf("/rss/channel/yweather:location/@region"));
        weather.setCountry(doc.valueOf("/rss/channel/yweather:location/@country"));                
        weather.setCondition(doc.valueOf("/rss/channel/item/yweather:condition/@text"));
        weather.setTemp(doc.valueOf("/rss/channel/item/yweather:condition/@temp"));
        weather.setChill(doc.valueOf("/rss/channel/yweather:wind/@chill"));
        weather.setHumidity(doc.valueOf("/rss/channel/yweather:atmosphere/@humidity"));

        return weather;
    }

    private SAXReader createXmlReader() {
        Map<String, String> uris = new HashMap<String, String>();
        uris.put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0");

        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs(uris);

        SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);

        return xmlReader;
    }
}
