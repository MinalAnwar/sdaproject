<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.erp.entity.Admin" %>
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
	<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
	<link rel="stylesheet" href="assets/plugins/datatables/datatables.min.css">
	<link rel="stylesheet" href="assets/css/feathericon.min.css">
	<link rel="stylesheet" href="assets/plugins/morris/morris.css">
	<link rel="stylesheet" href="assets/css/style.css"> 
	<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<script src="https://kit.fontawesome.com/4ecf238d25.js" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">

	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	






	<link rel="stylesheet" href="assets/css/table.css">
	<script>

		$(document).ready(function () {
			$('[data-toggle="tooltip"]').tooltip();
			var actions = $("table td:last-child").html();

			$(document).on("click", ".add", function () {
				var empty = false;
				var input = $(this).parents("tr").find('input[type="text"]');
				input.each(function () {
					if (!$(this).val()) {
						$(this).addClass("error");
						empty = true;
					} else {
						$(this).removeClass("error");
					}
				});
				$(this).parents("tr").find(".error").first().focus();
				if (!empty) {
					input.each(function () {
						$(this).parent("td").html($(this).val());
					});
					$(this).parents("tr").find(".add, .edit").toggle();
					$(".add-new").removeAttr("disabled");
				}
			});
			$(document).on("click", ".edit", function () {
				var currentRow = $(this).closest("tr");
				var arr = [];
				//itemid
				var itemId = $(this).closest("tr").find("td:first-child").text();
				currentRow.find("td:not(:last-child)").each(function () {
					var currentText = $(this).text();
					$(this).html('<input type="text" class="form-control" value="' + currentText + '">');
					arr.push($(this).find('input[type="text"]').val());
				});
				currentRow.find(".add, .edit").toggle();
				$(".add-new").prop("disabled", true);
				console.log("Initial Input values:", arr);

				//when add button is pressed
				$(".add").on("click", function () {
					// Array to store input values when "Add" is pressed
					var inputValues = [];
					currentRow.find("td:not(:last-child)").each(function () {
						// Store the input values in the array
						inputValues.push($(this).find('input[type="text"]').val());
					});
					//printing values
					console.log("Updated Input values:", inputValues);
					$.ajax({
						type: 'GET',
						url: 'productUpdate?productId=' + inputValues[0] + '&productName=' + inputValues[1] + '&productQuantity=' + inputValues[2] + '&productPrice=' + inputValues[3] + '&oldID=' + arr[0],
						success: function (response) {
							// On successful update, you can handle the response if needed
							location.reload();
						},
						error: function (error) {
							// Handle errors here
							console.log(error);
						}
					});


				});
			});
		});

	</script>

</head>

<body>
<jsp:include page="/templates/dashboard.jsp"/>
		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row align-items-center">
					<div class="col">
					<h3 class="page-title mt-5">All Products</h3>
					</div>
					</div>
					</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="card card-table">
							<div class="card-body booking_card">
								<div class="table-responsive">
									<table class="datatable table table-stripped table table-hover table-center mb-0"  data-sorter="false">
										<thead>
										<tr>
											<th >ID</th>
											<th>Name</th>
											<th>Stock</th>
											<th>Price</th>
										</tr>
										</thead>
										<tbody>
										<%
											Admin user = new Admin();
											ResultSet result = user.viewInventory("product");
											try {
												while (result.next()) {
										%>
										<tr>
											<td><%= result.getInt("productId") %></td>
											<td><%= result.getString("name") %></td>
											<td><%= result.getInt("price") %></td>
											<td><%= result.getInt("totalQuantity") %></td>
											<td>
												<a class="add" title="Add"><i class="material-icons">&#xE03B;</i></a>
												<a class="edit" title="Edit"><i class="material-icons">&#xE254;</i></a>
												<a class="delete" title="Delete" data-target="#delete_asset" onclick="sendRequestWithId(this)" data-product-id="<%= result.getInt("productId")%>"><i class="material-icons">&#xE872;</i></a>

												<%

													Boolean isValid = (Boolean) request.getAttribute("valid");
													if (isValid != null && !isValid) {
												%>
												</p>
												<div style="color: red;">Cannot delete Product</div>
												<%
													}
												%>
											</td>
										</tr>
										<%
												}
											} catch (Exception e) {
												throw new RuntimeException(e);
											}
										%>

										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		

			<div id="delete_asset" class="modal fade delete-modal" role="dialog">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-body text-center"> <img src="assets/img/sent.png" alt="" width="50" height="46">
							<h3 class="delete_class">Are you sure want to delete this Asset?</h3>
							<div class="m-t-20"> <a href="#" class="btn btn-white" data-dismiss="modal">Close</a>
								<button type="submit" id="delete_button_modal" class="btn btn-danger">Delete</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script>
				function sendRequestWithId(element) {
					var productId=element.getAttribute("data-product-id");
					//show alert by using its id and class
					$('#delete_asset').modal('show');

					// Attach a click event to the Delete button using its id in the modal then this function do the deletion
					$('#delete_button_modal').on('click', function () {
						// Make an AJAX request to delete the record
						$.ajax({
							type: 'GET',
							url: 'productdelete?productID=' + productId,
							success: function (response) {
								// On successful deletion, remove the row
								$('#row_' + productId).remove();
								// Hide the modal using its id after deletion
								$('#delete_asset').modal('hide');
								location.reload();
							},
							error: function (error) {
								$('#delete_asset').modal('hide');
							}
						});

						// Remove the click event to prevent multiple clicks
						$('#delete_button_modal').off('click');
					});
				}
			</script>
			<script src="disable.js"></script>
	<script data-cfasync="false" src="../../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
	<script src="assets/js/jquery-3.5.1.min.js"></script>
	<script src="assets/js/popper.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/raphael/raphael.min.js"></script>
	<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="assets/plugins/datatables/datatables.min.js"></script>
	<script src="assets/js/script.js"></script>
</body>

</html>