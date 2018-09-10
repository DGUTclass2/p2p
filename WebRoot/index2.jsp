<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页</title>
</head>

<body>
	<div class="daohang">
		<!-- 注册登录 -->
		<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid" style="background-color: white;">
			<div
				style="font-size: 14px; font-family: 宋体,微软雅黑; font-weight:bolder; width: 145px; height: 0px; margin-left: 46px; margin-top: 28px;">
				欢迎进入Bookstore!</div>
			<div style="width: 200px; float: right; margin-top: -12px;">
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${userId == null }">
						<li><a href="/bookStore/user/regi1.jsp"><span
								class="glyphicon glyphicon-user" style="color: black;">
									免费注册 </span></a></li>
						<li><a href="/bookStore/user/login.jsp"><span
								class="glyphicon glyphicon-log-in" style="color: black;">
									请登录 </span></a></li>
					</c:if>
					<c:if test="${userId != null }">
						<li><a href="/bookStore/user/userCenter.jsp"><span
								class="glyphicon glyphicon-log-in" style="color: black;">
									个人中心 </span></a></li>
						<li><a
							href="/bookStore/servlet/userServlet?type=cancellation"><span
								class="glyphicon glyphicon-log-in" style="color: black;">
									注销 </span></a></li>
					</c:if>
				</ul>
			</div>
		</div>
		</nav>
	</div>

	<div style="display: flex;">

		<div class="menus">
			<div class="list">
				<ul class="yiji">
	
					<li><a href="/bookStore/servlet/bookServlet?type=showAllGoods" class="inactive active" target="iframe">所有图书</a></li>
					<c:forEach items="${bookTypes }" var="bookType">
					<li><a href="/bookStore/servlet/bookServlet?type=getTypeBook&bookType=${bookType.bookType }" class="inactive active" target="iframe">${bookType.bookType }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="input">
			<form action="/bookStore/servlet/bookServlet?type=search" method="post">
			<div class="search1"
				style="width: 650px; height: 55px; display: flex; margin: auto;">
				<div style="width: 510px;">
					<input type="text" placeholder="Search" name="bookName"
						style="width: 500px; height: 42px; border: 2px solid #c7ae8f;">
				</div>
				<div style="width: 130px;">
					<button type="submit" class="search"
						style="width: 120px; height: 42px; background-color: #c7ae8f;">搜
						索</button>
				</div>
			</div>
			</form>
			<div id="myCarousel" class="carousel slide"
				style="width: 80%;height: 50%; margin: auto;">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="/bookStore/upload/images/lunbo/psb (1).jpg" alt="First slide"  style="width: 918px;height: 269px;">
					</div>
					<div class="item">
						<img src="/bookStore/upload/images/lunbo/psb (2).jpg" alt="Third slide" style="width:918px;height:269px;">
					</div>
					<div class="item">
						<img src="/bookStore/upload/images/lunbo/psb (3).jpg" alt="Third slide" style="width:918px;height:269px;">
					</div>
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel"
					data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
					href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>

			<div style="display: flex; margin:10px; margin-left: 140px;">
				<c:forEach items="${requestScope.bookes }" var="book">
					<div
						style="border: 1px solid #c7ae8f; width: 160px; height: 200px; margin-right: 14px;">
						<a
							href="/bookStore/servlet/bookServlet?type=showGoods&bookId=${book.bookId }">
							<img src="${book.imageUrl }" style="background-color: red;"
							width="160px" height="160px">
							<div style="text-align: center;">${book.bookName }</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>


	</div>
	</div>

	<div class="footstage">
		<div class="maintwo">
			<div style="display: flex;">
				<div class="in">
					<a href="">&#9658 首页</a>
				</div>
				<div class="in">
					<a href="">&#9658 联系我们</a>
				</div>
				<div class="in">
					<a href="">&#9658 招聘信息</a>
				</div>
				<div class="in">
					<a href="">&#9658 意见反馈</a>
				</div>
				<div class="in">
					<a href="">&#9658 联系我们</a>
				</div>

			</div>
			<div style="margin-top: 100px; text-align: center">2018
				东莞理工学院版权所有</div>
		</div>
</body>
</html>
<style type="text/css">
.daohang {
	/*background-color: white;*/
	border: 1px solid white;
	height: 70px;
	width: 100%;
}

.menus {
	background-color: #c7ae8f;
	/*border: 1px solid #c7ae8f;*/
	width: 225px;
	height: 535px;
	/* float: left;  */
	border-right: solid 2px #c7ae8f;
	margin-left: 60px;
	margin-top: 5px;
}

.input {
	/* background-color: rgb(120,150,150); */
	background-color: white;
	border: 1px solid white;
	width: 1150px;
	height: 540px;
	margin-top: 5px;
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
</style>

<!-- 导航条 -->
<style type="text/css">
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
	/*border-bottom:solid 1px white;*/
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
		$('.inactive').click(function() {
			if ($(this).siblings('ul').css('display') == 'none') {
				$(this).parent('li').siblings('li').removeClass('inactives');
				$(this).addClass('inactives');
				$(this).siblings('ul').slideDown(100).children('li');
				if ($(this).parents('li').siblings('li').children('ul').css('display') == 'block') {
					$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
					$(this).parents('li').siblings('li').children('ul').slideUp(100);
				}
			} else {
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
}
</style>