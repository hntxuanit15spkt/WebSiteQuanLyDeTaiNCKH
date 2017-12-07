<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h4>
		<small>RECENT POSTS</small>
	</h4>
	<hr />
	<h2>Thông báo về việc đăng ký đề tài nghiên cứu khoa học giảng
		viên và sinh viên năm học 2016 - 2017</h2>
	<h5>
		<span class="glyphicon glyphicon-time"></span> Post by Jane Dane, Sep
		27, 2015.
	</h5>
	<p>Để triển khai thực hiện các đề tài nghiên cứu khoa học (NCKH)
		cấp trường cho giảng viên và sinh viên trong năm học 2016 - 2017, đề
		nghị các Khoa tiến hành một số công việc như sau:</p>
	<p id="detailmore">1.	Đối với đề tài NCKH giảng viên: giảng viên đăng ký đề tài NCKH cấp
		trường sẽ thực hiện trong năm học 2016 - 2017. Chủ nhiệm các đề tài
		thực hiện các hồ sơ sau: - Phiếu đăng ký đề tài NCKH (BM01/QT01/QLKH)
		- Thuyết minh đề tài NCKH (BM02/QT01/QLKH) - Lý lịch khoa học của chủ
		nhiệm đề tài (BM03/QT01/QLKH) Dựa vào các hồ sơ nêu trên, Hội đồng
		khoa học Khoa đánh giá sơ bộ các đề tài NCKH của giảng viên theo mẫu
		Phiếu đánh giá đề tài NCKH (BM04/ QT01/QLKH). Khoa tổng hợp danh sách
		đề tài NCKH giảng viên theo biểu mẫu BM05/QT01/QLKH để gửi về cho P.
		QLKH-SĐH.<br />
		2. Đối với đề tài NCKH sinh viên: các Khoa triển khai cho
		sinh viên đăng ký đề tài NCKH thực hiện trong năm học 2016 - 2017 theo
		biểu mẫu BM01/QT02/NCKH. Khoa thực hiện đánh giá từng đề tài đăng ký
		theo biểu mẫu BM02/QT02/NCKH và tổng hợp danh sách đề tài NCKH sinh
		viên theo biểu mẫu BM03/QT02/NCKH để gửi về cho P. QLKH-SĐH. Các hồ sơ
		nêu trên gửi về P. QLKH – SĐH trước ngày 01/10/2016. Rất mong khoa
		quan tâm động viên giảng viên, sinh viên tích cực tham gia.</p>
	<div id="loadMore">Load more</div>
	<div id="showLess">Show less</div>
	<br />
	<br />
	<script>
		$(document).ready(function() {
/* 			size_li = $("#myList li").size();
			x = 3;
			$('#myList li:lt(' + x + ')').show(); */
			$('#loadMore').click(function() {
				$('#detailmore').show();
			});
			$('#showLess').click(function() {
				$('#detailmore').hide();
			});
		});

		/* 		$('a[href=#top]').click(function() {
		 $('body,html').animate({
		 scrollTop : 0
		 }, 600);
		 return false;
		 }); */

		/* 		$(window).scroll(function() {
		 if ($(this).scrollTop() > 50) {
		 $('.totop a').fadeIn();
		 } else {
		 $('.totop a').fadeOut();
		 }
		 }); */
	</script>
</body>
</html>