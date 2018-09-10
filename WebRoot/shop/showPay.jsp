<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>显示结算信息</title>
</head>

<body>
	<form action="/bookStore/servlet/orderServlet?type=pay" method="post">
		<div class="tip">
			<div class="top" style="margin-top: 0px;">填写快递信息</div>

			<div class="con">
				<!-- <div><p>欢迎注册！</p></div> -->
				<div>
					<h2>你需要支付：${totalPrice }元</h2>
				</div>
				<div>
					<div class="word">收件人</div>
					<input type="text" name="recipient" id="recipient" class="kuang">
				</div>

				<div>
					<label class="word">电话号码</label> <input type="text" name="phone"
						id="phone" class="kuang">
				</div>

				<div>
					<div class="word">邮政编码</div>
					<input type="text" name="code" id="code" class="kuang">
				</div>

				<div>
					<div class="word">收货地址</div>
					<input type="text" name="address" id="address"
						class="kuang"><br>
				</div>

			</div>
			<div class="buttontwo">
				<div>
					<input type="submit" value="支付"
						style="font-size: 13px; background-color: #c7ae8f;">
				</div>
				<div style="margin-left: 30px;">
					<input type="button" value="使用个人信息地址"
						style="font-size: 13px; background-color: #c7ae8f;" onclick="add('${address}')">
				</div>
				<div style="margin-left: 30px;">
					<input type="button"
						onclick="window.location.href='/bookStore/servlet/orderServlet?type=showPay'" value="返回"
						style="font-size: 13px;  background-color: #c7ae8f;" />
				</div>
			</div>
		</div>
	</form>
</body>
</html>
<script type="text/javascript">
    function add(adress){
        var txt=document.getElementById("address");
        txt.value=adress;
    }
</script>

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
           margin-top: 24px;
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

        margin-top: 6px;

        font-size: 13px;
        font-family: 宋体,微软雅黑；

       }
       .kuang{
        width: 342px;
        height: 28px;
       }
       div div{
        margin-top: 15px;
       }
    </style>