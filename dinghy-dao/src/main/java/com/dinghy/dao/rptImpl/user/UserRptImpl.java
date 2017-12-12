package com.dinghy.dao.rptImpl.user;

import com.dinghy.dao.hibernate.Hibernate;
import com.dinghy.domain.user.User;
import com.dinghy.domain.user.rpt.UserRpt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dinghy on 2017/10/30.
 */
@Service
public class UserRptImpl extends Hibernate implements UserRpt{
    @Override
    public void put(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public User getUser(String name, String password) {
        List<User> list = (List<User>)getHibernateTemplate().find("from User t where t.name=? and password=?",name,password);
        return list.isEmpty()?null:(User)list.get(0);
    }
}
