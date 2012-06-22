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
package com.phonytive.astive.agi;

import java.util.Date;
import java.util.TimeZone;


/**
 * API with all commands supported by the AGI protocol, since Asterisk version
 * 1.0.
 *
 * @since 1.0.0
 */
public interface AgiResponse {
    /**
     * Answers channel if not already in answer state.
     *
     * @since 1.0.0
     * @throws AgiException
     */
    void answer() throws AgiException;

    /**
     * <p></p>
     * @throws AgiException
     */
    void asyncAgiBreak() throws AgiException;

    /**
     * <p>Returns the status of the current channel.</p>
     *
     * Return values:
     *  0 - Channel is down and available.
     *  1 - Channel is down, but reserved.
     *  2 - Channel is off hook.
     *  3 - Digits (or equivalent) have been dialed.
     *  4 - Line is ringing.
     *  5 - Remote end is ringing.
     *  6 - Line is up.
     *  7 - Line is busy.
     * @since 1.0.0
     */
    ChannelStatus getChannelStatus() throws AgiException;

    /**
     * <p>Returns the status of the channel.</p>
     *
     * @param channel The channel to check
     *
     * Return values:
     *  0 - Channel is down and available.
     *  1 - Channel is down, but reserved.
     *  2 - Channel is off hook.
     *  3 - Digits (or equivalent) have been dialed.
     *  4 - Line is ringing.
     *  5 - Remote end is ringing.
     *  6 - Line is up.
     *  7 - Line is busy.
     * @since 1.0.0
     */
    ChannelStatus getChannelStatus(String channel) throws AgiException;

    /**
     * DOCUMENT ME!
     *
     * @param file DOCUMENT ME!
     *
     * @throws AgiException DOCUMENT ME!
     */
    void controlStreamFile(String file) throws AgiException;

    /**
     * DOCUMENT ME!
     *
     * @param file DOCUMENT ME!
     * @param escapeDigits DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws AgiException DOCUMENT ME!
     */
    char controlStreamFile(String file, String escapeDigits)
        throws AgiException;

    /**
     * DOCUMENT ME!
     *
     * @param file DOCUMENT ME!
     * @param escapeDigits DOCUMENT ME!
     * @param offset DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws AgiException DOCUMENT ME!
     */
    char controlStreamFile(String file, String escapeDigits, int offset)
        throws AgiException;

    /**
     * DOCUMENT ME!
     *
     * @param file DOCUMENT ME!
     * @param escapeDigits DOCUMENT ME!
     * @param offset DOCUMENT ME!
     * @param forwardDigit DOCUMENT ME!
     * @param rewindDigit DOCUMENT ME!
     * @param pauseDigit DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws AgiException DOCUMENT ME!
     */
    char controlStreamFile(String file, String escapeDigits, int offset,
        char forwardDigit, char rewindDigit, char pauseDigit)
        throws AgiException;

    /**
     *
     * @param family
     * @param key
     * @throws AgiException
     */
    void databaseDel(String family, String key) throws AgiException;

    /**
     *
     * @param family
     * @throws AgiException
     */
    void databaseDelTree(String family) throws AgiException;

    /**
     *
     * @param family
     * @param keyTree
     * @throws AgiException
     */
    void databaseDelTree(String family, String keyTree)
        throws AgiException;

    /**
     *
     * @param family
     * @param key
     * @return
     * @throws AgiException
     */
    String databaseGet(String family, String key) throws AgiException;

    /**
     *
     * @param family
     * @param key
     * @param value
     * @throws AgiException
     */
    void databasePut(String family, String key, String value)
        throws AgiException;

    /**
     *
     * @param application
     * @throws AgiException
     */
    void exec(String application) throws AgiException;

    /**
     *
     * @param application
     * @param args
     * @throws AgiException
     */
    void exec(String application, String... args) throws AgiException;

    /**
     * <p>Stream the given <file>, and receive DTMF data.</p>
     *
     * @param file the file to stream, must not include extension.
     * @return an String with the DTMF digits introduced by the user.
     * @since 1.0.0
     */
    String getData(String file) throws AgiException;

    /**
     * <p>Stream the given file, and receive DTMF data.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param timeout is the timeout(in milliseconds) to wait for user input.
     * 0 means standard timeout value, with -1 the commands wait for ever.
     * @return an String with the DTMF digits introduced by the user.
     * @since 1.0.0
     */
    String getData(String file, int timeout) throws AgiException;

