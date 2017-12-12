<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png" />
<link rel="icon" type="image/png" href="images/favicon.png" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<!-- Bootstrap core CSS     -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<!--  Material Dashboard CSS    -->
<link href="css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet" type='text/css' />
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css' />
<title>Đăng Ký Đề Tài Nghiên Cứu KHKT</title>
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/material.min.js" type="text/javascript"></script>
<!--  Charts Plugin -->
<script src="js/chartist.min.js"></script>
<!--  Dynamic Elements plugin -->
<script src="js/arrive.min.js"></script>
<!--  PerfectScrollbar Library -->
<script src="js/perfect-scrollbar.jquery.min.js"></script>
<!--  Notifications Plugin    -->
<script src="js/bootstrap-notify.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Material Dashboard javascript methods -->
<script src="js/material-dashboard.js?v=1.2.0"></script>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-color="purple"
			data-image="images/sidebar-1.jpg">
			<div class="logo">
				<c:forEach items="${thongtin}" var="value">
					<a href="trangchu" class="simple-text">${value.getHoTen()}</a>
					<a href="trangchu" class="simple-text" style="font-size: 12px">${value.getTenLoaiNguoiDung()}</a>
				</c:forEach>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="active"><a href="#"> <i class="material-icons">dashboard</i>
							<p>Trang Chủ</p>
					</a></li>
					<li><a href="thongtin"> <i class="material-icons">person</i>
							<p>Thông tin cá nhân</p>
					</a></li>
					<li><a href="detai"> <i class="material-icons">content_paste</i>
							<p>Danh sách đề tài</p>
					</a></li>
					<li><c:forEach items="${thongtin}" var='thongtin'>
							<c:if test="${thongtin.getMaLoaiNguoiDung() == 3}">
								<a href="DangKyDeTai"> <i class="material-icons">library_books</i>
									<p>Đăng ký đề tài</p>
								</a>
							</c:if>
							<c:if test="${thongtin.getMaLoaiNguoiDung() == 4}">
								<a href="XacNhanHuongDan"> <i class="material-icons">library_books</i>
									<p>Danh sách chờ xác nhận</p>
								</a>
							</c:if>
							<c:if test="${thongtin.getMaLoaiNguoiDung() == 5}">
								<a href="DanhSachChoDuyet"> <i class="material-icons">library_books</i>
									<p>Danh sách chờ duyệt</p>
								</a>
							</c:if>
						</c:forEach></li>
					<li><a href="ketquanghiemthu"> <i class="material-icons">bubble_chart</i>
							<p>Xem kết quả nghiệm thu</p>
					</a></li>
					<li><a href="./notifications.html"> <i
							class="material-icons text-gray">notifications</i>
							<p>Thông báo</p>
					</a></li>
					<li class="active-pro"><a href="dangxuat"> <i
							class="material-icons">unarchive</i>
							<p>Đăng xuất</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<div class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"> Trang Chủ </a>
					</div>
				</div>
			</div>
			<div class='content'>
				<form class="form-horizontal" action="GiaHanDeTai" method="post"
					id="reg_form">
					<!--<fieldset style="overflow: hidden;"> bỏ cái này là mất cái size cứng của form-->
					<input type="hidden" value="${maDeTai}" name="madetai" /> <input
						type="hidden" value="${maSinhVien}" name="masinhvien" />
					<div>
						<label class="col-md-4 control-label">Nhập ngày muốn gia
							hạn</label>
						<div class="col-md-8  inputGroupContainer">
							<input name="ngayxingiahan"
								placeholder="Nhập vào ngày muốn xin gia hạn"
								class="form-control" type="date" value="" />
						</div>
					</div>
					<div style="float:right;">
							<button type="submit" class="btn btn-info btn-lg">Xin
								gia hạn</button>
								<button type="submit" class="btn btn-info btn-lg"><a style="color:white;" href="trangchu">Về trang chủ</a></button>
					</div>
				</form>
			</div>
			<br />
		</div>
		</form>
	</div>
	<footer class="footer">
	<div class="container-fluid">
		<p class="copyright pull-right">
			&copy;
			<script>
				document.write(new Date().getFullYear())
			</script>
			<a href="trangchu">Toàn - Xuân</a>, Đăng ký đề tài nghiên cứu khoa
			học kĩ thuật.
		</p>
	</div>
	</footer>
	</div>
	</div>
</body>
</html>