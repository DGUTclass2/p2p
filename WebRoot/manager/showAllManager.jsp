<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员列表</title>
  </head>
  
  <body>
	<form action="/bookStore/servlet/managerServlet?type=showAllManager" id="showform" method="post">
		<table align="center" border="frame" rules="all"> 
			<tr bgcolor="#FFACAC">
				<td><a href="javascript:void(0);" onclick="getOnePage('','managerId')">管理员名</a></td>
				<td>E-mail</td><td>权限</td><td> </td><td> </td>
			</tr>
			<c:forEach items="${requestScope.managers}"  var="manager">
			<tr>
				<td>${manager.managerId }</td>
				<td>${manager.e_mail }</td>
				<td>${manager.limits }</td>
				<td><a href="#">禁用</a></td>
				<td><a href="#">修改</a></td>
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
