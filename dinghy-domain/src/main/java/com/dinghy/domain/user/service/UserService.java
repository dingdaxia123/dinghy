package com.dinghy.domain.user.service;

import com.dinghy.domain.user.User;

import java.util.List;

/**
 * Created by dinghy on 2017/10/31.
 */
public interface UserService {
    String save(String name, String password);

    User getUser(String name, String password);

    String deleteUser(String name, String password);

    List<User> findUser(String name);


}
