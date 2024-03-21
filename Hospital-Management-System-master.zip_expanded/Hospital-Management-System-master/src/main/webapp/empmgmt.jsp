<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.hospital.models.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Employee employee = (Employee) session.getAttribute("employee");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=employee.getFirstName()%></title>

<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

<link href="assets/css/dataTables.bootstrap.min.css" rel="stylesheet" />

<link href="assets/css/bootstrap.css" rel="stylesheet" />

<!--  Material Dashboard CSS    -->
<link href="assets/css/material-dashboard.css" rel="stylesheet" />

<link href="assets/css/jquery-ui.min.css" rel="stylesheet" />

<link href="assets/css/scrolling-nav.css" rel="stylesheet" />


<link href="assets/css/style.css" rel="stylesheet" />

<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="assets/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

<!--     Fonts and icons     -->
<link href="assets/css/font-awesome.min.css" rel="stylesheet" />

<!-- Date Picker -->
<link href="assets/css/date-picker.css" rel="stylesheet" />

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css'>

<script>
	function addEmployee() {
		demo.showNotification('top', 'right', 'Success Added Employee',
				'success');
	}

	function updateEmployee() {
		demo.showNotification('top', 'right', 'Success Updated Employee',
				'success');
	}

	function deleteEmployee() {
		demo.showNotification('top', 'right', 'Success Deleted Employee',
				'success');
	}

	function error() {
		demo.showNotification('top', 'right', 'Error Operations', 'danger');
	}
	
	function validatePassword() {
		
		var minNumberofChars = 6;
		var maxNumberofChars = 16;
		    
		var pass1 = document.getElementById("password").value;
		var pass2 = document.getElementById("confirm_password").value;
		var regularExpression  =  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/
		if (pass1 != pass2)
			{
			 demo.showNotification('top','right','Password not matched ','danger');
		  }
		
		  if(!regularExpression.test(pass1))
		    {
			 demo.showNotification('top','right','Password Must have at least one (upper case)-(lower case) letter and numbers','danger');
			}
		  
		if(pass1.length < minNumberofChars || pass1.length > maxNumberofChars)
		{
			 demo.showNotification('top','right','Password Must be at least 6 character ,can not exceed more than 16','danger');}
		}
      
		
		
	 document.getElementById('errorPass').click();
</script>

</head>
<body
	<c:if test="${not empty param['add']}">  onload="addEmployee();" </c:if>
	<c:if test="${not empty param['delete']}">  onload="deleteEmployee();" </c:if>
	<c:if test="${not empty param['update']}">  onload="updateEmployee();" </c:if>
	<c:if test="${not empty param['error']}">  onload="error();" </c:if>>

	<div class="wrapper">

		<jsp:include page="templates/user/side-bar.jsp" flush="true" />

		<div class="main-panel">

			<jsp:include page="templates/user/nav-bar.jsp" flush="true" />


			<c:choose>

				<c:when test="${ not empty param['uempid'] }">
					<jsp:include page="admin/updateEmployee.jsp" flush="true" />
				</c:when>

				<c:otherwise>
					<jsp:include page="admin/addEmployee.jsp" flush="true" />

				</c:otherwise>

			</c:choose>


			<%@include file="templates/footer.jsp"%>
		</div>

	</div>

	<script src="assets/js/jquery-3.1.0.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/material.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

	<!--  Notifications Plugin    -->
	<script src="assets/js/bootstrap-notify.js"></script>


	<!-- Material Dashboard javascript methods -->
	<script src="assets/js/material-dashboard.js"></script>

	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>


	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/jquery.bootstrap.wizard.js"
		type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="assets/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="assets/js/jquery.validate.min.js"></script>


	<script src="assets/js/jquery.dataTables.min.js"></script>

	<script src="assets/js/dataTables.bootstrap.min.js"></script>

	<!-- Date Picker -->
	<script src="assets/js/bootstrap-datepicker.js"></script>

</body>
</html>