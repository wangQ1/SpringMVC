<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>添加用户页面</title>
</head>
<body>
	添加新用户<br>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="${pageContext.request.contextPath}/saveUser" method="post" enctype="multipart/form-data">
			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				用户信息<br>
			</div>
			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td width="80px">姓名</td>
								<td><input type="text" name="name" class="InputStyle" value="" /> *</td>
							</tr>
							<tr>
								<td>联系电话</td>
								<td><input type="text" name="phone" class="InputStyle" value="" /> *</td>
							</tr>
							<tr>
								<td width="80px">照片</td>
								<td><input type="file" name="imageUrl" /> *</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" value="添加" class="FunctionButtonInput">
				<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>
	</div>
</body>
</html>
