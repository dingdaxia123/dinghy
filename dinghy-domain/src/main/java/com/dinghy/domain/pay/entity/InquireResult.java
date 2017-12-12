package com.dinghy.domain.pay.entity;

/**
 * Created by dinghy on 2017/11/30.
 */
public class InquireResult {

    private String merCode;
    private String beginDate;
    private String endDate;
    private String resultCount;
    private String pageIndex;
    private String pageSize;
    private String resultCode;
    private String orderNumber;
    private String orderDate;
    private String orderAmount;
    private String orderStatus;
    private String gouduiStatus;
    private String refundStatus;

    public InquireResult(String merCode, String beginDate, String endDate,
                         String resultCount, String pageIndex, String pageSize,
                         String resultCode, String orderNumber, String orderDate,
                         String orderAmount, String orderStatus, String gouduiStatus,
                         String refundStatus) {
        this.merCode = merCode;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.resultCount = resultCount;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.resultCode = resultCode;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.gouduiStatus = gouduiStatus;
        this.refundStatus = refundStatus;
    }

    public String getMerCode() {
        return merCode;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getResultCount() {
        return resultCount;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getGouduiStatus() {
        return gouduiStatus;
    }

    public String getRefundStatus() {
        return refundStatus;
    }
}
