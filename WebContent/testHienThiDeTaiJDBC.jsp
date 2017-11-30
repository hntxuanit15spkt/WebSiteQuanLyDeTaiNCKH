<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css" />
<script type="text/javascript">
	$(document).ready(function() {
		$('#datatable').dataTable();
	});
</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<!-- <div id="chitietdetai" style="font-size: 14px">
		<div class="row">
			<div class="col-sm-6" style="background-color: lavender;">
				<dl class="dl-horizontal">
					<dt>Tên đề tài</dt>
					<dd>Dự án AI</dd>
					<dt>Chủ nhiệm đề tài</dt>
					<dd>Huỳnh Ngọc Thanh Xuân</dd>
					<dt>Lớp</dt>
					<dd>159100A</dd>
					<dt>Giới tính</dt>
					<dd>Nam</dd>
					<dt>Ngày sinh</dt>
					<dd>20/7/2005</dd>
				</dl>
			</div>
			<div class="col-sm-6" style="background-color: lavenderblush;">
				<dl class="dl-horizontal">
					<dt>Loại hình</dt>
					<dd>Ứng dụng tâm lý, tình cảm</dd>
					<dt>Mục tiêu đề tài</dt>
					<dd>Giúp khỏe hơn</dd>
					<dt>Nội dung nghiên cứu</dt>
					<dd>Nghiên cứu về code</dd>
					<dt>Địa chỉ ứng dụng</dt>
					<dd>Sài Gòn</dd>
					<dt>Tình hình biển Đông</dt>
					<dd>Đang bão</dd>
				</dl>
			</div>
		</div>
	</div> -->
	<form id="form1">
		<h2 align="CENTER">DANH SÁCH CÁC ĐỀ TÀI</h2>
		<div style="border: 1px solid black; color: black">
			<table id="datatable">
				<thead>
					<tr>
						<th>Tên đề tài</th>
						<th>Phương pháp thực hiện</th>
						<th>Kinh phí</th>
						<th>Loại đề tài</th>
						<th>Operation</th>
						<!-- 						<th>Links</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${DeTai}" var="detai">
						<tr>
							<td>${detai.getTenDeTai() }</td>
							<td>${detai.getPhuongPhapThucHien() }</td>
							<td>${detai.getKinhPhi() }</td>
							<td>${detai.getLoaiDeTai() }</td>
							<td><a href="XoaDeTai?id=${detai.getMaDeTai()}" class="btn btn-danger">
								<span><strong>Xóa</strong></span>
							</a></td>
						</tr>
					</c:forEach>


					<!-- <tr>
						<td>2</td>
						<td>DT0001</td>
						<td>Dự án 2</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<tr>
						<td>3</td>
						<td>DT0001</td>
						<td>Dự án 3</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<tr>
						<td>4</td>
						<td>DT0001</td>
						<td>Dự án 4</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<tr>
						<td>5</td>
						<td>DT0001</td>
						<td>Dự án 5</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<%-- <c:forEach items="${DeTai}" var="deTai">
						<tr>
							<td>${deTai.getTenDeTai()}</td>
							<td>${deTai.getPhuongPhapThucHien()}</td>
							<td>${deTai.getKinhPhi()}</td>
							<td>${deTai.getLoaiDeTai()}</td>
						</tr>
					</c:forEach> --%>
					<tr>
						<td>6</td>
						<td>Dự án 6</td>
						<td>Dự án cải tân cơ thể và sắc đẹp để làm sao đẹp trai hơn
							Xuân</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<tr>
						<td>7</td>
						<td>DT0001</td>
						<td>Dự án 7</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<tr>
						<td>8</td>
						<td>DT0001</td>
						<td>Dự án cải tân cơ thể và sắc đẹp để làm sao đẹp trai hơn
							Xuân</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<tr>
						<td>1</td>
						<td>DT0001</td>
						<td>Dự án cải tân cơ thể và sắc đẹp để làm sao đẹp trai hơn
							Xuân</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<c:forEach items="${DeTai}" var="detai">
						<tr>
							<td>${detai.getTenDeTai()}</td>
							<td>${detai.getPhuongPhapThucHien()}</td>
							<td>${detai.getKinhPhi()}</td>
							<%-- <td>${detai.getMaDeTai()}</td> --%>
							<td>${detai.getLoaiDeTai()}</td>
							<td><a href="XoaDeTai?id=${detai.getMaDeTai()}" class="btn btn-danger">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        				<span><strong>Xóa</strong></span>       
							</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td>1</td>
						<td>DT0001</td>
						<td>Dự án cải tân cơ thể và sắc đẹp để làm sao đẹp trai hơn
							Xuân</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr>
					<tr>
						<td>1</td>
						<td>DT0001</td>
						<td>Dự án cải tân cơ thể và sắc đẹp để làm sao đẹp trai hơn
							Xuân</td>
						<td>Loại hình thuộc vào dạng rất khó thực hiện</td>
						<td>Trịnh Văn Công</td>
						<td>OCh. Nguyễn Minh Hoàng</td>
						<td>Đang chờ phê duyệt</td>
					</tr> -->
				</tbody>
			</table>
		</div>
	</form>
	<script>
		$(document).ready(function() {
			$('a[href="#xemdetai"]').click(function() {
				/* $('html, body').animate({
					scrollTop : $('#form1').scrollTop()
				}, 1000); */
				$('html, body').animate({
					scrollTop : $("#form1").offset().top - 140
				}, 1000);
				$('#form1').css("visibility", "visible");
				$('#chitietdetai').css("visibility", "hidden");
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$('a[href="#click-hien-chitiet"]').click(function() {
				$('html, body').animate({
					scrollTop : $("#chitietdetai").offset().top - 110
				}, 1000);
				$('#chitietdetai').css("visibility", "visible");
				$('#form1').css("visibility", "hidden");
			});
		});
	</script>

</body>
</html>