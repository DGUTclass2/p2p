<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户基本信息注册</title>
</head>

<body>
	<form action="/bookStore/servlet/userServlet?type=regi1" method="post"
		onsubmit="return submit1()">
		<div class="tip">
			<div class="top" style="margin-top: 0px;">用户注册</div>

			<div class="con">
				<!-- <div><p>欢迎注册！</p></div> -->
				<div>
					<div class="word">用户名</div>
					<input type="text" name="userId" placeholder="" id="userId"
						onblur="valName()" class="kuang"> <span id="namespan"
						class="Span"></span><br>
				</div>
				<div>
					<div class="word">邮箱</div>
					<input type="text" name="E_mail" placeholder="" id="E_mail"
						onblur="valmail()" class="kuang"> <span id="E_mailspan"
						class="Span"></span><br>
				</div>
				<div>
					<div class="word">密码</div>
					<input type="password" name="password" placeholder="" id="password"
						onblur="valPassword()" class="kuang"> <span
						id="passwordspan" class="Span"></span><br>
				</div>
				<div>
					<div class="word">确认密码</div>
					<input type="password" name="Repassword" placeholder=""
						id="Repassword" onblur="passwordSame()" class="kuang"> <span
						id="Repasswordspan" class="Span"></span><br>
				</div>
			</div>
			<div class="buttontwo">
				<div>
					<input type="submit" value="确认提交"
						style="font-size: 13px; background-color: #c7ae8f;">
				</div>
				<div style="margin-left: 30px;">
					<input type="button"
						onclick="window.location.href='/bookStore/index.jsp'" value="返回"
						style="font-size: 13px; background-color: #c7ae8f;" />
				</div>
			</div>
		</div>
	</form>
</body>
</html>

<style type="text/css">
.tip {
	border: 1px solid #906e40;
	width: 528px;
	height: 400px;
	/*box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);*/
	box-shadow: 0px 8px 16px 0px #c7ae8f;
	font-size: 12px;
	font-family: 宋体，微软雅黑； margin : auto;
	margin-left: 30%;
	margin-top: 4%;
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

.buttontwo {
	width: 200px;
	height: 76px;
	margin: 0 auto;
	display: flex;
	margin-top: -20px;
	font-size: 13px;
	font-family: 宋体, 微软雅黑;
}

form {
	border-radius: 1px solid blue;
}

.word {
	width: 65px;
	height: 20px;
	float: left;
	margin-top: 10px;
	font-size: 13px;
	font-family: 宋体, 微软雅黑；
}

.kuang {
	width: 342px;
	height: 32px;
}

div div {
	margin-top: 25px;
}
</style>

<script type="text/javascript">
	function valName() {
		var pattern = new RegExp("^[a-z]([a-z0-9])*[-_]?([a-z0-9]+)$", "i"); //创建模式对象
		var str1 = document.getElementById("userId").value; //获取文本框的内容

		if (document.getElementById("userId").value == null || document.getElementById("userId").value == "") {
			document.getElementById("namespan").innerHTML = "*不能为空";
			return false;
		} else if (str1.length >= 8 && pattern.test(str1)) { //pattern.test() 模式如果匹配，会返回true，不匹配返回false
			document.getElementById("namespan").innerHTML = "ok";
			return true;
		} else {
			document.getElementById("namespan").innerHTML = "*用户名至少需要8个字符，以字母开头，以字母或数字结尾，可以有-和_";
			return false;
		}
	}

	function valPassword() {
		var str = document.getElementById("password").value;
		var pattern = /^(\w){6,20}$/;

		if (document.getElementById("password").value == null || document.getElementById("password").value == "") {
			document.getElementById("passwordspan").innerHTML = "*不能为空";
			return false;
		} else if (str.match(pattern) == null) {
			document.getElementById("passwordspan").innerHTML = "*密码只能输入6-20个字母、数字、下划线";
			return false;
		} else {
			document.getElementById("passwordspan").innerHTML = "ok";
			return true;
		}
	}

	function valmail() {
		var str = document.getElementById("E_mail").value;
		var pattern = /^.+@[^\.].*\.[a-z]{2,}$/;

		if (document.getElementById("E_mail").value == null || document.getElementById("E_mail").value == "") {
			document.getElementById("E_mailspan").innerHTML = "*不能为空";
			return false;
		} else if (str.match(pattern) == null) {
			document.getElementById("E_mailspan").innerHTML = "*E-mail格式有误";
			return false;
		} else {
			document.getElementById("E_mailspan").innerHTML = "ok";
			return true;
		}
	}

	function passwordSame() {
		if (document.getElementById("Repassword").value == null || document.getElementById("Repassword").value == "") {
			document.getElementById("Repasswordspan").innerHTML = "*不能为空";
			return false;
		} else if (document.getElementById("password").value == document.getElementById("Repassword").value) {
			document.getElementById("Repasswordspan").innerHTML = "ok";
			return true;
		} else {
			document.getElementById("Repasswordspan").innerHTML = "*两次密码不一样";
			return false;
		}

	}

	function submit1() {
		result1 = valName();
		result1 = valPassword() && result1;
		result1 = passwordSame() && result1;
		result1 = valmail() && result1;

		if (result1)
			return true; //提交
		else
			return false; //阻止提交
	}
</script>
