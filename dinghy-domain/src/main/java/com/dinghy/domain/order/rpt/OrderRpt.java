package com.dinghy.domain.order.rpt;

import com.dinghy.domain.order.Order;
import com.dinghy.domain.order.Refund;

/**
 * Created by dinghy on 2017/11/13.
 */
public interface OrderRpt {
    void put(Object order);

    Refund getRefund(String refundNumber);
}
