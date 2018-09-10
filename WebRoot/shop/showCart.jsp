<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>展示购物车</title>
  </head>
  
  <body>
   	<table align="center" border="frame" rules="all">
		<tr bgcolor="orange">
			<th  colspan="2" width="300px">订单号:${orderlistId }</th>
			<th>单价</th><th>数量</th><th> </th>
			
		</tr>
		<c:forEach items="${requestScope.carts}"  var="cart">
		<tr>
			<td width="100px"><img src="${cart.imageUrl }" width="100px" height="100px"></td>
			<td>${cart.bookName }</td>
			<td width="100px">${cart.price }</td>
			<td width="100px">${cart.number }</td>
			<td width="100px"><a href="#">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<a href="/bookStore/servlet/orderServlet?type=showPay">结算</a> 
				<a href="/bookStore/index.jsp">返回首页</a>
			</td>
		</tr>
	</table>
	
  </body>
</html>
