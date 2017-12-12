package com.dinghy.service.user;

import com.dinghy.domain.user.User;
import com.dinghy.domain.user.rpt.UserRpt;
import com.dinghy.domain.user.service.UserService;
import com.dinghy.domain.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dinghy on 2017/10/31.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRpt userRpt;

    @Override
    public void save(String name, String password) {
        if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)){
            User user = new User(name , password);
            userRpt.put(user);
        }else {
            System.out.println("有必填参数为空");
        }

    }

    @Override
    public User getUser(String name, String password) {
        if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)) {
            User user = userRpt.getUser(name, password);
            return user;
        }else {
            return null;
        }

    }
}
