<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录</title>
  </head>
  
  <body>
    <form action="/bookStore/servlet/managerServlet?type=login" method="post" >
		<fieldset style="width: 400px;">
			<legend>用户注册</legend>
			<input type="text" name="managerId" placeholder="账号" id="managerId" ><br>
			<input type="password" name="password" placeholder="密码" id="password" ><br>
			<input type="submit" value="提交">
			<input type="button" value="返回" onclick="window.location.href='/bookStore/manager/manageCenter.jsp'">
		</fieldset>
	</form>
  </body>
</html>
