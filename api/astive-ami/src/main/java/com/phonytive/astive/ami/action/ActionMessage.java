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
package com.phonytive.astive.ami.action;

import com.phonytive.astive.ami.Message;
import com.phonytive.astive.ami.MessageType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Date;


/**
 *
 * @since 1.0.0
 */
public abstract class ActionMessage extends Message {
    private ActionType action;
    private long actionId = -1;

    /**
     * Creates a new ActionMessage object.
     *
     * @param action DOCUMENT ME!
     */
    public ActionMessage(ActionType action) {
        super(MessageType.ACTION, action);
        this.action = action;
        // TODO: Ensure is unique
        this.actionId = (new Date()).getTime();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public ActionType getAction() {
        return action;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public long getActionId() {
        return actionId;
    }

    // TODO: To be implemented
    private boolean meetsBeanConvection(String methodName) {
        return false;
    }

    /**
     * DOCUMENT ME!
     *
     * @param action DOCUMENT ME!
     */
    public void setAction(ActionType action) {
        this.action = action;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
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
}
