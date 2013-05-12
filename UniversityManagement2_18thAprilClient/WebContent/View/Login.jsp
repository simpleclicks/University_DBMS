<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<%@include file="home_login.jsp" %>
</head>
<body>
<!--     <table border="0" cellpadding="0" cellspacing="0" width="700">
        <tr><td bgcolor="white"><img src="http://upload.wikimedia.org/wikipedia/commons/2/23/University_of_Sydney_Main_Quadrangle.jpg" width="80" height="100" /></td>
        <td bgcolor="white"><h6><u><font face="Maiandra GD" color="#4AA02C"><b>UNIVERSITY MANAGEMENT</b></font></u><br /></h6></td>
         <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>
    <h1> <div align=center><font size="6" face="chiller" color="#151B54">UNIVERSITY MANAGEMENT</font> </div></h1>
        </td>

    </table>
 -->    
  

<!-- <style type="text/css">
.form {
	font: Lucida Handwriting;
	color: #2554C7;
	background-color: #C9B2DA;
	size: 5;
}

</style>
 -->
<form name="form1" id="form1" class="form" method="post" action="Login">
			<table align="center" class="form" width="100%">
			<tr>
				<td align="right"><h3>Enter User Name and Password</h3></td>
				</tr>
			<tr>
			<td align="right"> <span id="uname" class="form" ></span><label id="label1" for="username" class="detail">User Name:</label></td>			
			    <td align="left"><input type="text" id="uname" name="uname" size="25" title="Enter user name"  onchange="isnotsplchar(this,'No special characters allowed') " required></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="pwd" class="form" ></span><label id="label2" for="password" class="detail">Password:</label></td>			
			    <td align="left"><input type="password" id="pwd" name="pwd" size="25" title="Enter password" required></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    <tr>
				<td align="right"> <input type="reset" name="reset" value="Reset"> </td>
				 <td align="left"><input type="submit" name="Courseinfo" value="Submit"> </td>
				</tr> 
			    </table>
</form>


<%@include file="footer.jsp"%>