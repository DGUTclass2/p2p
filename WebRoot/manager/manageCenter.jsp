<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员中心</title>
  </head>
  
  <body>
    <div class="tip">
         <div class="top" style="margin-top: 0px;">管理者</div>
       
         <div class="con">
             <div>
               <div class="word"><a href="/bookStore/servlet/managerServlet?type=cancellation">管理员注销</a></div>
               <br>
             </div>
             <div>
               <div class="word"><a href="/bookStore/servlet/managerServlet?type=showAllUser">用户账号管理</a></div>
               <br>
             </div>
             <div>
               <div class="word"><a href="/bookStore/servlet/managerServlet?type=showAllManager">管理员账号管理</a></div>
               <br>
             </div>
             <div>
               <div class="word"><a href="/bookStore/book/addBook.jsp">添加书籍信息</a></div>
               <br>
             </div>
             <div>
               <div class="word"><a href="/bookStore/servlet/bookServlet?type=showAll">查看所有书籍</a></div>
               <br>
             </div>
             <div>
               <div class="word"><a href="#">查看所有订单</a></div>
               <br>
             </div>
         </div>
        </div>
  </body>
</html>
 <style type="text/css">
        .tip{
            border: 1px solid #906e40;
            width: 528px;
            height: 400px;
            /*box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);*/
            box-shadow: 0px 8px 16px 0px #c7ae8f;
            font-family: 宋体，微软雅黑；
            margin: auto;
            margin-left: 30%;
            margin-top: 4%;
        }
         .top{
            background-color: #c7ae8f;
            width: 528px;
            height: 38px;
            color: white;
            font-size: 25px;
            font-weight: bold;
            font-padding:16px;
            text-align: center;
        }
         .con{
           /* background-color: green; */
           width: 528px;
           height: 273px;
           margin-left: 30px;
       }
       .buttontwo{
           width: 200px;
           height: 76px;
           margin: 0 auto;
           display: flex;
           margin-top: -20px;
           font-size: 13px;
           font-family: 宋体,微软雅黑;
       }  
      
       .word{
        width: 160px;
        height: 20px;
        float: left;
        margin-top: 10px;
        font-size: 18px;
        font-family: 宋体,微软雅黑；
       }
       div div div{
        margin-top: 20px;
       }
       a{color: #906e40;}
    </style>