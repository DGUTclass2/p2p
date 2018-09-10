<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员注册</title>
  </head>
  <body>
  <form action="/bookStore/servlet/managerServlet?type=register" method="post" onsubmit="return submit1()">
		<fieldset style="width: 300px;">
			<legend>管理员注册</legend>
			<input type="text" name="managerId" placeholder="请输入管理员账号" id="managerId" onblur="valName()">
			<span id="namespan" class="Span"></span><br>
			<input type="password" name="password" placeholder="请输入密码" id="password" onblur="valPassword()">
			<span id="passwordspan" class="Span"></span><br>
			<input type="password" name="Repassword" placeholder="请重新输入密码" id="Repassword" onblur="passwordSame()">
			<span id="Repasswordspan" class="Span"></span><br>
			<input type="text" name="e_mail" placeholder="请输入E-mail地址" id="e_mail" onblur="valmail()">
			<span id="E_mailspan" class="Span"></span><br>
			<input type="submit" value="提交">
			<input type="button" value="返回" onclick="window.location.href='/bookStore/manage.jsp'">
		</fieldset>
	</form>
  </body>
</html>
<script type="text/javascript">
	function valName(){
		var pattern = new RegExp("^[a-z]([a-z0-9])*[-_]?([a-z0-9]+)$","i");//创建模式对象
		var str1=document.getElementById("managerId").value;//获取文本框的内容
		
		if(document.getElementById("managerId").value==null || document.getElementById("managerId").value==""){
			document.getElementById("namespan").innerHTML="*不能为空";
			return false;
		}else if(str1.length>=8 && pattern.test(str1)){//pattern.test() 模式如果匹配，会返回true，不匹配返回false
			document.getElementById("namespan").innerHTML="ok";
			return true;
		}else{
			document.getElementById("namespan").innerHTML="*用户名至少需要8个字符，以字母开头，以字母或数字结尾，可以有-和_";
			return false;
		}
	}

	function valPassword(){
		var str = document.getElementById("password").value;
		var pattern=/^(\w){6,20}$/;
		
		if(document.getElementById("password").value==null || document.getElementById("password").value==""){
			document.getElementById("passwordspan").innerHTML="*不能为空";
			return false;
		}else if(str.match(pattern)==null){
			document.getElementById("passwordspan").innerHTML="*密码只能输入6-20个字母、数字、下划线";
			return false;
		}else{
			document.getElementById("passwordspan").innerHTML="ok";
			return true;
		}
	}

	function valmail(){
		var str = document.getElementById("E_mail").value;
		var pattern=/^.+@[^\.].*\.[a-z]{2,}$/;
		
		if(document.getElementById("E_mail").value==null || document.getElementById("E_mail").value==""){
			document.getElementById("E_mailspan").innerHTML="*不能为空";
			return false;
		}else if(str.match(pattern)==null){
			document.getElementById("E_mailspan").innerHTML="*E-mail格式有误";
			return false;
		}else{
			document.getElementById("E_mailspan").innerHTML="ok";
			return true;
		}
	}

	function passwordSame(){
		if(document.getElementById("Repassword").value==null || document.getElementById("Repassword").value==""){
			document.getElementById("Repasswordspan").innerHTML="*不能为空";
			return false;
		}else if(document.getElementById("password").value==document.getElementById("Repassword").value){			
			document.getElementById("Repasswordspan").innerHTML="ok";
			return true ;
		}else{
			document.getElementById("Repasswordspan").innerHTML="*两次密码不一样";
			return false;
		}
				
	}

	function submit1(){
		result1=valName();
		result1=valPassword() && result1;
		result1=passwordSame() && result1;
		result1=valmail() && result1;
		
		if( result1)
			return true;//提交
		else 
			return false;//阻止提交
	}
</script>
