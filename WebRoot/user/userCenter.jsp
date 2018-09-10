<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>个人中心</title>
</head>

<body>
	<div class="daohang">
		<!-- 注册登录 -->
		<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<!-- 返回 -->
				<ul class="pager">
					<li class="previous"><a href="/bookStore/index.jsp"
						style="color: black; font-weight: bolder;">&#8630 返回</a></li>
				</ul>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/bookStore/user/userCenter.jsp" style="color: white;"><span
						class="glyphicon glyphicon-user"> 用户中心 </span></a></li>
				<li><a href="/bookStore/servlet/userServlet?type=cancellation" style="color: white;"><span
						class="glyphicon glyphicon-log-in"> 注销 </span></a></li>
			</ul>
		</div>
		</nav>
	</div>

	<div style="display: flex;">

		<div class="menus">
			<div class="list">
				<ul class="yiji">
					<li><a href="/bookStore/servlet/userServlet?type=show"
						class="inactive active" target="iframe">个人资料</a></li>
					<li><a href="/bookStore/user/changePassword.jsp"
						class="inactive active" target="iframe">修改密码</a></li>
					<li><a href="/bookStore/servlet/userServlet?type=showUpdate" 
						class="inactive active" target="iframe">修改个人信息</a></li>
					<li><a href="/bookStore/servlet/orderServlet?type=showCart" 
						class="inactive active" target="iframe">查看购物车</a></li>
				</ul>
			</div>
		</div>
		<div class="input">

			<iframe name="iframe" style="width: 100%; height: 100%; border:none;"></iframe>

		</div>
	</div>

	<div class="footstage">
		<div class="maintwo">
			<div style="display: flex;">
				<div class="in">
					<a href="#">&#9658 首页</a>
				</div>
				<div class="in">
					<a href="#">&#9658 公司简介</a>
				</div>
				<div class="in">
					<a href="#">&#9658 招聘信息</a>
				</div>
				<div class="in">
					<a href="#">&#9658 意见反馈</a>
				</div>
				<div class="in">
					<a href="#">&#9658 联系我们</a>
				</div>

			</div>
			<div style="margin-top: 100px; text-align: center">2018
				东莞理工学院版权所有</div>
		</div>
</body>
</html>
<style type="text/css">
.daohang {
	background-color: #c7ae8f;
	border: 1px solid white;
	height: 74px;
	width: 100%;
}

.menus {
	/*background-color: #c7ae8f;*/
	/*border: 1px solid #c7ae8f;*/
	width: 300px;
	height: 700px;
	border-right: solid 2px #c7ae8f;
}

.input {
	/* background-color: rgb(120,150,150); */
	background-color: white;
	border: 1px solid white;
	width: 1150px;
	height: 700px;
}

.footstage {
	border: 1px solid white;
	width: 100%;
	height: 280px;
	display: flex;
	background-color: rgb(71, 68, 67);
	/*  color: #ddd; */
	font-size: 15px;
	font-family: "Arial", "Hiragino Sans GB", \5fae\8f6f\96c5\9ed1,
		"Helvetica", "sans-serif";
}
/* 导航条 */
.container-fluid {
	background-color: #c7ae8f;
}
</style>


<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!-- 返回的按钮 -->
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</style>

<!-- 目录 -->
<style type="text/css">
* {
	margin: 0;
	padding: 0
}

body {
	font-size: 14px;
	font-family: "宋体", "微软雅黑";
}

ul, li {
	list-style: none;
}

a:link, a:visited {
	text-decoration: none;
	color: #ddd;
}

.list {
	width: 298px;
	border-bottom: solid 1px white;
}

.list ul li {
	padding-left: 20px;
}

.list ul li a {
	padding-left: 10px;
	color: black;
	font-size: 14px;
	display: block;
	font-weight: bolder;
	height: 36px;
	line-height: 36px;
	position: relative;
}
</style>

<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.inactive').click(function(){
			if($(this).siblings('ul').css('display')=='none'){
				$(this).parent('li').siblings('li').removeClass('inactives');
				$(this).addClass('inactives');
				$(this).siblings('ul').slideDown(100).children('li');
				if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
					$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
					$(this).parents('li').siblings('li').children('ul').slideUp(100);
				}
			}else{
				//控制自身变成+号
				$(this).removeClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').slideUp(100);
				//控制自身子菜单变成+号
				$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').children('li').children('ul').slideUp(100);
				//控制同级菜单只保持一个是展开的（-号显示）
				$(this).siblings('ul').children('li').children('a').removeClass('inactives');
			}
		})
	});
	</script>

<!-- 页脚 -->
<style>
.maintwo {
	margin-left: 80px;
	/*width: 520px;*/
	height: 250px;
	text-align: right;
	line-height: 19px;
	margin-left: 270px;
	color: #ddd
}

.in {
	color: black;
	width: 140px;
	height: 28px;
	margin-top: 118px;
	/*  padding: 16px; */
}
</style>