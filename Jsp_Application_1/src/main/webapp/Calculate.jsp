<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
		int fact;
		int factorial(int n)
		{
			fact=1;
			for(int i=n;i>=1;i--)
			{
				fact=fact*i;
			}
			return fact;
		}
	%>
	
	<%
		int n=Integer.parseInt(request.getParameter("v"));
		int res=factorial(n);
		out.println("Factorial :"+res+"<br>");
	%>
	
	<%@ include file="input.html" %>
</body>
</html>