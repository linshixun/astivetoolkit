package com.phonytive.astive.ami.action;

public class HangupAction extends ActionMessage {
    private String channel;
    private int cause;

    public HangupAction(String channel) {
        super(ActionType.HANGUP);
        this.channel = channel;
    }

    public HangupAction(String channel, int cause) {
        super(ActionType.HANGUP);
        this.channel = channel;
        this.cause = cause;
    }

    public int getCause() {
        return cause;
    }

    public void setCause(int cause) {
        this.cause = cause;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
