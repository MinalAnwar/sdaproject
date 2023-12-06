<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, user-scalable=0">
		<title>ERP</title>
		<link rel="shortcut icon" type="image/x-icon" href="download.png">
		<link rel="stylesheet" href="assets/css/bootstrap.min.css">
		<link rel="stylesheet"
			href="assets/plugins/fontawesome/css/fontawesome.min.css">
		<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
		<link rel="stylesheet" href="assets/css/feathericon.min.css">
		<link rel="stylesheet" href="assets/plugins/morris/morris.css">
		<link rel="stylesheet" type="text/css"
			href="assets/css/bootstrap-datetimepicker.min.css">
		<link rel="stylesheet" href="assets/css/style.css">
		<link
			href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css"
			rel="stylesheet" type='text/css'>
		<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
		<script src="https://kit.fontawesome.com/4ecf238d25.js"
			crossorigin="anonymous"></script>
	</head>

	<body>
	<jsp:include page="/templates/dashboard.jsp"/>
		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col">
							<h2 class="page-title mt-5">Add Quotations</h2>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<form>

							<div class="row formtype">
								<div class="col-md-5">
									<div class="form-group">
										<h4>Vendor Name</h4>

										<select class="form-control" required name="vendor"  id="vendor">
											<option value="." disabled>Select Material</option>
											<c:forEach items="${vendors}" var="v">
												<option value="${v.getEmail()}">${v.getName()}</option>
											</c:forEach>
										</select>
									</div>
								</div>

							</div>

							<h5>Material 1</h5>
							<div class="row formtype">
								<div class="col-md-3">
									<div class="form-group">
										<label for="material">Name</label>
										<select class="form-control" required name="name"  id="material">
											<option disabled value=".">Select Material</option>
											<option value="leather">Leather</option>
											<option value="lining">Lining</option>
											<option value="cotton_cloth">Cotton Cloth</option>
											<option value="collar">Collar</option>
											<option value="cuffs">Cuffs</option>
											<option value="zips">Zips</option>
											<option value="button">Button</option>
											<option value="brand_tag">Brand Tag</option>
											<option value="thread">Thread</option>
										</select>
									</div>
								</div>
									<div class="col-md-3">
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Quantity</label>
											<input type="number" min="15" max="10000" class="form-control" id="usr1"> </div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Price</label>
											<input type="number" min="15" max="1000000" class="form-control" id="usr1"> </div>
									</div>
									</div>
									<h5>Material 2</h5>

							<div class="row formtype">
								<div class="col-md-3">
									<div class="form-group">
										<label for="material">Select Material</label>
										<select class="form-control" required name="name" id="material">
											<option value="." disabled >Select Material</option>
											<option value="leather">Leather</option>
											<option value="lining">Lining</option>
											<option value="cotton_cloth">Cotton Cloth</option>
											<option value="collar">Collar</option>
											<option value="cuffs">Cuffs</option>
											<option value="zips">Zips</option>
											<option value="button">Button</option>
											<option value="brand_tag">Brand Tag</option>
											<option value="thread">Thread</option>
										</select>
									</div>
								</div><div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Quantity</label>
                                        <input type="number" min="15" max="10000" class="form-control" id="usr1"> </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Price</label>
										<input type="number" min="1" max="1000000" class="form-control" id="usr1"> </div>
                                </div>
                                </div>
											<h5>Product 3</h5>

							<div class="row formtype">
								<div class="col-md-3">
									<div class="form-group">
										<label for="material">Select Material</label>
										<select class="form-control" required name="name" id="material">
											<option  value="." disabled>Select Material</option>
											<option value="leather">Leather</option>
											<option value="lining">Lining</option>
											<option value="cotton_cloth">Cotton Cloth</option>
											<option value="collar">Collar</option>
											<option value="cuffs">Cuffs</option>
											<option value="zips">Zips</option>
											<option value="button">Button</option>
											<option value="brand_tag">Brand Tag</option>
											<option value="thread">Thread</option>
										</select>
									</div>
								</div>
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Quantity</label>
                                        <input type="number" min="1" max="10000" class="form-control" id="usr1"> </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Price</label>
                                        <input type="number" min="1" max="100000" class="form-control" id="usr1"> </div>
                                </div>
                                </div>		</div>
								</form>
						</div>
					</div>
					<button type="button" class="btn btn-primary buttonedit1" onclick>Add Quotation</button>
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