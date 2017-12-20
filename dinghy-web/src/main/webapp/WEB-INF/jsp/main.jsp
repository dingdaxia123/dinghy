<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/9/30
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>主界面</title>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global_color.css"/>
</head>
<body class="index">
<div id="header">
    <%--<img src="../images/logo.png" alt="logo" class="left"/>--%>
    <a href="login">[退出]</a>
</div>
<!--导航区域开始-->
<div id="index_navi">
    <ul id="menu">
        <li><a href="main" class="index_off"></a></li>
        <li><a href="role/role_list.html" class="role_off"></a></li>
        <li><a href="admin/admin_list.html" class="admin_off"></a></li>
        <li><a href="fee_list" class="fee_off"></a></li>
        <li><a href="account/account_list.html" class="account_off"></a></li>
        <li><a href="service/service_list.html" class="service_off"></a></li>
        <li><a href="bill/bill_list.html" class="bill_off"></a></li>
        <li><a href="report/report_list.html" class="report_off"></a></li>
        <li><a href="getUser" class="information_off"></a></li>
        <li><a href="updatePwd" class="password_off"></a></li>
    </ul>
</div>
</body>
</html>
