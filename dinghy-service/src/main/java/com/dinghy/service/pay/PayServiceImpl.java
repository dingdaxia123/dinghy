package com.dinghy.service.pay;

import com.dinghy.domain.order.Order;
import com.dinghy.domain.order.Refund;
import com.dinghy.domain.order.rpt.OrderRpt;
import com.dinghy.domain.pay.PayOrder;
import com.dinghy.domain.pay.entity.InquirePayEntity;
import com.dinghy.domain.pay.entity.InquireResult;
import com.dinghy.domain.pay.entity.PayEntity;
import com.dinghy.domain.pay.entity.RefundEntity;
import com.dinghy.domain.pay.service.PayService;
import com.dinghy.domain.util.HttpClientJson;
import com.dinghy.domain.util.Md5Utils;
import org.apache.commons.codec.binary.Base64;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dinghy on 2017/11/8.
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private OrderRpt orderRpt;

    @Override
    public PayEntity pay(String amount) {
        String billNo = getPayBillNo();
        String sign = md5(amount, billNo);
        PayEntity payEntity = new PayEntity(billNo, amount, sign);
        return payEntity;
    }

    @Override
    public RefundEntity refund(String refundAmount, String orderNumber, String noticeUrl) {
        String type = null;
        RefundEntity refundEntity = new RefundEntity(orderNumber, getRefundBillNo(), refundAmount, noticeUrl);
        String xml = refundEntity.requestXml(refundEntity);
        HttpClientJson httpClientJson = new HttpClientJson();
        Base64 base64 = new Base64();
        try {
            type = new String(base64.encode(xml.getBytes("UTF-8")));
            httpClientJson.setList("requestDomain", type);
            String result = httpClientJson.send("https://gwapi.yemadai.com/merchantRefundAPI");
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new ByteArrayInputStream(result.getBytes("utf-8")));
            Element root = doc.getRootElement();
            String refundStatus = root.getChildText("refundStatus");
            if (refundStatus.equals("00")) {
//                Refund refund = orderRpt.getRefund(orderNumber);
//                refund.setIp("");
                Refund refund = new Refund();
                refund.setRefundStatus(refundStatus);
                orderRpt.put(refund);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Object order) {
        orderRpt.put(order);
    }

    @Override
    public InquireResult InquirePay(String billNo) {
        String type = null;
        InquireResult inquireResult = null;
        InquirePayEntity entity = new InquirePayEntity(billNo);
        String xml = entity.requestXml(entity);
        HttpClientJson httpClientJson = new HttpClientJson();
        Base64 base64 = new Base64();
        try {
            type = new String(base64.encode(xml.getBytes("UTF-8")));
            httpClientJson.setList("requestDomain", type);
            String result = httpClientJson.send("https://gwapi.yemadai.com/merchantBatchQueryAPI");
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new ByteArrayInputStream(result.getBytes("utf-8")));
            Element root = doc.getRootElement();
            String merCode = root.getChildText("merCode");
            String beginDate = root.getChildText("beginDate");
            String endDate = root.getChildText("endDate");
            String resultCount = root.getChildText("resultCount");
            String pageIndex = root.getChildText("pageIndex");
            String pageSize = root.getChildText("pageSize");
            String resultCode = root.getChildText("resultCode");
            Element list = root.getChild("list");
            String orderNumber = list.getChildText("orderNumber");
            String orderDate = list.getChildText("orderDate");
            String orderAmount = list.getChildText("orderAmount");
            String orderStatus = list.getChildText("orderStatus");
            String gouduiStatus = list.getChildText("gouduiStatus");
            String refundStatus = list.getChildText("refundStatus");

            inquireResult = new InquireResult(merCode, beginDate, endDate, resultCount,
                            pageIndex, pageSize, resultCode, orderNumber, orderDate, orderAmount,
                            orderStatus, gouduiStatus, refundStatus);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return inquireResult;
    }

    @Override
    public String pay(String MerNo, String BillNo, String Amount, String ReturnURL, String AdviceURL, String SignInfo,
                      String OrderTime, String defaultBankNumber, String Remark, String products, String payType) throws Exception{
        PayOrder payOrder = new PayOrder(MerNo, BillNo, getPayBillNo(), Amount, ReturnURL, AdviceURL, new SimpleDateFormat(
                "yyyyMMddHHmmss").parse(OrderTime), SignInfo, Remark);
        orderRpt.put(payOrder);
        return "ok";
    }

//    @Override
//    public void refund(Refund refund) {
//        orderRpt.put(refund);
//    }

    private String getPayBillNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String billNo = "Pay" + simpleDateFormat.format(date);
        return billNo;
    }

    private String getRefundBillNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String billNo = "Refund" + simpleDateFormat.format(date);
        return billNo;
    }

    private String md5(String amount, String billNo) {
        PayEntity payEntity = new PayEntity();
        String pain = "MerNo=" + payEntity.getMerNo() + "&" + "BillNo=" + billNo + "&" + "Amount=" + amount
                + "&" + "OrderTime=" + payEntity.getOrderTime() + "&" + "ReturnURL=" + payEntity.getReturnURL() + "&" +
                "AdviceURL=" + payEntity.getAdviceURL() + "&" + payEntity.getMd5Key();
        Md5Utils md5Utils = new Md5Utils();
        String sign = md5Utils.getMD5ofStr(pain);
        return sign;
    }
}
