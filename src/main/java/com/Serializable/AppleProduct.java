package com.Serializable;

import java.io.Serializable;

public class AppleProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    public String headphonePort;
    public String thunderboltPort;

    public String getHeadphonePort() {
        return headphonePort;
    }

    public void setHeadphonePort(String headphonePort) {
        this.headphonePort = headphonePort;
    }

    public String getThunderboltPort() {
        return thunderboltPort;
    }

    public void setThunderboltPort(String thunderboltPort) {
        this.thunderboltPort = thunderboltPort;
    }
}
