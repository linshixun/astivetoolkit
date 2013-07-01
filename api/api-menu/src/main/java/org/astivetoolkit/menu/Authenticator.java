/*
 * Copyright (C) 2010-2013 by PhonyTive LLC (http://phonytive.com)
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
package org.astivetoolkit.menu;

/**
 * Allowed or denied access to client to enter restricted menus.
 *
 * @since 1.0.0
 */
public abstract class Authenticator {

    private boolean authenticated = false;
    private int maxAuth = 3;

    /**
     * Creates a new Authenticator object.
     */
    public Authenticator() {
    }

    /**
     * Use by {@link Menu} to obtain the maximum amount of authentication
     * attempts before call is close.
     *
     * @return max amount of authentication attempts before call is hangup.
     */
    public int getMaxAuth() {
        return maxAuth;
    }

    /**
     * Helps check whether client is authenticated or not.
     *
     * @return true if authentication was successful false otherwise.
     */
    public boolean isAuthenticated() {
        return authenticated;
    }

    /**
     * Force authentication to be true or false.
     *
     * @param authenticated set to true to allow client to enter restricted
     * menus, or false to denied access.
     */
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * Overwrites the default maximum attempts to authenticate.
     *
     * @param maxAuth new maximum attempts to authenticate.
     */
    public void setMaxAuth(int maxAuth) {
        this.maxAuth = maxAuth;
    }

    /**
     * Use by final implementation to set the variable
     * <code>authenticated</code> to true.
     */
    public abstract void signIn();

    /**
     * Set's the variable authenticated to false.
     */
    public void signOut() {
        setAuthenticated(false);
    }
}
