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
package org.astivetoolkit.agi;

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
   * @throws AgiException if the command can't be sent to Asterisk 
   * (for example because the channel has been hung up).
   */
  void answer() throws AgiException;

  /**   
   * Interrupts expected flow of Async AGI commands and returns control to 
   * previous source (typically, the PBX dialplan).
   * 
   * @throws AgiException
   */
  void asyncAgiBreak() throws AgiException;

  /**
   * Returns the status of the current channel.
   *
   * @param channel the channel to check
   * @return an enumerator with all possible channel status.
   * @see ChannelStatus
   */
  ChannelStatus getChannelStatus() throws AgiException;

  /**
   * Returns the status of the specified <code>channel</code>. If no channel 
   * name is given then returns the status of the current channel.
   *
   * @param channel the channel to check
   * @return an enumerator with all possible channel status.
   * @see ChannelStatus
   */
  ChannelStatus getChannelStatus(String channel) throws AgiException;  
  
  /**
   * Sends audio file on channel and allows the listener to control the stream.
   *
   * @param file the file extension must not be included in the filename.
   * @throws AgiException
   */
  void controlStreamFile(String file) throws AgiException;

  /**
   * Sends audio file on channel and allows the listener to control the stream.
   *
   * @param file the file extension must not be included in the filename.
   * @param escapeDigits allow users to finish stream.
   * @return the key press by the user
   * @throws AgiException
   */
  char controlStreamFile(String file, String escapeDigits)
                  throws AgiException;

  /**
   * Sends audio file on channel and allows the listener to control the stream.
   *
   * @param file the file extension must not be included in the filename.
   * @param escapeDigits allow users to finish stream.
   * @param offset silence time(in milliseconds) before play stream.
   * @return the key press by the user
   * @throws AgiException
   */
  char controlStreamFile(String file, String escapeDigits, int offset)
                  throws AgiException;

  /**
   * Sends audio file on channel and allows the listener to control the stream.
   * 
   * @param file the file extension must not be included in the filename.
   * @param escapeDigits allow users to finish stream.
   * @param offset silence time(in milliseconds) before play stream.   
   * @param forwardDigit allow user to move stream forward. (Defaults to *)
   * @param rewindDigit start over the stream. (Defaults to #)
   * @param pauseDigit allow user to stop stream.
   * @return the key press by the user
   * @throws AgiException
   */
  char controlStreamFile(String file, String escapeDigits, int offset, char forwardDigit,
                         char rewindDigit, char pauseDigit)
                  throws AgiException;

  /**
   * Deletes an entry in the Asterisk database for a given family and key.
   * 
   * @param family the database family.
   * @param key the key of entry to be remove.
   * @throws AgiException
   */
  void databaseDel(String family, String key) throws AgiException;

  /**
   * Deletes a family within a family in the Asterisk database
   * 
   * @param family the family.
   * @throws AgiException
   */
  void databaseDelTree(String family) throws AgiException;

  /**
   * Deletes a family or specific keytree within a family in the Asterisk database
   * 
   * @param family the family to be deleted.
   * @param keyTree the specific keytree for the family.
   * @throws AgiException
   */
  void databaseDelTree(String family, String keyTree) throws AgiException;

  /**
   * Retrieves an entry in the Asterisk database for a given family and key.
   * 
   * @param family the database family.
   * @param key the entry key.
   * @return a database value.
   * @throws AgiException
   */
  String databaseGet(String family, String key) throws AgiException;

  /**
   * Adds or updates an entry in the Asterisk database for a given family, key, 
   * and value.
   * 
   * @param family the database family.
   * @param key the entry key.
   * @param value the value for the parameter.
   * @throws AgiException
   */
  void databasePut(String family, String key, String value)
            throws AgiException;

  /**
   * Executes application without options.
   * 
   * @param application the application to be executed.
   * @throws AgiException
   */
  void exec(String application) throws AgiException;

  /**
   * Executes application with given options.
   * 
   * @param application the application to be executed.
   * @param args array of options needed by the application.
   * @throws AgiException
   */
  void exec(String application, String... args) throws AgiException;

  /**
   * Stream the given <code>file</code>, and receive DTMF data.
   *
   * @param file the file to stream must not include extension.
   * @return the digits received from the channel at the other end.
   */
  String getData(String file) throws AgiException;

  /**
   * Stream the given <code>file</code>, and receive DTMF data.
   *
   * @param file the file to stream, must not include extension.
   * @param timeout is the timeout(in milliseconds) to wait for user input.
   * 0 means standard timeout value, with -1 the commands wait for ever.
   * @return the digits received from the channel at the other end.
   */
  String getData(String file, int timeout) throws AgiException;

  /**
   * Stream the given <code>file</code>, and receive DTMF data.
   *
   * @param file the file to stream, must not include extension.
   * @param timeout is the timeout(in milliseconds) to wait for user input.
   * 0 means standard timeout value, with -1 the commands wait for ever.
   * @param maxDigits the maximum amount of digits that the user can enter.
   * @return the digits received from the channel at the other end.
   */
  String getData(String file, int timeout, int maxDigits)
          throws AgiException;

  /**
   * Evaluates a channel expression in the current <code>channel</code>.
   *
   * @param variable the variable must be set and channel exist.
   * @return the value of the variable.
   * @throws AgiException 
   */
  String getFullVariable(String variable) throws AgiException;

  /**
   * Evaluates a channel expression in the specified <code>channel</code>.
   * 
   * @param variable the variable to retrieve must be set and channel exist.
   * @param channel specific channel.
   * @return the value of variable.
   * @throws AgiException
   */
  String getFullVariable(String variable, String channel)
                  throws AgiException;

  /**
   * Behaves similar to STREAM FILE but used with a timeout option.
   *
   * @param file the file to stream, must not include extension.
   * @param escapeDigits contains the digits that the user is expected to
   * press.
   * @return the DTMF digit pressed or '0' if none was pressed.
   */
  char getOption(String file, String escapeDigits) throws AgiException;

  /**
   * Behaves similar to STREAM FILE but used with a timeout option.
   *
   * @param file the file to stream, must not include extension.
   * @param escapeDigits contains the digits that the user is expected to
   * press.
   * @param timeout the timeout in milliseconds to wait if none of the defined
   * escape digits was presses while streaming.
   * @return the DTMF digit pressed or '0' if none was pressed.
   */
  char getOption(String file, String escapeDigits, int timeout)
          throws AgiException;

  /**
   * Gets a channel variable.
   *
   * @param variable the variable set in the current channel.
   * @return the value of variable if was previously set.
   * @throws AgiException
   */
  String getVariable(String variable) throws AgiException;

  /**
   * Cause the channel to execute the specified dialplan subroutine, 
   * returning to the dialplan with execution of a Return().
   *
   * @param context context of the subroutine.
   * @param extension extension within context.
   * @param priority specific priority.   
   * @throws AgiException
   */
  void gosub(String context, String extension, String priority)
      throws AgiException;

  /**
   * Cause the channel to execute the specified dialplan subroutine, 
   * returning to the dialplan with execution of a Return().
   *
   * @param context context of the subroutine.
   * @param extension extension within context.
   * @param priority specific priority.
   * @param arguments optional arguments
   * @throws AgiException
   */
  void gosub(String context, String extension, String priority, String... arguments)
      throws AgiException;

  /**
   * Hangs up the current channel.
   */
  void hangup() throws AgiException;
  
  /**
   * Hangs up the specified channel.
   * 
   * @param chanel specific channel to hangup.
   */
  void hangup(String channel) throws AgiException;

  /**
   * Does nothing.
   * 
   * @throws AgiException
   */
  void noop() throws AgiException;  

  /**
   * Receives one character from channels supporting it.
   *
   * @return the character if one is received.
   * @throws AgiException if channel does not support this operation.
   */
  char receiveChar() throws AgiException;  

  /**
   * Receives one character from channels supporting it.
   *
   * @param timeout maximum time to wait for input in milliseconds or 0 for 
   * infinite.
   * @return the character if one is received.
   * @throws AgiException if channel does not support this operation.
   */
  char receiveChar(int timeout) throws AgiException;  
 
  /**
   * Receives a string of text on a channel. Most channels do not support the 
   * reception of text.
   *
   * @return the text receive by the channel.
   * @throws AgiException if channel does not support this operation.
   */
  String receiveText() throws AgiException;

  /**
   * Receives a string of text on a channel. Most channels do not support the 
   * reception of text.
   *
   * @param timeout maximum time to wait for input in milliseconds or 0 for 
   * infinite.
   * @return the text receive by the channel.
   * @throws AgiException if channel does not support this operation.
   */
  String receiveText(int timeout) throws AgiException;  
  
  void musicOnHold(boolean on) throws AgiException;

  void musicOnHold(boolean on, String musicClass) throws AgiException;

  /**
   * Record to a file until a given DTMF digit in the sequence is received.
   * 
   * @param file the file to stream, must not include extension.
   * @param format the format of the file to be recorded, for instance "wav".
   * @throws AgiException 
   */
  void recordFile(String file, String format) throws AgiException;

  /**
   * Record to a file until a given DTMF digit in the sequence is received.
   * 
   * @param file the file to stream, must not include extension.
   * @param format the format of the file to be recorded, for instance "wav".
   * @return the DTMF digit pressed or '0' if none was pressed.
   * @throws AgiException 
   */  
  char recordFile(String file, String format, String escapeDigits)
           throws AgiException;

  /**
   * Record to a file until a given DTMF digit in the sequence is received.
   *
   * @param file the file to stream, must not include extension.
   * @param format the format of the file to be recorded, for instance "wav".
   * @param escapeDigits contains the digits that allow the user to end
   * recording.
   * @param timeout the maximum record time in milliseconds, or -1 for no
   * timeout.
   * @return the DTMF digit pressed or '0' if none was pressed.
   * @throws AgiException
   */
  char recordFile(String file, String format, String escapeDigits, int timeout)
           throws AgiException;

  /**
   * Record to a file until a given DTMF digit in the sequence is received.
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
   * returning despite the lack of DTMF digits or reaching timeout.
   * @return the DTMF digit pressed or '0' if none was pressed.
   * @throws AgiException 
   */
  char recordFile(String file, String format, String escapeDigits, int timeout, int offset,
                  boolean beep, int maxSilence) throws AgiException;

  /**
   * Says the given character string.
   *
   * @param text the text to say.
   * @throws AgiException 
   */
  void sayAlpha(String text) throws AgiException;

  /**
   * Says the given character string, returning early if any of the given DTMF
   * number are received on the channel.
   *
   * @param text the text to say.
   * @param escapeDigits the string containing the DTMF digits that allow the
   * user to escape.
   * @return '0' if playback completes without a digit being pressed,
   * or the DTMF numerical value of the digit if one was pressed or
   * -1 on error/hangup.
   * @throws AgiException 
   */
  char sayAlpha(String text, String escapeDigits) throws AgiException;

  /**
   * Says the given date.
   * 
   * @param date the date to say
   * @throws AgiException 
   */
  void sayDate(Date date) throws AgiException;

  /**
   * Says the given date, returning early if any of the given DTMF number are 
   * received on the channel.
   * 
   * @param date the date to say.
   * @param escapeDigits the string containing the DTMF digits that allow the
   * user to escape.
   * @return '0' if playback completes without a digit being pressed,
   * or the DTMF numerical value of the digit if one was pressed or
   * -1 on error/hangup.
   * @throws AgiException 
   */
  char sayDate(Date date, String escapeDigits) throws AgiException;

  /**
   * 
   * @param datetime
   * @throws AgiException 
   */
  void sayDatetime(Date datetime) throws AgiException;

  /**
   * 
   * @param datetime
   * @param escapeDigits
   * @return
   * @throws AgiException 
   */
  char sayDatetime(Date datetime, String escapeDigits)
            throws AgiException;

  /**
   * 
   * @param datetime
   * @param escapeDigits
   * @param format
   * @return
   * @throws AgiException 
   */
  char sayDatetime(Date datetime, String escapeDigits, String format)
            throws AgiException;

  /*
   * 
   */
  char sayDatetime(Date datetime, String escapeDigits, String format, TimeZone timeZone)
            throws AgiException;

  /**
   * Say a given digit string.
   *
   * @param text the text to say.
   */
  void sayDigits(String digits) throws AgiException;

  /**
   * Say a given digit string returning early if any of the given DTMF
   * number are received on the channel.
   *
   * @param text the text to say.
   * @param escapeDigits a String containing the DTMF digits that allow the
   * user to escape.
   * @return '0' if playback completes without a digit being pressed,
   * or the DTMF numerical value of the digit if one was pressed or
   * -1 on error/hangup.
   * @throws AgiException
   */
  char sayDigits(String digits, String escapeDigits) throws AgiException;

  /**
   * 
   * @param number
   * @throws AgiException 
   */
  void sayNumber(int number) throws AgiException;

  /**
   * 
   * @param number
   * @param escapeDigits
   * @return
   * @throws AgiException 
   */
  char sayNumber(int number, String escapeDigits) throws AgiException;

  /**
   * Says the given character string with phonetics.
   *
   * @param text the text to say.
   */
  void sayPhonetic(String text) throws AgiException;

  /**
   * Says the given character string with phonetics, returning early if any of
   * the given DTMF number are received on the channel.
   *
   * @param text the text to say.
   * @param escapeDigits a String containing the DTMF digits that allow the
   *                     user to escape.
   * @return the DTMF digit pressed or 0x0 if none was pressed.
   */
  char sayPhonetic(String text, String escapeDigits) throws AgiException;

  /**
   * 
   * @param time
   * @throws AgiException 
   */
  void sayTime(Date time) throws AgiException;

  /**
   *    
   * @param time
   * @param escapeDigits
   * @return
   * @throws AgiException 
   */
  char sayTime(Date time, String escapeDigits) throws AgiException;
  
  void sendImage(String image) throws AgiException;

  void sendText(String text) throws AgiException;

  void setAutoHangup(int time) throws AgiException;

  void setCallerId(String callerId) throws AgiException;

  void setContext(String context) throws AgiException;

  void setExtension(String extension) throws AgiException;

  void setPriority(String priority) throws AgiException;

  void setTddMode(Boolean on) throws AgiException;

  void speechActivateGrammar(String name) throws AgiException;

  void speechCreate() throws AgiException;

  void speechCreate(String engine) throws AgiException;

  void speechDeactivateGrammar(String name) throws AgiException;

  void speechDestroy() throws AgiException;

  void speechLoadGrammar(String name, String path) throws AgiException;

  SpeechRecognitionResult speechRecognize(String prompt, int timeout)
                                   throws AgiException;

  void speechSet(String name, String value) throws AgiException;

  void speechUnloadGrammar(String name) throws AgiException;

  void streamFile(String file) throws AgiException;

  char streamFile(String file, String escapeDigits) throws AgiException;

  char streamFile(String file, String escapeDigits, int offset)
           throws AgiException;

  void verbose(String message, int level) throws AgiException;

  char waitForDigit(int interDigitsTimeout) throws AgiException;
  
  AgiCommandReply sendAgiCommand(String cmd) throws AgiException;
}
