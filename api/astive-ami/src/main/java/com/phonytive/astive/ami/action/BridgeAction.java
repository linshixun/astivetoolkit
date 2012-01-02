package com.phonytive.astive.ami.action;

public class BridgeAction extends ActionMessage {
    private String channel1;
    private String channel2;
    private YesNo tone = YesNo.NO;

    public BridgeAction(String channel1, String channel2) {
        super(ActionType.BRIDGE);
        this.channel1 = channel1;
        this.channel2 = channel2;
    }

    public BridgeAction(String channel1, String channel2, YesNo tone) {
        super(ActionType.BRIDGE);
        this.channel1 = channel1;
        this.channel2 = channel2;
        this.tone = tone;
    }

    public String getChannel1() {
        return channel1;
    }

    public void setChannel1(String channel1) {
        this.channel1 = channel1;
    }

    public String getChannel2() {
        return channel2;
    }

    public void setChannel2(String channel2) {
        this.channel2 = channel2;
    }

    public YesNo getTone() {
        return tone;
    }

    public void setTone(YesNo tone) {
        this.tone = tone;
    }
}
