<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<div class="blank">
		<h2>Blank Page</h2>
		<div class="blankpage-main">
			<div class="edit-info">
				<jsp:include page="edit-info.jsp" />
			</div>
			<div class="topic">
				<jsp:include page="topic.jsp" />
			</div>
		</div>

	</div>
	<!-- <script>
		$(document).ready(function() {
			$("#contact_form").scroll(function() {
			});
		});
	</script> -->
	<script>
		$(function() {
			$("#datepicker_content").datepicker();
		});
	</script>
</body>
</html>