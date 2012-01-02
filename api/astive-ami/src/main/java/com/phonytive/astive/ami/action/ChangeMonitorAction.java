package com.phonytive.astive.ami.action;

public class ChangeMonitorAction extends ActionMessage {
    private String channel;
    private String file;

    public ChangeMonitorAction(String channel, String file) {
        super(ActionType.CHANGE_MONITOR);
        this.channel = channel;
        this.file = file;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
