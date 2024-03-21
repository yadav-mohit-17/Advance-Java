<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg=(String)session.getAttribute("msg");
		out.println(msg+"<br>");
	%>
	<a href="userlogin.html">UserLogin</a>
	<a href="AdminLogin.html">AdminLogin</a>
</body>
</html>