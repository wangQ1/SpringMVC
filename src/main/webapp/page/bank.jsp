<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my"%><!-- 引入自定义标签 -->
<%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/updateBalance" method="get">
		请输入取款金额：<input type="text" name="money"/>
		<my:token></my:token><!-- 前缀my:标签名 -->
		<input type="submit" value="取款" name="取款" >
	</form>
</body>
</html>