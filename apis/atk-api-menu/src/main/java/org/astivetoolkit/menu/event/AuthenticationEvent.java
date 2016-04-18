/* 
 * Copyright (C) 2010-2016 by Fonoster Inc (http://fonoster.com)
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
package org.astivetoolkit.menu.event;

import java.util.EventObject;
import org.astivetoolkit.menu.Authenticator;

/**
 * An AuthenticationEvent is trigger with each attempt to access a restricted
 * menu area.
 *
 * @since 1.0.0
 * @see AuthenticationListener
 */
public class AuthenticationEvent extends EventObject {

    private Authenticator authenticator;

    /**
     * Create a new AuthenticationEvent.
     *
     * @param source the object that originated the event.
     * @param authenticator contains the authenticator mechanism.
     */
    public AuthenticationEvent(final Object source, final Authenticator authenticator) {
        super(source);
        this.authenticator = authenticator;
        this.source = source;
    }

    /**
     * Returns the {@link Authenticator} mechanism.
     *
     * @return the authenticator object.
     */
    public Authenticator getAuthenticator() {
        return authenticator;
    }
}
