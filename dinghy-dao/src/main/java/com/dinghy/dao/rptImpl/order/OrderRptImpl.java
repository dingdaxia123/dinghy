package com.dinghy.dao.rptImpl.order;

import com.dinghy.dao.hibernate.Hibernate;
import com.dinghy.domain.order.Order;
import com.dinghy.domain.order.Refund;
import com.dinghy.domain.order.rpt.OrderRpt;
import org.springframework.stereotype.Service;

import java.util.Vector;

/**
 * Created by dinghy on 2017/11/13.
 */
@Service
public class OrderRptImpl extends Hibernate implements OrderRpt{
    @Override
    public void put(Object order) {
        getHibernateTemplate().saveOrUpdate(order);
    }

    @Override
    public Refund getRefund(String refundNumber) {
        Vector<Object> vector = new Vector<>();
        vector.add(refundNumber);
        String hql="from Refund r where r.refundNumber=?";
        return (Refund)getHibernateTemplate().find(hql, vector.toArray()).stream().findAny().orElse(null);
    }
}
