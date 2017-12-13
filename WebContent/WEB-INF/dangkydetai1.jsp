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
						<a href="detai"> 
							<i class="material-icons">content_paste</i>
							<p>Danh sách đề tài</p>
						</a>
					</li>
					<c:forEach items="${thongtin}" var='thongtin'>
						<c:if test="${thongtin.getMaLoaiNguoiDung() == 3}">
							<li>
								<a href="dangkydetai"> 
									<i class="material-icons">library_books</i>
									<p>Đăng ký đề tài</p>
								</a>
							</li>
							<li>
								<a href="KetQuaPhanBien"> 
									<i class="material-icons">bubble_chart</i>
									<p>Xem kết quả phản biện</p>
								</a>
							</li>
							<li>
								<a href="KetQuaNghiemThu"> 
									<i class="material-icons">bubble_chart</i>
									<p>Xem kết quả nghiệm thu</p>
								</a>
							</li>
						</c:if>
						<c:if test="${thongtin.getMaLoaiNguoiDung() == 4}">
							<li>
								<a href="XacNhanHuongDan"> 
									<i class="material-icons">library_books</i>
									<p>Danh sách chờ xác nhận</p>
								</a>
							</li>
							<li>
								<a href="DanhGiaPhanBien"> 
									<i class="material-icons">bubble_chart</i>
									<p>Đánh giá phản biện</p>
								</a>
							</li>
							<li>
								<a href="DanhGiaNghiemThu"> 
									<i class="material-icons">bubble_chart</i>
									<p>Đánh giá nghiệm thu</p>
								</a>
							</li>
						</c:if>
						<c:if test="${thongtin.getMaLoaiNguoiDung() == 5}">
							<li>
								<a href="DanhSachChoDuyet"> 
									<i class="material-icons">library_books</i>
									<p>Danh sách chờ duyệt</p>
								</a>
							</li>
							<li>
								<a href="PhanCongPhanBien"> 
									<i class="material-icons">bubble_chart</i>
									<p>Phân công phản biện</p>
								</a>
							</li>
							<li>
								<a href="PhanCongNghiemThu"> 
									<i class="material-icons">bubble_chart</i>
									<p>Phân công nghiệm thu</p>
								</a>
							</li>
						</c:if>
					</c:forEach>
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
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"> Trang Chủ </a>
					</div>
				</div>
			</div>
			<div class='content'>
				<form class="form-horizontal" action="dangkydetai" method="post"
					id="reg_form">
					<!--<fieldset style="overflow: hidden;"> bỏ cái này là mất cái size cứng của form-->
					<legend> Đăng ký đề tài </legend>
					<br />
					<div class="form-group">
						<label class="col-md-4 control-label">Tên đề tài</label>
						<div class="col-md-8  inputGroupContainer">
							<input name="tendetai" placeholder="Nhập vào tên đề tài của bạn"
								class="form-control" type="text" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Mục tiêu</label>
						<div class="col-md-8  inputGroupContainer">
							<input name="muctieu" placeholder="Nhập vào mục tiêu của bạn"
								class="form-control" type="text" required/>
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
							<textarea name="tinhcapthiet" class="form-control" rows="5" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Lĩnh vực nghiên cứu</label>
						<div class="col-md-8  inputGroupContainer">
							<input name="linhvucnghiencuu"
								placeholder="Lĩnh vực của đề tài là gì?" class="form-control"
								type="text" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Phương pháp thực
							hiện</label>
						<div class="col-md-8  inputGroupContainer">
							<textarea name="phuongphapthuchien" class="form-control" rows="5"
								placeholder="Trình bày sơ lược phương pháp nghiên cứu" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Kinh phí dự kiến</label>
						<div class="col-md-8  inputGroupContainer">
							<textarea name="kinhphi" class="form-control" rows="5" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Thời gian bắt đầu
							nghiên cứu:</label>
						<div class="col-md-8 inputGroupContainer">
							<input type="date" class="form-control" name='thoigianbatdau' />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Thời gian kết thúc
							nghiên cứu:</label>
						<div class="col-md-8 inputGroupContainer">
							<input type="date" class="form-control" name='thoigianketthuc' required/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Mã giảng viên hướng
							dẫn</label>
						<div class="col-md-8 inputGroupContainer">
							<input name="magiangvienhuongdan"
								placeholder="Nhập vào mã giảng viên hướng dẫn"
								class="form-control" type="text" required/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-6" style="float:right;">
							<button type="submit" class="btn btn-primary">
								Gửi đơn
							</button>
						</div>
					</div>
					<!-- <div class="Thongtinsinhvien1">
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
									<label><input type="radio" name="gioitinh" value="1"/>Nam</label> <label><input
										type="radio" name="gioitinh" value="0"/>Nữ</label>
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
								<label class="col-md-4 control-label">Số tài khoản ngân
									hàng:</label>
								<div class="col-md-8 inputGroupContainer">
									<input type="text" class="form-control" name="taikhoannganhang"
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
							<div class="form-group">
								<div class="col-md-6">
									<button class="btn btn-primary" id="themthanhvien1">Thêm
										thành viên tham gia</button>
								</div>
								<div class="col-md-6">
									<button type="submit" class="btn btn-warning">
										Gửi đơn <span class="glyphicon glyphicon-send"></span>
									</button>
								</div>
							</div>
							<br /> -->
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
							<label><input type="radio" name="gioitinh" value="1" />Nam</label>
							<label><input type="radio" name="gioitinh" value="0" />Nữ</label>
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
						<label class="col-md-4 control-label">Số tài khoản ngân
							hàng:</label>
						<div class="col-md-8 inputGroupContainer">
							<input type="text" class="form-control" name="taikhoannganhang"
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
						<button class="btn btn-primary" id="themthanhvien2">Thêm
							thành viên tham gia</button>
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
						<label class="col-md-4 control-label">Số tài khoản ngân
							hàng:</label>
						<div class="col-md-8 inputGroupContainer">
							<input type="text" class="form-control" name="taikhoannganhang"
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