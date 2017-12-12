package com.dinghy.domain.user;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dinghy on 2017/10/30.
 */
public class User implements Serializable {
    private Long id;
    private String name;
    private String password;
    private Date createTime = new Date();
    private Level level=Level.ONE;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.level=getLevel();
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
