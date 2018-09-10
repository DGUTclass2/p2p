<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
  </head>
  
  <body>
	<form action="/bookStore/servlet/userServlet?type=login" method="post" >
		 <div class="tip">
         <div class="top" style="margin-top: 0px;">用户登录</div>
       
         <div class="con" >
         <!-- <div><p>欢迎注册！</p></div> -->
             <div >
              <div class="word">账号</div>
              <input type="text" name="userId" id="userId" class="kuang"><br>
             </div>

             <div>
               <div class="word">密码</div>
               <input type="password" name="password" id="password" class="kuang"><br>
             </div>

             </div>
         <div class="buttontwo">
             <div>
                 <input type="submit" value="确认提交" style="font-size: 20px; background-color: #c7ae8f;">
             </div>
             <div style="margin-left: 30px;">
                 <input type="button" onclick="window.location.href='/bookStore/index.jsp'" value="返回" style="font-size: 20px; background-color: #c7ae8f;" />
             </div>
         </div>
     </div>
	</form>
  </body>
</html>
    <style type="text/css">
        .tip{
            border: 1px solid #906e40;
            width: 528px;
            height: 400px;
            /*box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);*/
            box-shadow: 0px 8px 16px 0px #c7ae8f;
            font-size: 12px;
            font-family: 宋体，微软雅黑；
            margin: auto;
            margin-left: 30%;
            margin-top: 4%;
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
           margin-top: -100px;
           font-size: 14px;
           font-family: 宋体,微软雅黑;
       }  
       form{
        border-radius: 1px solid blue;
       }
       .word{
        width: 65px;
        height: 20px;
        float: left;

        margin-top: 6px;

        font-size: 20px;
        font-family: 宋体,微软雅黑；

       }
       .kuang{
        width: 356px;
        height: 36px;
       }
       div div{
        margin-top: 70px;
       }
    </style>