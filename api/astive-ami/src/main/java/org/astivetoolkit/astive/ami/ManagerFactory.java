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
package com.phonytive.astive.ami;

import java.io.IOException;
import java.net.Socket;
import com.phonytive.astive.ami.action.ActionMessage;
import com.phonytive.astive.ami.action.LoginAction;
import com.phonytive.astive.ami.action.LogoffAction;
import com.phonytive.astive.ami.action.ResponseMessage;
import com.phonytive.astive.util.AppLocale;

/**
 *
 * @since 1.0.0
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
