<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String id = request.getParameter("id");
    String driver = "com.mysql.cj.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String database = "sdapro";
    String userid = "root";
    String password = "bakhti";
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<%
    try{
        connection = DriverManager.getConnection(connectionUrl+database, userid, password);
        statement=connection.createStatement();
        String sql ="select * from employee where employeeId="+id;
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
%>


<!DOCTYPE html>
<html>

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
<h1>Edit Employee data </h1>

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
                        <h2 class="page-title mt-5">Update Employee</h2>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form method="post" action="update_employee_process.jsp">
                        <input type="hidden" name="employeeId" value="<%=resultSet.getString("employeeId") %>">
                        <br>
                        Name:<br>
                        <input type="text" name="name" value="<%=resultSet.getString("name") %>">
                        <br>
                        Designation:<br>
                        <input type="text" name="designation" value="<%=resultSet.getString("designation") %>">
                        <br>
                        Employee Address:<br>
                        <input type="text" name="address" value="<%=resultSet.getString("address") %>">
                        <br>
                        Email :<br>
                        <input type="email" name="email" value="<%=resultSet.getString("email") %>">
                        <br>
                        Phone Number :<br>
                        <input type="text" name="phoneNumber" value="<%=resultSet.getString("phoneNumber") %>">
                        <br>
                        Age :<br>
                        <input type="text" name="age" value="<%=resultSet.getString("age") %>">
                        <br>
                        Date Of Birth :<br>
                        <input type="text" name="dateOfBirth" value="<%=resultSet.getString("dateOfBirth") %>">
                        <br>
                        Cnic :<br>
                        <input type="text" name="cnic" value="<%=resultSet.getString("cnic") %>">
                        <br>
                        gender :<br>
                        <input type="text" name="gender" value="<%=resultSet.getString("gender") %>">
                        <br>
                        DateOfJoining :<br>
                        <input type="text" name="dateOfJoining" value="<%=resultSet.getString("dateOfJoining") %>">
                        <br>
                        Salary :<br>
                        <input type="text" name="salary" value="<%=resultSet.getString("salary") %>">
                        <br>

                        <br>
                        <div class="row" style="display: flex;justify-content: center;margin-top: 4vmax;margin-bottom: 5vmax;">
                            <input type="submit"  value="Update employee"class="btn btn-success" refresh></input>
                        </div>
                    </form>
                    <%
                            }
                            connection.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </div>
            </div>

        </div>
    </div>
</div>


</body>
</html>

