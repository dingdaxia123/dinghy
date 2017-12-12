package com.dinghy.domain.user;

/**
 * Created by dinghy on 2017/10/30.
 */
public enum Level {
    ONE("一级"),
    TWO("二级"),
    THREE("三级");

    private final String text;

    Level(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
