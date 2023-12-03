<%@ page import="java.util.*" %>
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
	<div class="main-wrapper">
		<div class="header">
			<div class="header-left">
				<b><a href="dashboard.jsp" class="logo"> <span class="logoclass">ERP</span> </a></b>
				<b><a href="dashboard.jsp" class="logo logo-small" style="font-size: large; color:#009688;">ERP</a></b>
			</div>
			<a href="javascript:void(0);" id="toggle_btn"> <i class="fe fe-text-align-left"></i> </a>
			<a class="mobile_btn" id="mobile_btn"> <i class="fas fa-bars"></i> </a>
			<ul class="nav user-menu">
				
				<li class="nav-item dropdown has-arrow">
					<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> <span class="user-img"><i class="fa-solid fa-bars"></i></span> </a>
					<div class="dropdown-menu">
					<a class="dropdown-item" href="profile.html">My Profile</a><a class="dropdown-item" href="index.jsp">Logout</a></div>
				</li>
			</ul>
		
		</div>
		<div class="sidebar" id="sidebar">
			<div class="sidebar-inner slimscroll">
				<div id="sidebar-menu" class="sidebar-menu">
					<ul>
						<li class="active"> <a href="dashboard.jsp"><i class="fas fa-tachometer-alt"></i> <span>Dashboard</span></a> </li>
						<li class="list-divider"></li>
						<li class="submenu"> <a href="#"><i class="fas fa-user"></i> <span>Employee</span> <span class="menu-arrow"></span></a>
							<ul class="submenu_class" style="display: none;">
								<li><a href="all-employee.jsp"> All Employees </a></li>
								<li><a href="add-employee.jsp"> Add Employee </a></li>
							
							</ul>
						</li>
						<li class="submenu"> <a href="#"><i class="fa-solid fa-bars"></i></fa-solid><span>Products</span> <span class="menu-arrow"></span></a>
							<ul class="submenu_class" style="display: none;">
								<li><a href="all-products.jsp">All Products </a></li>
								<li><a href="add-product.jsp"> Add Product </a></li>
							</ul>
						</li>
						<li class="submenu"> <a href="#"><i class="fas fa-suitcase"></i> <span>Materials</span> <span class="menu-arrow"></span></a>
							<ul class="submenu_class" style="display: none;">
								<li><a href="all-materials.jsp"> All Materials </a></li>
								<li><a href="add-material.jsp"> Add Material </a></li>
								
							</ul>
						</li>
						<li class="submenu"> <a href="#"><i class="fa-solid fa-clipboard-list"></i><span>Order Material</span> <span class="menu-arrow"></span></a>
							<ul class="submenu_class" style="display: none;">
								<li><a href="all-orders.jsp">All Orders </a></li>
								<li><a href="add-order.jsp"> Add Order </a></li>
							</ul>
						</li>
						<li class="submenu"> <a href="#"><i class="fa fa-industry"></i> <span>Vendors</span> <span class="menu-arrow"></span></a>
							<ul class="submenu_class" style="display: none;">
								<li><a href="all-vendors.jsp"> All Vendors </a></li>
								<li><a href="add-vendors.jsp"> Add Vendors </a></li>

							</ul>
						</li>
						<li class="submenu"> <a href="#"><i class="fa-solid fa-star"></i><span>Quality</span> <span class="menu-arrow"></span></a>
							<ul class="submenu_class" style="display: none;">
								<li><a href="report.html">Quality Report</a></li>
								<li><a href="rate-product.html">Rate product</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
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
									<label>Material Id</label>
									<input type="text" class="form-control" required name="id"> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Name</label>
									<input type="text" class="form-control"  required name="name"> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Quantity</label>
									<input type="text" class="form-control" required name="stock"> </div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Price</label>
									<input type="text" class="form-control" required name="price"> </div>
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