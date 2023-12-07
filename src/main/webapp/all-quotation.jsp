<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.erp.entity.Admin" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylehseet" href="https://cdn.oesmith.co.uk/morris-0.5.1.css">
	<link rel="stylesheet" href="assets/plugins/morris/morris.css">
	<link rel="stylesheet" href="assets/css/style.css"> 
	<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet"  type='text/css'>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<script src="https://kit.fontawesome.com/4ecf238d25.js" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="assets/css/table.css">
		<script>
			
		$(document).ready(function(){
		$('[data-toggle="tooltip"]').tooltip();
		var actions = $("table td:last-child").html();
		// Append table with add row form on add new button click
		
		// Add row on add button click
		$(document).on("click", ".add", function(){
		var empty = false;
		var input = $(this).parents("tr").find('input[type="text"]');
		input.each(function(){
		if(!$(this).val()){
		$(this).addClass("error");
		empty = true;
		} else{
		$(this).removeClass("error");
		}
		});
		$(this).parents("tr").find(".error").first().focus();
		if(!empty){
		input.each(function(){
		$(this).parent("td").html($(this).val());
		});
		$(this).parents("tr").find(".add, .edit").toggle();
		$(".add-new").removeAttr("disabled");
		}
		});
		// Edit row on edit button click
		$(document).on("click", ".edit", function(){
		$(this).parents("tr").find("td:not(:last-child):not(:first-child )").each(function(){
		$(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
		});
		$(this).parents("tr").find(".add, .edit").toggle();
		$(".add-new").attr("disabled", "disabled");
		});
		// Delete row on delete button click
		//$(document).on("click", ".delete", function(){
		//$(this).parents("tr").remove();
		//$(".add-new").removeAttr("disabled")
		
		//;
		//});
		});
	
		</script>

</head>

<body>
<jsp:include page="/templates/dashboard.jsp"/>
		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col" style="display: flex;justify-content: space-between;">
							<div class="mt-5">
								<h4 class="card-title float-left mt-2">All Quotations</h4>
								
                            </div>				
						</div>
						
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="card card-table">
							<div class="card-body booking_card">
								
								<div class="table-responsive">
									<table class="datatable table table-stripped table table-hover table-center mb-0">
										<thead>
										<tr>
										<th  >Vendor Name</th>
										<th ></th>
										<th ></th>
										<th ></th>
										<th >Price</th>
										</tr>
										</thead>
										<tbody style="cursor: pointer;">
											

                                            <tr>
                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal">Ahmed</td>
                                                <th data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></th>
                                                <th data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></th>
                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></td>
                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal">5000</td>
                                                <td>
                                                    <a class="delete" title="Delete"  data-target="#delete_asset" href="#" data-toggle="modal"><i class="material-icons">&#xE872;</i></a>
													<a class="check" title="Check"  data-target="#check_asset" href="#" data-toggle="modal"><i class="fa-solid fa-check"></i></a>
												</td>
                                                </tr>

                                                    

                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal">Ahmed</td>
                                                <th data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></th>
                                                <th data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></th>
                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></td>
                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal">5000</td>
                                                <td>
                                                <a class="delete" title="Delete"  data-target="#delete_asset" href="#" data-toggle="modal"><i class="material-icons">&#xE872;</i></a>
                                                <a class="check" title="Check"  data-target="#check_asset" href="#" data-toggle="modal"><i class="fa-solid fa-check"></i></a>
                                                    </td>
                                                </tr>
                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal">Ahmed</td>
                                                <th data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></th>
                                                <th data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></th>
                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal" ></td>
                                                <td data-target="#ShowCompleteQuoteInfo" data-toggle="modal">5000</td>
                                                <td>
                                                    <a class="delete" title="Delete"  data-target="#delete_asset" href="#" data-toggle="modal"><i class="material-icons">&#xE872;</i></a>
													<a class="check" title="Check"  data-target="#check_asset" href="#" data-toggle="modal"><i class="fa-solid fa-check"></i></a>
												</td>
                                                        </tr>
                                                
											
											
											</tbody>
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
							<h3 class="delete_class">Do you really want to delete these records? This process cannot be undone.</h3>
							<div class="m-t-20"> <a href="#" class="btn btn-white" data-dismiss="modal">Close</a>
								<button type="submit" class="btn btn-danger ">Delete</button>
							
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="check_asset" class="modal fade delete-modal" role="dialog">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-body text-center"> 
							<h3 class="delete_class">Are you sure that you want to approve this quotation?</h3>
							<div class="m-t-20"> <a href="#" class="btn btn-success" data-dismiss="modal">Yes</a>
								<button type="submit" class="btn btn-danger ">No</button>
							
							</div>
						</div>
					</div>
				</div>
			</div>

            <div id="ShowCompleteQuoteInfo" class="modal fade delete-modal" role="dialog">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-body text-center"> 
							<h3 class="delete_class">This is the entire quotation</h3>
		
                            <div class="table-responsive">
                                <table class="datatable table table-stripped table table-hover table-center mb-0">
                                    <thead>
                                        <tr>
                                        <th  >Name</th>
                                        <th></th>
                                        <th>Quantity</th>
                                        <th  >Price</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        
                                        <tr>
                                        <td>Gloves</td>
                                        <th></th>
                                        <td>22</td>
                                        <td>5000</td>
                                        </tr>

                                        <tr>
                                            <td>Gloves</td>
                                            <th></th>
                                            <td>23</td>
                                            <td>5000</td>
                                            </tr>


                                            <tr>
                                                <td>Gloves</td>
                                                <th></th>
                                                <td>11</td>
                                                <td>5000</td>
                                                </tr>

                                            </tbody>
                                </table>
                            </div>				</div>
					</div>
				</div>
			</div>

        </div>
	</div>
	<script data-cfasync="false" src="../../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
	<script src="assets/js/jquery-3.5.1.min.js"></script>
	<script src="assets/js/popper.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="assets/plugins/datatables/datatables.min.js"></script>
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/raphael/raphael.min.js"></script>
	<script src="assets/js/script.js"></script>
</body>

</html>