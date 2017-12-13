<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/11/15
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="register" method="post">
  <td><input name="name" type="text" class="width150" value="${name}"></td>
  <td><input name="password" type="text" class="width150" value="${password}"></td>
  <input type="submit" name="b1" value="注册">
  <tr>${result}</tr>
</form>
</body>
</html>
