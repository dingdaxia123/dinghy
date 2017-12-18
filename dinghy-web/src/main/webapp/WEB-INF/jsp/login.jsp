<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/11/3
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global_color.css"/>
</head>
<body class="index">

<%--<td><input name="name" type="text" class="width150" value="${name}"/></td>--%>
<%--<td><input name="password" type="text" class="width150" value="${password}"/></td>--%>
<%--<input type="submit" name="b1" value="Payment">--%>
<%--<a href="/index/register">注册</a>--%>
<div id="header">
    <a href="register">[注册]</a>
</div>
<form action="login" method="post">
    <div class="login_box">
        <table>
            <tr>
                <td class="login_info">账号：</td>
                <td colspan="2"><input name="accountNumber" type="text" class="width150" value="${accountNumber}"/></td>
                <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
            </tr>
            <tr>
                <td class="login_info">密码：</td>
                <td colspan="2"><input name="password" type="password" class="width150" vale="${password}"/></td>
                <td><span class="required">30长度的字母、数字和下划线</span></td>
            </tr>
            <tr>
                <td class="login_info">验证码：</td>
                <td class="width70"><input name="" type="text" class="width70"/></td>
                <td><img id="img" src="<%=basePath%>/check" onclick="refresh()" alt="验证码" title="点击更换"/></td>
                <td><span class="required"></span></td>
            </tr>
            <tr>
                <td></td>
                <td class="login_button" colspan="2">
                    <a href="javascript:document.forms[0].submit();">
                        <img src="/static/images/login_btn.png"/></a>
                </td>
                <td><span class="required"></span></td>
                <%--<td><a href="/index/register">注册</a></td>--%>
            </tr>
        </table>
    </div>
</form>

<script>
    function refresh() {
        var url = $("#basePath").val() + "check.jpg?number=" + Math.random();
        $("#img").attr("src", url);
    }
</script>
</body>
</html>
