	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
	  <head>
	    <title>购买书籍</title>
	  </head>
	  
	  <body>
  <div class="tip">
         <form action="/bookStore/servlet/orderServlet?type=addCart&bookId=${book.bookId }&price=${book.price}" method="post" id="showform">
   <table border="frame" rules="all" class="word">
    <tr>
      <td class="td1">书名</td>
      <td class="td2">${book.bookName}</td>
    </tr>
    <tr>
      <td class="td1">类型</td>
      <td class="td2">${book.bookType}</td>
    </tr>
    <tr>
      <td class="td1">作者</td>
      <td class="td2">${book.author}</td>
    </tr>
    <tr>
      <td class="td1">图片</td>
      <td class="td2"><img src="${book.imageUrl}" alt="${book.bookName}" width="100px" height="160px"></td>
    </tr>
    <tr>
      <td class="td1">价格</td>
      <td class="td2">${book.price}</td>
    </tr>
    <tr>
      <td class="td1">库存</td>
      <td class="td2">${book.inventory}</td>
    </tr>
    <tr>
      <td class="td1">销量</td>
      <td class="td2">${book.sales}</td>
    </tr>
    <tr>
      <td class="td1">内容</td>
      <td class="td1">${book.introduction}</td>
    </tr>
    <tr>
      <td class="td1">发售时间</td>
      <td class="td2">${book.publishTime}</td>
    </tr>
    <tr>
      <td class="td1">出版时间</td>
      <td class="td2">${book.bookTime}</td>
    </tr>
    <tr>
      <td class="td1">购买个数</td>
      <td class="td2">
      <input type="button" value="-"  onclick="document.getElementById('showform').submit();">
      <input type="text" value="0" id="number" style="width:20px" name="number">
      <input type="button" value="+"  onclick="add()">
      </td>
    </tr>
    <tr style="text-align: center;">  
      <td colspan="2">
        <a href="javascript:void(0);" style="margin-right: 100px;" onclick="submit()">加入购物车</a>  
        <a href="/bookStore/servlet/orderServlet?type=showPay" style="margin-right: 100px;">结算</a> 
        <a href="/bookStore/servlet/bookServlet?type=showAllGoods">返回</a> 
      </td>
    </tr>
  </table>
  </form>
     </div>
	  </body>
	</html>
	<script type="text/javascript">
	
		function submit(){
			//提交
    	  	document.getElementById('showform').submit();
		}
		function sub(){
	        var txt=document.getElementById("number");
	        var a=txt.value;
	        if(a>1){
	            a--;
	            txt.value=a;
	        }else{
	            txt.value=1;
	        }
	        
	    }
	    function add(){
	        var txt=document.getElementById("number");
	        var a=txt.value;
	        a++;
	        txt.value=a;
	    }
	</script>
	
	<style type="text/css">
        .tip{
           /* border: 1px solid #906e40;
            box-shadow: 0px 8px 16px 0px #c7ae8f;*/
            width: 745px;
            height: 438px;
            font-size: 12px;
            font-family: 宋体，微软雅黑;
            font-weight: bold;
            margin: auto;
            margin:auto;
            
        }
         .top{
            /*background-color: rgb(45,45,45);*/
            background-color: #c7ae8f;
            width: 528px;
            height: 38px;
            color: white;
            font-size: 25px;
            font-weight: bold;
            font-padding:16px;
            text-align: center;
        }
         form{
          border: 0px;
         }
        
      
       .word{
        font-size: 16px;
        font-family: 宋体,微软雅黑；
         border: 1px solid #906e40;
       box-shadow: 0px 8px 16px 0px #c7ae8f;
       }

       .td1{
        width: 66px;
       }
        .td2{
        width: 600px;
       }

       
    </style>