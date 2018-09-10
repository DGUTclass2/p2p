<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Document</title>
  </head>
  
  <body>
  <h1>用户</h1>
 	<p>
 		用户登录模块
 		<a href="/bookStore/user/regi1.jsp">用户注册</a>
 		<c:if test="${userId == null }">
 			 <a href="/bookStore/user/login.jsp">用户登录</a>
 		</c:if>
 		<c:if test="${userId!=null }">
 			<a href="/bookStore/servlet/userServlet?type=cancellation">注销登录</a>
 		</c:if>
 	</p>
 	<p>
 		用户个人中心
 		<a href="/bookStore/servlet/userServlet?type=show">用户信息显示</a>
 		<a href="/bookStore/user/changePassword.jsp">修改密码</a>
 	</p>
 	<p>
		用户购书模块
		<a href="/bookStore/servlet/bookServlet?type=showAllGoods">购买书籍</a>
		<a href="/bookStore/servlet/orderServlet?type=showCart">查看购物车</a>
		<a href="#">查看个人订单</a>
	</p>
 	<h1>管理员</h1>
	<p>
		管理员登录模块
		<a href="/bookStore/manager/regiManager.jsp">管理员注册</a>
		<a href="/bookStore/manager/loginManager.jsp">管理员登录</a>
		<a href="/bookStore/servlet/managerServlet?type=cancellation">管理员注销</a>
	</p>
	<p>
		账号管理模块
		<a href="/bookStore/servlet/managerServlet?type=showAllUser">用户账号管理</a>
		<a href="/bookStore/servlet/managerServlet?type=showAllManager">管理员账号管理</a>
	</p>
	<p>
		书籍管理模块
		<a href="/bookStore/book/addBook.jsp">添加书籍信息</a>
		<a href="/bookStore/servlet/bookServlet?type=showAll">查看所有书籍</a>
		<a href="#">查看所有订单</a>
	</p>
  </body>
</html>

