package com.dinghy.domain.user.server;

import com.dinghy.domain.user.User;

/**
 * Created by dinghy on 2017/10/31.
 */
public interface UserServer {
    void save(String name , String password);

    User getUser(String name , String password);

}
