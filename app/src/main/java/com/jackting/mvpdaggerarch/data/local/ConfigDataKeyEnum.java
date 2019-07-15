package com.jackting.mvpdaggerarch.data.local;

public enum  ConfigDataKeyEnum {
    USER_INFO("1","用户信息"),
    ;

    private String key;
    private String desc;

    ConfigDataKeyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
