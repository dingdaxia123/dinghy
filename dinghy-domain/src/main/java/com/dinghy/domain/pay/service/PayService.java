package com.dinghy.domain.pay.service;

import com.dinghy.domain.order.Order;
import com.dinghy.domain.order.Refund;
import com.dinghy.domain.pay.entity.InquireResult;
import com.dinghy.domain.pay.entity.PayEntity;
import com.dinghy.domain.pay.entity.RefundEntity;

/**
 * Created by dinghy on 2017/11/8.
 */
public interface PayService {

    PayEntity pay(String amount);

    RefundEntity refund(String refundAmount, String orderNumber, String noticeUrl);

    void save(Object order);

    InquireResult InquirePay(String billNo);
}
