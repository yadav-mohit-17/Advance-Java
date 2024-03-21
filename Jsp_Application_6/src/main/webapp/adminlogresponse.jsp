<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.admin.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean ab=(AdminBean) session.getAttribute("ab");
	out.println("Welcome Admin :"+ab.getFirstName()+"<br>");
	%>
	<a href="view">ViewProducts</a>
	<a href="logout">Logout</a>
</body>
</html>