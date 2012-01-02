package com.phonytive.astive.ami;

import com.phonytive.astive.ami.action.ActionType;
import com.phonytive.astive.ami.event.EventType;
import com.phonytive.astive.ami.util.Utils;
import com.phonytive.astive.util.AppLocale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;


public class Message {
    public static final String SEPARATOR = ": ";
    private MessageType type;
    private Enum subType;
    private HashMap<String, String> params;
    private Pattern p = Pattern.compile("");

    public Message(ArrayList<String> lines) throws AmiException {
        String messageType = lines.get(0).split(SEPARATOR)[0];
        String messageSubType = lines.get(0).split(SEPARATOR)[1];
        type = Utils.getMessageType(messageType);

        if (type.equals(MessageType.ACTION)) {
            subType = Utils.getMessageType(messageSubType);
        } else if (type.equals(MessageType.EVENT)) {
            // Convert messageSubType as it come from Asterisk into
            // the enum(capitalize) with the dashes(_) before exec the valueOf
            subType = Utils.getEventType(messageSubType);
        } else if (type.equals(MessageType.RESPONSE)) {
            subType = Utils.getResponseStatus(messageSubType);
        } else {
            // TODO: Include a message with this exception
            throw new AmiException(AppLocale.getI18n("unknownActionType"));
        }

        params = new HashMap();

        for (int i = 1; i < lines.size(); i++) {
            String k = lines.get(i).split(SEPARATOR)[0];
            String v = lines.get(i).split(SEPARATOR)[1];
            params.put(k, v);
        }
    }

    public Message(MessageType type, Enum subType) {
        this.type = type;
        this.subType = subType;
        params = new HashMap();
    }

    public Message(MessageType type, Enum subType,
        HashMap<String, String> params) {
        this.type = type;
        this.subType = subType;
        this.params = params;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public String getParameter(String key) {
        return params.get(key);
    }

    public void addParameter(String key, String value) {
        params.put(key, value);
    }

    public ArrayList<String> getMessageLines() {
        ArrayList<String> lines = new ArrayList();
        // First line
        lines.add(getType() + SEPARATOR + getSubType());

        Iterator i = getParams().keySet().iterator();

        while (i.hasNext()) {
            String k = (String) i.next();
            String line = k + SEPARATOR + getParams().get(k);
            lines.add(line);
        }

        return lines;
    }

    public Enum getSubType() {
        return subType;
    }

    public void setSubType(Enum subType) {
        this.subType = subType;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        // Capitalize
        String messageType = Utils.getMessageType(type);
        String messageSubType = null;

        if (type.equals(MessageType.ACTION)) {
            ActionType aType = ActionType.valueOf(subType.toString());
            messageSubType = Utils.getActionType(aType);
        } else if (type.equals(MessageType.EVENT)) {
            EventType eType = EventType.valueOf(subType.toString());
            messageSubType = Utils.getEventType(eType);
        } else if (type.equals(MessageType.RESPONSE)) {
            ResponseStatus rType = ResponseStatus.valueOf(subType.toString());
            messageSubType = Utils.getResponseStatus(rType);
        } else {
            // Epic fail !
        }

        // Adding header #1
        b.append(messageType);
        b.append(SEPARATOR);
        b.append(messageSubType);
        b.append("\n");

        if (!getParams().isEmpty()) {
            Iterator i = getParams().keySet().iterator();

            while (i.hasNext()) {
                String k = (String) i.next();
                b.append(k);
                b.append(SEPARATOR);
                b.append(getParams().get(k));
                b.append("\n");
            }
        }

        return b.toString();
    }
}
