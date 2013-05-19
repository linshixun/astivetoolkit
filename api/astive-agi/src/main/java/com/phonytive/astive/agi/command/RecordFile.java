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
import com.phonytive.astive.agi.annotation.BooleanChoose;
import com.phonytive.astive.agi.annotation.ParamConverter;
import com.phonytive.astive.agi.annotation.Parameter;

import java.io.Serializable;


/**
 * Record to a file until a given DTMF digit in the sequence is received. 
 * 
 * <p>Returns -1 on hangup or error.  The format will specify what kind of file 
 * will be recorded. The <code>timeout</code> is the maximum record time in milliseconds, or '-1'
 * for no timeout. <code>offset samples</code> is optional, and, if provided, will seek
 * to the offset without exceeding the end of the file. <code>silence</code> is the number
 * of seconds of silence allowed before the function returns despite the lack
 * of DTMF digits or reaching timeout. <code>silence</code> value must be preceded by
 * 's=' and is also optional.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "RECORD FILE")
public class RecordFile implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -7007752832292860291L;    

    /**
     * Audio to send to channel.
     */
    @Parameter(optional = false)
    private String file;
    
    /**
     * Format for the new audio.
     */
    @Parameter(position = 1, optional = false)
    private String format;

    /**
     * Can be use to the interrupt the audio recording.
     */    
    @Parameter(position = 2, optional = false)
    private String escapeDigits;

    /**
     * Maximum record time in milliseconds. Use -1 for no timeout.
     */
    @Parameter(position = 3, optional = false)
    private Integer timeout;

    /**
     * The offset samples to skip.
     */
    @Parameter(position = 4)
    private Integer offset;
    
    /**
     * Whether a beep should be played before recording.
     */
    @Parameter(position = 5)
    @ParamConverter
    @BooleanChoose(valueOnTrue = "BEEP", valueOnFalse = "")
    private Boolean beep;
    
    /**
     * The amount of silence (in seconds) to allow before returning despite the
     * lack of DTMF digits or reaching timeout.
     */
    @Parameter(position = 6, prefix = "s=")
    private Integer maxSilence;

    /**
     * Create a new RecordFile object.
     * 
     * @param file name for the new file.
     * @param format format for new file.
     */
    public RecordFile(String file, String format) {
        this.file = file;
        this.format = format;
        this.escapeDigits = "";
        this.timeout = -1;
    }

    /**
     * Create a new RecordFile object.
     * 
     * @param file file name.
     * @param format file format.
     * @param escapeDigits digits to interrupt the audio recording.
     */
    public RecordFile(String file, String format, String escapeDigits) {
        this.file = file;
        this.format = format;
        this.escapeDigits = escapeDigits;
        this.timeout = -1;
        this.offset = 0;
        this.beep = false;
        this.maxSilence = 0;
    }    
    
    /**
     * Create a new RecordFile object.
     * 
     * @param file file name.
     * @param format file format.
     * @param escapeDigits digits to interrupt the audio recording.
     * @param timeout maximum time(in seconds) to record this file.
     */
    public RecordFile(String file, String format, String escapeDigits, Integer timeout) {
        this.file = file;
        this.format = format;
        this.escapeDigits = escapeDigits;
        this.timeout = timeout;
        this.offset = 0;
        this.beep = false;
        this.maxSilence = 0;
    }

    /**
     * Create a new Record object.
     * 
     * @param file file name.
     * @param format file format.
     * @param escapeDigits digits to interrupt the audio recording.
     * @param timeout maximum time(in seconds) to record this file.
     * @param offset the offset samples to skip.
     * @param beep <code>true</code> if a beep should be played before recording.
     * @param maxSilence The amount of silence (in seconds) to allow before 
     * returning despite the lack of DTMF digits or reaching timeout.
     */
    public RecordFile(String file, String format, String escapeDigits,
        Integer timeout, Integer offset, Boolean beep, Integer maxSilence) {
        this.file = file;
        this.format = format;
        this.escapeDigits = escapeDigits;
        this.timeout = timeout;
        this.offset = offset;
        this.beep = beep;
        this.maxSilence = maxSilence;
    }

    /**
     * Return <code>true</code> if beep should be played before recording.
     * 
     * @return true for beep before recording, or false otherwise.
     */
    public boolean hasBeep() {
        return beep;
    }

    /**
     * Set whether or not a beep should be played before recording.
     * 
     * @param beep true to play beep before recording, or false for no beep.
     */
    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    /**
     * Get the digits used to interrupt the audio recording.
     *
     * @return digits used to interrupt the audio recording.
     */
    public String getEscapeDigits() {
        return escapeDigits;
    }

    /**
     * Set the digits to be use to interrupt the audio recording.
     *
     * @param escapeDigits digits to be use to interrupt the audio recording.
     */
    public void setEscapeDigits(String escapeDigits) {
        this.escapeDigits = escapeDigits;
    }

    /**
     * Get file name.
     * 
     * @return file name.
     */
    public String getFile() {
        return file;
    }

    /**
     * Set file name.
     * 
     * @param file file name.
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Get file format.
     * 
     * @return file format.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Set file format.
     * 
     * @param format file format.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Get the amount of silence (in seconds) to allow before returning despite the
     * lack of DTMF digits or reaching timeout.
     * 
     * @return max silence.
     */
    public Integer getMaxSilence() {
        return maxSilence;
    }

    /**
     * Set max silence.
     * 
     * @param maxSilence max silence.
     */     
    public void setMaxSilence(Integer maxSilence) {
        this.maxSilence = maxSilence;
    }

    /**
     * Get offset.
     * 
     * @return offset.
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Set offset.
     * 
     * @param offset offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Get timeout. Maximum time to record the new file.
     * 
     * @return timeout in seconds
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Set timeout(in seconds) to record the new file.
     * 
     * @param timeout time(in seconds) to record the new file.
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
