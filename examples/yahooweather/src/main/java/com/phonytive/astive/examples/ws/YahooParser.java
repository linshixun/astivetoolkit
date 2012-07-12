package com.phonytive.astive.examples.ws;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class YahooParser {
    private static Logger log = Logger.getLogger(YahooParser.class);

    public Weather parse(InputStream inputStream) throws Exception {
        Weather weather = new Weather();

        log.info("Creating XML Reader");
        log.info("Parsing XML Response");
        
        SAXReader xmlReader = createXmlReader();
        Document doc = xmlReader.read(inputStream);
        
        System.out.println(doc.asXML());
                 
        Node location = doc.selectSingleNode("//rss/channel/yweather:location/");
        /*Node condition = doc.selectSingleNode("/rss/channel/item/yweather:condition/");
        Node wind = doc.selectSingleNode("/rss/channel/yweather:wind");
        Node atmosphere = doc.selectSingleNode("/rss/channel/yweather:atmosphere");

        weather.setCity(location.valueOf("@city"));
        weather.setRegion(location.valueOf("@region"));
        weather.setCountry(location.valueOf("@country"));                
        weather.setCondition(condition.valueOf("@text"));
        weather.setTemp(condition.valueOf("@temp"));        
        weather.setChill(wind.valueOf("@chill"));
        weather.setHumidity(atmosphere.valueOf("@humidity"));*/
        System.out.println(doc.valueOf("//rss/channel/yweather:location[@city]"));

        return weather;
    }

    private SAXReader createXmlReader() {
        Map<String, String> uris = new HashMap<String, String>();
        uris.put("p", "http://weather.yahooapis.com/forecastrss");

        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs(uris);

        SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);

        return xmlReader;
    }
}
