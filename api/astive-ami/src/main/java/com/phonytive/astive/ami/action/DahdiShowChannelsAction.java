package com.phonytive.astive.ami.action;

public class DahdiShowChannelsAction extends ActionMessage {
    private String dahdiChannel;

    public DahdiShowChannelsAction() {
        super(ActionType.DAHDI_SHOW_CHANNELS);
    }

    public DahdiShowChannelsAction(String dahdiChannel) {
        super(ActionType.DAHDI_SHOW_CHANNELS);
        this.dahdiChannel = dahdiChannel;
    }

    public String getDahdiChannel() {
        return dahdiChannel;
    }

    public void setDahdiChannel(String dahdiChannel) {
        this.dahdiChannel = dahdiChannel;
    }
}
