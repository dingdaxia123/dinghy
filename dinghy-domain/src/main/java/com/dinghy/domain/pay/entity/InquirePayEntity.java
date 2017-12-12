package com.dinghy.domain.pay.entity;

import com.dinghy.domain.util.Md5Utils;

/**
 * Created by dinghy on 2017/11/29.
 */
public class InquirePayEntity {
    private String merCode = "16886";
    private String orderNumber;
    private String beginTime;
    private String endTime;
    private String pageIndex;
    private String sign;
    private String key = "zhuxiang";

    public InquirePayEntity(String orderNumber, String beginTime, String endTime, String pageIndex, String sign) {
        this.orderNumber = orderNumber;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.pageIndex = pageIndex;
        this.sign = sign;
    }

    public InquirePayEntity(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public InquirePayEntity(){}

    public String requestXml(InquirePayEntity refundEntity){
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<root tx=\"1001\">");
        sb.append("<merCode>").append(this.merCode).append("</merCode>");
        sb.append("<orderNumber>").append(this.orderNumber).append("</orderNumber>");
//        sb.append("<beginTime>").append(this.beginTime).append("</beginTime>");
//        sb.append("<endTime>").append(this.endTime).append("</endTime>");
//        sb.append("<pageIndex>").append(this.pageIndex).append("</pageIndex>");
        Md5Utils md5Utils = new Md5Utils();
        String str = merCode+key;
        this.sign = md5Utils.getMD5ofStr(str);
        sb.append("<sign>").append(this.sign).append("</sign>");
        sb.append("</root>");
        String xml = sb.toString();
        return xml;
    }
}

