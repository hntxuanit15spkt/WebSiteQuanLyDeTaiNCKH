<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<link rel="icon" type="image/png" href="images/favicon.png" />
<!-- Bootstrap core CSS     -->
<link href="css/bootstrap.min.css" rel="stylesheet" type='text/css' />
<!--  Material Dashboard CSS    -->
<link href="css/material-dashboard.css?v=1.2.0" rel="stylesheet"
	type='text/css' />
<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet" type='text/css' />
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css' />
<link href="css/fresh-bootstrap-table.css" rel="stylesheet"
	type='text/css' />
<title>Chi Tiết đề tài</title>
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
						<a class="navbar-brand" href="#"> Danh sách đề tài </a>
					</div>
				</div>
			</div>
			<div class='content'>
				<div class="container-fluid">
					<div class="col-md-12">
						<div class="fresh-table toolbar-color-azure">
							<div class="toolbar">
								<button id="alertBtn" class="btn btn-default">Danh sách
									các đề tài</button>
							</div>

							<table id="fresh-table" class="table">
								<thead>
									<tr>
										<th data-field="id" data-sortable="true">Tên đề tài</th>
										<th data-field="name" data-sortable="true">Mục tiêu</th>
										<th data-field="city" data-sortable="true">Trạng thái</th>
										<th data-field="salary" data-sortable="true">Thời gian
											bắt đầu</th>
										<th data-field="country" data-sortable="true">Thời gian
											kết thúc</th>
										<th data-field="country" data-sortable="true">Thời gian
											phản biện</th>
										<th data-field="actions">Operation</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${detai}" var="detai">
										<tr>
											<td>${detai.getTenDeTai() }</td>
											<td>${detai.getMucTieu() }</td>
											<td><i>${detai.getTenTrangThai()}</i></td>
											<td><fmt:formatDate
													value="${detai.getThoiGianBatDau() }" pattern="dd-MM-yyyy" /></td>
											<td><fmt:formatDate
													value="${detai.getThoiGianKetThuc() }" pattern="dd-MM-yyyy" /></td>
											<td><fmt:formatDate
													value="${detai.getThoiGianPhanBien() }"
													pattern="dd-MM-yyyy" /></td>
											<td><a href="ChiTietDeTai?madetai=${detai.getMaDeTai()}"
												class="btn btn-danger"> <span><strong>Chi
															tiết</strong></span>
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class='content' id='chitiet'>
				<form class="form-horizontal" action="dangkydetai" method="post"
					id="chitietdetai_form">
					<!--<fieldset style="overflow: hidden;"> bỏ cái này là mất cái size cứng của form-->
					<legend> Chi tiết đề tài: </legend>
					<c:forEach items="${chitietdetai}" var="chitiet">
						<div class="form-group">
							<label class="col-md-4 control-label">Tên đề tài</label>
							<div class="col-md-8  inputGroupContainer">
								<input name="tendetai" class="form-control" type="text"
									value='${chitiet.getTenDeTai()}' />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Mục tiêu</label>
							<div class="col-md-8  inputGroupContainer">
								<input name="muctieu" class="form-control" type="text"
									value="${chitiet.getMucTieu()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Mô tả ý tưởng</label>
							<div class="col-md-8  inputGroupContainer">
								<textarea name="motaytuong" class="form-control" rows="5">${chitiet.getMoTaYTuong()}</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Tính cấp thiết</label>
							<div class="col-md-8  inputGroupContainer">
								<textarea name="tinhcapthiet" class="form-control" rows="5">${chitiet.getTinhCapThiet()}</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Lĩnh vực nghiên cứu</label>
							<div class="col-md-8  inputGroupContainer">
								<input name="linhvucnghiencuu" class="form-control" type="text"
									value='${chitiet.getLinhVucNghienCuu()}' />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Phương pháp thực
								hiện</label>
							<div class="col-md-8  inputGroupContainer">
								<textarea name="phuongphapthuchien" class="form-control"
									rows="5" placeholder="Trình bày sơ lược phương pháp nghiên cứu">${chitiet.getPhuongPhapThucHien()}</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Kinh phí dự kiến</label>
							<div class="col-md-8  inputGroupContainer">
								<textarea name="kinhphi" class="form-control" rows="5">${chitiet.getKinhPhi()}</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Thời gian bắt đầu
								nghiên cứu:</label>
							<div class="col-md-8 inputGroupContainer">
								<input type="date" class="form-control" name='thoigianbatdau'
									value='${chitiet.getThoiGianBatDau()}' />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Thời gian kết thúc
								nghiên cứu:</label>
							<div class="col-md-8 inputGroupContainer">
								<input type="date" class="form-control" name='thoigianketthuc'
									value='${chitiet.getThoiGianKetThuc()}' />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Mã giảng viên hướng
								dẫn</label>
							<div class="col-md-8 inputGroupContainer">
								<input name="magiangvienhuongdan" class="form-control"
									type="text" value='${chitiet.getMaGiangVienHuongDan()}' />
							</div>
						</div>
						<div class="Thongtinsinhvien1">
							<legend> Thông tin thành viên tham gia </legend>
							<div class=col-md-6>
								<div class="form-group">
									<label class="col-md-4 control-label">Họ tên:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="text" class="form-control" name="hoten"
											value='${chitiet.getHoTen()}' />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Mã số sinh viên:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="text" class="form-control" name="masosinhvien"
											value='${chitiet.getTenDangNhap()}' />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Khóa học:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="text" class="form-control" name="khoahoc"
											value='${chitiet.getKhoaHoc()}' />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Ngày sinh:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="date" class="form-control" name='ngaysinh'
											value='${chitiet.getNgaySinh()}' />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Địa chỉ:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="text" class="form-control" name="diachi"
											value='${chitiet.getDiaChi()}' />
									</div>
								</div>

							</div>

							<div class=col-md-6>
								<div class="form-group">
									<label class="col-md-4 control-label">Giới tính:</label>
									<div class="col-md-8 inputGroupContainer">
										<c:if test="${chitiet.getGioiTinh()}">
											<input type="text" class="form-control" value='Nam' />
										</c:if>
										<c:if test="${chitiet.getGioiTinh()==false}">
											<input type="text" class="form-control" value='Nữ' />
										</c:if>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Lớp:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="text" class="form-control" name="masolop"
											value='${chitiet.getLop()}' />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Số tài khoản ngân
										hàng:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="text" class="form-control"
											name="taikhoannganhang"
											value='${chitiet.getSoTaiKhoanNganHang()}' />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Số điện thoại:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="text" class="form-control" name="sodienthoai"
											value='${chitiet.getSoDienThoai()}' />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Email:</label>
									<div class="col-md-8 inputGroupContainer">
										<input type="text" class="form-control" name="email"
											value='${chitiet.getEmail()}' />
									</div>
								</div>

								<div class="form-group">
										<div class="col-md-6">
											<button type="button" class="btn btn-primary" id="">
												<a href="GiaHanDeTai?madetai=${chitiet.getMaDeTai()}">Gia
													hạn đề tài</a>
											</button>
										</div>
									<div class="col-md-6">
										<button type="button" class="btn btn-warning">
											<a href="HuyDeTai?madetai=${chitiet.getMaDeTai()}">Hủy đề tài</a></span>
										</button>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
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

	<script type="text/javascript" src="js/bootstrap-table.js"></script>

	<script type="text/javascript">
		var $table = $('#fresh-table'), $alertBtn = $('#alertBtn'), full_screen = false;

		$().ready(function() {
			$table.bootstrapTable({
				toolbar : ".toolbar",

				showRefresh : true,
				search : true,
				showToggle : true,
				showColumns : true,
				pagination : true,
				striped : true,
				pageSize : 8,
				pageList : [ 8, 10, 25, 50, 100 ],

				formatShowingRows : function(pageFrom, pageTo, totalRows) {
					//do nothing here, we don't want to show the text "showing x of y from..." 
				},
				formatRecordsPerPage : function(pageNumber) {
					return pageNumber + " rows visible";
				},
				icons : {
					refresh : 'fa fa-refresh',
					toggle : 'fa fa-th-list',
					columns : 'fa fa-columns',
					detailOpen : 'fa fa-plus-circle',
					detailClose : 'fa fa-minus-circle'
				}
			});
			$(window).resize(function() {
				$table.bootstrapTable('resetView');
			});
			window.operateEvents = {
				'click .like' : function(e, value, row, index) {
					alert('You click like icon, row: ' + JSON.stringify(row));
					console.log(value, row, index);
				},
				'click .edit' : function(e, value, row, index) {
					alert('You click edit icon, row: ' + JSON.stringify(row));
					console.log(value, row, index);
				},
				'click .remove' : function(e, value, row, index) {
					$table.bootstrapTable('remove', {
						field : 'id',
						values : [ row.id ]
					});

				}
			};

			$alertBtn.click(function() {
				alert("You pressed on Alert");
			});

		});

		function operateFormatter(value, row, index) {
			return [
					'<a rel="tooltip" title="Like" class="table-action like" href="javascript:void(0)" title="Like">',
					'<i class="fa fa-heart"></i>',
					'</a>',
					'<a rel="tooltip" title="Edit" class="table-action edit" href="javascript:void(0)" title="Edit">',
					'<i class="fa fa-edit"></i>',
					'</a>',
					'<a rel="tooltip" title="Remove" class="table-action remove" href="javascript:void(0)" title="Remove">',
					'<i class="fa fa-remove"></i>', '</a>' ].join('');
		}
	</script>
	<!-- 
	<script type="text/javascript">
	$(document).ready(function(){
		$("#chitietdetai_form").attr('disabled','disabled');
	});
	</script> -->
</body>
</html>