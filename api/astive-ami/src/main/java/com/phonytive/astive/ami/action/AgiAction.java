package com.phonytive.astive.ami.action;

public class AgiAction extends ActionMessage {
    private String channel;
    private String command;
    private String commandId;

    public AgiAction(String channel, String command) {
        super(ActionType.AGI);
        this.channel = channel;
        this.command = command;
    }

    public AgiAction(String channel, String command, String commandId) {
        super(ActionType.AGI);
        this.channel = channel;
        this.command = command;
        this.commandId = commandId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }
}
