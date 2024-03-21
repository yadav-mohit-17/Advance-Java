<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
<title>E-Banking</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-fns.js"></script>

</head>
<body>
  <%
            if (request.getParameter("message") != null) {%>
        <script>alert('Bank Added Succesfully');</script>
        <%}
            if (request.getParameter("m2") != null) {%>
        <script>alert('Login Failed Username/Password Wrong');</script> 
        
        <%}
        %>
<div id="shell">
  <div id="header">
      <center><h1 id="logo"><a href="#">E-Banking</a></h1></center>
   
  </div>
  <div id="navigation">
     <ul>
      <li><a href="adminhome.jsp">HOME</a></li>      
     <li><a href="addbank.jsp">Add Bank</a></li> 
      <li><a href="index.html">Logout</a></li>
    </ul>
    <div class="search">
      
    </div>
  </div>
<br><br><br><br><br><br><br><br>
    <center>
	<h2  style="color: #0b6c81">Add Bank Details</h2>
        <br>
    <hr>
           <form name="f" action="addbankact.jsp" method="post" >  <center>
<table>
   
        <tr>
            <th><font color="black" size="4">Bank Name :</th>
              <th><input type="text" name="username" id="userName1" placeholder= "Bank Name" style="height:30px; width:170px"></input>
              </th>
        </tr>

        <tr>
              <th><font color="black" size="4">Password: </th>
              <th><input type="password" name="password" id="password1" placeholder= Password style="height:30px; width:170px"></input>
              </th>
        </tr>
    
      <tr>
             <th><font color="black" size="4">Email :</th>
              <th><input type="text" name="email" id="userName1" placeholder= Email style="height:30px; width:170px"></input>
              </th>
        </tr>
    
      
    
       
	  <tr>
              <td>
                    <input type="submit" value="Add"  style="height:30px; width:65px" />
                   
            </td>
            </tr>
 
            
	</table>
                    </center>
     </form>
        
    
        <hr>
    
  <div class="footer">
    <div style="clear:both;"></div>
  </div>
</div>
<!-- END PAGE SOURCE -->
</html>