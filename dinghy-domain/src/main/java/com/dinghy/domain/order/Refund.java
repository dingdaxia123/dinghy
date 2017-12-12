package com.dinghy.domain.order;

import java.util.Date;

/**
 * Created by dinghy on 2017/11/22.
 */
public class Refund {

    private Long id;
    private String merCode;
    private String orderNumber;
    private String orderTime;//退款时间
    private String orderAmount;
    private String refundAmount;
    private String sign;
    private String remark;
    private String refundStatus;
    private String refundNumber;
    private String ip;
    private Date createTime = new Date();//存入时间

    public Refund() {
    }

    public Refund(String merCode, String orderNumber, String orderTime, String orderAmount,
                  String sign, String ip, String refundAmount, String remark, String refundStatus,
                  String refundNumber) {
        this.merCode = merCode;
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.orderAmount = orderAmount;
        this.sign = sign;
        this.ip = ip;
        this.refundAmount = refundAmount;
        this.remark = remark;
        this.refundStatus = refundStatus;
        this.refundNumber = refundNumber;
    }

    public String getMerCode() {
        return merCode;
    }

    public void setMerCode(String merCode) {
        this.merCode = merCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundNumber() {
        return refundNumber;
    }

    public void setRefundNumber(String refundNumber) {
        this.refundNumber = refundNumber;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
