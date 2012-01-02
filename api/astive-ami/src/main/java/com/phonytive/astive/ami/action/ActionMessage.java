package com.phonytive.astive.ami.action;

import com.phonytive.astive.ami.Message;
import com.phonytive.astive.ami.MessageType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Date;


public abstract class ActionMessage extends Message {
    private ActionType action;
    private long actionId = -1;

    public ActionMessage(ActionType action) {
        super(MessageType.ACTION, action);
        this.action = action;
        // TODO: Ensure is unique
        this.actionId = (new Date()).getTime();
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public long getActionId() {
        return actionId;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        // Adding super class info
        b.append(super.toString());

        if (getActionId() != -1) {
            b.append("ActionID");
            b.append(SEPARATOR);
            b.append(getActionId());
            b.append("\n");
        }

        Method[] ms = this.getClass().getDeclaredMethods();

        for (int i = 0; i < ms.length; i++) {
            Method m = ms[i];

            // Ignore method getActionId in case is overwrited in a subclass
            // TODO: Use regex to findout wheter or not this method follow
            // the bean convention. Is better than use "startsWith"
            if ((m.getName().startsWith("get") || m.getName().startsWith("is")) &&
                    !m.getName().equals("getActionId")) {
                m.setAccessible(true);

                // Constructing the parameter name
                String k = m.getName().replaceAll("get", "");
                // Since ami sends headers with the x-y format we had
                // setters with the form getHea_der setHea_der, that way we
                // can subtitute the char '_' by a '-' transform the bean to
                // an string.
                k.replaceAll("_", "-");

                Object v = null;

                try {
                    v = m.invoke(this, new Object[] {  });
                } catch (IllegalAccessException ex) {
                } catch (IllegalArgumentException ex) {
                } catch (InvocationTargetException ex) {
                }

                if ((k != null) && !k.equals("")) {
                    b.append(k);
                    b.append(SEPARATOR);
                    b.append(v);
                    b.append("\n");
                }
            }
        }

        return b.toString();
    }

    // TODO: To be implemented
    private boolean meetsBeanConvection(String methodName) {
        return false;
    }
}
