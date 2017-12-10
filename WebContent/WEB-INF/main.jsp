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
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<!-- Bootstrap core CSS     -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<!--  Material Dashboard CSS    -->
<link href="css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
<!--     Fonts and icons     -->
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet" type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css' />
<title>Đăng Ký Đề Tài Nghiên Cứu KHKT</title>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-color="purple" data-image="images/sidebar-1.jpg">
			<div class="logo">
				<c:forEach items="${thongtin}" var="value">
					<a href="trangchu" class="simple-text">${value.getHoTen()}</a>
					<a href="trangchu" class="simple-text" style="font-size: 12px">${value.getTenLoaiNguoiDung()}</a>
				</c:forEach>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="active">
						<a href="#">
							<i class="material-icons">dashboard</i>
							<p>Trang Chủ</p>
						</a>
					</li>
					<li>
						<a href="thongtin">
							<i class="material-icons">person</i>
							<p>Thông tin cá nhân</p>
						</a>
					</li>
					<li>
						<a href="dangkydetai"> 
							<i class="material-icons">content_paste</i>
							<p>Danh sách đề tài</p>
						</a>
					</li>
					<li>
						<c:forEach items="${thongtin}" var='thongtin'>
							<c:if test="${thongtin.getMaLoaiNguoiDung() == 3}">
								<a href="DangKyDeTai"> 
									<i class="material-icons">library_books</i>
									<p>Đăng ký đề tài</p>
								</a>
							</c:if>
							<c:if test="${thongtin.getMaLoaiNguoiDung() == 4}">
								<a href="XacNhanHuongDan"> 
									<i class="material-icons">library_books</i>
									<p>Danh sách chờ xác nhận</p>
								</a>
							</c:if>
							<c:if test="${thongtin.getMaLoaiNguoiDung() == 5}">
								<a href="DanhSachChoDuyet"> 
									<i class="material-icons">library_books</i>
									<p>Danh sách chờ duyệt</p>
								</a>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<a href="ketquanghiemthu"> 
							<i class="material-icons">bubble_chart</i>
							<p>Xem kết quả nghiệm thu</p>
						</a>
					</li>
					<li>
						<a href="./notifications.html"> 
							<i class="material-icons text-gray">notifications</i>
							<p>Thông báo</p>
						</a>
					</li>
					<li class="active-pro">
						<a href="dangxuat"> 
							<i class="material-icons">unarchive</i>
							<p>Đăng xuất</p>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<div class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"> Trang Chủ </a>
					</div>
				</div>
			</div>
			<div class='content'>
				<div class="container-fluid">
					<h2>Thông báo về việc đăng ký đề tài nghiên cứu khoa học giảng
						viên và sinh viên năm học 2016 - 2017</h2>
					<h5>
						<span class="glyphicon glyphicon-time"></span> Được đăng bởi Xuân đẹp trai, 13/12/2017.
					</h5>
					<p>
						Để triển khai thực hiện các đề tài nghiên cứu khoa học (NCKH) cấp trường cho giảng viên và sinh viên trong năm học 2016 - 2017, đề nghị các Khoa tiến hành một số công việc như sau:
					</p>
					<p>
						1. Đối với đề tài NCKH giảng viên: giảng viên đăng ký đề tài NCKH cấp trường sẽ thực hiện trong năm học 2016 - 2017. Chủ nhiệm các đề tài thực hiện các hồ sơ sau:<br /> 
						- Phiếu đăng ký đề tài NCKH (BM01/QT01/QLKH)<br />
						- Thuyết minh đề tài NCKH (BM02/QT01/QLKH)<br />
						- Lý lịch khoa học của chủ nhiệm đề tài (BM03/QT01/QLKH) Dựa vào các hồ sơ nêu trên, Hội đồng khoa học Khoa đánh giá sơ bộ các đề tài NCKH của giảng viên theo mẫu Phiếu đánh giá đề tài NCKH (BM04/ QT01/QLKH). Khoa tổng hợp danh sách đề tài NCKH giảng viên theo biểu mẫu BM05/QT01/QLKH để gửi về cho P. QLKH-SĐH. <br />
						2. Đối với đề tài NCKH sinh viên: các Khoa triển khai cho sinh viên đăng ký đề tài NCKH thực hiện trong năm học 2016 - 2017 theo biểu mẫu BM01/QT02/NCKH. Khoa thực hiện đánh giá từng đề tài đăng ký theo biểu mẫu BM02/QT02/NCKH và tổng hợp danh sách đề tài NCKH sinh viên theo biểu mẫu BM03/QT02/NCKH để gửi về cho P. QLKH-SĐH. Các hồ sơ nêu trên gửi về P. QLKH – SĐH trước ngày 01/10/2016. Rất mong khoa quan tâm động viên giảng viên, sinh viên tích cực tham gia.</p>
				</div>
			</div>
			<footer class="footer">
			<div class="container-fluid">
				<p class="copyright pull-right">
					&copy;
					<script>
						document.write(new Date().getFullYear())
					</script>
					<a href="trangchu">Toàn - Xuân</a>, Đăng ký đề tài nghiên cứu khoa học kĩ thuật.
				</p>
			</div>
			</footer>
		</div>
	</div>
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
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<!-- Material Dashboard javascript methods -->
	<script src="js/material-dashboard.js?v=1.2.0"></script>
</body>
</html>