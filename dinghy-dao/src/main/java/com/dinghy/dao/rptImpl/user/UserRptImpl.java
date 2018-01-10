package com.dinghy.dao.rptImpl.user;

import com.dinghy.dao.hibernate.Hibernate;
import com.dinghy.domain.cost.Cost;
import com.dinghy.domain.user.User;
import com.dinghy.domain.user.rpt.UserRpt;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dinghy on 2017/10/30.
 */
@Service
public class UserRptImpl extends Hibernate implements UserRpt {
    @Override
    public void put(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public User getUser(String accountNumber, String password) {
        List<User> list = (List<User>) getHibernateTemplate().find("from User t where t.accountNumber=? and password=?", accountNumber, password);
        return list.isEmpty() ? null : (User) list.get(0);

    }

    @Override
    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }

    @Override
    public List<User> findUser(String name) {
        List<User> list = (List<User>) getHibernateTemplate().find("from User t where t.name=?", name);
//        getHibernateTemplate().find(user.getName(),list);
        return list;

    }
    @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
    @Override
    public List<User> findByPage(int page, int pageSize) {
        return (List<User>)getHibernateTemplate().executeFind(new HibernateCallback() {
            public List<Object> doInHibernate(Session session) throws HibernateException, SQLException {
                String hql="from User ";
                Query query=session.createQuery(hql);
                /**
                 * 设置分页参数，注意在内层函数中调用外层函数的参数，
                 * 要求外层函数的参数必须是final的，因此需要将
                 * page、pageSize设置为final。
                 */
                query.setFirstResult((page-1)*pageSize);
                query.setMaxResults(pageSize);
                return query.list();
            }
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public int findTotalPage(int pageSize) {
        String hql="select count(*) from User";
        List<Object> list=(List<Object>)getHibernateTemplate().find(hql);
//        System.out.println(list);
        //查出总行数
        int rows=Integer.valueOf(list.get(0).toString());
//        System.out.println(4%2);
        //根据总行数算出页数
        if(rows%pageSize==0)
            return rows/pageSize;
        else
            return rows/pageSize+1;
    }

}



