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
	<div class="md-modal md-effect-1" id="modal-1">
		<div class="md-content">
			<h3>Cập nhật thông tin cá nhân</h3>
			<form class="well form-horizontal" action="" method="post"
				id="contact_form">
				<fieldset style="height: 400px; overflow: auto;">
					<div class="form-group">
						<label class="col-md-4 control-label">Họ tên</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<input name="first_name" value="Huỳnh Ngọc Thanh Xuân"
									class="form-control" type="text" required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Mã số sinh viên: </label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<input name="first_name" value="15114789" class="form-control"
									type="text" required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Email</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<input name="email" value="15114789@student.hcmute.edu.vn"
									class="form-control" type="text" required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Số điện thoại</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<input name="phone" value="(845)555-1212" class="form-control"
									type="text" required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Ngành</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<select name="state" class="form-control selectpicker">
									<option>Công nghệ thông tin</option>
									<option>Kỹ thuật dữ liệu</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Ngày sinh</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<input type="date" name="dateofbirth" id="dateofbirth"
									class="form-control" id="datepicker_content" type="text"
									required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Số CMND</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<input name="phone" placeholder="(845)555-1212"
									class="form-control" type="text" required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Số tài khoản ngân
							hàng</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<input name="phone" placeholder="(845)555-1212"
									class="form-control" type="text" required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Chi nhánh</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<input name="phone" placeholder="(845)555-1212"
									class="form-control" type="text" required />
							</div>
						</div>
					</div>
				</fieldset>
				<div style="color: black; text-align: center;">
					<input type="button" value="Sửa" /> <input type="submit"
						value="Lưu" /> <input type="button" value="Thoát"
						class="md-close" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>