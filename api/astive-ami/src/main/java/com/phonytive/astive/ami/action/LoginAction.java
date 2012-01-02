package com.phonytive.astive.ami.action;

public class LoginAction extends ActionMessage {
    private String userName;
    private String secret;

    public LoginAction(String userName) {
        super(ActionType.LOGIN);
        this.userName = userName;
    }

    public LoginAction(String userName, String secret) {
        super(ActionType.LOGIN);
        this.userName = userName;
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
