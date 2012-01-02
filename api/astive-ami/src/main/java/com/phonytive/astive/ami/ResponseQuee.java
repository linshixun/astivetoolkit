package com.phonytive.astive.ami;

import com.phonytive.astive.util.AppLocale;

import org.apache.log4j.Logger;

import java.util.HashMap;


public class ResponseQuee {
    private static final Logger logger = Logger.getLogger(ResponseQuee.class);
    private static HashMap<String, Message> responseQuee = new HashMap();

    public void pushMessage(String key, Message message) {
        logger.debug(AppLocale.getI18n("pushingMessageToQuee",
                new Object[] { key }));
        responseQuee.put(key, message);
    }

    public Message pullMessage(String key) throws AmiException {
        logger.debug(AppLocale.getI18n("pullingMessageFromQuee",
                new Object[] { key }));

        Message msg = responseQuee.get(key);
        responseQuee.remove(key);

        return msg;
    }

    public boolean messageExist(String key) {
        return responseQuee.containsKey(key);
    }

    public boolean isEmpty() {
        return responseQuee.isEmpty();
    }
}
