<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
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
</head>
<body style="font-family: Arial">
	<form id="form1">
		<div style="width: 500px; border: 1px solid black; padding: 5px">
			<table id="datatable">
				<thead>
					<tr>
						<th>ID</th>
						<th>City</th>
						<th>Country</th>
						<th>Continent</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Montería</td>
						<td>Colombia</td>
						<td>South America</td>
					</tr>
					<tr>
						<td>2</td>
						<td>Birmingham</td>
						<td>United Kingdom</td>
						<td>Europe</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>