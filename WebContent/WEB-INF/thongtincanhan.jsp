<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" type="image/png" href="images/favicon.png" />
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
<link rel='stylesheet' href='css/cmxform.css' type='text/css'/>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet" type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css' />
<title>Thông tin cá nhân</title>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-color="purple" data-image="images/sidebar-3.jpg">
			<div class="logo">
				<c:forEach items="${thongtin}" var="value">
					<a href="trangchu" class="simple-text">${value.getHoTen()}</a>
					<a href="trangchu" class="simple-text" style="font-size: 12px">${value.getTenLoaiNguoiDung()}</a>
				</c:forEach>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li>
						<a href="trangchu">
							<i class="material-icons">dashboard</i>
							<p>Trang Chủ</p>
						</a>
					</li>
					<li class="active">
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
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"> Thông tin cá nhân </a>
					</div>
				</div>
			</div>
			<div class='content'>
				<div class="container-fluid">
						<form action="thongtin" method='post' class="form-horizontal" id='thongtin-form'>
							<c:forEach items="${thongtin}" var="thongtin">
							<div class="form-group">
								<label class="control-label col-sm-4">Mã số sinh viên:</label>
								<div class="col-sm-4">
									<label class="control-label col-sm-4"><i>${thongtin.getTenDangNhap()}</i></label>
									<%-- <input type="text" class="form-control" value='${thongtin.getTenDangNhap()}'/> --%>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Họ và Tên:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id='hoten' name='hoten' value='${thongtin.getHoTen()}'/>
									<input type="text" id='idhoten' name='name' value='hoten'/>
								</div>
								<div class="col-sm-2">
									<input type='submit' class="btn btn-primary" id='savehoten' value='Lưu'/>
									<label id='cshoten'><a><i>Chỉnh sửa</i></a></label>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Giới tính:</label>
								<div class="col-sm-3">
									<c:if test="${thongtin.getGioiTinh()}">
										<input type="text" class="form-control" disabled="disabled" value='Nam'/>
									</c:if>
									<c:if test="${thongtin.getGioiTinh()==false}">
										<input type="text" class="form-control" disabled="disabled" value='Nữ'/>
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Ngày sinh:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" disabled="disabled" value='<fmt:formatDate value="${thongtin.getNgaySinh()}" pattern="dd-MM-yyyy"/>'></input>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Số điện thoại:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id='sdt' name='sodienthoai' value='${thongtin.getSoDienThoai()}'/>
									<input type='text' id='idsdt' name='name' value='sodienthoai'/>
								</div>
								<div class="col-sm-2">
									<input type='submit' class="btn btn-primary" id='savesdt' value='Lưu'/>
									<label id='cssdt'><a><i>Chỉnh sửa</i></a></label>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Địa chỉ:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id='diachi' name='diachi' value='${thongtin.getDiaChi()}'/>
									<input type='text' id='iddiachi' name='name' value='diachi'/>
								</div>
								<div class="col-sm-2">
									<input type='submit' class="btn btn-primary" id='savediachi' value='Lưu'/>
									<label id='csdiachi'><a><i>Chỉnh sửa</i></a></label>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Email:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id='email' name='email' value='${thongtin.getEmail()}'/>
									<input type='text' id='idemail' name='name' value='email'/>
								</div>
								<div class="col-sm-2">
									<input type='submit' class="btn btn-primary" id='saveemail' value='Lưu'/>
									<label id='csemail'><a><i>Chỉnh sửa</i></a></label>
								</div>
							</div>
							<c:if test="${thongtin.getMaLoaiNguoiDung()==3}">
								<div class="form-group">
									<label class="control-label col-sm-4">Lớp:</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" value='${thongtin.getLop()}'/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4">Khóa học:</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" value='${thongtin.getKhoaHoc()}'/>
									</div>
								</div>
							</c:if>
							<c:if test="${thongtin.getMaLoaiNguoiDung()==4}">
								<div class="form-group">
									<label class="control-label col-sm-4">Mã bộ môn:</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" value='${thongtin.getMaBoMon()}'/>
									</div>
								</div>
							</c:if>
							<c:if test="${thongtin.getMaLoaiNguoiDung()==5}">
								<div class="form-group">
									<label class="control-label col-sm-4">Mã bộ môn:</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" value='${thongtin.getMaBoMon()}'/>
									</div>
								</div>
							</c:if>
							<div class="form-group">
								<label class="control-label col-sm-4">Trạng thái:</label>
								<div class="col-sm-3">
									<c:if test="${thongtin.getTrangThaiNguoiDung()}">
										<c:if test="${thongtin.getMaLoaiNguoiDung()==2}">
											<input type="text" class="form-control" value='Khả dụng'/>
										</c:if>
										<c:if test="${thongtin.getMaLoaiNguoiDung()==3}">
											<input type="text" class="form-control" value='Còn đang học'/>
										</c:if>
										<c:if test="${thongtin.getMaLoaiNguoiDung()==4}">
											<input type="text" class="form-control" value='Còn đang dạy'/>
										</c:if>
										<c:if test="${thongtin.getMaLoaiNguoiDung()==5}">
											<input type="text" class="form-control" value='Còn đang dạy'/>
										</c:if>
									</c:if>
									<c:if test="${thongtin.getTrangThaiNguoiDung()==false}">
										<input type="text" class="form-control" value='Đã nghĩ'/>
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Loại người dùng:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" value='${thongtin.getTenLoaiNguoiDung()}'/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Mật khẩu:</label>
								<div class="col-sm-3">
									<input type="password" class="form-control" id='matkhau' name='matkhau' value='${thongtin.getMatKhau()}'/>
									<input type='text' id='idmatkhau' name='name' value='matkhau'/>
								</div>
								<div class="col-sm-2">
									<input type='submit' class="btn btn-primary" id='savemk' value='Lưu'/>
									<label id='csmatkhau'><a><i>Chỉnh sửa</i></a></label>
								</div>
							</div>
							<input type='hidden' name='manguoidung' value='${thongtin.getMaNguoiDung()}'/>
							</c:forEach>
							
						</form>
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
	
	<script type="text/javascript" src='js/jquery.validate.js'></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("input[type='text']").attr('disabled','disabled');
		$("input[type='password']").attr('disabled','disabled');
		$("#savehoten").hide();
		$("#savediachi").hide();
		$("#savesdt").hide();
		$("#savemk").hide();
		$("#saveemail").hide();
		
		$("#idhoten").hide();
		$("#iddiachi").hide();
		$("#idsdt").hide();
		$("#idmatkhau").hide();
		$("#idemail").hide();
		
	    $("#cshoten").click(function(){
	    	$("#hoten").removeAttr('disabled');
	    	$("#idhoten").removeAttr('disabled');
	    	$("#cshoten").hide();
	    	$("#savehoten").show();
	    });
	    $("#cssdt").click(function(){
	    	$("#sdt").removeAttr('disabled');
	    	$("#idsdt").removeAttr('disabled');
	    	$("#cssdt").hide();
	    	$("#savesdt").show();
	    });
	    $("#csdiachi").click(function(){
	    	$("#diachi").removeAttr('disabled');
	    	$("#iddiachi").removeAttr('disabled');
	    	$("#csdiachi").hide();
	    	$("#savediachi").show();
	    });
	    $("#csemail").click(function(){
	    	$("#email").removeAttr('disabled');
	    	$("#idemail").removeAttr('disabled');
	    	$("#csemail").hide();
	    	$("#saveemail").show();
	    });
	    $("#csmatkhau").click(function(){
	    	$("#matkhau").removeAttr('disabled');
	    	$("#idmatkhau").removeAttr('disabled');
	    	$("#csmatkhau").hide();
	    	$("#savemk").show();
	    });
	});
	</script>
	<script>
	$().ready(function() {

		// validate signup form on keyup and submit
		$("#thongtin-form").validate({
			rules: {
				hoten: {
					required: true,
					minlength: 1
				},
				matkhau: {
					required: true,
					minlength: 3
				},
				email: {
					required: true,
					minlength: 12,
					email: true
				},
			},
			messages: {
				hoten: {
					required: "*Vui lòng điền đầy đủ Họ và Tên",
					minlength: "*Tên tài khoản phải có ít nhất 3 ký tự"
				},
				matkhau: {
					required: "*Vui lòng điền mật khẩu",
					minlength: "*Mật khẩu có phải có ít nhất 3 ký tự"
				},
				email: {
					required: "*Vui lòng điền Email",
					minlength: "*Email phải có phải có ít nhất 12 ký tự",
					email: "Vui lòng điền đúng định dạng email!"
				},
			}
		});
	});
	</script>
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