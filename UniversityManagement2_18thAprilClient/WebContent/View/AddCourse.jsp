<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instructor</title>
-->
<%@include file="Header.jsp"%>
<style type="text/css">

.form{
	font: Lucida Handwriting;
	color: #2554C7;
	background-color: #C9B2DA;
	size: 5;
}
.detail{
	font: Lucida Handwriting;
	color: #254117;
	size: 4;
}
</style>
<script type="text/javascript">


function isnotsplchar(element,alerttxt)
{
	var val = element.value;
	var regexpr =/[^A-Za-z0-9]/;
	result= regexpr.test(val);
	if(result == true)
	{
		alert(alerttxt);
		element.value="";
		return false;
		
	}
	return true;
}



function isallfieldsfilled()
{
	//alert("allfield");
	var flag = 0,cflag=0;
	cname = document.form1.cname.value;
	cid = document.form1.cid.value;
	location = document.form1.location.value;

	if (cname == "" || cname == null  || cid == "" || cid == null || location == "" || location == null)
	{
		alert("You have not filled all the fields");
		return false;
	}

	
	return true;

}

</script>
<!--  </head>
<body style="background:#C9B2DA;">
	--><div id="div1" class="form">
		<form name="form1" id="form1" class="form" method="post" action="AddInstructor">
			<table align="center" class="form" width="100%">
				<tr>
				<td align="right"><h3>Enter Course Details</h3></td>
				</tr>
				<tr/>
				<tr>
				<td align="right"> <span id="name" class="form" ></span><label id="label1" for="cname" class="detail">Course Name:</label></td>			
			    <td align="left"><input type="text" id="cname" name="cname" size="25" title="Enter course name"  onchange="isnotsplchar(this,'No special characters allowed') "></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="id" class="form" ></span><label id="label2" for="cid" class="detail">Course Id:</label></td>			
			    <td align="left"><input type="text" id="cid" name="cid" size="25" title="Enter course id"></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="loc" class="form" ></span><label id="label3" for="location" class="detail">Location:</label></td>			
			    <td align="left"><input type="text" id="location" name="location" size="25" title="Enter location"></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			     <tr>
				<td align="right"> <input type="reset" name="reset" value="Reset"> </td>
				 <td align="left"><input type="submit" name="instructorinfo" value="Submit" onclick=" return isallfieldsfilled()"> </td>
				</tr> 
		
			</table>

</form>
</div>

<%@include file="footer.jsp"%>