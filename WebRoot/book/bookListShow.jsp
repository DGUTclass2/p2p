<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>书目一览</title>
  </head>
  
  <body>
  	<form action="/bookStore/servlet/bookServlet?type=showAll" id="showform" method="post">
  	<table align="center" border="frame" rules="all"> 
  		<tr bgcolor="#FFACAC">
  			<td>书籍Id</td>
  			<td>书名</td>
  			<td>类型</td>
  			<td>作者</td>
  			<td>价格</td>
  			<td>存库</td>
  			<td>销量</td>
  			<td>发售时间</td>
  			<td>出版时间</td>
  			<td>图片</td>
  			<td>&nbsp</td><td>&nbsp</td>
  		</tr>
  		<c:forEach items="${requestScope.bookes}" var="bookes">
  			<tr>
  				<td>${bookes.bookId }</td>
  				<td><a href="/bookStore/servlet/bookServlet?type=show&bookId=${bookes.bookId}">${bookes.bookName }</a></td>
  				<td>${bookes.bookType }</td>
  				<td>${bookes.author }</td>
  				<td>${bookes.price }</td>
  				<td>${bookes.inventory }</td>
  				<td>${bookes.sales }</td>
  				<td>${bookes.publishTime }</td>
  				<td>${bookes.bookTime }</td>
  				<td><img alt="图片" src="${bookes.imageUrl }" width="100px;" height="160px;"></td>
  				<td><a href="/bookStore/servlet/bookServlet?type=edit&bookId=${bookes.bookId}">编辑</a></td>
  				<td><a href="/bookStore/servlet/bookServlet?type=delete&bookId=${bookes.bookId}">删除</a></td>
  			</tr>
  		</c:forEach>
  	</table>
  	<table align="center" border="frame" rules="all"> 
			<tr>
				<c:if test="${requestScope.pageInformation.page> 1 }">
					<td><a href="javascript:void(0;)" onclick="getOnePage('first','');">首页</a></td>
				</c:if>
				
				<c:if test="${requestScope.pageInformation.page> 1 }">
					<td><a href="javascript:void(0;)" onclick="getOnePage('pre','');">上一页</a></td>
				</c:if>
				
				<c:if test="${requestScope.pageInformation.page < requestScope.pageInformation.totalPageCount }">
					<td><a href="javascript:void(0;)" onclick="getOnePage('next','');">下一页</a></td>
				</c:if>
				
				<c:if test="${requestScope.pageInformation.page < requestScope.pageInformation.totalPageCount }">
					<td><a href="javascript:void(0;)" onclick="getOnePage('last','');">尾页</a></td>
				</c:if>
				<td>共${requestScope.pageInformation.totalPageCount }页</td>
				<td><a href="/bookStore/manager/manageCenter.jsp">返回首页</a></td>
			</tr>
		</table>
		
		<input type="hidden" name="page" id="page" value="${pageInformation.page}">
		<input type="hidden" name="pageSize" id="pageSize" value="${pageInformation.pageSize}">
	 	<input type="hidden" name="totalPageCount" id="totalPageCount" value="${pageInformation.totalPageCount}">
		<input type="hidden" name="allRecordCount" id="allRecordCount" value="${pageInformation.allRecordCount}">
	 	<input type="hidden" name="orderField" id="orderField" value="${pageInformation.orderField}">
		<input type="hidden" name="order" id="order" value="${pageInformation.order}">
		<input type="hidden" name="searchSql" id="searchSql" value="${pageInformation.searSql}">
	 	<input type="hidden" name="result" id="result" value="${pageInformation.result}">
	 	<input type="hidden" name="ids" id="ids" value="${pageInformation.ids}">
	 	</form>
  </body>
</html>
<script type="text/javascript">

      function getOnePage(type,orderFieldName){
    	  	var url1;
    	  	var page=document.getElementById("page");
    	  	var pageSize=document.getElementById("pageSize");
    	  	var totalPageCount=document.getElementById("totalPageCount");
    	  	
  			var order=document.getElementById("order");
  			var orderField=document.getElementById("orderField");
			
			if(orderFieldName!=""){//切换排序
				orderField.value=orderFieldName;//设置排序字段名
				if(order.value == "asc")//切换排序
					order.value="desc";
				else
					order.value="asc";	
					
				page.value=1;//排序后从第一页开始显示												
			}
			
    	  	pageValue=parseInt(page.value);
    	  	if(type=="first")
    	  		page.value="1";
    	  	else if(type=="pre"){
    	  		pageValue-=1;
    	  		page.value=pageValue.toString();
    	  	}else if(type=="next"){
    	  		pageValue+=1;
    	  		page.value=pageValue.toString();
    	  	}else if(type=="last"){
    	  		page.value=totalPageCount.value;
    	  	}
    	  	//提交
    	  	document.getElementById('showform').submit();
      	}
	</script> 