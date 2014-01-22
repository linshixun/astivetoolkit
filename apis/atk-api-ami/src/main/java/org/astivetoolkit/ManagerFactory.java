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
package org.astivetoolkit.ami;

import java.io.IOException;

import java.net.Socket;

import org.astivetoolkit.ami.action.ActionMessage;
import org.astivetoolkit.ami.action.LoginAction;
import org.astivetoolkit.ami.action.LogoffAction;
import org.astivetoolkit.ami.action.ResponseMessage;
import org.astivetoolkit.util.AppLocale;

/**
 *
 * @since 1.1
 */
public class ManagerFactory {
  private static ManagerFactory INSTANCE = new ManagerFactory();

  private ManagerFactory() {
  }

  /**
   * DOCUMENT ME!
   *
   * @param host DOCUMENT ME!
   * @param userName DOCUMENT ME!
   * @param password DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Manager createManager(final String host, final String userName, final String password) {
    return createManager(host, Manager.DEFAULT_PORT, userName, password);
  }

  /**
   * DOCUMENT ME!
   *
   * @param host DOCUMENT ME!
   * @param port DOCUMENT ME!
   * @param userName DOCUMENT ME!
   * @param password DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Manager createManager(final String host, final int port, final String userName,
                               final String password) {
    return new Manager() {
        private MessageHandler handler;
        private Thread handlerT;
        private Socket connection;

        @Override
        public void login() throws AmiException {
          try {
            connection = new Socket(host, port);
          } catch (IOException ex) {
            throw new AmiException(AppLocale.getI18n("cantOpenAManagerSection"));
          }

          handler = new MessageHandler(this, connection);
          handlerT = new Thread(handler);
          handlerT.start();

          LoginAction login = new LoginAction(userName, password);

          ResponseMessage response = sendAction(login);

          if (response.getSubType().equals(ResponseStatus.ERROR)) {
            throw new AmiException(AppLocale.getI18n("unableToAuthenticatecant"));
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
            throw new AmiException(AppLocale.getI18n("thisManagerIsNotLoggedIntoAsterisk"));
          }
        }

        @Override
        public ResponseMessage sendAction(ActionMessage action)
                                   throws AmiException {
          if (handler == null) {
            throw new AmiException(AppLocale.getI18n("thisManagerIsNotLoggedIntoAsterisk"));
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

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static ManagerFactory getInstance() {
    return INSTANCE;
  }
}
