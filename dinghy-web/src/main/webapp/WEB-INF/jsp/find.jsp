<%--
  Created by IntelliJ IDEA.
  User: 16525
  Date: 2017/12/9
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询用户信息</title>
</head>
<form action="/index/findUser" method="post">
    <tr>查询<input type="text" name="name" value="${user.name}"></tr>
    <input type="submit" name="b1" value="查询用户信息">
    <table>
        <c:choose>
            <c:when test="${not empty userList}">
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td></td>
                        <td>姓名:<input type="text" name="name" value="${user.name}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>密码:<input type="text" name="password" value="${user.password}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>创建日期:<input type="text" name="createTime" value="${user.createTime}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>等级:<input type="text" name="level" value="${user1.level}"></td>
                    </tr>
                    <td></td>

                </c:forEach>
            </c:when>
        </c:choose>
    </table>
</form>
</body>
</html>
