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
package com.phonytive.astive.server.utils;

import com.phonytive.astive.server.SystemException;
import com.phonytive.astive.util.AppLocale;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 *
 * @since 1.0.0
 */
public final class ServicePropertiesImpl implements ServiceProperties {

    private Properties properties;
    private InetAddress bindAddr;
    private InetAddress onlyFrom;
    private String server;
    private String serviceName;
    private boolean disabled;
    private boolean unableToOpen;
    private int backlog;
    private int port;    

    /**
     * Creates a new ServicePropertiesImpl object.
     *
     * @param properties DOCUMENT ME!
     * @param serviceName DOCUMENT ME!
     *
     * @throws SystemException DOCUMENT ME!
     */
    public ServicePropertiesImpl(Properties properties, String serviceName)
            throws SystemException {

        this.properties = properties;

        setDisabled(Boolean.parseBoolean(properties.get("disabled").toString().trim()));
        setPort(Integer.valueOf(properties.get("port").toString().trim()).intValue());
        setBacklog(Integer.valueOf(properties.get("threads").toString().trim()).intValue());

        try {
            setBindAddr(InetAddress.getByName(properties.get("bind").toString().trim()));
        } catch (UnknownHostException ex) {
            throw new SystemException(AppLocale.getI18n("unknownHost",
                    new Object[]{properties.get("bind").toString().trim()}));
        }

        try {
            setOnlyFrom(InetAddress.getByName(properties.get("onlyFrom").toString().trim()));
        } catch (UnknownHostException ex) {
            throw new SystemException(AppLocale.getI18n("unknownHost",
                    new Object[]{
                        properties.get("onlyFrom").toString().trim()
                    }));
        } catch (NullPointerException ex) {
        }

        setServer((String) properties.get("server"));
        setServiceName(serviceName);
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public int getBacklog() {
        return backlog;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public InetAddress getBindAddr() {
        return bindAddr;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public InetAddress getOnlyFrom() {
        return onlyFrom;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public int getPort() {
        return port;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public String getServer() {
        return server;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public String getServiceName() {
        return serviceName;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * DOCUMENT ME!
     *
     * @param backlog DOCUMENT ME!
     */
    @Override
    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    /**
     * DOCUMENT ME!
     *
     * @param bindAddr DOCUMENT ME!
     */
    @Override
    public void setBindAddr(InetAddress bindAddr) {
        this.bindAddr = bindAddr;
    }

    /**
     * DOCUMENT ME!
     *
     * @param disabled DOCUMENT ME!
     */
    @Override
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * DOCUMENT ME!
     *
     * @param onlyFrom DOCUMENT ME!
     */
    @Override
    public void setOnlyFrom(InetAddress onlyFrom) {
        this.onlyFrom = onlyFrom;
    }

    /**
     * DOCUMENT ME!
     *
     * @param port DOCUMENT ME!
     */
    @Override
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * DOCUMENT ME!
     *
     * @param server DOCUMENT ME!
     */
    @Override
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * DOCUMENT ME!
     *
     * @param serviceName DOCUMENT ME!
     */
    @Override
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String getPameter(String parameter) {
        try {
            return properties.get(parameter).toString().trim();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    @Override
    public boolean isUnableToOpen() {
        return unableToOpen;
    }

    @Override
    public void setUnableToOpen(boolean unableToOpen) {
        this.unableToOpen = unableToOpen;
    }        
}
