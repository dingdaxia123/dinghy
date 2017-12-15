<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/12/15
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>用户信息</title>
  <link type="text/css" rel="stylesheet" media="all" href="/static/css/global.css" />
  <link type="text/css" rel="stylesheet" media="all" href="/static/css/global_color.css" />
  <script language="javascript" type="text/javascript">
    //保存成功的提示信息
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

    function getForm(){
      document.getElementById("Form").submit();
    }
  </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
  <%--<img src="/static/images/logo.png" alt="logo" class="left"/>--%>
  <a href="#">[退出]</a>
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
    <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
  </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
  <!--保存操作后的提示信息：成功或者失败-->
  <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
  <form action="updateUser" method="post" class="main_form" name="Form" id="Form">
    <div class="text_info clearfix"><span>账号：</span></div>
    <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${user.accountNumber}" /></div>
    <div class="text_info clearfix"><span>角色：</span></div>
    <div class="input_info">
      <input type="text" readonly="readonly" class="readonly width400" value="${user.level}" />
    </div>
    <div class="text_info clearfix"><span>姓名：</span></div>
    <div class="input_info">
      <input type="text" readonly="readonly" class="readonly" value="${user.name}" />
      <%--<span class="required">*</span>--%>
      <%--<div class="validate_msg_long error_msg">20长度以内的汉字、字母的组合</div>--%>
    </div>
    <div class="text_info clearfix"><span>电话：</span></div>
    <div class="input_info">
      <input type="text" class="width200" readonly="readonly" class="readonly" value="${user.phone}" />
      <%--<div class="validate_msg_medium">电话号码格式：手机或固话</div>--%>
    </div>
    <div class="text_info clearfix" ><span>Email：</span></div>
    <div class="input_info">
      <input type="text" class="width200" readonly="readonly" class="readonly" value="${user.email}" />
      <%--<div class="validate_msg_medium">50长度以内，符合 email 格式</div>--%>
    </div>
    <div class="text_info clearfix"><span>创建时间：</span></div>
    <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${user.createTime}"/></div>
    <div class="button_info clearfix">
      <input type="submit"  value="修改信息" class="btn_save" />
      <%--<input type="button" value="取消" class="btn_save" />--%>
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

