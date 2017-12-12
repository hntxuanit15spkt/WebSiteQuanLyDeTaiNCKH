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
<link rel='stylesheet' href='css/cmxform.css' type='text/css'/>
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet" type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css' />
<title>Thông tin giảng viên</title>
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
					<li class="active">
						<a href="ThongTinGiangVien"> 
							<i class="material-icons">person</i>
							<p>Thông tin giảng viên</p>
						</a>
					</li>
					<li>
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
						<a class="navbar-brand" href="#"> Thông tin giảng viên </a>
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
		                <div class="fresh-table toolbar-color-orange">
		                    <div class="toolbar">
		                        <button id="alertBtn" class="btn btn-default">Danh sách giảng viên</button>
		                        <a href='#themgiangvien'><button id="themtaikhoan" class="btn btn-default">Thêm tài khoản</button></a>
		                    </div>
		                    
		                    <table id="fresh-table" class="table">
		                        <thead>
		                        	<tr>
			                            <th data-field="id" data-sortable="true">Mã số</th>
			                        	<th data-field="name" data-sortable="true">Họ và Tên</th>
			                        	<th data-field="city" data-sortable="true">Số điện thoại</th>
			                        	<th data-field="salary" data-sortable="true">Ngày sinh</th>
			                        	<th data-field="password">Mật khẩu</th>
			                        	<th data-field="country" data-sortable="true">Trạng thái</th>
			                        	<th data-field="actions">Operation</th>
		                        	</tr>
		                        </thead>
		                        <tbody>
		                     		<c:forEach items="${quanlygiangvien}" var="value">
										<tr>
											<td>${value.getTenDangNhap() }</td>
											<td>
												<c:if test="${value.getMaLoaiNguoiDung()==4}">
													${value.getHoTen()}
												</c:if>
												<c:if test="${value.getMaLoaiNguoiDung()==5}">
													<b>${value.getHoTen()}</b>
												</c:if>
											</td>
											<td>${value.getSoDienThoai()}</td>
											<td><fmt:formatDate value="${value.getNgaySinh() }" pattern="dd-MM-yyyy"/></td>
											<td>${value.getMatKhau()}</td>
											<c:if test="${value.getTrangThaiNguoiDung()}">
												<td><i>Còn đang dạy</i></td>
												<td>
													<form action="ThongTinGiangVien?tendangnhap=${value.getTenDangNhap()}" method="post">
														<a href="EditNguoiQuanLy?tendangnhap=${value.getTenDangNhap()}&maloainguoidung=4" class="btn btn-danger"><span><strong>Khóa</strong></span></a>
														<input type='submit' class="btn btn-danger" value='Xóa'/>
													</form>
												</td>
											</c:if>
											<c:if test="${value.getTrangThaiNguoiDung()==false}">
												<td><i>Đã nghĩ</i></td>
												<td>
													<form action="ThongTinGiangVien?tendangnhap=${value.getTenDangNhap()}" method="post">
														<input type='submit' class="btn btn-danger" value='Xóa'/>
													</form>
												</td>
											</c:if>
										</tr>
									</c:forEach>
		                		</tbody>
		            		</table>
		        		</div>
					</div>
				</div>
			</div>
			<div id='themgiangvien' class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#themgiangvien"> Thêm giảng viên </a>
					</div>
				</div>
			</div>
			<div id='formthemgiangvien' class='content'>
				<div class="container-fluid">
					<form class="form-horizontal" action="ThemTaiKhoan" method="post" id="themtaikhoan_form">
						<legend> Thông tin tài khoản </legend>
						<div class="form-group" class='col-md-8 col-md-offset-2'>
							<label class="col-md-4 control-label">Tên đăng nhập</label>
							<div class="col-md-4  inputGroupContainer">
								<input name="tendangnhap" placeholder="Nhập vào mã số giảng viên"
									class="form-control" type="text" />
							</div>
						</div>
						<div class="form-group" class='col-md-8 col-md-offset-2'>
							<label class="col-md-4 control-label">Mật khẩu</label>
							<div class="col-md-4  inputGroupContainer">
								<input name="matkhau" placeholder="Nhập vào mật khẩu tài khoản"
									id='matkhau' class="form-control" type="password" />
							</div>
						</div>
						<div class="form-group" class='col-md-8 col-md-offset-2'>
							<label class="col-md-4 control-label">Nhập lại mật khẩu</label>
							<div class="col-md-4  inputGroupContainer">
								<input name="nhaplaimatkhau" placeholder="Nhập lại mật khẩu giảng viên"
									id='nhaplaimatkhau' class="form-control" type="password" />
							</div>
						</div>
						<legend> Thông tin giảng viên </legend>
						<div class=col-md-6>
							<div class="form-group">
								<label class="col-md-4 control-label">Họ tên:</label>
								<div class="col-md-8 inputGroupContainer">
									<input type="text" class="form-control" name="hoten"
										placeholder="Nhập vào họ tên giảng viên" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Mã số giảng viên:</label>
								<div class="col-md-8 inputGroupContainer">
									<input type="text" class="form-control" name="masosinhvien"
										placeholder="Nhập vào mã số giảng viên" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Mã bộ môn:</label>
								<div class="col-md-8 inputGroupContainer">
									<input type="text" class="form-control" name="mabomon"
										placeholder="Nhập vào mã bộ môn" />
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
									<label><input type="radio" name="gioitinh" value="1"/>Nam</label>
									<label><input type="radio" name="gioitinh" value="0"/>Nữ</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Chức vụ:</label>
								<div class="radio">
									<label><input type="radio" name="maloainguoidung" value="4"/>Hướng dẫn</label>
									<label><input type="radio" name="maloainguoidung" value="5"/>Kiểm duyệt</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Số tài khoản ngân
									hàng:</label>
								<div class="col-md-8 inputGroupContainer">
									<input type="text" class="form-control" name="sotaikhoan"
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
							<input type='hidden' name='khoahoc' value='0'/>
							<input type="hidden" name="lop" value='0'/>
							<div class="form-group">
								<div class="col-md-6">
								</div>
								<div class="col-md-6">
									<button type="submit" class="btn btn-warning">
										Thêm <span class="glyphicon glyphicon-send"></span>
									</button>
								</div>
							</div>
						</div>
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
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src='js/jquery.validate.js'></script>
	<script>
	$().ready(function() {

		// validate signup form on keyup and submit
		$("#themtaikhoan_form").validate({
			rules: {
				hoten: {
					required: true,
					minlength: 5
				},
				tendangnhap: {
					required: true,
					minlength: 3
				},
				matkhau: {
					required: true,
					minlength: 3
				},
				nhaplaimatkhau: {
					required: true,
					minlength: 3,
					equalTo: "#matkhau"
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
					minlength: "*Tên phải có ít nhất 5 ký tự"
				},
				tendangnhap: {
					required: "*Vui lòng điền Tên đăng nhập",
					minlength: "*Tên đăng nhập phải có ít nhất 3 ký tự"
				},
				matkhau: {
					required: "*Vui lòng điền mật khẩu",
					minlength: "*Mật khẩu có phải có ít nhất 3 ký tự"
				},
				nhaplaimatkhau: {
					required: "*Vui nhập lại mật khẩu",
					minlength: "*Mật khẩu có phải có ít nhất 3 ký tự",
					equalTo: "*Mật khẩu nhập lại không đúng"
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
	<script type="text/javascript">
		$(document).ready(function(){
			$("#themgiangvien").hide();
			$("#formthemgiangvien").hide();
			$("#themtaikhoan").click(function(){
				$("#themgiangvien").show();
				$("#formthemgiangvien").show();
			});
		});
	</script>
</body>
</html>