// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.ami;

import com.phonytive.astive.ami.action.ActionMessage;
import com.phonytive.astive.ami.action.LoginAction;
import com.phonytive.astive.ami.action.LogoffAction;
import com.phonytive.astive.ami.action.ResponseMessage;
import com.phonytive.astive.util.AppLocale;

import java.io.IOException;

import java.net.Socket;

/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class ManagerFactory {

    private static ManagerFactory INSTANCE = new ManagerFactory();

    private ManagerFactory() {
    }

    public static ManagerFactory getInstance() {
        return INSTANCE;
    }

    public Manager createManager(final String host, final String userName,
            final String password) {
        return createManager(host, Manager.DEFAULT_PORT, userName, password);
    }

    public Manager createManager(final String host, final int port,
            final String userName, final String password) {
        return new Manager() {

            private MessageHandler handler;
            private Thread handlerT;
            private Socket connection;

            @Override
            public void login() throws AmiException {
                try {
                    connection = new Socket(host, port);
                } catch (IOException ex) {
                    throw new AmiException(AppLocale.getI18n(
                            "cantOpenAManagerSection"));
                }

                handler = new MessageHandler(this, connection);
                handlerT = new Thread(handler);
                handlerT.start();

                LoginAction login = new LoginAction(userName, password);

                ResponseMessage response = sendAction(login);

                if (response.getSubType().equals(ResponseStatus.ERROR)) {
                    throw new AmiException(AppLocale.getI18n(
                            "unableToAuthenticatecant"));
                }
            }

            @Override
            public void logout() throws AmiException {
                LogoffAction logoff = new LogoffAction();
                sendAction(logoff);

                handler.done();

                try {
                    connection.close();
                } catch (IOException ex) {
                    throw new AmiException(AppLocale.getI18n(
                            "thisManagerIsNotLoggedIntoAsterisk"));
                }
            }

            @Override
            public ResponseMessage sendAction(ActionMessage action)
                    throws AmiException {
                if (handler == null) {
                    throw new AmiException(AppLocale.getI18n(
                            "thisManagerIsNotLoggedIntoAsterisk"));
                }
                handler.sendMessage(action);
                Message msg = handler.getMessage(action.getActionId());
                return new ResponseMessage(msg.getMessageLines());
            }

            @Override
            public String getVersion() {
                return handler.getProtocolVersion();
            }
        };
    }
}
