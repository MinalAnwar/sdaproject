<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/sdapro?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false";%>
<%!String user = "root";%>
<%!String psw = "bakhti";%>
<%
    String id = request.getParameter("employeeId");
    String name=request.getParameter("name");
    String designation=request.getParameter("designation");
    String address=request.getParameter("address");
    String email=request.getParameter("email");
    String phoneNumber=request.getParameter("phoneNumber");
    String ag=request.getParameter("age");
    int age = Integer.parseInt(ag);
    String dateOfBirth=request.getParameter("dateOfBirth");
    String cnic=request.getParameter("cnic");
    String gender=request.getParameter("gender");
    String dateOfJoining=request.getParameter("dateOfJoining");
    String sal=request.getParameter("salary");
    int salary = Integer.parseInt(sal);
    if(id != null)
    {
        Connection con = null;
        PreparedStatement ps = null;
        try
        {
            Class.forName(driverName);
            con = DriverManager.getConnection(url,user,psw);
            String sql="Update employee set name=?,designation=?,address=?,email=?, phoneNumber=?, age=?, dateOfBirth=?, cnic=?, gender=?, dateOfJoining=?, salary=? where employeeId="+id;
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.setString(5, phoneNumber);
            ps.setInt(6, age);
            ps.setString(7, dateOfBirth);
            ps.setString(8, cnic);
            ps.setString(9, gender);
            ps.setString(10, dateOfJoining);
            ps.setInt(11, salary);
            ps.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
%>

<html>
<head>
    <title>dashboard</title>
</head>
<body>
<jsp:forward page="/dashboard.jsp" />
</body>
</html>