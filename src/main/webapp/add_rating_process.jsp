<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
    String e_name=request.getParameter("e_name");
    String rating_star=request.getParameter("rating_star");
    String review_text=request.getParameter("review_text");

    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdapro", "root", "bakhti");
        PreparedStatement ps = null;
        Statement st=conn.createStatement();
        st.executeUpdate("insert into rating(e_name, rating_star,review_text)values('"+e_name+"','"+rating_star+"','"+review_text+"')");
    }
    catch (Exception e) {
        throw new RuntimeException(e);
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