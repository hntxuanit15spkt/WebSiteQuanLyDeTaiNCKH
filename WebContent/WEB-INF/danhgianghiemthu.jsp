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
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<link rel="icon" type="image/png" href="images/favicon.png" />
<!-- Bootstrap core CSS     -->
<link href="css/bootstrap.min.css" rel="stylesheet" type='text/css'/>
<link rel='stylesheet' href='css/cmxform.css' type='text/css'/>
<!--  Material Dashboard CSS    -->
<link href="css/material-dashboard.css?v=1.2.0" rel="stylesheet" type='text/css'/>
<!--     Fonts and icons     -->
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet" type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css' />
<link href="css/fresh-bootstrap-table.css" rel="stylesheet" type='text/css'/>
<title>Đánh giá nghiệm thu</title>
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
					<li>
						<a href="trangchu">
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
					<li class="active">
						<a href="DanhGiaNghiemThu"> 
							<i class="material-icons">bubble_chart</i>
							<p>Đánh giá nghiệm thu</p>
						</a>
					</li><li>
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
						<a class="navbar-brand" href="#"> Đánh giá nghiệm thu </a>
					</div>
				</div>
			</div>
			<div class='content'>
				<div class="container-fluid">
					<div class="col-md-12">
		                <div class="fresh-table toolbar-color-azure">
		                    <div class="toolbar">
		                        <button id="alertBtn" class="btn btn-default">Danh sách chờ nghiệm thu</button>
		                    </div>
		                    
		                    <table id="fresh-table" class="table">
		                        <thead>
		                        	<tr>
			                        	<th data-field="name" data-sortable="true">Sinh viên</th>
			                        	<th data-field="number" data-sortable="true">Mã đề tài</th>
			                            <th data-field="id" data-sortable="true">Tên đề tài</th>
			                        	<th data-field="city" data-sortable="true">Trạng thái</th>
			                        	<th data-field="country" data-sortable="true">Thời gian phản biện</th>
			                        	<th data-field="actions">Operation</th>
		                        	</tr>
		                        </thead>
		                        <tbody>
		                     		<c:forEach items="${detainghiemthu}" var="detai">
										<tr>
											<td>${detai.getHoTen() }</td>
											<td>${detai.getMaDeTai() }</td>
											<td>${detai.getTenDeTai() }
											</td>
											<td>
												<c:if test="${detai.getMaTrangThai() == 8}">
													<i>${detai.getTenTrangThai()}</i>
												</c:if>
												<c:if test="${detai.getMaTrangThai() == 9}">
													<i>Đã nghiệm thu</i>
												</c:if>
											</td>
											<td><fmt:formatDate value="${detai.getThoiGianPhanBien()}" pattern="dd-MM-yyyy"/></td>
											<td>
												<c:if test="${detai.getMaTrangThai() == 8}">
													<a href="#danhgianghiemthu" id='danhgia' class="btn btn-danger"><span><strong>Đánh giá</strong></span></a>
												</c:if>
												<c:if test="${detai.getMaTrangThai() == 9}">
													<i>Đã đánh giá</i>
												</c:if>
											</td>
										</tr>
									</c:forEach>
		                		</tbody>
		            		</table>
		        		</div>
					</div>
				</div>
			</div>
			<div id='danhgianghiemthu' class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#danhgianghiemthu"> Đánh giá nghiệm thu </a>
					</div>
				</div>
			</div>
			<div id='formdanhgianghiemthu' class='content'>
				<div class="container-fluid">
					<form class="form-horizontal" action="DanhGiaNghiemThu" method="post" id="nghiemthu_form">
						<div class="form-group" class='col-md-6 col-md-offset-3'>
							<label class="col-md-4 control-label">Mã đề tài:</label>
							<div class="col-md-4  inputGroupContainer">
								<input name="madetai" placeholder="Nhập vào mã đề tài" class="form-control" type="text"/>
							</div>
						</div>
						<table class="table table-bordered" id='nghiemthutable'>
							<tr>
								<th>STT</th>
								<th>Tiêu chí đánh giá</th>
								<th>Điểm tối đa</th>
								<th>Điểm đánh giá</th>
							</tr>
							<tr>
								<td>1</td>
								<td>Tổng quan tình hình nghiên cứu thuộc lĩnh vực đề tài</td>
								<td>15</td>
								<td>
									<div class="col-md-8 col-md-offset-2">
										<input name="tieuchi1" class="form-control" type="text" min='0' max='15' placeholder="Từ 0 - 15 điểm"/>
									</div>
								</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Ý tưởng của đề tài và cách tiếp cận</td>
								<td>15</td>
								<td>
									<div class="col-md-8 col-md-offset-2">
										<input name="tieuchi2" class="form-control" type="text" min='0' max='15' placeholder="Từ 0 - 15 điểm"/>
									</div>
								</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Mục tiêu đề tài</td>
								<td>10</td>
								<td>
									<div class="col-md-8 col-md-offset-2">
										<input name="tieuchi3" class="form-control" type="text" min='0' max='10' placeholder="Từ 0 - 10 điểm"/>
									</div>
								</td>
							</tr>
							<tr>
								<td>4</td>
								<td>Phương pháp nghiên cứu</td>
								<td>10</td>
								<td>
									<div class="col-md-8 col-md-offset-2">
										<input name="tieuchi4" class="form-control" type="text" min='0' max='10' placeholder="Từ 0 - 10 điểm"/>
									</div>
								</td>
							</tr>
							<tr>
								<td>5</td>
								<td>Kết quả nghiên cứu</td>
								<td>40</td>
								<td>
									<div class="col-md-8 col-md-offset-2">
										<input name="tieuchi5" class="form-control" type="text" min='0' max='40' placeholder="Từ 0 - 40 điểm"/>
									</div>
								</td>
							</tr>
							<tr>
								<td>6</td>
								<td>Hình thức trình bày báo cáo tổng kết đề tài</td>
								<td>5</td>
								<td>
									<div class="col-md-8 col-md-offset-2">
										<input name="tieuchi6" class="form-control" type="text" min='0' max='5' placeholder="Từ 0 - 5 điểm"/>
									</div>
								</td>
							</tr>
							<tr>
								<td>7</td>
								<td>Công bố khoa học từ kết quả nghiên cứu của đề tài trên các tạp chí khoa học trong và ngoài nước</td>
								<td>5</td>
								<td>
									<div class="col-md-8 col-md-offset-2">
										<input name="tieuchi7" class="form-control" type="text" min='0' max='5' placeholder="Từ 0 - 5 điểm"/>
									</div>
								</td>
							</tr>
							<tr class='danger'>
								<td></td>
								<td>Tổng điểm</td>
								<td>100</td>
								<td>
									<div class="col-md-6 col-md-offset-2">
										<button type="submit" class="btn btn-warning">
											Xác nhận <span class="glyphicon glyphicon-send"></span>
										</button>
									</div>
								</td>
							</tr>
						</table>
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
	
	<script type="text/javascript" src="js/bootstrap-table.js"></script>

    <script type="text/javascript">
        var $table = $('#fresh-table'),
            $alertBtn = $('#alertBtn'),
            full_screen = false;
            
        $().ready(function(){
            $table.bootstrapTable({
                toolbar: ".toolbar",
    
                showRefresh: true,
                search: true,
                showToggle: true,
                showColumns: true,
                pagination: true,
                striped: true,
                pageSize: 8,
                pageList: [8,10,25,50,100],
                
                formatShowingRows: function(pageFrom, pageTo, totalRows){
                    //do nothing here, we don't want to show the text "showing x of y from..." 
                },
                formatRecordsPerPage: function(pageNumber){
                    return pageNumber + " rows visible";
                },
                icons: {
                    refresh: 'fa fa-refresh',
                    toggle: 'fa fa-th-list',
                    columns: 'fa fa-columns',
                    detailOpen: 'fa fa-plus-circle',
                    detailClose: 'fa fa-minus-circle'
                }
            });
            $(window).resize(function () {
                $table.bootstrapTable('resetView');
            });
            window.operateEvents = {
                'click .like': function (e, value, row, index) {
                    alert('You click like icon, row: ' + JSON.stringify(row));
                    console.log(value, row, index);
                },
                'click .edit': function (e, value, row, index) {
                    alert('You click edit icon, row: ' + JSON.stringify(row));
                    console.log(value, row, index);    
                },
                'click .remove': function (e, value, row, index) {
                    $table.bootstrapTable('remove', {
                        field: 'id',
                        values: [row.id]
                    });
            
                }
            };
            
            $alertBtn.click(function () {
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
                    '<i class="fa fa-remove"></i>',
                '</a>'
            ].join('');
        }
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#formdanhgianghiemthu").hide();
			$("#danhgianghiemthu").hide();
			$("#danhgia").click(function(){
				$("#formdanhgianghiemthu").slideDown();
				$("#danhgianghiemthu").slideDown("flow");
			});
		});
	</script>
</body>
</html>