package com.phonytive.astive.ami.action;

public class CommandAction extends ActionMessage {
    private String command;

    public CommandAction(String command) {
        super(ActionType.COMMAND);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
