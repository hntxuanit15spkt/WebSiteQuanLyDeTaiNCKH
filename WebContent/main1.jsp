<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- <c:if test="${sessionScope.user != 'Thanh Xuân' }">
	<c:redirect url="login.jsp"></c:redirect>
</c:if> --%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 







</script>
<title>Website quản lý đăng ký đề tài nghiên cứu khoa học</title>
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery-2.1.1.min.js"></script>
<!--icons-css-->
<link href="css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<div class="page-container">
		<div class="left-content">
			<jsp:include page="/WEB-INF/left-content.jsp" />
		</div>
		<script>
			$(function() {
				$("#datepicker_content").datepicker();
			});
		</script>
		<div class="sidebar-menu">
			<jsp:include page="/WEB-INF/sidebar-menu.jsp" />
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		$(document).ready(function() {
			var navoffeset = $(".header-main").offset().top;
			$(window).scroll(function() {
				var scrollpos = $(window).scrollTop();
				if (scrollpos >= navoffeset) {
					$(".header-main").addClass("fixed");
				} else {
					$(".header-main").removeClass("fixed");
				}
			});
		});
	</script>
	<script>
		var toggle = true;
		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"

						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}
					toggle = !toggle;
				});
	</script>
	<!-- <script>
		var toggle = true;
		/*Chỗ này đã bỏ đi lớp page-container nên nó không cuốn lại được*/
		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"

						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}
					toggle = !toggle;
				});
	</script> -->
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<div class="clearfix"></div>
	<script src="js/modalEffects.js"></script>
	<script src="js/cssParser.js"></script>
	<script src="js/classie.js"></script>
</body>
</html>