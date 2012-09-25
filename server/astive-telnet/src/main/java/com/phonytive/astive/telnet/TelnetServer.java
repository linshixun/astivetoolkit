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
package com.phonytive.astive.telnet;

import com.phonytive.astive.server.security.AstPolicy;
import com.phonytive.astive.server.security.AstPolicyUtil;
import com.phonytive.astive.util.AppLocale;
import com.phonytive.astive.util.NetUtil;
import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @since 1.0.0
 */
public abstract class TelnetServer extends ServerSocket implements Runnable {

    private static final Logger logger = Logger.getLogger(TelnetServer.class);
    private InetAddress bindAddr;
    private int backlog;
    private int port;
    private static String promptSymbol = ColorsANSI.BRIGHT + "[astive]$ " + ColorsANSI.SANE;

    public TelnetServer(int port, int backlog, InetAddress bindAddr) throws IOException {
        super();
        this.port = port;
        this.backlog = backlog;
        this.bindAddr = bindAddr;
    }
    
    public abstract void stop();
    public abstract List<String> lookup();
    public abstract String version();
    public abstract String system();    

    @Override
    public void run() {
        try {

            if (!NetUtil.available(port)) {
                throw new RuntimeException(AppLocale.getI18n("unableToOpenPort", new Object[]{port}));
            }            
            
            InetSocketAddress inet = new InetSocketAddress(bindAddr, port);
            bind(inet, backlog);

            while (true) {
                Socket client = accept();

                StringBuilder sbr = new StringBuilder();
                sbr.append(client.getInetAddress().getHostAddress());
                sbr.append(":");
                sbr.append(port);
                
                SocketPermission sp = new SocketPermission(sbr.toString(), 
                        AstPolicy.DEFAULT_ACTION);
                
                if(!AstPolicyUtil.hasPermission(sp)) {
                    client.close();
                    continue;
                }
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        client.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

                writer.println(AppLocale.getI18n("telnetIntro"));
                writer.println(AppLocale.getI18n("telnetHelp"));
                writer.print(promptSymbol);
                writer.flush();

                while (true) {

                    String commandStr = reader.readLine();

                    TelnetCommand command = TelnetCommand.get(commandStr);

                    if (command == null) {
                        writer.println(AppLocale.getI18n("telnetCommandNotFound"));
                        writer.print(promptSymbol);
                        writer.flush();
                        continue;
                    }

                    if (command.equals(TelnetCommand.STOP)) {
                        stop();
                        break;
                    }

                    if (command.equals(TelnetCommand.SYSTEM)) {
                        writer.println(AppLocale.getI18n("telnetCommandNotImpl"));
                        writer.print(promptSymbol);
                        writer.flush();
                        continue;
                    }

                    if (command.equals(TelnetCommand.HELP)) {
                        StringBuilder sb = new StringBuilder(" ");
                        sb.append("stop");
                        sb.append("\n");
                        sb.append(" ");
                        sb.append("system");
                        sb.append("\n");
                        sb.append(" ");
                        sb.append("help");
                        sb.append("\n");
                        sb.append(" ");
                        sb.append("lookup");
                        sb.append("\n");
                        sb.append(" ");
                        sb.append("exit");
                        sb.append("\n");
                        sb.append(" ");
                        sb.append("version");
                        writer.println(sb.toString());
                        writer.print(promptSymbol);
                        writer.flush();
                        continue;
                    }

                    if (command.equals(TelnetCommand.LOOKUP)) {
                        StringBuilder sb = new StringBuilder();
                        Iterator<String> i = lookup().iterator();
                        while (i.hasNext()) {
                            String appInfo = i.next();
                            sb.append(appInfo);
                            if (i.hasNext()) {
                                sb.append("\n");
                            }
                        }
                        // TODO: Print a message if is empty?
                        writer.println(sb.toString());
                        writer.print(promptSymbol);
                        writer.flush();
                        continue;
                    }

                    if (command.equals(TelnetCommand.EXIT)) {
                        client.close();
                        break;
                    }

                    if (command.equals(TelnetCommand.VERSION)) {
                        writer.println(version());
                        writer.print(promptSymbol);
                        writer.flush();
                        continue;
                    }
                }
            }
        } catch (IOException ex) {
            logger.error(AppLocale.getI18n("unableToPerformIOWithAdminDaemon",
                    new Object[]{ex.getMessage()}));
        }
    }    
    
}
