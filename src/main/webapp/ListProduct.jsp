<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 </head>
<body>

	<%  ResultSet rs =  (ResultSet)request.getAttribute("rs"); %>

	<%while(rs.next()) {%>
		<%=rs.getString("productName") %><Br> 
	
	<%} %>

</body>
</html>