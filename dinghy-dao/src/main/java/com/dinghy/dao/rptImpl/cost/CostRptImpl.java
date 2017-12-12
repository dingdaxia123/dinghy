package com.dinghy.dao.rptImpl.cost;

import com.dinghy.dao.hibernate.Hibernate;
import com.dinghy.domain.cost.Cost;
import com.dinghy.domain.cost.rpt.CostRpt;
import org.springframework.stereotype.Service;




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


}
