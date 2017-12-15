<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/11/15
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>注册</title>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global_color.css"/>
    <script language="javascript" type="text/javascript">
        //保存成功的提示消息
        function showResult() {
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }
        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }

        function insertManager() {
            var divResult = document.getElementById("save_result_info");
            var password = document.getElementById("password").value;
            var password1 = document.getElementById("password1").value;
            if (password1 != password) {
                window.alert("您输入的密码与确认密码确认不一致");
                divResult.style.display = "none";
                Form.password1.focus();
                return false;

            }

            divResult.style.display = "block";
            document.getElementById("Form").submit();
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <%--<img src="../images/logo.png" alt="logo" class="left"/>--%>
    <a href="login">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<%--<div id="navi">--%>
<%--<ul id="menu">--%>
<%--<li><a href="../index.html" class="index_off"></a></li>--%>
<%--<li><a href="../role/role_list.html" class="role_off"></a></li>--%>
<%--<li><a href="../admin/admin_list.html" class="admin_off"></a></li>--%>
<%--<li><a href="../fee/fee_list.html" class="fee_off"></a></li>--%>
<%--<li><a href="../account/account_list.html" class="account_off"></a></li>--%>
<%--<li><a href="../service/service_list.html" class="service_off"></a></li>--%>
<%--<li><a href="../bill/bill_list.html" class="bill_off"></a></li>--%>
<%--<li><a href="../report/report_list.html" class="report_off"></a></li>--%>
<%--<li><a href="../user/user_info.html" class="information_off"></a></li>--%>
<%--<li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <div id="save_result_info" class="save_success">保存成功！</div>
    <form action="register" method="post" class="main_form" id="Form" name="Form">
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input type="text" name="name" value="${name}"/>
            <span class="required">*</span>

            <div class="validate_msg_long">20长度以内的汉字、字母、数字的组合</div>
        </div>
        <div class="text_info clearfix"><span>账号：</span></div>
        <div class="input_info">
            <input type="text" name="accountNumber" value="${accountNumber}"/>
            <span class="required">*</span>

            <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
        </div>
        <div class="text_info clearfix"><span>密码：</span></div>
        <div class="input_info">
            <input type="password" name="password" id="password" value="${password}"/>
            <span class="required">*</span>

            <div class="validate_msg_long error_msg">30长度以内的字母、数字和下划线的组合</div>
        </div>
        <div class="text_info clearfix"><span>重复密码：</span></div>
        <div class="input_info">
            <input type="password" id="password1" name="password1" value="${password1}"/>
            <span class="required">*</span>

            <div class="validate_msg_long error_msg">两次密码必须相同</div>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" class="width200" value="${phone}" name="phone"/>
            <span class="required">*</span>

            <div class="validate_msg_medium error_msg">正确的电话号码格式：手机或固话</div>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" class="width200" name="email" value="${email}"/>
            <span class="required">*</span>

            <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
        </div>
        <%--<div class="text_info clearfix"><span>角色：</span></div>--%>
        <%--<div class="input_info_high">--%>
            <%--<div class="input_info_scroll">--%>
                <%--<ul>--%>
                    <%--<li><input type="checkbox"/>超级管理员</li>--%>
                    <%--<li><input type="checkbox"/>账务账号管理员</li>--%>
                    <%--<li><input type="checkbox"/>业务账号管理员</li>--%>
                    <%--<li><input type="checkbox"/>账务账号管理员</li>--%>
                    <%--<li><input type="checkbox"/>业务账号管理员</li>--%>
                    <%--<li><input type="checkbox"/>账务账号管理员</li>--%>
                    <%--<li><input type="checkbox"/>业务账号管理员</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<span class="required">*</span>--%>

            <%--<div class="validate_msg_tiny error_msg">至少选择一个</div>--%>
        <%--</div>--%>
        <div class="button_info clearfix">
            <input type="button" value="注册" class="btn_save" onclick="insertManager();"/>
            <%--<input type="button" value="取消" class="btn_save" />--%>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自扬哥的技术，最优秀的扬哥资源，最真实的企业环境，最适用崽崽的实战项目]</span>
    <br/>
    <span>版权所有(C)扬哥IT专训崽崽集团公司 </span>
</div>
</body>
</html>

