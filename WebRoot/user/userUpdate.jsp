<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改用户信息</title>
</head>

<body>
	<form action="/bookStore/servlet/userServlet?type=update" method="post" enctype="multipart/form-data">
	<table>
		
		<tr>
			<td>账号</td>
			<td><input type="text" name="userId" value="${User.userId }"
				id="userId" disabled="disabled"></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><input type="text" name="e_mail" value="${User.e_mail }"
				id="e_mail" disabled="disabled"></td>
		</tr>
		<tr>
			<td>昵称</td>
			<td><input type="text" name="nickName" value="${User.nickName }"
				id="nickName"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><select name="sex"><option value="男">男</option>
					<option value="女">女</option></select></td>
		</tr>
		<tr>
			<td>修改头像</td>
			<td><input type="file" name="imageUrl"></td>
		</tr>
		<tr>
			<td>个人简介</td>
			<td><textarea name="introduction" cols="32" rows="7" warp="hard">${User.introduction }</textarea></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" name="address" value="${User.address }"
				id="address"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="修改"> <input
				type="button" value="返回"
				onclick="window.location.href='/bookStore/user/userShow.jsp'"></td>
		</tr>
	</table>
	</form>
</body>
</html>
