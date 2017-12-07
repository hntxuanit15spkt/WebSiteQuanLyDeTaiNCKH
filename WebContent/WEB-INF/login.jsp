<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Đăng nhập</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--js-->
<script src="js/jquery-3.2.1.min.js"></script>
<!--icons-css-->
<link href="css/font-awesome.css" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="login-page">
		<div class="login-main">
			<div class="login-head">
				<h1>Đăng nhập</h1>
			</div>
			<div class="login-block">
				<form id="login-form" action="dangnhap" method='post' style='text-align:center'>
					<div class="row">
					  <div class="col-sm-12">
						<label class="radio-inline">
							<input type="radio" name="loainguoidung" value='3' checked="checked">Nghiên cứu viên</label>
						<label class="radio-inline">
							<input type="radio" name="loainguoidung" value='4'>Giảng viên</label>
						<label class="radio-inline">
							<input type="radio" name="loainguoidung" value='5'>Hội đồng kiểm duyệt</label>
						<label class="radio-inline" style='color: navy;'>
							<input type="radio" name="loainguoidung" value='1'>Admin</label>
						<label class="radio-inline" style='color: navy;'>
							<input type="radio" name="loainguoidung" value='2'>Quản lí</label>
					  </div>
					</div>
						
					<input type="text" name="username" placeholder="Tài khoản" />
					<input type="password" name="password" class="lock" placeholder="Mật khẩu" id="cpassword"/>
					<div class="forgot-top-grids">
						<div class="forgot-grid">
							<ul>
								<li><input type="checkbox" id="brand1" value=""/><label
									for="brand1"> <span></span>Remember me
								</label></li>
							</ul>
						</div>
						<div class="forgot">
							<a href="#">Forgot password?</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<input type="submit" name="login" value="Login"/>
				</form>
			</div>
		</div>
	</div>
	<SCRIPT type="text/javascript" src="js/jquery.validate.js"></SCRIPT>
	<script>
	/* $.validator.setDefaults({
		submitHandler: function() {
			alert("Đã đăng nhập!");
		}
	}); */

	$().ready(function() {

		// validate signup form on keyup and submit
		$("#login-form").validate({
			rules: {
				username: {
					required: true,
					minlength: 3
				},
				password: {
					required: true,
					minlength: 3
				},
			},
			messages: {
				username: {
					required: "*Vui lòng điền tên tài khoản",
					minlength: "*Tên tài khoản phải có ít nhất 3 ký tự"
				},
				password: {
					required: "*Vui lòng điền mật khẩu",
					minlength: "*Mật khẩu có phải có ít nhất 3 ký tự"
				},
			}
		});
	});
	</script>
</body>
</html>
