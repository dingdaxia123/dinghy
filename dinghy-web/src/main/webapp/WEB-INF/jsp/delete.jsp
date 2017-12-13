<%--
  Created by IntelliJ IDEA.
  User: 16525
  Date: 2017/12/9
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除</title>
</head>
<body>
<form action="/index/deleteUser" method="post">
<td><input name="name" type="text" class="width150" value="${name}"></td>
<td><input name="password" type="text" class="width150" value="${password}"></td>
<input type="submit" name="b1" value="Payment">
  <h1>${result} </h1>
</form>
</body>
</html>
