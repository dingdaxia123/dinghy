<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/11/3
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
  <form action="login" method="post">
    <td><input name="name" type="text" class="width150" value="${name}"></td>
    <td><input name="password" type="text" class="width150" value="${password}"></td>
    <input type="submit" name="b1" value="Payment">
    <a href="/index/register">注册</a>
    <a href="/index/refund">退款</a>
  </form>
</body>
</html>
