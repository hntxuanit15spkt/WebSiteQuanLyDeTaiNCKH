<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost/quanlydetainghiencuukhoahoc" user="root"
	password="15110376" />

<c:if test="${not empty param.login}">
	<sql:query var="taikhoan" dataSource="${db}"
		sql="select * from NguoiDung where TaiKhoan='${param.username}' and MatKhau='${param['password']}'" />
	<c:if test="${taikhoan!=null }">
		<c:set var="user" value="${taikhoan.rows[0].TenNguoiDung }"
			scope="session" />
		<c:redirect url="main.jsp" />
	</c:if>
</c:if>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Đăng nhập</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!-- <script type="application/x-javascript">
		 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script> -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--js-->
<script src="js/jquery-2.1.1.min.js"></script>
<!--icons-css-->
<link href="css/font-awesome.css" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="login-page">
		<div class="login-main">
			<div class="login-head">
				<h1>Login</h1>
			</div>
			<div class="login-block">
				<form id="login-form" action="login.jsp" method='post'>
					<input type="text" name="username" placeholder="Tài khoản" /> <input
						type="password" name="password" class="lock"
						placeholder="Mật khẩu">
					<div class="forgot-top-grids">
						<div class="forgot-grid">
							<ul>
								<li><input type="checkbox" id="brand1" value=""><label
									for="brand1"> <span></span>Remember me
								</label></li>
							</ul>
						</div>
						<div class="forgot">
							<a href="#">Forgot password?</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<input type="submit" name="login" value="Login">
					<h3>
						Not a member? <a href="signup.html"> Sign up now</a>
					</h3>
					<h2>or login with</h2>
					<div class="login-icons">
						<ul>
							<li><a href="#" class="facebook"> <i
									class="fa fa-facebook"></i>
							</a></li>
							<li><a href="#" class="twitter"> <i
									class="fa fa-twitter"></i>
							</a></li>
							<li><a href="#" class="google"> <i
									class="fa fa-google-plus"></i>
							</a></li>
						</ul>
					</div>
				</form>
				<h5>
					<a href="index.html">Go Back to Home</a>
				</h5>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#login-form").submit(function() {
				window.location.href = "http://www.stackoverflow.com";
			});
		});
	</script>
</body>
</html>