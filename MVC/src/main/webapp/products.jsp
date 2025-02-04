<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%@page import="java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@page import="com.dao.DBConnect"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
 rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
 crossorigin="anonymous">
</head>
<body>
<%
Connection con=DBConnect.getConnection();
PreparedStatement pst=con.prepareStatement("select *from products");
ResultSet rs=pst.executeQuery();
%>
<div class="col-6 offset-3 border shadow p-3 mt-3">
<h1 class="text-center mt-2 mb-2 display-6">Product Data</h1>
<table class="table table-bordered">
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Color</th>
<th>Actions</th>
</tr>
<%
while(rs.next()){
%>
<tr>
<td><%=rs.getInt(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getDouble(3)%></td>
<td><%=rs.getString(4)%></td>
<td>
<a href="ProductController?pid=<%=rs.getInt(1)%>" class="btn btn-danger">Delete</a>
<a href="update.jsp?pid=<%=rs.getInt(1)%>" class="btn btn-warning">Update</a>
</td>
</tr>
<%
}
%>
</table>
<div class="text-center mt-3">
    <a href="index.jsp" class="btn btn-primary">Back to Index</a>
</div>

</div>
</body>
</html>