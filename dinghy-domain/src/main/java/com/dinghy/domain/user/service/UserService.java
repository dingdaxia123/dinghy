package com.dinghy.domain.user.service;

import com.dinghy.domain.user.User;

/**
 * Created by dinghy on 2017/10/31.
 */
public interface UserService {
    void save(String name , String password);

    User getUser(String name , String password);

}
