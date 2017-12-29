<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册页面</title>
<!--
   <link rel="stylesheet" type="text/css" href="styles.css">
   -->
<script type="text/javascript">//js函数
	function checkSubmit() {
			//校验 不通过不提交
		/*   前端校验(不安全)
		var userName = document.getElementsByName("userName")[0].value;
	    if(userName == null || userName == ""){
	      alert("用户名不能为空");
	      return;
	    }
		        var password = document.getElementsByName("password")[0].value;
	    if(password == null || password.trim() == ""){
	      alert("密码不能为空");
	      return;
	    }
	    var rePassword = document.getElementsByName("rePassword")[0].value;
	    if(rePassword == null || rePassword.trim() == ""){
	      alert("重复密码不能为空");
	      return;
	    }
	    if(rePassword != password){
	      alert("两次密码不一致");
	      return;
	    }
	    */
	    document.forms[0].submit(); //手动提交
	}
</script>
</head>
<body>
	<form action="<%=path %>/reg" method="post">
		用 户 名:<input type="text" name="userName" />
		<font color=red><form:errors path="userInfo.userName"/></font><br />
		密 码&nbsp; :<input type="password" name="password" />
		<font color=red><form:errors path="userInfo.password"/></font><br />
		重复密码:<input type="password" name="rePassword" />
		<font color=red><form:errors path="userInfo.rePassword"/></font><br />
		邮 件&nbsp; :<input type="text" name="email" />
		<font color=red><form:errors path="userInfo.email"/></font><br />
		年 龄&nbsp; :<input type="text" name="age" />
		<font color=red><form:errors path="userInfo.age"/></font><br />
		手 机 号:<input type="text" name="phone" />
		<font color=red><form:errors path="userInfo.phone"/></font><br />
		<input type="button" onclick="checkSubmit()" value="注册" /> <!-- 调用js函数 -->
	</form>
	<br />
</body>
</html>
