<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示书籍信息</title>
  </head>
  
  <body>
   <table border="frame" rules="all">
		<tr>
			<td>bookId</td>
			<td width="300px">${book.bookId}</td>
		</tr>
		<tr>
			<td>书名</td>
			<td>${book.bookName}</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>${book.bookType}</td>
		</tr>
		<tr>
			<td>作者</td>
			<td>${book.author}</td>
		</tr>
		<tr>
			<td>图片</td>
			<td><img src="${book.imageUrl}" alt="${book.bookName}" width="100px" height="160px"></td>
		</tr>
		<tr>
			<td>价格</td>
			<td>${book.price}</td>
		</tr>
		<tr>
			<td>库存</td>
			<td>${book.inventory}</td>
		</tr>
		<tr>
			<td>销量</td>
			<td>${book.sales}</td>
		</tr>
		<tr>
			<td>内容</td>
			<td height="200px">${book.introduction}</td>
		</tr>
		<tr>
			<td>发售时间</td>
			<td>${book.publishTime}</td>
		</tr>
		<tr>
			<td>出版时间</td>
			<td>${book.bookTime}</td>
		</tr>
		<tr>	
			<td colspan="2">
				<a href="/bookStore/servlet/bookServlet?type=edit&bookId=${book.bookId }">修改</a> 
				<a href="/bookStore/servlet/bookServlet?type=showAll">返回</a> 
				<a href="/bookStore/manager/manageCenter.jsp">首页</a> 
			</td>
		</tr>
	</table>
  </body>
</html>
