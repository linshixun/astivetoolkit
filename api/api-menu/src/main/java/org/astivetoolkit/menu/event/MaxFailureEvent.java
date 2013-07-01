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
package org.astivetoolkit.menu.event;

/**
 * A MaxFailerEvent is triggered when the maximum attempts to pick an menu
 * option is reached.
 *
 * @since 1.0.0
 * @see MaxFailureListener
 * @see DigitsEvent
 */
public class MaxFailureEvent extends DigitsEvent {

    private int maxFailure;

    /**
     * Create a new MaxFailureEvent object.
     *
     * @param source the object that originated the event.
     * @param digits the digits pressed.
     * @param maxFailure the maximum attempts admitted by the menu.
     */
    public MaxFailureEvent(final Object source, final String digits, final int maxFailure) {
        super(source, digits);
        this.maxFailure = maxFailure;
    }

    /**
     * Returns the amount(the maximum) of attempts.
     *
     * @return the maximum amount of attempts.
     */
    public int getMaxFailure() {
        return maxFailure;
    }
}
