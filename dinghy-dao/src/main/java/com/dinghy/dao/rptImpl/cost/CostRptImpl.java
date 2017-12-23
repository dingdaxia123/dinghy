package com.dinghy.dao.rptImpl.cost;

import com.dinghy.dao.hibernate.Hibernate;
import com.dinghy.domain.cost.Cost;
import com.dinghy.domain.cost.rpt.CostRpt;
import com.dinghy.domain.user.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by dinghy on 2017/9/29.
 */


@Service
public class CostRptImpl extends Hibernate implements CostRpt {

//    @Resource(name = "sessionFactory")
//    public void setSessionFactoryOverride(SessionFactory sessionFactory)
//    {
//        super.setSessionFactory(sessionFactory);
//
//    }

    @Override
    public void put(Cost cost) {
        getHibernateTemplate().saveOrUpdate(cost);
    }

    @Override
    public List<Cost> findAll() {
        String hql="from Cost";
        return (List<Cost>)getHibernateTemplate().find(hql);
    }

    @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
    @Override
    public List<Cost> findByPage(final int page, final int pageSize) {
        /**
         * executeFind方法需要传入接口对象,该接口对象的doInHibernate方法会在执行时自动被Spring调用.
         * 并且doInHibernate方法的返回值将作为最终结果.
         */
        return (List<Cost>)getHibernateTemplate().executeFind(new HibernateCallback() {
            /**
             * doInHibernate方法类似于回调函数,实在executeFind方面里调用,该方法可以直接使用session,这个session
             * 由Spring负责管理,不需要我们创建和关闭
             */
            @Override
            public List<Object> doInHibernate(Session session) throws HibernateException, SQLException {
                String hql="from Cost";
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
        String hql="select count(*) from Cost";
        List<Object> list=(List<Object>)getHibernateTemplate().find(hql);
        System.out.println(list);
        //查出总行数
        int rows=Integer.valueOf(list.get(0).toString());
        System.out.println(4%2);
        //根据总行数算出页数
        if(rows%pageSize==0)
            return rows/pageSize;
        else
            return rows/pageSize+1;
    }

    @Override
    public Cost findById(Long id) {
        String hql="from Cost where id=?";
        List<Cost> list = (List<Cost>)getHibernateTemplate().find(hql,id);
        return list.isEmpty()?null:(Cost)list.get(0);
        //使用延迟加载方法实现
//        return getHibernateTemplate().load(Cost.class, id);
    }

    @Override
    public void update(Cost cost) {
        if(cost==null)
            return;
        getHibernateTemplate().update(cost);
    }

}
