<%--
  Created by IntelliJ IDEA.
  User: 16525
  Date: 2017/12/16
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改密码</title>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global_color.css"/>
</head>
<body>
<script language="javascript" type="text/javascript">
    //判断页面上输入的新密码是否一致
    function insertManager() {
        var divResult = document.getElementById("save_result_info");
        var password2 = document.getElementById("password2").value;
        var password1 = document.getElementById("password1").value;
        if (password1 != password2) {
            window.alert("您输入的密码与确认密码确认不一致");
            divResult.style.display = "none";
            Form.password1.focus();
            return false;

        }
        divResult.style.display = "block";
        document.getElementById("Form").submit();
    }
</script>
<!--Logo区域开始-->
<div id="header">

    <a href="main">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <ul id="menu">
        <li><a href="main" class="index_off"></a></li>
        <li><a href="../role/role_list.html" class="role_off"></a></li>
        <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
        <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
        <li><a href="../account/account_list.html" class="account_off"></a></li>
        <li><a href="../service/service_list.html" class="service_off"></a></li>
        <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
        <li><a href="../report/report_list.html" class="report_off"></a></li>
        <li><a href="getUser" class="information_off"></a></li>
        <li><a href="updatePwd" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<div id="main">
    <!--保存操作后的提示信息：成功或者失败-->
    <div id="save_result_info" class="save_success">保存成功！</div>
    <!--保存失败，旧密码错误！-->

    <form action="updatePwd" method="post" class="main_form" name="Form" id="Form">
        <div class="text_info clearfix"><span>旧密码：</span></div>
        <div class="input_info">
            <input name="password1" type="password" class="width200"/><span class="required">*</span>

            <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
        </div>
        <div class="text_info    clearfix"><span>新密码：</span></div>
        <div class="input_info">
            <input type="password" name="password2" class="width200"/><span class="required">*</span>

            <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
        </div>
        <div class="text_info clearfix"><span>重复新密码：</span></div>
        <div class="input_info">
            <input type="password" class="width200" name="password3"/><span class="required">*</span>

            <div class="validate_msg_medium">两次新密码必须相同</div>
        </div>
        <div class="button_info clearfix">
            <input type="button" value="保存" class="btn_save" onclick="insertManager();"/>
            <input type="button" value="取消" class="btn_save"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自扬哥的技术，最优秀的扬哥资源，最真实的企业环境，最适用崽崽的实战项目]</p>

    <p>版权所有(C)扬哥IT专训崽崽集团公司</p>
</div>
</body>
</html>
