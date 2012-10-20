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
    package com.phonytive.astive.agi.command;

import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.annotation.ParamConverter;
import com.phonytive.astive.agi.annotation.Parameter;
import com.phonytive.astive.agi.annotation.Separator;
import java.io.Serializable;


/**
 * Cause the channel to execute the specified dialplan subroutine, returning
 * to the dialplan with execution of a Return().
 *
 * @since 1.0.0
 */
@AgiCommand(command = "GOSUB")
public class GoSub implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 0x804d1554ba24fc6dL;

    /**
     * The context of the called subroutine.
     */
    @Parameter(optional = false)
    private String context;

    /**
     * The extension in the called context.
     */    
    @Parameter(position = 0x1, optional = false)
    private String extension;

    /**
     * The priority of the called extension.
     */    
    @Parameter(position = 0x2, optional = false)
    private String priority;

    /**
     * An optional list of arguments to be passed to the subroutine.
     */    
    @Parameter(position = 0x3)
    @ParamConverter
    @Separator
    private String[] arguments;

    /**
     * Create a new GoSub object.
     * 
     * @param context context of the called subroutine.
     * @param extension extension in the called context.
     * @param priority priority of the called extension.
     */
    public GoSub(String context, String extension, String priority) {
        this.context = context;
        this.extension = extension;
        this.priority = priority;
    }

    /**
     * Create a new GoSub object.
     * 
     * @param context context of the called subroutine.
     * @param extension extension in the called context.
     * @param priority priority of the called extension.
     * @param arguments optional list of arguments to be passed to the 
     * subroutine.
     */    
    public GoSub(String context, String extension, String priority,
        String... arguments) {
        this.context = context;
        this.extension = extension;
        this.priority = priority;
        this.arguments = arguments;
    }

    /**
     * Get context.
     * 
     * @return context.
     */
    public String getContext() {
        return context;
    }

    /**
     * Set context.
     * 
     * @param context context.
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * Get extension.
     * 
     * @return extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Set extension.
     * 
     * @param extension extension.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Get priority.
     * 
     * @return priority.
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Set priority.
     * 
     * @param priority priority.
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Get subroutine arguments.
     * 
     * @return subroutine arguments.
     */
    public String[] getArguments() {
        return arguments;
    }

    /**
     * Set subroutine arguments.
     * 
     * @param arguments subroutine arguments.
     */    
    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }
}
