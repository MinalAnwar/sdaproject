<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>ERP</title>
	<link rel="shortcut icon" type="image/x-icon" href="download.png">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
	<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="assets/css/feathericon.min.css">
	<link rel="stylesheet" href="assets/plugins/morris/morris.css">
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<script src="https://kit.fontawesome.com/4ecf238d25.js" crossorigin="anonymous"></script>

</head>

<body>
	<jsp:include page="/templates/dashboard.jsp"/>
	<div class="page-wrapper">
		<div class="content container-fluid">
			<div class="page-header">
				<div class="row align-items-center">
					<div class="col">
						<h3 class="page-title mt-5">Add Employee</h3> </div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form method="get" action="addEmployee">
						<div class="row formtype">
							<div class="col-md-4">
								<div class="form-group">
									<label>Name</label>
									<input name = "name"  class="form-control" type="text"  value="" required> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Age</label>
									<input type="number" min="18" max="80" name = "age" class="form-control" required> </div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label>Phone Number</label>
									<input type="text"  placeholder="0300-8888886" name = "phoneNumber" class="form-control" required> </div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label>Address</label>
									<input type="text" name = "address" class="form-control" required> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Email</label>
									<input type="text" placeholder="minal@gmail.com" name = "email" class="form-control" required> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Date of Birth</label>
									<input type="date" name = "dateOfBirth" class="form-control" required> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>CNIC</label>
									<input type="text" placeholder="35202-6456106-4" name="cnic" class="form-control" required> </div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="gender">Gender</label>
									<select class="form-control" required name="gender" id="gender">
										<option value="." disabled>Select Option</option>
										<option value="male">Male</option>
										<option value="female">Female</option>
										<option value="other">Other</option>
									</select>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label>Salary</label>
									<input type="number" min="10000" max="1000000" name = "salary" class="form-control"  required> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Designation</label>
									<input type="text" name ="designation" class="form-control"  required> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Joining Date</label>
									<input type="date" name = "joiningDate" class="form-control" required> </div>
							</div>
						</div>
						<button class="btn btn-primary btn-block" type="submit">Add Employee</button>
						<%
							Boolean isValid = (Boolean) request.getAttribute("valid");
							if (isValid != null && !isValid) {
						%>
						</div>
						<div style="color: red;">Cannot Add New Employee</div>
						<%
							}
						%>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="assets/js/jquery-3.5.1.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/plugins/raphael/raphael.min.js"></script>
<script src="assets/js/moment.min.js"></script>
<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script src="assets/js/script.js"></script>
<script>
	$(function() {
		$('#datetimepicker3').datetimepicker({
			format: 'LT'
		});
	});
</script>
</body>

</html>