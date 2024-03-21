<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.user.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	UserBean ub=(UserBean)session.getAttribute("ub");
	out.println("Welcome User :"+ub.getFirstName()+"<br>");
	%>
	<a href="view">ViewProducts</a>
	<a href="logout">Logout</a>
</body>
</html>