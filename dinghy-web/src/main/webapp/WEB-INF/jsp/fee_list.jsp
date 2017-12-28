<%--
  Created by IntelliJ IDEA.
  User: dinghy
  Date: 2017/12/19
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%--<%@ include file="../jsp/top.jsp" %>--%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>资费列表</title>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/static/css/global_color.css"/>
    <script type="text/javascript" src="/static/js/jquery-1.10.1.min.js"></script>
    <script language="javascript" type="text/javascript">
        //排序按钮的点击事件
        function sort(btnObj) {
            if (btnObj.className == "sort_desc")
                btnObj.className = "sort_asc";
            else
                btnObj.className = "sort_desc";
        }

        //启用
        function startFee(obj1) {
//            var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
//            document.getElementById("operate_result_info").style.display = "block";
            if (window.confirm("确认开启吗?")) {
                var path = "${ctx}/index/startCost";
                $.post(path, {
                            id: obj1
                        }, function (data) {
                            if (data == "ok") {
                                alert("启动成功!");
                                var x = document.getElementById("Form");
                                x.action = "fee_list";
                                x.submit();
                            } else {
                                alert("操作失败");
                                return
                            }
                        }
                );
            }
        }
        //删除
        function deleteFee() {
            var r = window.confirm("确定要删除此资费吗？");
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
    <form action="fee_list" method="post" id="Form">
        <!--排序-->
        <div class="search_add">
            <div>
                <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />
                <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />-->
            </div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='fee_add';"/>
        </div>
        <!--启用操作的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="/static/images/close.png" onclick="this.parentNode.style.display='none';"/>
            删除成功！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>资费ID</th>
                    <th class="width100">资费名称</th>
                    <th>基本时长</th>
                    <th>基本费用</th>
                    <th>单位费用</th>
                    <th>创建时间</th>
                    <th>开通时间</th>
                    <th class="width50">状态</th>
                    <th class="width200"></th>
                </tr>
                <c:choose>
                    <c:when test="${not empty pager}">
                        <c:forEach items="${pager.list}" var="list" varStatus="vs">
                            <tr>
                                <td>${vs.index+1}</td>
                                <td><a href="fee_detail.html">${list.name}</a></td>
                                <td>${list.baseDuration}</td>
                                <td>${list.baseCost}</td>
                                <td>${list.unitCost}</td>
                                <td>${list.createTime}</td>
                                <td>${list.startTime}</td>
                                <td>${list.status.text}</td>
                                <td>
                                    <input type="button" value="启用" class="btn_start" onclick="startFee(${list.id});"/>
                                    <input type="button" value="修改" class="btn_modify"
                                           onclick="location.href='fee_modi?id=${list.id}';"/>
                                    <input type="button" value="禁用" class="btn_delete" onclick="deleteFee();"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="100" class="center">没有相关数据</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>

            <%--<p>业务说明：<br/>--%>
            <%--1、创建资费时，状态为暂停，记载创建时间；<br/>--%>
            <%--2、暂停状态下，可修改，可删除；<br/>--%>
            <%--3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br/>--%>
            <%--4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）--%>
            <%--</p>--%>
        </div>
        <!--分页-->
        <%--<div id="pages"><page:page page="${pager}" info="true" pagenum="5" url="${ctx}/index/fee_list"/></div>--%>
        <div id="pages">
            <c:if test="${pager.pageNo == 1}">
                <a href="#">上一页</a>
            </c:if>
            <c:if test="${pager.pageNo != 1}">
                <a href="fee_list?page=${pager.pageNo-1}">上一页</a>
            </c:if>
            <c:forEach begin="1" end="${pager.totalPage}" var="p">
                <%--<c:if test="">--%>

                <%--</c:if>--%>
                <%--<c:if test="${p != pager.pageNo}">--%>
                <%----%>
                <%--</c:if>--%>
                <c:choose>
                    <c:when test="${p==pager.pageNo}"><a href="fee_list?page=${p}"
                                                         class="current_page">${p}</a></c:when>
                    <c:otherwise><a href="fee_list?page=${p}">${p}</a></c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${pager.pageNo == pager.totalPage}">
                <a href="#">下一页</a>
            </c:if>
            <c:if test="${pager.pageNo != pager.totalPage}">
                <a href="fee_list?page=${pager.pageNo+1}">下一页</a>
            </c:if>
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
