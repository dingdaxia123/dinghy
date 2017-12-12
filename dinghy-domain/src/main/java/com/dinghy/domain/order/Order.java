package com.dinghy.domain.order;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dinghy on 2017/11/13.
 */
public class Order implements Serializable {

    private Long id;
    private String merNo;
    private String billNo;
    private String amount;
    private String yemadaiOrderNo;
    private String succeed;
    private String result;
    private String signInfo;
    private String ip;
    private Date createTime = new Date();//存入时间

    public Order() {
    }

    public Order(String merNo, String billNo, String amount, String yemadaiOrderNo,
                 String succeed, String result, String signInfo, String ip) {
        this.merNo = merNo;
        this.billNo = billNo;
        this.amount = amount;
        this.yemadaiOrderNo = yemadaiOrderNo;
        this.succeed = succeed;
        this.result = result;
        this.signInfo = signInfo;
        this.ip = ip;
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getYemadaiOrderNo() {
        return yemadaiOrderNo;
    }

    public void setYemadaiOrderNo(String yemadaiOrderNo) {
        this.yemadaiOrderNo = yemadaiOrderNo;
    }

    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
