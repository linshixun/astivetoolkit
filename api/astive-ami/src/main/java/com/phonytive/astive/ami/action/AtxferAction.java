package com.phonytive.astive.ami.action;

public class AtxferAction extends ActionMessage {
    private String channel;
    private String exten;
    private String context;
    private int priority;

    public AtxferAction(String channel, String exten, String context,
        int priority) {
        super(ActionType.ATXFER);
        this.channel = channel;
        this.exten = exten;
        this.context = context;
        this.priority = priority;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getExten() {
        return exten;
    }

    public void setExten(String exten) {
        this.exten = exten;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
