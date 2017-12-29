<%--
  Created by IntelliJ IDEA.
  User: 16525
  Date: 2017/12/27
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>达内－NetCTOSS</title>
  <link type="text/css" rel="stylesheet" media="all" href="/static/css/global.css" />
  <link type="text/css" rel="stylesheet" media="all" href="/static/css/global_color.css" />
</head>
<body>
<!--Logo区域开始-->
<div id="header">
  <a href="#">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
  <ul id="menu">
    <li><a href="../index.html" class="index_off"></a></li>
    <li><a href="../role/role_list.html" class="role_off"></a></li>
    <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
    <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
    <li><a href="../account/account_list.html" class="account_off"></a></li>
    <li><a href="../service/service_list.html" class="service_off"></a></li>
    <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
    <li><a href="../report/report_list.html" class="report_off"></a></li>
    <li><a href="../user/user_info.html" class="information_off"></a></li>
    <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
  </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
  <form action="" method="" class="main_form">
    <div class="text_info clearfix"><span>资费ID：</span></div>
    <div class="input_info"><input type="text" class="readonly" readonly value="${id}" /></div>
    <div class="text_info clearfix"><span>资费名称：</span></div>
    <div class="input_info"><input type="text" class="readonly" readonly value="${name}"/></div>
    <div class="text_info clearfix"><span>资费状态：</span></div>
    <div class="input_info">
      <select class="readonly" disabled>
        var status = "${list.status.text}";
        if (status == "开通"){
        <option selected="selected">开通</option>
        }else{
        <option selected="selected">禁用</option>
        }
        <%--else{--%>
        <%--<option selected="selected">删除</option>--%>
        <%--}--%>
      </select>
    </div>
    <div class="text_info clearfix"><span>资费类型：</span></div>
    <div class="input_info fee_type">
      <c:choose>
        <c:when test="${radFeeType == '包月'}">
          <input type="radio" name="radFeeType" checked="checked" id="monthly" onclick="feeTypeChange(1);"
                 value="${radFeeType}"/>
        </c:when>
        <c:otherwise>
          <input type="radio" name="radFeeType" id="monthly" onclick="feeTypeChange(1);"
                 value="${radFeeType}"/>
        </c:otherwise>
      </c:choose>
      <label for="package">包月</label>
      <c:choose>
        <c:when test="${radFeeType == '套餐'}">
          <input type="radio" name="radFeeType" checked="checked" id="package" onclick="feeTypeChange(2);"
                 value="${radFeeType}"/>
        </c:when>
        <c:otherwise>
          <input type="radio" name="radFeeType" id="package" onclick="feeTypeChange(2);"
                 value="${radFeeType}"/>
        </c:otherwise>
      </c:choose>
      <label for="monthly">套餐</label>
      <c:choose>
        <c:when test="${radFeeType == '计时'}">
          <input type="radio" name="radFeeType" checked="checked" id="timeBased" onclick="feeTypeChange(3);"
                 value="${radFeeType}"/>
        </c:when>
        <c:otherwise>
          <input type="radio" name="radFeeType" id="timeBased" onclick="feeTypeChange(3);"
                 value="${radFeeType}"/>
        </c:otherwise>
      </c:choose>
      <label for="timeBased">计时</label>
    </div>
    <div class="text_info clearfix"><span>基本时长：</span></div>
    <div class="input_info">
      <input type="text" class="readonly" readonly value="${baseDuration}"  />
      <span>小时</span>
    </div>
    <div class="text_info clearfix"><span>基本费用：</span></div>
    <div class="input_info">
      <input type="text"  class="readonly" readonly value="${baseCost}" />
      <span>元</span>
    </div>
    <div class="text_info clearfix"><span>单位费用：</span></div>
    <div class="input_info">
      <input type="text"  class="readonly" readonly value="${unitCost}" />
      <span>元/小时</span>
    </div>
    <div class="text_info clearfix"><span>创建时间：</span></div>
    <div class="input_info"><input type="text"  class="readonly" readonly value="${createTime}" /></div>
    <div class="text_info clearfix"><span>启动时间：</span></div>
    <div class="input_info"><input type="text"  class="readonly" readonly value="${startTime}" /></div>
    <div class="text_info clearfix"><span>资费说明：</span></div>
    <div class="input_info_high">
      <textarea class="width300 height70 readonly" readonly>"${descr}"</textarea>
    </div>
    <div class="button_info clearfix">
      <input type="button" value="返回" class="btn_save" onclick="location.href='fee_list';" />
    </div>
  </form>
</div>
<!--主要区域结束-->
<div id="footer">
  <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
  <br />
  <span>版权所有(C)加拿大达内IT培训集团公司 </span>
</div>
</body>
</html>
