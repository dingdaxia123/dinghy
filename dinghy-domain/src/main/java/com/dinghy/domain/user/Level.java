package com.dinghy.domain.user;

/**
 * Created by dinghy on 2017/10/30.
 */
public enum Level {
    ONE("用户"),
    TWO("Vip用户"),
    THREE("管理员");

    private final String text;

    Level(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }



}
