<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/11/24
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="refund" method="post">
  <td><input name="name" type="text" class="width150" value="${refundAmount}"></td>
  <td><input name="password" type="text" class="width150" value="${orderNumber}"></td>
  <input type="submit" name="b1" value="Payment">
</form>
</body>
</html>
