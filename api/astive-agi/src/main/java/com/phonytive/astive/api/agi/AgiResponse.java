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
package com.phonytive.astive.api.agi;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 * @see FastAgiResponse
 * @see AstivletResponse
 * @see AgiRequest
 */
public interface AgiResponse {
    /**
     * <p>Answers channel if not already in answer state.</p>
     *
     * @since 0.1
     */
    public void answer() throws AgiException;

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
     * @since 0.1
     */
    public int getChannelStatus() throws AgiException;

    /**
     * <p>Stream the given <file>, and receive DTMF data.</p>
     *
     * @param file the file to stream, must not include extension.
     * @return an String with the DTMF digits introduced by the user.
     * @since 0.1
     */
    public String getData(String file) throws AgiException;

    /**
     * <p>Stream the given file, and receive DTMF data.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param timeout is the timeout(in milliseconds) to wait for user input.
     * 0 means standard timeout value, with -1 the commands wait for ever.
     * @return an String with the DTMF digits introduced by the user.
     * @since 0.1
     */
    public String getData(String file, int timeout) throws AgiException;

    /**
     * <p>Stream the given file, and receive DTMF data.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param timeout is the timeout(in milliseconds) to wait for user input.
     * 0 means standard timeout value, with -1 the commands wait for ever.
     * @param maxDigits is max amount of digits that the user can enter.
     * @return an String with the DTMF digits introduced by the user.
     * @since 0.1
     */
    public String getData(String file, int timeout, int maxDigits)
        throws AgiException;

    /**
     * <p>Behaves similar to STREAM FILE but used with a timeout option.</p>
     *
     * @param file the file to stream, must not include extension.
     * @param escapeDigits contains the digits that the user is expected to
     * press.
     * @return the DTMF digit pressed or 0x0 if none was pressed.
     * @since 0.1
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
     * <p>Hangs up the current channel.</p>
     *
     * @since 0.1
     */
    public void hangup() throws AgiException;

    /**
     * <p>Receives a character of text on a channel.</p>
     *
     * @param timeout maximum time to wait for input in milliseconds
     * or 0 for infinite.
     * @return the decimal value of the character
     * if one is received, or 0x0 if the channel does not support text reception.
     * Returns -1 only on error/hangup.
     * @since 0.1
     */
    public char receiveChar(int timeout) throws AgiException;

    /**
     * <p>Receives a string of text on a channel.</p>
     *
     * @param timeout maximum time to wait for input in milliseconds
     * or 0 for infinite.
     * @return -1 for failure or 1 for success, and the string in parentheses.
     * @since 0.1
     */
    public String receiveText(int timeout) throws AgiException;

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
     * @since 0.1
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
     * @since 0.1
     */
    char recordFile(String file, String format, String escapeDigits,
        int timeout, int offset, boolean beep, int maxSilence)
        throws AgiException;

    /**
     * <p>Says the given character string.</p>
     *
     * @param text the text to say.
     * @since 0.1
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
     * @since 0.1
     */
    char sayAlpha(String text, String escapeDigits) throws AgiException;

    /**
     * <p>Say a given digit string.</p>
     *
     * @param text the text to say.
     * @since 0.1
     */
    void sayDigits(String text) throws AgiException;

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
     * @since 0.1
     */
    char sayDigits(String text, String escapeDigits) throws AgiException;

    void sayNumber(String text) throws AgiException;

    char sayNumber(String text, String escapeDigits) throws AgiException;

    /**
     * <p>Says the given character string with phonetics.</p>
     *
     * @param text the text to say.
     * @since 0.1
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
     * @since 0.1
     */
    char sayPhonetic(String text, String escapeDigits)
        throws AgiException;

    void sayDate(long time) throws AgiException;

    char sayDate(long time, String escapeDigits) throws AgiException;

    void sayTime(long time) throws AgiException;

    char sayTime(long time, String escapeDigits) throws AgiException;

    void sayDateTime(long time) throws AgiException;

    char sayDateTime(long time, String escapeDigits) throws AgiException;

    char sayDateTime(long time, String escapeDigits, String format)
        throws AgiException;

    char sayDateTime(long time, String escapeDigits, String format,
        String timezone) throws AgiException;

    void sendImage(String image) throws AgiException;

    void setContext(String context) throws AgiException;

    void setExtension(String extension) throws AgiException;

    void setPriority(String priority) throws AgiException;

    void musicOnHoldEnabled(boolean enable) throws AgiException;

    void musicOnHold(String musicClass) throws AgiException;

    void setAutoHangup(int time) throws AgiException;

    void setCallerId(String callerId) throws AgiException;

    public void streamFile(String file) throws AgiException;

    public char streamFile(String file, String escapeDigits)
        throws AgiException;

    public char streamFile(String file, String escapeDigits, int offset)
        throws AgiException;

    void controlStreamFile(String file) throws AgiException;

    char controlStreamFile(String file, String escapeDigits)
        throws AgiException;

    char controlStreamFile(String file, String escapeDigits, int offset)
        throws AgiException;

    char controlStreamFile(String file, String escapeDigits, int offset,
        String forwardDigit, String rewindDigit, String pauseDigit)
        throws AgiException;

    public char waitForDigit(int interDigitsTimeout) throws AgiException;

    void speechCreate() throws AgiException;

    void speechCreate(String engine) throws AgiException;

    void speechSet(String name, String value) throws AgiException;

    void speechLoadGrammar(String label, String path) throws AgiException;

    void speechActivateGrammar(String label) throws AgiException;

    void speechDeactivateGrammar(String label) throws AgiException;

    //SpeechRecognitionResult speechRecognize(String prompt, int timeout) throws AgiException;
    //SpeechRecognitionResult speechRecognize(String prompt, int timeout, int offset) throws AgiException, AgiSpeechException;
    public void gosub(String context, String extension, String priority)
        throws AgiException;

    public void gosub(String context, String extension, String priority,
        String... arguments) throws AgiException;
}
