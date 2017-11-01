<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<head>
<title>Trang đăng nhập</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
		 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--js-->
<script src="js/jquery-2.1.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- <script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script> -->
<!--icons-css-->
<link href="css/font-awesome.css" rel="stylesheet" />
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css' />
<!--static chart-->
</head>
</head>
<body>
	<div class="login-page">
		<div class="login-main">
			<div class="login-head">
				<h1>Login</h1>
			</div>
			<div class="login-block">
				<form id="loginForm">
					<input type="text" name="taikhoan" placeholder="Tài khoản" required
						minlength="6" maxlength="18" /> <input type="password"
						name="matkhau" class="lock" placeholder="Mật khẩu" required
						minlength="8" />
					<div class="forgot-top-grids">
						<div class="forgot-grid">
							<ul>
								<li><input type="checkbox" id="brand1" value="" /> <label
									for="brand1"><span></span>Remember me</label></li>
							</ul>
						</div>
						<div class="forgot">
							<a href="#">Forgot password?</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<input type="submit" name="Sign In" value="Login" />
					<h3>
						Not a member?<a href="signup.html"> Sign up now</a>
					</h3>
					<h2>or login with</h2>
					<div class="login-icons">
						<ul>
							<li><a href="#" class="facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="google"><i
									class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</form>
				<h5>
					<a href="index.html">Go Back to Home</a>
				</h5>
			</div>
		</div>
	</div>
	<!--inner block end here-->
	<!--copy rights start here-->
	<div class="copyrights">
		<p>© 2016 Shoppy. All Rights Reserved | Design by W3layouts, but
			customize by Huỳnh Ngọc Thanh Xuân</p>
	</div>
	<!--COPY rights end here-->

	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<script src="js/bootstrap.js">
		
	</script>
	<script>
		$(document).ready(function() {
			$("#loginForm").on('submit', function(e) {
				alert("Đăng nhập thành công");
				window.location.href="http://localhost:8888/WebSiteQuanLyNghienCuuKhoaHocAdmin-Shoppy/index.jsp";
				return false;

			});
		});
	</script>
</body>
</html>