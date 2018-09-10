<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>展示商品</title>
</head>
<body>
	<form action="/bookStore/servlet/bookServlet?type=showAllGoods" id="showform" method="post">

		<c:forEach items="${requestScope.bookes}" var="book">
			<div class="tip">
				<div class="con">
					<div style="display: flex;">
						<div
							style="border: 1px solid #c7ae8f; width: 200px; height: 200px; margin-top: 20px;">
							<img src="${book.imageUrl }" width="200px" height="200px;">
						</div>
						<div style="margin-left: 30px">
							<div class="word">${book.bookName }</div>
							<div class="word">价格：${book.price }</div>
							<div class="word">销量：${book.sales }</div>
							<div class="word">库存：${book.inventory }</div>
							<div class="word" style="display: flex; width: 300px;">
								<a
									href="/bookStore/servlet/bookServlet?type=showGoods&bookId=${book.bookId }"
									style="margin-right: 30px;">查看详情</a> <a
									href="/bookStore/servlet/orderServlet?type=addCart&bookId=${book.bookId }&price=${book.price}&number=1">加入购入车</a>
							</div>
						</div>
						<br>
					</div>
				</div>
			</div>
		</c:forEach>



		<div style="display: flex; width: 500px; margin:50px auto;">
		<c:if test="${requestScope.pageInformation.page> 1 }">
			<div style="width: 80px; height: 50px;">
				<a href="javascript:void(0;)" onclick="getOnePage('first','');">首页</a>
			</div>
		</c:if>
		<c:if test="${requestScope.pageInformation.page> 1 }">
			<div style="width: 80px; height: 50px;">
				<a href="javascript:void(0);" onclick="getOnePage('pre','');">上一页</a>
			</div>
		</c:if>
		<c:if test="${requestScope.pageInformation.page < requestScope.pageInformation.totalPageCount }">
			<div style="width: 80px; height: 50px;">
				<a href="javascript:void(0);" onclick="getOnePage('next','');">下一页</a>
			</div>
		</c:if>
		<c:if test="${requestScope.pageInformation.page < requestScope.pageInformation.totalPageCount }">
			<div style="width: 80px; height: 50px;">
				<a href="javascript:void(0);" onclick="getOnePage('last','');">尾页</a>
			</div>
		</c:if>
			<div style="width: 80px; height: 50px;">
				共${requestScope.pageInformation.totalPageCount }页</div>
			<div style="width: 80px; height: 50px;">
				<a href="/bookStore/index.jsp">返回首页</a>
			</div>
		</div>
		
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


<style type="text/css">
.tip {
	border: 1px solid #906e40;
	width: 980px;
	height: 240px;
	/*box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);*/
	box-shadow: 0px 8px 16px 0px #c7ae8f;
	font-size: 12px;
	margin: auto;
	margin-top: 4%;
	font-family: 宋体，微软雅黑；
}

.top {
	/*background-color: rgb(45,45,45);*/
	background-color: #c7ae8f;
	width: 528px;
	height: 38px;
	color: white;
	font-size: 25px;
	font-weight: bold;
	font-padding: 16px;
	text-align: center;
}

.con {
	/* background-color: green; */
	width: 528px;
	height: 273px;
	margin-left: 30px;
}

.word {
	width: 200px;
	height: 20px;
	margin-top: 20px;
}
</style>