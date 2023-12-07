<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
    String vendor_name=request.getParameter("vendor_name");
    String p_name=request.getParameter("p_name");
    String price=request.getParameter("price");
    String quantity=request.getParameter("quantity");


    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdapro", "root", "bakhti");
        PreparedStatement ps = null;
        Statement st=conn.createStatement();
        st.executeUpdate("insert into quotation(vendor_name, p_name,price,quantity)values('"+vendor_name+"','"+p_name+"','"+price+"','"+quantity+"')");
    }
    catch (Exception e) {
        throw new RuntimeException(e);
    }
%>

<html>
<head>
    <title>index</title>
</head>
<body>
<jsp:forward page="/index.jsp" />
</body>
</html>