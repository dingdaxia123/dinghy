package com.dinghy.domain.pay.entity;

import com.dinghy.domain.order.Refund;
import com.dinghy.domain.util.Md5Utils;

/**
 * Created by dinghy on 2017/11/23.
 */
public class RefundEntity {
    private String merNo = "16886";
    private String orderNumber;
    private String refundNumber;
    private String refundAmount;
    private String noticeUrl;
    private String sign;
    private String key = "zhuxiang";

    public RefundEntity(){}

    public RefundEntity(String orderNumber, String refundNumber, String refundAmount, String noticeUrl) {
        this.orderNumber = orderNumber;
        this.refundNumber = refundNumber;
        this.refundAmount = refundAmount;
        this.noticeUrl = noticeUrl;
    }

    public String requestXml(RefundEntity refundEntity){
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<root tx=\"1002\">");
        sb.append("<merCode>").append(this.merNo).append("</merCode>");
        sb.append("<orderNumber>").append(this.orderNumber).append("</orderNumber>");
        sb.append("<refundNumber>").append(this.refundNumber).append("</refundNumber>");
        sb.append("<refundAmount>").append(this.refundAmount).append("</refundAmount>");
        sb.append("<noticeUrl>").append(this.noticeUrl).append("</noticeUrl>");
        Md5Utils md5Utils = new Md5Utils();
        String str = "merCode="+merNo+"&orderNumber="+orderNumber+"&refundNumber="
                +refundNumber+"&refundAmount="+refundAmount+"&noticeUrl="+noticeUrl+"&"+key;
        this.sign = md5Utils.getMD5ofStr(str);
        sb.append("<sign>").append(this.sign).append("</sign>");
        sb.append("</root>");
        String xml = sb.toString();
        return xml;
    }
}