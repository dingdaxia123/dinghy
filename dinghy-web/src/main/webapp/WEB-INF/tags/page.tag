<%@ tag body-content="empty" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ attribute name="page" rtexprvalue="true" required="true" type="com.dinghy.domain.util.Pagination" description="分页对象Pagination"%>
<%@ attribute name="url" rtexprvalue="true" required="true" type="java.lang.String" description="URL"%>
<%@ attribute name="info" rtexprvalue="true" required="true" type="java.lang.Boolean" description="是否显示分页信息（记录总数，页面总数，当前第几页）"%>
<%@ attribute name="pagenum" type="java.lang.Integer" description="显示页码数量，如5（1,2,3,4,5) 3(2,3,4)" required="true"%>
<div class="pagelib">
	<c:if test="${info}">
		<span class="info">共${page.totalCount}条记录 <c:if test="${page.totalCount gt 0 }">，第${page.pageNo}页，共${page.totalPage}页</c:if>
		</span>
	</c:if>
	<c:if test="${page.totalCount gt 0}">
		<c:choose>
			<c:when test="${pagenum%2==0 }">
				<c:set var="half" value="${pagenum/2}"></c:set>
				<c:set var="left" value="${half-1}"></c:set>
				<c:set var="right" value="${half}"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="half" value="${(pagenum+1)/2}"></c:set>
				<c:set var="left" value="${half-1}"></c:set>
				<c:set var="right" value="${left}"></c:set>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${page.pageNo==1}">
				<span class="nav_currPage">首页</span>
			</c:when>
			<c:otherwise>
				<a class="nav" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=1&pageSize=${page.pageSize}')">首页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${page.prePage==page.pageNo}">
				<span class="nav_currPage">上一页</span>
			</c:when>
			<c:otherwise>
				<a class="nav" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=${page.prePage}&pageSize=${page.pageSize}')">上一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${page.pageNo le half}">
				<c:forEach begin="1" end="${page.pageNo}" var="index">
					<c:choose>
						<c:when test="${index eq page.pageNo}">
							<span class="code_currPage">${index}</span>
						</c:when>
						<c:otherwise>
							<a class="code" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=${index}&pageSize=${page.pageSize}')">${index}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:forEach begin="${page.pageNo+1}" end="${page.totalPage ge pagenum?pagenum:page.totalPage}" var="index">
					<a class="code" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=${index}&pageSize=${page.pageSize}')">${index}</a>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${page.pageNo+right le page.totalPage}">
						<c:forEach begin="${page.pageNo-left}" end="${page.pageNo}" var="index">
							<c:choose>
								<c:when test="${index eq page.pageNo}">
									<span class="code_currPage">${index}</span>
								</c:when>
								<c:otherwise>
									<a class="code" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=${index}&pageSize=${page.pageSize}')">${index}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="${page.totalPage+1-pagenum ge 1?page.totalPage+1-pagenum:1}" end="${page.pageNo}" var="index">
							<c:choose>
								<c:when test="${index eq page.pageNo}">
									<span class="code_currPage">${index}</span>
								</c:when>
								<c:otherwise>
									<a class="code" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=${index}&pageSize=${page.pageSize}')">${index}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${page.pageNo+1}" end="${page.pageNo+right le page.totalPage?page.pageNo+right:page.totalPage}" var="index">
					<a class="code" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=${index}&pageSize=${page.pageSize}')">${index}</a>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${page.nextPage eq page.pageNo}">
				<span class="nav_currPage">下一页</span>
			</c:when>
			<c:otherwise>
				<a class="nav" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=${page.nextPage}&pageSize=${page.pageSize}')">下一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${page.pageNo eq page.totalPage}">
				<span class="nav_currPage">尾页</span>
			</c:when>
			<c:otherwise>
				<a class="nav" href="javascript:void(0)" onclick="studio_open_url('${url}${fn:contains(url,'?')?'&':'?'}pageNo=${page.totalPage}&pageSize=${page.pageSize}')">尾页</a>
			</c:otherwise>
		</c:choose>
	</c:if>

	<script type="text/javascript">
	$(function(){
		$('body').append('<form method="post" id="studio_page_form"></form>');
		 studio_open_url=function(url) {
			$('#studio_page_form').html('');
			var arr = url.split('?');
			$('#studio_page_form').attr('action',arr[0]);
			if (arr[1]) {
				var params = arr[1].split('&');
				for ( var index in params) {
					var item = params[index];
					var pair = item.split('=');
					var key = pair[0];
					var val = pair[1] ? pair[1] : '';
					var hidden = '<input type="hidden" name="'+key+'" value="'+val+'"/>';
					$('#studio_page_form').append(hidden);
				}
			}
			$('#studio_page_form').submit();
		};
	});
	</script>
</div>