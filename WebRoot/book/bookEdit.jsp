 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>修改书籍信息</title>
	<script src='/bookStore/plugin/utf8-jsp/ueditor.config.js'	type="text/javascript"></script>
	<script src='/bookStore/plugin/utf8-jsp/ueditor.all.min.js'	type="text/javascript"></script>
	<script src='/bookStore/plugin/utf8-jsp/lang/zh-cn/zh-cn.js'	type="text/javascript"></script>
  </head>
  
  <body>
    <form action="/bookStore/servlet/bookServlet?type=update&bookId=${book.bookId }" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td>书名</td><td><input type="text" name="bookName" id="bookName" value="${book.bookName }"></td>
		</tr>
		<tr>
			<td>作者</td><td><input type="text" name="author" id="author" value="${book.author }"></td>
		</tr>
		<tr>
			<td>类型</td><td><select name="bookType">
				<c:forEach items="${bookTypes }" var="bookType">
					<li><a href="/bookStore/servlet/bookServlet?type=getTypeBook&bookType=${bookType.bookType }" class="inactive active" target="iframe">${bookType.bookType }</a></li>
				</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>价格</td><td><input type="text" name="price"  id="price" value="${book.price }"></td>
		</tr>	
		<tr>
			<td>存库</td><td><input type="text" name="inventory"  id="inventory" value="${book.inventory }"></td>
		</tr>	
		<tr>
			<td>图片</td><td><input type="file" name="imageUrl"></td>
		</tr>
		<tr>
			<td>书籍简介</td><td><div><script id="content" type="text/plain" style="width:800px;height:500px;">${book.introduction}</script></div></td>
		</tr>
		<tr>
			<td>出版时间</td><td><input type="datetime-local" name="bookTime" id="bookTime" value="${book.bookTime }"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="添加">
			<input type="button" value="返回" onclick="window.location.href='/bookStore/manager/manageCenter.jsp'">
			<input type="hidden" value="${book.bookId }" name="bookId"></td>
		</tr>
	</table>
	</form>
  </body>
</html>
<script type="text/javascript">
	
	    //实例化编辑器
	    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	    var ue = UE.getEditor('content');
	</script>