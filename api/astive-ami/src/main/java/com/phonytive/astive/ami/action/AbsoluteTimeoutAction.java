package com.phonytive.astive.ami.action;

public class AbsoluteTimeoutAction extends ActionMessage {
    private String channel;
    private int timeout;

    public AbsoluteTimeoutAction(String channel, int timeout) {
        super(ActionType.ABSOLUTE_TIMEOUT);
        this.channel = channel;
        this.timeout = timeout;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
