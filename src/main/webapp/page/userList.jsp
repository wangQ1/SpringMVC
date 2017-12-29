<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->
<title>用户管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">用户列表</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/showUsers"
			method="get">
			<input type="hidden" name="method" value="search"> <input
				type="text" name="name" title="请输入用户姓名"> <input
				type="submit" value="搜索">
		</form>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" cellspacing="0" cellpadding="10"
			border=0>
			<!-- 表头-->
			<thead>
				<tr align="center" id="TableTitle">
					<td>编号</td>
					<td>姓名</td>
					<td>联系电话</td>
					<td>照片</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach var="tmp" items="${requestScope.list.data}">
					<tr class="TableDetail1">
						<td>${pageScope.tmp.id }&nbsp;</td>
						<td><a
							href="${pageContext.request.contextPath}/showUser/${pageScope.tmp.id}">${pageScope.tmp.name}&nbsp;</a>
						</td>
						<td>${pageScope.tmp.phone}&nbsp;</td>
						<td>${pageScope.tmp.photoPath}&nbsp;</td>
						<td><a
							href="${pageContext.request.contextPath}/page/updateUser.jsp?id=${pageScope.tmp.id }&
							name=${pageScope.tmp.name }&phone=${pageScope.tmp.phone }&photoPath=${pageScope.tmp.photoPath}"
							class="FunctionButton">更新</a> <a
							href="${pageContext.request.contextPath}/deleteUser?id=${pageScope.tmp.id}"
							class="FunctionButton">删除</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6">
						<a href="${pageContext.request.contextPath}/showUsers?curPage=1">首页</a>
						<a href="${pageContext.request.contextPath}/showUsers?curPage=${requestScope.list.prePage}">上一页</a>
						<c:forEach var="i" begin="1" end="${requestScope.list.totalPage}" step="1">
							<a href="${pageContext.request.contextPath}/showUsers?curPage=${pageScope.i}">${pageScope.i}</a>
						</c:forEach>
						<a href="${pageContext.request.contextPath}/showUsers?curPage=${requestScope.list.nextPage}">下一页</a>
						<a href="${pageContext.request.contextPath}/showUsers?curPage=${requestScope.list.totalPage}">尾页</a>
						总共 ${requestScope.list.totalCount}条 ，${requestScope.list.totalPage}页
					</td>
				</tr>
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div class="FunctionButton">
				<a href="${pageContext.request.contextPath}/page/saveUser.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
