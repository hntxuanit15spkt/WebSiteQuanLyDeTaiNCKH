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
<title>Danh sách đề tài</title>
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
										<th data-field="salary" data-sortable="true">Thời gian
											bắt đầu</th>
										<th data-field="country" data-sortable="true">Thời gian
											kết thúc</th>
										<th data-field="actions">Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${danhsachdetaicanxacnhan}" var="detai">
										<tr>
											<td>${detai.getTenDeTai() }</td>
											<td>${detai.getThoiGianBatDau() }</td>
											<td>${detai.getThoiGianKetThuc() }</td>
											<td><a
												href="ChiTietDeTai_XacNhanHuongDan?madetai=${detai.getMaDeTai()}&magiangvienhuongdan=${detai.getMaGiangVienHuongDan()}"
												class="btn btn-danger"> <span><strong>Xem
															chi tiết</strong></span>
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
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
</body>
</html>