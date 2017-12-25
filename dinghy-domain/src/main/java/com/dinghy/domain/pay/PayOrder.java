package com.dinghy.domain.pay;

import java.util.Date;

/**
 * Created by dinghy on 2017/12/25.
 */
public class PayOrder {
    private Long id;
    private String merNo;
    private String merchantBillNo;
    private String systemBillNo;
    private String amount;
    private String returnURL;
    private String adviceURL;
    private Date orderTime;
    private String signInfo;
    private String remark;
    private Date createTime = new Date();

    public PayOrder() {
    }

    public PayOrder(String merNo, String merchantBillNo, String systemBillNo, String amount,
                    String returnURL, String adviceURL, Date orderTime, String signInfo, String remark) {
        this.merNo = merNo;
        this.merchantBillNo = merchantBillNo;
        this.systemBillNo = systemBillNo;
        this.amount = amount;
        this.returnURL = returnURL;
        this.adviceURL = adviceURL;
        this.orderTime = orderTime;
        this.signInfo = signInfo;
        this.remark = remark;
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getMerchantBillNo() {
        return merchantBillNo;
    }

    public void setMerchantBillNo(String merchantBillNo) {
        merchantBillNo = merchantBillNo;
    }

    public String getSystemBillNo() {
        return systemBillNo;
    }

    public void setSystemBillNo(String systemBillNo) {
        this.systemBillNo = systemBillNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getAdviceURL() {
        return adviceURL;
    }

    public void setAdviceURL(String adviceURL) {
        this.adviceURL = adviceURL;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
