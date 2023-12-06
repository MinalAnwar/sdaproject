<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%><!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>ERP</title>
	<link rel="shortcut icon" type="image/x-icon" href="download.png">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
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
				<div class="page-header mt-5">
					<div class="row">
						<div class="col">
							<h3 class="page-title">Profile</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
								<li class="breadcrumb-item active">Profile</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="profile-header">
							<div class="row align-items-center">

								<div class="col ml-md-n2 profile-user-info">
									<h4 class="user-name mb-3">${user.getName()}</h4>
									<h6 class="text-muted mt-1">${user.getDesignation()}</h6>
									<div class="user-Location mt-1"><i class="fas fa-map-marker-alt"></i>${user.getAddress()}</div>
								</div>
							</div>
						</div>
						<div class="profile-menu">
							<ul class="nav nav-tabs nav-tabs-solid">
								<li class="nav-item"> <a class="nav-link active" data-toggle="tab" href="#per_details_tab">About</a> </li>
								<li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#password_tab">Password</a> </li>
							</ul>
						</div>

						<div class="tab-content profile-tab-cont">
							<div class="tab-pane fade show active" id="per_details_tab">
								<div class="row">
									<div class="col-lg-6">
										<div class="card">
											<div class="card-body">
												<h5 class="card-title d-flex justify-content-between">
													<span>Personal Details</span>
													<a class="edit-link" data-toggle="modal" href="#edit_personal_details"><i class="fa fa-edit mr-1"></i>Edit</a>
													</h5>
												<div class="row mt-5">
													<p class="col-sm-3 text-sm-right mb-0 mb-sm-3">Name</p>
													<p class="col-sm-9">${user.getName()}</p>
												</div>
												<div class="row">
													<p class="col-sm-3 text-sm-right mb-0 mb-sm-3">Date of Birth</p>
													<p class="col-sm-9">${user.getDateOfBirth()}</p>
												</div>
												<div class="row">
													<p class="col-sm-3 text-sm-right mb-0 mb-sm-3">Email ID </p>
													<p class="col-sm-9"><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="caaeabbca3aeaba6bcabb8afb08aafb2aba7baa6afe4a9a5a7">${user.getEmail()}</a></p>
												</div>
												<div class="row">
													<p class="col-sm-3 text-sm-right mb-0 mb-sm-3">Mobile</p>
													<p class="col-sm-9">${user.getPhoneNumber()}</p>
												</div>
												<div class="row">
													<p class="col-sm-3 text-sm-right mb-0">Address</p>
													<p class="col-sm-9 mb-0">${user.getAddress()}</p>
												</div>
											</div>
										</div>
										<div class="modal fade" id="edit_personal_details" aria-hidden="true" role="dialog">
											<div class="modal-dialog modal-dialog-centered" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title">Personal Details</h5>
														<button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
													</div>
													<div class="modal-body">
														<form method="post" action="updateProfile">
															<div class="row form-row">
																<div class="col-12 col-sm-6">
																	<div class="form-group">
																		<label>Name</label>
																		<input type="text" name="name" class="form-control" value="${user.getName()}"> </div>
																</div>
																<c:choose>
																<c:when test="${designation==null}">
																<div class="col-12">
																	<div class="form-group">
																		<label>Designation</label>
																		<div>
																			<select  name="designation" class="form-control">
																				<option value="Manager" >Manager</option>
																				<option value="Quality Analyst" >Quality Analyst</option>
																				<option value="Admin" >Admin</option>
																			</select>
																		</div>
																	</div>
																</div>
																</c:when>
																</c:choose>
																<div class="col-12">
																	<div class="form-group">
																		<label>Date of Birth</label>
																		<div >
																			<input type="date" name="dateOfBirth" class="form-control" value="${user.getDateOfBirth()}"> </div>
																	</div>
																</div>
																<div class="col-12 col-sm-6">
																	<div class="form-group">
																		<label>Email ID</label>
																		<input type="email" name="email" class="form-control" value="${user.getEmail()}"> </div>
																</div>
																<div class="col-12 col-sm-6">
																	<div class="form-group">
																		<label>Mobile</label>
																		<input type="text" name="phoneNumber" value="${user.getPhoneNumber()}" class="form-control"> </div>
																</div>
																<div class="col-12 col-sm-6">
																	<div class="form-group">
																		<label>CNIC</label>
																		<input type="text" name="cnic" value="${user.getCnic()}" class="form-control"> </div>
																</div>
																<div class="col-12 col-sm-6">
																	<div class="form-group">
																		<label>Age</label>
																		<input type="text" name="age" value="${user.getAge()}" class="form-control"> </div>
																</div>
																<div class="col-12">
																	<h5 class="form-title"><span>Address</span></h5> </div>
																<div class="col-12">
																	<div class="form-group">
																		<label>Address</label>
																		<input type="text" name="address" class="form-control" value="${user.getAddress()}"> </div>
																</div>
															</div>
															<button type="submit" class="btn btn-primary btn-block">Save Changes</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div id="password_tab" class="tab-pane fade">
								<div class="card">
									<div class="card-body">
										<h5 class="card-title">Change Password</h5>
										<div class="row">
											<div class="col-md-10 col-lg-6">
												<form method="post" action="updatePassword">
													<div class="form-group">
														<label>Old Password</label>
														<input name="oldPassword" type="password" class="form-control"> </div>
													<div class="form-group">
														<label>New Password</label>
														<input name="newPassword" type="password" class="form-control"> </div>
													<div class="form-group">
														<label>Confirm Password</label>
														<input name="confirmedPassword" type="password" class="form-control"> </div>
													<button class="btn btn-primary" type="submit">Save Changes</button>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="disable.js"></script>
	<script data-cfasync="false" src="../../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
	<script src="assets/js/jquery-3.5.1.min.js"></script>
	<script src="assets/js/popper.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/moment.min.js"></script>
	<script src="assets/js/select2.min.js"></script>
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
	<script src="assets/js/script.js"></script>
</body>

</html>