package com.phonytive.astive.ami.action;

public class DahdiTransferAction extends ActionMessage {
    private String dahdiChannel;

    public DahdiTransferAction(String dahdiChannel) {
        super(ActionType.DAHDI_TRANSFER);
        this.dahdiChannel = dahdiChannel;
    }

    public String getDahdiChannel() {
        return dahdiChannel;
    }

    public void setDahdiChannel(String dahdiChannel) {
        this.dahdiChannel = dahdiChannel;
    }
}
