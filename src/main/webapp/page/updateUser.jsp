<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">更新新菜品</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 文件上传
   表单 必须是post
    设置编码格式   application/x-www-form-urlencoded (不支持文件上传)
            multipart/form-data（支持文件上传）
 文件选择框  input type=file

-->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="${pageContext.request.contextPath}/updateUser/${param.id}"
			method="post" enctype="multipart/form-data">
			<input type='hidden' name="_method" value="put">
			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				个人信息
			</div>
			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td width="80px">姓名</td>
								<td><input type="text" name="name" class="InputStyle"
									value="${param.name}" /> *</td>
							</tr>
							<tr>
								<td>联系电话</td>
								<td><input type="text" name="phone" class="InputStyle"
									value="${param.phone}" /> *</td>
							</tr>
							<tr>
								<td width="80px">照片</td>
								<td><img style='width:68px;height:68px'
									src="${pageContext.request.contextPath}/images/${param.photoPath}">
									<input type="file" name="imageUrl"/> * 
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" value="修改" class="FunctionButtonInput">
				<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>
	</div>
</body>
</html>
