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
package com.phonytive.astive.server.utils;

import com.phonytive.astive.server.SystemException;
import com.phonytive.astive.util.AppLocale;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Properties;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public class ServicePropertiesImpl implements ServiceProperties {
    private boolean disabled;
    private int port;
    private int backlog;
    private InetAddress bindAddr;
    private InetAddress onlyFrom;
    private String server;
    private String serviceName;

    public ServicePropertiesImpl(Properties properties, String serviceName)
        throws SystemException {
        setDisabled((Boolean.valueOf(properties.get("disabled").toString())
                            .booleanValue()));
        setPort(Integer.valueOf(properties.get("port").toString()).intValue());
        setBacklog(Integer.valueOf(properties.get("threads").toString())
                          .intValue());

        try {
            setBindAddr(InetAddress.getByName(properties.get("bind").toString()));
        } catch (UnknownHostException ex) {
            throw new SystemException(AppLocale.getI18n("unknownHost",
                    new Object[] { properties.get("bind").toString() }));
        }

        try {
            setOnlyFrom(InetAddress.getByName(properties.get("only_from")
                                                        .toString()));
        } catch (UnknownHostException ex) {
            throw new SystemException(AppLocale.getI18n("unknownHost",
                    new Object[] { properties.get("only_from").toString() }));
        } catch (NullPointerException ex) {
        }

        setServer((String) properties.get("server"));
        setServiceName(serviceName);
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public int getBacklog() {
        return backlog;
    }

    @Override
    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    @Override
    public InetAddress getBindAddr() {
        return bindAddr;
    }

    @Override
    public void setBindAddr(InetAddress bindAddr) {
        this.bindAddr = bindAddr;
    }

    @Override
    public InetAddress getOnlyFrom() {
        return onlyFrom;
    }

    @Override
    public void setOnlyFrom(InetAddress onlyFrom) {
        this.onlyFrom = onlyFrom;
    }

    @Override
    public String getServer() {
        return server;
    }

    @Override
    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
