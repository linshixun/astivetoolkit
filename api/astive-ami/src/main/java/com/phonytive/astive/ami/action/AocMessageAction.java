package com.phonytive.astive.ami.action;


// TODO: To be implemented
public class AocMessageAction extends ActionMessage {
    private String channel;
    private String channelPrefix;
    private MsgType msgType;
    private ChargeType chargeType;

    public AocMessageAction() {
        super(ActionType.AOC_MESSAGE);
    }
}
