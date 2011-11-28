package com.phonytive.astive.api.agi;

import java.io.Serializable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see AgiResponse
 */
public class AgiRequest implements Serializable {
    private String network;
    private String networkScript;
    private String request;
    private String channel;
    private String language;
    private String type;
    private String uniqueId;
    private String version;
    private String callerId;
    private String callerIdName;
    private String callingPres;
    private String callingAni2;
    private String callingTon;
    private String callingTns;
    private String dnId;
    private String rdNis;
    private String context;
    private String extension;
    private String priority;
    private String enhanced;
    private String accountCode;
    private String threadId;
    private HashMap methodMap;
    private ArrayList<String> lines;

    public AgiRequest(ArrayList<String> lines) {
        this.lines = lines;
        methodMap = new HashMap();
        methodMap.put("agi_network", "setNetwork");
        methodMap.put("agi_network_script", "setNetworkScript");
        methodMap.put("agi_request", "setRequest");
        methodMap.put("agi_channel", "setChannel");
        methodMap.put("agi_language", "setLanguage");
        methodMap.put("agi_type", "setType");
        methodMap.put("agi_uniqueid", "setUniqueId");
        methodMap.put("agi_version", "setVersion");
        methodMap.put("agi_callerid", "setCallerId");
        methodMap.put("agi_calleridname", "setCallerIdName");
        methodMap.put("agi_callingpres", "setCallingPres");
        methodMap.put("agi_callingani2", "setCallingAni2");
        methodMap.put("agi_callington", "setCallingTon");
        methodMap.put("agi_callingtns", "setCallingTns");
        methodMap.put("agi_dnid", "setDnId");
        methodMap.put("agi_rdnis", "setRdNis");
        methodMap.put("agi_context", "setContext");
        methodMap.put("agi_extension", "setExtension");
        methodMap.put("agi_priority", "setPriority");
        methodMap.put("agi_enhanced", "setEnhanced");
        methodMap.put("agi_accountcode", "setAccountCode");
        methodMap.put("agi_threadid", "setThreadId");

        for (String line : lines) {
            if (line.split(":").length != 2) {
                continue;
            }

            String key = line.split(":")[0].trim();
            String value = line.split(":")[1].trim();
            setVar(key, value);
        }
    }

    // Looking inside de class. Reflection !
    private void setVar(String key, Object value) {
        Method m = null;

        try {
            m = AgiRequest.class.getMethod((String) methodMap.get(key),
                    String.class);
        } catch (NoSuchMethodException ex) {
        } catch (SecurityException ex) {
        }

        m.setAccessible(true);

        Object[] args = { value };

        try {
            m.invoke(this, args);
        } catch (IllegalAccessException ex) {
        } catch (IllegalArgumentException ex) {
        } catch (InvocationTargetException ex) {
        }
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        String str = "network = " + network;
        str += ("\nnetworkScript = " + networkScript);
        str += ("\nrequest = " + request);
        str += ("\nchannel = " + channel);
        str += ("\nlanguage = " + language);
        str += ("\ntype = " + type);
        str += ("\nuniqueId = " + uniqueId);
        str += ("\nversion = " + version);
        str += ("\ncallerId = " + callerId);
        str += ("\ncallerIdName = " + callerIdName);
        str += ("\ncallingPres = " + callingPres);
        str += ("\ncallingAni2 = " + callingAni2);
        str += ("\ncallingTns = " + callingTns);
        str += ("\ndnId = " + dnId);
        str += ("\nrdNis = " + rdNis);
        str += ("\ncontext = " + context);
        str += ("\nextension = " + extension);
        str += ("\npriority = " + priority);
        str += ("\nenhanced = " + callingTns);
        str += ("\naccountCode = " + accountCode);
        str += ("\nthreadId = " + threadId);

        return str;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNetworkScript() {
        return networkScript;
    }

    public void setNetworkScript(String networkScript) {
        this.networkScript = networkScript;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getCallerIdName() {
        return callerIdName;
    }

    public void setCallerIdName(String callerIdName) {
        this.callerIdName = callerIdName;
    }

    public String getCallingPres() {
        return callingPres;
    }

    public void setCallingPres(String callingPres) {
        this.callingPres = callingPres;
    }

    public String getCallingAni2() {
        return callingAni2;
    }

    public void setCallingAni2(String callingAni2) {
        this.callingAni2 = callingAni2;
    }

    public String getCallingTon() {
        return callingTon;
    }

    public void setCallingTon(String callingTon) {
        this.callingTon = callingTon;
    }

    public String getCallingTns() {
        return callingTns;
    }

    public void setCallingTns(String callingTns) {
        this.callingTns = callingTns;
    }

    public String getDnId() {
        return dnId;
    }

    public void setDnId(String dnId) {
        this.dnId = dnId;
    }

    public String getRdNis() {
        return rdNis;
    }

    public void setRdNis(String rdNis) {
        this.rdNis = rdNis;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getEnhanced() {
        return enhanced;
    }

    public void setEnhanced(String enhanced) {
        this.enhanced = enhanced;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public HashMap getMap() {
        return methodMap;
    }

    public void setMap(HashMap map) {
        this.methodMap = map;
    }
}
