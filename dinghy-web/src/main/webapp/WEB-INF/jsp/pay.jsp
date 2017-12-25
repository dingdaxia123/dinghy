<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/11/13
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="http://localhost:8000/dhy/pay" method="post">
<%--<c:forEach items="${payEntity}" var="payEntity">--%>
<tr>
    <td></td>
    <td><input type="hidden" name="MerNo" value="${payEntity.merNo}"></td>
  </tr>
  <tr>
    <td></td>
    <td><input type="hidden" name="BillNo" value="${payEntity.billNo}"></td>
  </tr>
  <tr>
    <td></td>
    <td><input type="hidden" name="Amount" value="${payEntity.amount}"></td>
  </tr>

  <tr>
    <td></td>
    <td><input type="hidden" name="ReturnURL" value="${payEntity.returnURL}" ></td>
  </tr>

  <tr>
    <td></td>
    <td><input type="hidden" name="AdviceURL" value="${payEntity.adviceURL}" ></td>
  </tr>

  <tr>
    <td></td>
    <td><input type="hidden" name="SignInfo" value="${payEntity.signInfo}"></td>
  </tr>
  <tr>
    <td></td>
    <td><input type="hidden" name="defaultBankNumber" value="${payEntity.defaultBankNumber}"></td>
  </tr>
  <tr>
    <td></td>
    <td><input type="hidden" name="payType" value="${payEntity.payType}"></td>
  </tr>
  <tr>
    <td></td>
    <td><input type="hidden" name="OrderTime" value="${payEntity.orderTime}"></td>
  </tr>
  <tr>
    <td></td>
    <td><input type="hidden" name="Remark" value="${payEntity.remark}"></td>
  </tr>
  <input type="submit" name="b1" value="查询">
<%--</c:forEach>--%>
</form>
</body>
</html>
