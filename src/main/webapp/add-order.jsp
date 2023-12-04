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
<jsp:include page="/templates/dashboard.jsp"/>>
		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col">
							<h3 class="page-title mt-5">Add Order</h3> </div>
					</div>
				</div>
				<form method="post" action="addOrder">
				<div class="row">
					<div class="col-md-auto">
						<label for="exampleFormControlInput1" class="form-label">OrderNumber</label>
						<input type="text" class="form-control" name="orderNumber" id="exampleFormControlInput1" placeholder="Enter Order Number" style="width: 300px;">
					</div>
					<div class="col-md-auto">
						<label for="exampleFormControlInput1" class="form-label">Items</label>
						<input type="text" class="form-control" name="items" id="exampleFormControlInput1" placeholder="Enter Item List" style="width: 300px;">
					</div>
					<div class="col-md-auto">
						<label for="exampleFormControlInput1" class="form-label">TotalAmount</label>
						<input type="number" id="totalAmount" name="totalAmount" min="1" max="1000000" class="form-control">
					</div>
				</div>
				<div class="row my-2">
					<div class="col-md-auto">
						<label for="exampleFormControlInput1" class="form-label">Date</label>
						<input type="text" class="form-control" name="date" id="exampleFormControlInput1" placeholder="Enter Due Date" style="width: 300px;">
					</div>
					<div class="col-md-auto">
						<label for="exampleFormControlInput1" class="form-label">TotalItems</label>
						<input type="number" id="quantity" name="totalItems" min="1" max="10000" class="form-control">
					</div>
				</div>
				<div class="row my-2">
					<div class="col-md-auto">
						<label for="exampleFormControlInput1" class="form-label">OrderStatus</label>
						<input type="text" class="form-control" name="orderStatus" id="exampleFormControlInput1" placeholder="Enter Order Status" style="width: 300px;">
					</div>
				</div>
					<button type="submit" class="btn btn-primary my-3">Add Order</button>
				</form>
			</div>
		</div>
	</div>
	<script src="disable.js"></script>
	<script src="assets/js/jquery-3.5.1.min.js"></script>
	<script src="assets/js/popper.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/moment.min.js"></script>
	<script src="assets/js/select2.min.js"></script>
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/raphael/raphael.min.js"></script>
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