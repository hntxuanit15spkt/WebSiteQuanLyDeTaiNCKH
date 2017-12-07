<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost/quanlydetainghiencuukhoahoc" user="root"
	password="15110376" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/datepicker.css" rel="stylesheet" type="text/css" />
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
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" href="/resources/demos/style.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap-timepicker.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" href="/resources/demos/style.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<%!String tenKhoa = "";%>
	<div class="page-container">
		<div class="left-content">
			<div class="mother-grid-inner">
				<div class="header-main">
					<jsp:include page="/WEB-INF/header-main.jsp" />
				</div>
				<div class="inner-block">
					<div class="blank">
						<!-- <div class="container"> -->
							<form class="form-horizontal" action=" " method="post"
								id="reg_form">
								<!--<fieldset style="overflow: hidden;"> bỏ cái này là mất cái size cứng của form-->
								<legend> Đăng ký đề tài </legend>
								<br />
								<div class="form-group">
									<label class="col-md-4 control-label">Tên đề tài</label>
									<div class="col-md-8  inputGroupContainer">
										<input name="tendetai"
											placeholder="Nhập vào tên đề tài của bạn"
											class="form-control" type="text" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Mục tiêu</label>
									<div class="col-md-8  inputGroupContainer">
										<input name="muctieu" placeholder="Nhập vào mục tiêu của bạn"
											class="form-control" type="text" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Mô tả ý tưởng</label>
									<div class="col-md-8  inputGroupContainer">
										<textarea name="motaytuong" class="form-control" rows="5"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Tính cấp thiết</label>
									<div class="col-md-8  inputGroupContainer">
										<textarea name="tinhcapthiet" class="form-control" rows="5"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Lĩnh vực nghiên
										cứu</label>
									<div class="col-md-8  inputGroupContainer">
										<input name="linhvucnghiencuu"
											placeholder="Lĩnh vực của đề tài là gì?" class="form-control"
											type="text" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Phương pháp thực
										hiện</label>
									<div class="col-md-8  inputGroupContainer">
										<textarea name="phuongphapthuchien" class="form-control"
											rows="5"
											placeholder="Trình bày sơ lược phương pháp nghiên cứu"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Kinh phí dự kiến</label>
									<div class="col-md-8  inputGroupContainer">
										<textarea name="kinhphi" class="form-control" rows="5"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Mã giảng viên
										hướng dẫn</label>
									<div class="col-md-8 inputGroupContainer">
										<input name="magiangvienhuongdan"
											placeholder="Nhập vào mã giảng viên hướng dẫn"
											class="form-control" type="text" />
									</div>
								</div>
								<!-- <div class="Thongtinsinhvien1"> -->
								<legend> Thông tin các thành viên tham gia </legend>
								<div class=col-md-6>
									<div class="form-group">
										<label class="col-md-4 control-label">Họ tên:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="text" class="form-control" name="hoten"
												placeholder="Nhập vào họ tên" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Mã số sinh viên:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="text" class="form-control" name="masosinhvien"
												placeholder="Nhập vào mã số sinh viên" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Bạn là sinh viên
											khóa:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="text" class="form-control" name="khoahoc"
												placeholder="Nhập vào khóa mà bạn đang theo học" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Ngày sinh:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="date" class="form-control" name='ngaysinh' />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Địa chỉ:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="text" class="form-control" name="diachi"
												placeholder="Nhập vào địa chỉ" />
										</div>
									</div>

								</div>

								<div class=col-md-6>
									<div class="form-group">
										<label class="col-md-4 control-label">Giới tính:</label>
										<div class="radio">
											<label><input type="radio" name="gioitinh" />Nam</label> <label><input
												type="radio" name="gioitinh" />Nữ</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Mã số lớp:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="text" class="form-control" name="masolop"
												placeholder="Nhập vào mã số sinh viên" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Số tài khoản
											ngân hàng:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="text" class="form-control"
												name="taikhoannganhang"
												placeholder="Nhập vào số tài khoản ngân hàng" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Số điện thoại:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="text" class="form-control" name="sodienthoai"
												placeholder="Nhập vào số điện thoại" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Email:</label>
										<div class="col-md-8 inputGroupContainer">
											<input type="text" class="form-control" name="email"
												placeholder="Nhập vào email" />
										</div>
									</div>

									<!-- </div> -->
									<div class="form-group">
										<div class="col-md-6">
											<button class="btn btn-primary" id="themthanhvien1">Thêm thành viên tham
												gia</button>
										</div>
										<div class="col-md-6">
											<button type="submit" class="btn btn-warning">
												Gửi đơn <span class="glyphicon glyphicon-send"></span>
											</button>
										</div>
									</div>
									<br />

								</div>
								<div class="Thongtinsinhvien2" style="display: none;">
									<legend> Thông tin các thành viên tham gia </legend>
									<div class=col-md-6>
										<div class="form-group">
											<label class="col-md-4 control-label">Họ tên:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="hoten"
													placeholder="Nhập vào họ tên" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Mã số sinh
												viên:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="masosinhvien"
													placeholder="Nhập vào mã số sinh viên" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Bạn là sinh
												viên khóa:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="khoahoc"
													placeholder="Nhập vào khóa mà bạn đang theo học" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Ngày sinh:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="date" class="form-control" name='ngaysinh' />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Địa chỉ:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="diachi"
													placeholder="Nhập vào địa chỉ" />
											</div>
										</div>

									</div>

									<div class=col-md-6>
										<div class="form-group">
											<label class="col-md-4 control-label">Giới tính:</label>
											<div class="radio">
												<label><input type="radio" name="gioitinh" />Nam</label> <label><input
													type="radio" name="gioitinh" />Nữ</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Mã số lớp:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="masolop"
													placeholder="Nhập vào mã số sinh viên" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Số tài khoản
												ngân hàng:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control"
													name="taikhoannganhang"
													placeholder="Nhập vào số tài khoản ngân hàng" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Số điện thoại:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="sodienthoai"
													placeholder="Nhập vào số điện thoại" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Email:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="email"
													placeholder="Nhập vào email" />
											</div>
										</div>

									</div>
									<div class="form-group">
										<div class="col-md-6">
											<button class="btn btn-primary" id="themthanhvien2">Thêm thành viên tham
												gia</button>
										</div>
										<div class="col-md-6">
											<button type="submit" class="btn btn-warning">
												Gửi đơn <span class="glyphicon glyphicon-send"></span>
											</button>
										</div>
									</div>
									<br />

								</div>
								<div class="Thongtinsinhvien3" style="display: none;">
									<legend> Thông tin các thành viên tham gia </legend>
									<div class=col-md-6>
										<div class="form-group">
											<label class="col-md-4 control-label">Họ tên:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="hoten"
													placeholder="Nhập vào họ tên" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Mã số sinh
												viên:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="masosinhvien"
													placeholder="Nhập vào mã số sinh viên" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Bạn là sinh
												viên khóa:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="khoahoc"
													placeholder="Nhập vào khóa mà bạn đang theo học" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Ngày sinh:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="date" class="form-control" name='ngaysinh' />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Địa chỉ:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="diachi"
													placeholder="Nhập vào địa chỉ" />
											</div>
										</div>

									</div>

									<div class=col-md-6>
										<div class="form-group">
											<label class="col-md-4 control-label">Giới tính:</label>
											<div class="radio">
												<label><input type="radio" name="gioitinh" />Nam</label> <label><input
													type="radio" name="gioitinh" />Nữ</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Mã số lớp:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="masolop"
													placeholder="Nhập vào mã số sinh viên" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Số tài khoản
												ngân hàng:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control"
													name="taikhoannganhang"
													placeholder="Nhập vào số tài khoản ngân hàng" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Số điện thoại:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="sodienthoai"
													placeholder="Nhập vào số điện thoại" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Email:</label>
											<div class="col-md-8 inputGroupContainer">
												<input type="text" class="form-control" name="email"
													placeholder="Nhập vào email" />
											</div>
										</div>

										<!-- 									</div> -->
										<div class="form-group">
											<!-- <div class="col-md-6">
												<button class="btn btn-primary" id="themthanhvien3">Thêm thành viên tham gia</button>
											</div> -->
											<div class="col-md-6">
												<button type="submit" class="btn btn-warning">
													Gửi đơn <span class="glyphicon glyphicon-send"></span>
												</button>
											</div>
										</div>
										<br />
									</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="copyrights">
		<p>
			© 2016 Shoppy. All Rights Reserved | Design by <a
				href="http://w3layouts.com/" target="_blank">W3layouts</a>
		</p>
	</div>
	<div class="sidebar-menu">
		<jsp:include page="/WEB-INF/sidebar-menu.jsp" />
	</div>
	<div class="clearfix"></div>
	<script>
		$('#themthanhvien1').click(function{
			$('.Thongtinsinhvien2').show();
		});
	</script>
</body>
</html>