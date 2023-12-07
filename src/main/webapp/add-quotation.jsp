<%@ page import="com.erp.entity.Admin" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
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
<%
	try{
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost/sdapro?user=root&password=bakhti");
		Statement statement = connection.createStatement() ;
		resultset =statement.executeQuery("select * from vendor") ;
%>

<div class="main-wrapper">
	<div class="header">
		<div class="header-left">
			<b><a href="index.html" class="logo"> <span class="logoclass">ERP</span>
			</a></b>
			<b><a href="index.html" class="logo logo-small"
				  style="font-size: large; color:#009688;">ERP</a></b>
		</div>
		<a href="javascript:void(0);" id="toggle_btn"> <i
				class="fe fe-text-align-left"></i> </a>
		<a class="mobile_btn" id="mobile_btn"> <i class="fas fa-bars"></i> </a>
		<ul class="nav user-menu">

			<li class="nav-item dropdown has-arrow">
				<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> <span
						class="user-img"><i class="fa-solid fa-bars"></i></span> </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="profile.html">My Profile</a><a
						class="dropdown-item" href="login.html">Logout</a></div>
			</li>
		</ul>

	</div>
	<div class="sidebar" id="sidebar">
		<div class="sidebar-inner slimscroll">
			<div id="sidebar-menu" class="sidebar-menu">
				<ul>
					<li class="active"> <a href="index.html"><i class="fas fa-tachometer-alt"></i>
						<span>Dashboard</span></a> </li>
					<li class="list-divider"></li>
					<li class="submenu"> <a href="#"><i class="fas fa-user"></i> <span>Employee</span>
						<span class="menu-arrow"></span></a>
						<ul class="submenu_class" style="display: none;">
							<li><a href="all-employee.html"> All Employees </a></li>
							<li><a href="add-employee.html"> Add Employee </a></li>

						</ul>
					</li>
					<li class="submenu"> <a href="#"><i class="fa-solid fa-bars"></i></fa-solid><span>Products</span>
						<span class="menu-arrow"></span></a>
						<ul class="submenu_class" style="display: none;">
							<li><a href="all-jackets.html">All Products </a></li>
							<li><a href="add-jacket.html"> Add Product </a></li>
						</ul>
					</li>
					<li class="submenu"> <a href="#"><i class="fas fa-suitcase"></i> <span>Materials</span>
						<span class="menu-arrow"></span></a>
						<ul class="submenu_class" style="display: none;">
							<li><a href="all-materials.html"> All Materials </a></li>
							<li><a href="create-materials.html"> Add Material </a></li>

						</ul>
					</li>
					<li class="submenu"> <a href="#"><i class="fa fa-industry"></i> <span>Vendors</span>
						<span class="menu-arrow"></span></a>
						<ul class="submenu_class" style="display: none;">
							<li><a href="all-vendors.html"> All Vendors </a></li>
							<li><a href="add-vendors.html"> Add Vendors </a></li>
							<li><a href="add-quotations.html"> Add Quotations </a></li>
							<li><a href="all-quotations.html"> All Quotations </a></li>
						</ul>
					</li>

					<li class="submenu"> <a href="#"><i class="fa-solid fa-clipboard-list"></i><span>Order
									Material</span> <span class="menu-arrow"></span></a>
						<ul class="submenu_class" style="display: none;">
							<li><a href="all-orders.html">All Orders </a></li>
							<li><a href="add-order.html"> Add Order </a></li>
						</ul>
					</li>
					<li class="submenu"> <a href="#"><i class="fa-solid fa-star"></i><span>Quality</span>
						<span class="menu-arrow"></span></a>
						<ul class="submenu_class" style="display: none;">
							<li><a href="report.jsp">Quality Report</a></li>
							<li><a href="rate-product.jsp">Rate product</a></li>
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
						<h2 class="page-title mt-5">Add Quotations</h2>

					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form method="post" action="add_quotation_process.jsp">

						<center>
							<h2> Vendor Name </h2>
							<label>
								<select name="vendor_name">
									<%  while(resultset.next()){ %>
									<option><%= resultset.getString(2)%></option>
									<% } %>
								</select>
							</label>
						</center>
						Product name:<br>
						<input type="text" name="p_name">
						<br>
						Price :<br>
						<input type="number" name="price">
						<br>
						Total Quantity :<br>
						<input type="number" name="quantity">
						<br>

						<br><br>
						<div style="display: flex;justify-content: center;margin-bottom: 200px;">
							<input type="submit" value="submit" style="margin-bottom: 100px;" class="btn btn-primary buttonedit1 my-2" ></input>
						</div>
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
<%
	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>
</html>