    /**
     * <p>Stream the given file, and receive DTMF data.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param timeout is the timeout(in milliseconds) to wait for user input.
     * 0 means standard timeout value, with -1 the commands wait for ever.
     * @param maxDigits is max amount of digits that the user can enter.
     * @return an String with the DTMF digits introduced by the user.
     * @since 1.0.0
     */
    String getData(String file, int timeout, int maxDigits)
        throws AgiException;

    /**
     *
     * @param variable
     * @return
     * @throws AgiException
     */
    String getFullVariable(String variable) throws AgiException;

    /**
     *
     * @param variable
     * @return
     * @throws AgiException
     */
    String getFullVariable(String variable, String channel)
        throws AgiException;

    /**
     * <p>Behaves similar to STREAM FILE but used with a timeout option.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param escapeDigits contains the digits that the user is expected to
     * press.
     * @return the DTMF digit pressed or 0x0 if none was pressed.
     * @since 1.0.0
     */
    char getOption(String file, String escapeDigits) throws AgiException;

    /**
     * <p>Behaves similar to STREAM FILE but used with a timeout option.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param escapeDigits contains the digits that the user is expected to
     * press.
     * @param timeout the timeout in milliseconds to wait if none of the defined
     * esacpe digits was presses while streaming.
     * @return the DTMF digit pressed or 0x0 if none was pressed.
     * @since 0.2
     */
    char getOption(String file, String escapeDigits, int timeout)
        throws AgiException;

    /**
     *
     * @param variable
     * @return
     * @throws AgiException
     */
    String getVariable(String variable) throws AgiException;

    /**
     * DOCUMENT ME!
     *
     * @param context DOCUMENT ME!
     * @param extension DOCUMENT ME!
     * @param priority DOCUMENT ME!
     *
     * @throws AgiException DOCUMENT ME!
     */
    void gosub(String context, String extension, String priority)
        throws AgiException;

    /**
     * DOCUMENT ME!
     *
     * @param context DOCUMENT ME!
     * @param extension DOCUMENT ME!
     * @param priority DOCUMENT ME!
     *
     * @throws AgiException DOCUMENT ME!
     */
    void gosub(String context, String extension, String priority,
        String... arguments) throws AgiException;

    /**
     * <p>Hangs up the current channel.</p>
     *
     * @since 1.0.0
     */
    void hangup() throws AgiException;

    /**
     *
     * @throws AgiException
     */
    void noop() throws AgiException;

    /**
     * <p>Wait until receive a character of text on a channel.</p>
     *
     * @return the decimal value of the character
     * if one is received, or 0x0 if the channel does not support text reception.
     * Returns -1 only on error/hangup.
     * @since 1.0.0
     */
    char receiveChar() throws AgiException;

    /**
     * <p>Receives a character of text on a channel.</p>
     *
     * @param timeout maximum time to wait for input in milliseconds
     * or 0 for infinite.
     * @return the decimal value of the character
     * if one is received, or 0x0 if the channel does not support text reception.
     * Returns -1 only on error/hangup.
     * @since 1.0.0
     */
    char receiveChar(int timeout) throws AgiException;

    /**
     * <p> Wait until receive a string of text on a channel.</p>
     *
     * @return -1 for failure or 1 for success, and the string in parentheses.
     * @since 1.0.0
     */
    String receiveText() throws AgiException;

    /**
     * <p>Receives a string of text on a channel.</p>
     *
     * @param timeout maximum time to wait for input in milliseconds
     * or 0 for infinite.
     * @return -1 for failure or 1 for success, and the string in parentheses.
     * @since 1.0.0
     */
    String receiveText(int timeout) throws AgiException;

    void recordFile(String file, String format) throws AgiException;

    char recordFile(String file, String format, String escapeDigits)
        throws AgiException;

    /**
     * <p>Record to a file until a given dtmf digit in the sequence is received.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param format the format of the file to be recorded, for instance "wav".
     * @param escapeDigits contains the digits that allow the user to end
     * recording.
     * @param timeout the maximum record time in milliseconds, or -1 for no
     * timeout.
     * @return the DTMF digit pressed or 0x0 if none was pressed.
     * @since 1.0.0
     */
    char recordFile(String file, String format, String escapeDigits, int timeout)
        throws AgiException;

