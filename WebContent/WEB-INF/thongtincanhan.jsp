<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="ThayDoi" method='post' class="form-horizontal" id='thongtin-form'>
		<c:forEach items="${thongtinnguoidung}" var="thongtin">
		<div class="form-group">
			<label class="control-label col-sm-2">Tên đăng nhập:</label>
			<div class="col-sm-2">
				<label class="control-label col-sm-2"><i>${thongtin.getTenDangNhap()}</i></label>
				<%-- <input type="text" class="form-control" value='${thongtin.getTenDangNhap()}'/> --%>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Họ và Tên:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id='hoten' name='hoten' value='${thongtin.getHoTen()}'/>
				<input type="text" id='idhoten' name='name' value='hoten'/>
			</div>
			<div class="col-sm-1">
				<input type='submit' class="btn btn-primary" id='savehoten' value='Lưu'/>
				<label id='cshoten'><a><i>Chỉnh sửa</i></a></label>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Giới tính:</label>
			<div class="col-sm-2">
				<c:if test="${thongtin.getGioiTinh()}">
					<input type="text" class="form-control" disabled="disabled" value='Nam'/>
				</c:if>
				<c:if test="${thongtin.getGioiTinh()==false}">
					<input type="text" class="form-control" disabled="disabled" value='Nữ'/>
				</c:if>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Ngày sinh:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" disabled="disabled" value='${thongtin.getNgaySinh()}'></input>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Số điện thoại:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id='sdt' name='sodienthoai' value='${thongtin.getSoDienThoai()}'/>
				<input type='text' id='idsdt' name='name' value='sodienthoai'/>
			</div>
			<div class="col-sm-1">
				<input type='submit' class="btn btn-primary" id='savesdt' value='Lưu'/>
				<label id='cssdt'><a><i>Chỉnh sửa</i></a></label>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Địa chỉ:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id='diachi' name='diachi' value='${thongtin.getDiaChi()}'/>
				<input type='text' id='iddiachi' name='name' value='diachi'/>
			</div>
			<div class="col-sm-1">
				<input type='submit' class="btn btn-primary" id='savediachi' value='Lưu'/>
				<label id='csdiachi'><a><i>Chỉnh sửa</i></a></label>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Email:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id='email' name='email' value='${thongtin.getEmail()}'/>
				<input type='text' id='idemail' name='name' value='email'/>
			</div>
			<div class="col-sm-1">
				<input type='submit' class="btn btn-primary" id='saveemail' value='Lưu'/>
				<label id='csemail'><a><i>Chỉnh sửa</i></a></label>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Mã số:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" value='${thongtin.getMaSo()}'/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Lớp:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" value='${thongtin.getLop()}'/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Khóa học:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" value='${thongtin.getKhoaHoc()}'/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Trạng thái:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" value='${thongtin.getTrangThaiNguoiDung()}'/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Loại người dùng:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" value='${thongtin.getTenLoaiNguoiDung()}'/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Mật khẩu:</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id='matkhau' name='matkhau' value='${thongtin.getMatKhau()}'/>
				<input type='text' id='idmatkhau' name='name' value='matkhau'/>
			</div>
			<div class="col-sm-1">
				<input type='submit' class="btn btn-primary" id='savemk' value='Lưu'/>
				<label id='csmatkhau'><a><i>Chỉnh sửa</i></a></label>
			</div>
		</div>
		<input type='hidden' name='manguoidung' value='${thongtin.getMaNguoiDung()}'/>
		</c:forEach>
		
	</form>
	
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
</body>
</html>