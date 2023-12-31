<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>COSMO</title>
	<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
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
						<h3 class="page-title mt-5">Add Material</h3> </div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form method="post" action="material">
						<div class="row formtype">

							<div class="col-md-4">
								<div class="form-group">
									<label >Select Material</label>
									<select class="form-control" required name="material"  id="m1">

										<c:forEach items="${material}" var="v">
											<option value="${v.getName()}">${v.getName()}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label>Quantity</label>
									<input type="number" min="10" max="10000" class="form-control" required name="stock"> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Price</label>
									<input type="number" min="10" max="10000" aria-placeholder="pice per piece" class="form-control" placeholder="Price Per Piece" required name="price"> </div>
							</div>
						</div>
						<button type="submit" class="btn btn-primary buttonedit1">ADD</button>
						<%
							Boolean isValid = (Boolean) request.getAttribute("valid");
							if (isValid != null && !isValid) {
						%>
						</p>
						<div style="color: red;">Cannot Add New material</div>
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