    /**
     * <p>Record to a file until a given dtmf digit in the sequence is received.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param format the format of the file to be recorded, for instance "wav".
     * @param escapeDigits contains the digits that allow the user to end
     * recording.
     * @param timeout the maximum record time in milliseconds, or -1 for no
     * timeout.
     * @param offset the offset samples to skip.
     * @param beep <code>true</code> if a beep should be played before
     * recording.
     * @param maxSilence The amount of silence (in seconds) to allow before
     * returning despite the lack of dtmf digits or reaching timeout.
     * @return the DTMF digit pressed or 0x0 if none was pressed.
     * @since 1.0.0
     */
    char recordFile(String file, String format, String escapeDigits,
        int timeout, int offset, boolean beep, int maxSilence)
        throws AgiException;

    /**
     * <p>Says the given character string.</p>
     *
     * @param text the text to say.
     * @since 1.0.0
     */
    void sayAlpha(String text) throws AgiException;

    /**
     * Says the given character string, returning early if any of the given DTMF
     * number are received on the channel.
     *
     * @param text the text to say.
     * @param escapeDigits a String containing the DTMF digits that allow the
     * user to escape.
     * @return 0x0 if playback completes without a digit being pressed,
     * or the DTMF numerical value of the digit if one was pressed or
     * -1 on error/hangup.
     * @since 1.0.0
     */
    char sayAlpha(String text, String escapeDigits) throws AgiException;

    void sayDate(Date date) throws AgiException;

    char sayDate(Date date, String escapeDigits) throws AgiException;

    void sayDatetime(Date datetime) throws AgiException;

    char sayDatetime(Date datetime, String escapeDigits)
        throws AgiException;

    char sayDatetime(Date datetime, String escapeDigits, String format)
        throws AgiException;

    char sayDatetime(Date datetime, String escapeDigits, String format,
        TimeZone timeZone) throws AgiException;

    /**
     * <p>Say a given digit string.</p>
     *
     * @param text the text to say.
     * @since 1.0.0
     */
    void sayDigits(String digits) throws AgiException;

    /**
     * <p>Say a given digit string returning early if any of the given DTMF
     * number are received on the channel.</p>
     *
     * @param text the text to say.
     * @param escapeDigits a String containing the DTMF digits that allow the
     * user to escape.
     * @return 0x0 if playback completes without a digit being pressed,
     * or the DTMF numerical value of the digit if one was pressed or
     * -1 on error/hangup.
     * @since 1.0.0
     */
    char sayDigits(String digits, String escapeDigits)
        throws AgiException;

    void sayNumber(int number) throws AgiException;

    char sayNumber(int number, String escapeDigits)
        throws AgiException;

    /**
     * <p>Says the given character string with phonetics.</p>
     *
     * @param text the text to say.
     * @since 1.0.0
     */
    void sayPhonetic(String text) throws AgiException;

    /**
     * <p>Says the given character string with phonetics, returning early if any of
     * the given DTMF number are received on the channel.</p>
     *
     * @param text the text to say.
     * @param escapeDigits a String containing the DTMF digits that allow the
     *                     user to escape.
     * @return the DTMF digit pressed or 0x0 if none was pressed.
     * @since 1.0.0
     */
    char sayPhonetic(String text, String escapeDigits)
        throws AgiException;

    void sayTime(Date time) throws AgiException;

    char sayTime(Date time, String escapeDigits) throws AgiException;

    void sendImage(String image) throws AgiException;

    void sendText(String text) throws AgiException;

    void setAutoHangup(int time) throws AgiException;

    void setCallerId(String callerId) throws AgiException;

    void setContext(String context) throws AgiException;

    void setExtension(String extension) throws AgiException;

    void musicOnHold(Boolean on) throws AgiException;

    void musicOnHold(Boolean on, String musicClass) throws AgiException;

    void setPriority(String priority) throws AgiException;

    void speechActivateGrammar(String name) throws AgiException;

    void speechCreate(String engine) throws AgiException;

    void speechDeactivateGrammar(String name) throws AgiException;

    void speechDestroy() throws AgiException;

    void speechLoadGrammar(String name, String path) throws AgiException;

    // TODO: Fix this !!!
    //SpeechRecognitionResult speechRecognize(String prompt, int timeout) throws AgiException;
    void speechSet(String name, String value) throws AgiException;

    void speechUnloadGrammar(String name) throws AgiException;

    void streamFile(String file) throws AgiException;

    char streamFile(String file, String escapeDigits) throws AgiException;

    char streamFile(String file, String escapeDigits, int offset)
        throws AgiException;

    void setTddMode(Boolean on) throws AgiException;

    void verbose(String message, int level) throws AgiException;

    char waitForDigit(int interDigitsTimeout) throws AgiException;
}
