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

function isstatevalid(element,alerttxt)
{
	var stateArray = new Array("AL","AK","AZ","AR","CA","CO","CT","DE","DC","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");
	var flag=0;
	var val = element.value.toUpperCase(); 
	for(var i=0; i < stateArray.length; i++){
		if (stateArray[i]== val){
			flag = 1;
		}
	}
	if(flag == 0){
		alert(alerttxt);
		element.value="";
		return false;
	}
	
	
}

function isallfieldsfilled()
{
	//alert("allfield");
	var flag = 0,cflag=0;
	fname = document.form1.fname.value;
	lname = document.form1.lname.value;
	addr = document.form1.addr.value;
	city= document.form1.city.value;
	state = document.form1.state.value;
	zcode = document.form1.zcode.value;
	eid = document.form1.eid.value;

	if (fname == "" || fname == null  || lname == "" || lname == null || addr == "" || addr == null
			|| state == "" || state == null || city == "" || city == null || zcode == "" || zcode == null
			|| eid == "" || eid == null )
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
		<form name="form1" id="form1" class="form" method="post" action="UpdateInstructorInfo">
			<table align="center" class="form" width="100%">
				<tr>
				<td align="right"><h3>Update Instructor Details</h3></td>
				</tr>
				<tr/>
 				
				<tr>
				<td align="right"> <span id="fn" class="form" ></span><label id="label1" for="fname" class="detail">First Name:</label></td>			
			    <td align="left"><input type="text" id="fname" name="fname" size="25" value="<%= request.getAttribute("fname") %>" title="Enter your first name"  onchange="isnotsplchar(this,'No special characters allowed') "></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="ln" class="form" ></span><label id="label2" for="lname" class="detail">Last Name:</label></td>			
			    <td align="left"><input type="text" id="lname" name="lname" size="25" value="<%= request.getAttribute("lname") %>" title="Enter your last name"></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="add" class="form" ></span><label id="label3" for="address" class="detail">Address:</label></td>			
			    <td align="left"><input type="text" id="addr" name="addr" size="25" value="<%= request.getAttribute("address") %>" title="Enter your address"></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="cityform" class="form" ></span><label id="label4" for="city" class="detail">City:</label></td>			
			    <td align="left"><input type="text" id="city" name="city" size="25" value="<%= request.getAttribute("city") %>"title="Enter City"></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			     <tr>
				<td align="right"> <span id="st" class="form" ></span><label id="label5" for="state" class="detail">State:</label></td>			
			    <td align="left"><input type="text" id="state" name="state" size="25" value="<%= request.getAttribute("state") %>"title="Enter State" onchange="isstatevalid(this,'Invalid State')"></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			     <tr>
				<td align="right"> <span id="zc" class="form" ></span><label id="label6" for="zipcode" class="detail">Zip Code:</label></td>			
			    <td align="left"><input type="text" id="zcode" name="zcode" size="25" value="<%= request.getAttribute("zipcode") %>"title="Enter Zip Code"></td>
			    </tr>
			    
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    
			     <tr>
				<td align="right"> <span id="empid" class="form" ></span><label id="label9" for="emplid" class="detail">Instructor Employee Id:</label></td>			
			    <td align="left"><input type="text" id="eid" name="eid" size="25" value="<%= request.getAttribute("eid") %>"title="Enter id"></td>
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