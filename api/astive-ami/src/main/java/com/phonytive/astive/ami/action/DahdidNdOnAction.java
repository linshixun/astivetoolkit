package com.phonytive.astive.ami.action;

public class DahdidNdOnAction extends ActionMessage {
    private String dahdiChannel;

    public DahdidNdOnAction(String dahdiChannel) {
        super(ActionType.DAHDID_ND_ON);
        this.dahdiChannel = dahdiChannel;
    }

    public String getDahdiChannel() {
        return dahdiChannel;
    }

    public void setDahdiChannel(String dahdiChannel) {
        this.dahdiChannel = dahdiChannel;
    }
}
