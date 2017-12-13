package com.dinghy.domain.user;

/**
 * Created by dinghy on 2017/12/13.
 */
public enum UserResult {
    Success("注册成功"),
    NameRepeat("用户已存在"),
    ParamNull("名字或密码为空");

    private final String text;

    UserResult(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
