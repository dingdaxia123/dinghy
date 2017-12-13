package com.dinghy.service.user;

import com.dinghy.domain.user.User;
import com.dinghy.domain.user.UserResult;
import com.dinghy.domain.user.rpt.UserRpt;
import com.dinghy.domain.user.service.UserService;
import com.dinghy.domain.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dinghy on 2017/10/31.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRpt userRpt;

    @Override
    public String save(String name, String password) {
        if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)){
            List<User> userList = userRpt.findUser(name);
            if(userList.size() == 0 || userList == null){
                User user = new User(name, password);
                userRpt.put(user);
                return UserResult.Success.getText();
            }else {
                return UserResult.NameRepeat.getText();
            }
        }else {
            return UserResult.ParamNull.getText();
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


    public String deleteUser(String name, String password) {
        User user = userRpt.getUser(name, password);
        if (user == null) {
            return "error";
        }
        userRpt.delete(user);
        return "删除成功";
    }


    public List<User> findUser(String name) {

        if (name != null) {
            List<User> listUser = userRpt.findUser(name);

            return listUser;
        }

        return null;
    }


}
