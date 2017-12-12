package com.dinghy.domain.user.rpt;

import com.dinghy.domain.user.User;

import java.util.List;

/**
 * Created by dinghy on 2017/10/30.
 */
public interface UserRpt {
    void put(User user);

    User getUser(String name, String password);

    void delete(User user);

    List<User> findUser(String name);



}
