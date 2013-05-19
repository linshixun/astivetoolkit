/* 
 * Copyright (C) 2010-2013 PhonyTive LLC
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
package com.phonytive.astive.agi.command;

import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.annotation.Parameter;

import java.io.Serializable;


/**
 * Stream the given <code>file</code>, and receive DTMF data.
 *
 * <p>Returns the digits received from the channel at the other end.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "GET DATA")
public class GetData implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -6316397364689291658L;

    /**
     * Default max digits.
     */
    private static final int DEFAULT_MAX_DIGITS = 1024;

    /**
     * Default max timeout.
     */
    private static final int DEFAULT_TIMEOUT = 0;

    /**
     * Audio to send to channel.
     */
    @Parameter(optional = false)
    private String file;

    /**
     * Time in milliseconds to wait for DTMF. If a digit is pressed the wait
     * time is reset. <p>With timeout set to -1 this command wait forever.
     */
    @Parameter(position = 1)
    private Integer timeout;

    /**
     * Max digits to enter.
     */
    @Parameter(position = 2)
    private Integer maxDigits;

    /**
     * Create a new GetData object with file as parameter.
     *
     * @param file audio to stream.
     */
    public GetData(String file) {
        this.file = file;
        this.timeout = DEFAULT_TIMEOUT;
        this.maxDigits = DEFAULT_MAX_DIGITS;
    }

    /**
     * Create a new GetData object with timeout.
     *
     * @param file audio to stream.
     * @param timeout time in milliseconds to wait for a new DTMF digit.
     */
    public GetData(String file, Integer timeout) {
        this.file = file;
        this.timeout = timeout;
        this.maxDigits = DEFAULT_MAX_DIGITS;
    }

    /**
     * Create a new GetData object with timeout and maxDigits.
     *
     * @param file audio to stream.
     * @param timeout time in milliseconds to wait for a new DTMF digit.
     * @param maxDigits maximum amount digits accepted.
     */
    public GetData(String file, Integer timeout, Integer maxDigits) {
        this.file = file;
        this.timeout = timeout;
        this.maxDigits = maxDigits;
    }

    /**
     * Get audio file.
     *
     * @return audio file.
     */
    public String getFile() {
        return file;
    }

    /**
     * Set audio file
     *
     * @param file audio file.
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Get maximum amount of digits.
     *
     * @return maximum amount of digits.
     */
    public Integer getMaxDigits() {
        return maxDigits;
    }

    /**
     * Set maximum amount of digits.
     *
     * @param maxDigits maximum amount of digits.
     */
    public void setMaxDigits(Integer maxDigits) {
        this.maxDigits = maxDigits;
    }

    /**
     * Get timeout(in milliseconds).
     *
     * @return time in milliseconds.
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Set timeout(in milliseconds).
     *
     * @param timeout time in milliseconds
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
