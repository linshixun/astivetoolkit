package com.phonytive.astive.ami.action;

public class DahdidNdOffAction extends ActionMessage {
    private String dahdiChannel;

    public DahdidNdOffAction(String dahdiChannel) {
        super(ActionType.DAHDID_ND_OFF);
        this.dahdiChannel = dahdiChannel;
    }

    public String getDahdiChannel() {
        return dahdiChannel;
    }

    public void setDahdiChannel(String dahdiChannel) {
        this.dahdiChannel = dahdiChannel;
    }
}
