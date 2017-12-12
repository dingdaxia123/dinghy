<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/11/30
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/index/payInquire" method="post">
  <table>
  <c:forEach items="${result}" var="">
    <tr>
      <td></td>
      <td>输入订单号:<input type="text" name="orderNo" value="${orderNo}"></td>
    </tr>
    <tr>
      <td></td>
      <td>商户号:<input type="text" name="merCode" value="${result.merCode}"></td>
    </tr>
    <tr>
      <td></td>
      <td>开始日期:<input type="text" name="beginDate" value="${result.beginDate}"></td>
    </tr>
    <tr>
      <td></td>
      <td>结束日期:<input type="text" name="endDate" value="${result.endDate}"></td>
    </tr>
    <tr>
      <td></td>
      <td>查询结果总数:<input type="text" name="resultCount" value="${result.resultCount}" ></td>
    </tr>
    <tr>
      <td></td>
      <td>查询分页:<input type="text" name="pageIndex" value="${result.pageIndex}" ></td>
    </tr>
    <tr>
      <td></td>
      <td>每页显示记录数:<input type="text" name="pageSize" value="${result.pageSize}"></td>
    </tr>
    <tr>
    <td></td>
    <td>返回结果码:<input type="text" name="resultCode" value="${result.resultCode}"></td>
    </tr>
    <tr>
    <td></td>
    <td>交易的订单号:<input type="text" name="orderNumber" value="${result.orderNumber}"></td>
    </tr>
    <tr>
      <td></td>
      <td>订单交易时间:<input type="text" name="orderDate" value="${result.orderDate}"></td>
    </tr>
    <tr>
      <td></td>
      <td>订单金额:<input type="text" name="orderAmount" value="${result.orderAmount}"></td>
    </tr>
    <tr>
      <td></td>
      <td>订单的状态:<input type="text" name="orderStatus" value="${result.orderStatus}"></td>
    </tr>
    <tr>
    <td></td>
    <td>勾兑状态:<input type="text" name="gouduiStatus" value="${result.gouduiStatus}"></td>
    </tr>
    <tr>
      <td></td>
      <td>退款状态:<input type="text" name="refundStatus" value="${result.refundStatus}"></td>
    </tr>
    <input type="submit" name="b1" value="Payment">
  </c:forEach>
  </table>
</form>
</body>
</body>
</html>
