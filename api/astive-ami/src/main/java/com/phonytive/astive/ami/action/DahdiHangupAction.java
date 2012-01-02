package com.phonytive.astive.ami.action;

public class DahdiHangupAction extends ActionMessage {
    private String dahdiChannel;

    public DahdiHangupAction(String dahdiChannel) {
        super(ActionType.DAHDI_HANGUP);
        this.dahdiChannel = dahdiChannel;
    }

    public String getDahdiChannel() {
        return dahdiChannel;
    }

    public void setDahdiChannel(String dahdiChannel) {
        this.dahdiChannel = dahdiChannel;
    }
}
