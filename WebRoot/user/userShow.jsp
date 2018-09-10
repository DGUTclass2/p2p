<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看用户个人信息</title>
  </head>
  <body>
     <div class="tip">
         <!-- <div class="top" style="margin-top: 0px;">个人信息</div> -->
       
         <div class="con" >
         <!-- <div><p>欢迎注册！</p></div> -->
             <div >
              <div class="word">当前头像</div>
              <img src="${user.imageUrl }" width="100px" height="100px" style="border:1px solid"><br>
             </div>
             <div>
                <div class="word">用户名</div>
                ${user.userId }<br>
             </div>
             <div>
               <div class="word">昵称</div>
               ${user.nickName }<br>
             </div>
              <div>
               <div class="word">性别</div>
               ${user.sex }<br>
             </div>
             <div>
               <div class="word">个人简介</div>
               ${user.introduction }<br>
             </div>
             <div>
               <div class="word">收货地址</div>
               ${user.address }<br>
             </div>
         </div>
         </div>
  </body>
</html>
<style type="text/css">
        .tip{
            border: 1px solid #906e40;
            width: 528px;
            height: 500px;
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
           margin-top: -20px;
           font-size: 13px;
           font-family: 宋体,微软雅黑;
       }  
       form{
        border-radius: 1px solid blue;
       }
       .word{
        width: 65px;
        height: 20px;
        float: left;
		line-height: 0;
        margin-top: 10px;

        font-size: 13px;
        font-family: 宋体,微软雅黑；

       }
       .kuang{
        width: 342px;
        height: 32px;
       }
       div div div{
        margin-top: 50px;
       }
    </style>