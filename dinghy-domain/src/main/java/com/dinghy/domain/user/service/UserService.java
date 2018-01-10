package com.dinghy.domain.user.service;

import com.dinghy.domain.user.User;

import java.util.List;

/**
 * Created by dinghy on 2017/10/31.
 */
public interface UserService {
    String save(String name, String password, String phone, String email, String accountNumber);

    User getUser(String accountNumber, String password);

    String deleteUser(String name, String password);

    List<User> findUser(String name);

    void updateUser(String name, String phone, String email, User user);

    void updatePwd(String password,User user);

    String addSave(String name, String password,String password1, String phone, String email, String accountNumber);



}
