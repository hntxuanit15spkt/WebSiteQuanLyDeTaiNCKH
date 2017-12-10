<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png" />
<link rel="icon" type="image/png" href="images/favicon.png" />
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/admin.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
<link href="css/fresh-bootstrap-table.css" rel="stylesheet" type='text/css'/>
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet" type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css' />
<title>Thông tin đề tài</title>
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
						<a href="Admin">
							<i class="material-icons">dashboard</i>
							<p>HOME</p>
						</a>
					</li>
					<li>
						<a href="ThongTinSinhVien">
							<i class="material-icons">person</i>
							<p>Thông tin sinh viên</p>
						</a>
					</li>
					<li>
						<a href="ThongTinGiangVien"> 
							<i class="material-icons">person</i>
							<p>Thông tin giảng viên</p>
						</a>
					</li>
					<li class="active">
						<a href="ThongTinDeTai"> 
							<i class="material-icons">content_paste</i>
							<p>Thông tin đê tài</p>
						</a>
					</li>
					<li>
						<a href="#"> 
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
		<div class="main-panel" id='ad_home'>
			<div class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"> Thông tin đề tài </a>
					</div>
				</div>
			</div>
			<div class='content'>
				<div class="container-fluid">
					<div class="market-updates">
						<a href='ThongTinSinhVien'>
							<div class="col-md-4 market-update-gd">
								<div class="market-update-block clr-block-1">
									<div class="col-md-8 market-update-left">
										<c:forEach items="${soluongsinhvien}" var="sv">
											<h3>${sv.getSoLuongSinhVien()}</h3>
										</c:forEach>
										<h4>SINH VIÊN</h4>
										<p><i>Nghiên cứu viên</i></p>
									</div>
									<div class="col-md-4 market-update-right">
										<i class="fa fa-file-text-o"> </i>
									</div>
									<div class="clearfix"> </div>
								</div>
							</div>
						</a>
						<a href='ThongTinGiangVien'>
							<div class="col-md-4 market-update-gd">
								<div class="market-update-block clr-block-2">
									<div class="col-md-8 market-update-left">
										<c:forEach items="${soluonggiangvien}" var="value">
											<h3>${value.getSoLuongSinhVien()}</h3>
										</c:forEach>
										<h4>GIẢNG VIÊN</h4>
										<p>Hướng dẫn, kiểm duyệt</p>
									</div>
									<div class="col-md-4 market-update-right">
										<i class="fa fa-file-text-o"> </i>
									</div>
									<div class="clearfix"> </div>
								</div>
							</div>
						</a>
						<a href='ThongTinDeTai'>
							<div class="col-md-4 market-update-gd">
								<div class="market-update-block clr-block-3">
									<div class="col-md-8 market-update-left">
										<c:forEach items="${soluongdetai}" var="value">
											<h3>${value.getSoLuongDeTai()}</h3>
										</c:forEach>
										<h4>ĐỀ TÀI</h4>
										<p>Danh sách các đề tài</p>
									</div>
									<div class="col-md-4 market-update-right">
										<i class="fa fa-envelope-o"> </i>
									</div>
									<div class="clearfix"> </div>
								</div>
							</div>
						</a>
						<div class="clearfix"> </div>
					</div>
					<br /><br />
					<div class="col-md-12">
		                <div class="fresh-table toolbar-color-blue">
		                    <div class="toolbar">
		                        <button id="alertBtn" class="btn btn-default">Danh sách đề tài</button>
		                    </div>
		                    
		                    <table id="fresh-table" class="table">
		                        <thead>
		                        	<tr>
			                        	<th data-field="name" data-sortable="true">Sinh viên</th>
			                            <th data-field="id" data-sortable="true">Tên đề tài</th>
			                        	<th data-field="city" data-sortable="true">Trạng thái</th>
			                        	<th data-field="salary" data-sortable="true">Thời gian bắt đầu</th>
			                        	<th data-field="start-time" data-sortable="true">Thời gian kết thúc</th>
			                        	<th data-field="end-time" data-sortable="true">Thời gian phản biện</th>
		                        	</tr>
		                        </thead>
		                        <tbody>
		                     		<c:forEach items="${quanlydetai}" var="value">
										<tr>
											<td>${value.getHoTen() }</td>
											<td>${value.getTenDeTai() }</td>
											<td><i>${value.getTenTrangThai()}</i></td>
											<td><fmt:formatDate value="${value.getThoiGianBatDau() }" pattern="dd-MM-yyyy"/></td>
											<td><fmt:formatDate value="${value.getThoiGianKetThuc() }" pattern="dd-MM-yyyy"/></td>
											<td><fmt:formatDate value="${value.getThoiGianPhanBien() }" pattern="dd-MM-yyyy"/></td>
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
                alert("Bạn đang ở danh sách các đề tài!");
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
</body>
</html>