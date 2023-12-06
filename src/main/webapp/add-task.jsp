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
</head>


<body>
<jsp:include page="/templates/dashboard.jsp"/>
    <div class="page-wrapper">
        <div class="content container-fluid">
            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col">
                        <h3 class="page-title mt-5">Add Tasks</h3> </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form method="post" action="addTask">
                        <div class="row formtype">

                            <div class="col-md-5">
                                <div class="form-group">
                                    <label>Task Name</label>
                                    <input name = "name"  class="form-control" type="text"  value="" required> </div>
                            </div>

                            <div class="col-md-5">
                                <div class="form-group">
                                    <label>Task Desciption</label>
                                    <input name = "description"  class="form-control" type="text"  value="" required> </div>
                            </div>
                            <div class="col-md-5">
                                <div class="form-group">
                                    <label for="status">Status</label>
                                    <select class="form-control" required name="status" id="status">
                                        <option value="pending">Select Status</option>
                                        <option value="pending">Pending</option>
                                        <option value="completed">Completed</option>
                                        <option value="inprogress">In Progress</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-5">
                                <div class="form-group">
                                    <label>Deadline</label>
                                    <input type="date" name = "deadline" class="form-control" required> </div>
                            </div>
                        </div>
                        <button class="btn btn-primary btn-block" type="submit" style="width: 20%;">Add Task</button>
                            <%
							Boolean isValid = (Boolean) request.getAttribute("valid");
							if (isValid != null && !isValid) {
						%>
                </div>
                <div style="color: red;">Cannot Add New Task</div>
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
<script data-cfasync="false" src="../../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="assets/js/jquery-3.5.1.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/plugins/raphael/raphael.min.js"></script>
<script src="assets/plugins/morris/morris.min.js"></script>
<script src="assets/js/chart.morris.js"></script>
<script src="assets/js/script.js"></script>
</body>

</html>