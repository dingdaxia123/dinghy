package com.dinghy.domain.pay.entity;

import com.dinghy.domain.util.Md5Utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dinghy on 2017/11/13.
 */
public class PayEntity{
    private String merNo="16886";
    private String md5Key = "zhuxiang";
    private String billNo;
    private String amount;
    private String orderTime=getTime();
    private String returnURL="http://180.173.165.224:10045/index/login";
    private String adviceURL="http://180.173.165.224:10045/index/payAdviceUrl";
    private String pain="MerNo="+merNo +"&"+ "BillNo="+this.getBillNo() +"&"+ "Amount="+this.getBillNo()
            +"&"+"OrderTime="+orderTime+"&"+ "ReturnURL="+returnURL +"&"+"AdviceURL="+adviceURL+"&"+"zhuxiang" ;
    private String payType = "noCard";
    private String defaultBankNumber = "NOCARD";
    private String remark="±¸×¢";


    private String signInfo = md5(pain);

    private String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String time = simpleDateFormat.format(date);
        return time;
    }

    private String md5(String pain){
        Md5Utils md5Utils = new Md5Utils();
        String sign = md5Utils.getMD5ofStr(pain);
        return sign;
    }

    public PayEntity(String billNo, String amount , String signInfo) {
        this.billNo = billNo;
        this.amount = amount;
        this.signInfo = signInfo;
    }

    public PayEntity(){}

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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
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

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    public String getPain() {
        return pain;
    }

    public String getMd5Key() {
        return md5Key;
    }

    public String getPayType() {
        return payType;
    }

    public String getDefaultBankNumber() {
        return defaultBankNumber;
    }

    public String getRemark() {
        return remark;
    }
}
