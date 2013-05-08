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
	var regexpr =/[^A-Za-z0-9\s]/;
	result= regexpr.test(val);
	if(result == true)
	{
		alert(alerttxt);
		element.value="";
		return false;
		
	}
	return true;
}



function isallfieldsfilled() {
	//alert("allfield");
	var flag = 0, cflag = 0;
	cname = document.form1.cname.value;
	location = document.form1.location.value;
	cid = document.form1.cid.value;
	section = document.form1.section.value;
	
	var endtime = document.getElementsByName("endtime");
	for(var i = 0; i < endtime.length; i++) {
		if (endtime[i] == "" || endtime[i] == null){
			alert("You have not filled all the fields");
			return false;
		}
	}
	
	var starttime = document.getElementsByName("starttime");
	for(var i = 0; i < starttime.length; i++) {
		if (starttime[i] == "" || starttime[i] == null) {
		alert("You have not filled all the fields");
		return false;
		}
	}
	var days = document.getElementsByName("days");
	for(var i = 0; i < days.length; i++) {
		if (days[i] == "" || days[i] == null) {
		alert("You have not filled all the fields");
		return false;
		}
	}
	if (cname == "" || cname == null || location == "" || location == null
			|| cid == "" || cid == null ){	
		alert("You have not filled all the fields");
		return false;
	}

	return true;

}

function add() {

	add.count = ++add.count || 1;

	var daysText = document.createElement("input");
	daysText.setAttribute("type", "text");
	daysText.setAttribute("name", "days");
	daysText.setAttribute("size", "25");

	var tr = document.createElement("tr");
	var td1 = document.createElement("td");
	td1.setAttribute("align", "right");
	var td2 = document.createElement("td");
	var td3 = document.createElement("td");
	td3.setAttribute("align", "right");
	var td4 = document.createElement("td");
	var td5 = document.createElement("td");
	td5.setAttribute("align", "right");
	var td6 = document.createElement("td");
	var br = document.createElement("br");

	var label = document.createElement("label");
	label.setAttribute("class", "detail");
	
	var daytxt = document.createTextNode("Days:");
	
	var strttime = document.createTextNode("Start time:");
	var endtime = document.createTextNode("End time:");

	var strtTimeText = document.createElement("input");
	strtTimeText.setAttribute("type", "time");
	strtTimeText.setAttribute("name", "starttime");
	strtTimeText.setAttribute("size", "25");

	var endTimeText = document.createElement("input");
	endTimeText.setAttribute("type", "time");
	endTimeText.setAttribute("name", "endtime");
	endTimeText.setAttribute("size", "25");
	
	//label.appendChild(daytxt);
	//td1.appendChild(label);
	td1.appendChild(daytxt);
	td2.appendChild(daysText);
	td3.appendChild(strttime);
	td4.appendChild(strtTimeText);
	td5.appendChild(endtime);
	td6.appendChild(endTimeText);

	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);


	var tbl = document.getElementById("insTable");

	//tbl.tBodies(0).appendChild(tr);
	tbl.appendChild(tr);

}

</script>
<!--  </head>
<body style="background:#C9B2DA;">
	--><div id="div1" class="form">
		<form name="form1" id="form1" class="form" method="post" action="AddCourse">
			<table id="insTable" align="center" class="form" width="100%">
				<tr>
				<td align="right"><h3>Enter Course Details</h3></td>
				</tr>
				<tr/>
				<tr>
				<td align="right"> <span id="name" class="form" ></span><label id="label1" for="cname" class="detail">Course Name:</label></td>			
			    <td align="left"><input type="text" id="cname" name="cname" size="25" title="Enter course name"  onchange="isnotsplchar(this,'No special characters allowed') " required></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="id" class="form" ></span><label id="label2" for="cid" class="detail">Course Id:</label></td>			
			    <td align="left"><input type="text" id="cid" name="cid" size="25" title="Enter course id" required></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			      <tr>
				<td align="right"> <span id="sec" class="form" ></span><label id="label3" for="section" class="detail">Section:</label></td>			
			    <td align="left"><input type="text" id="section" name="section" size="25" title="Enter Section" required></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="loc" class="form" ></span><label id="label4" for="location" class="detail">Location:</label></td>			
			    <td align="left"><input type="text" id="location" name="location" size="25" title="Enter location" required></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				
				<td align="right"><span id="days" class="form"></span><label
					id="label10" for="days" class="detail">Office Hours: Days:</label></td>
				<td align="left"><input type="text" id="days" name="days"
					size="25" title="Enter days" required></td>
				<td align="right"><span id="time" class="form"></span><label
					id="label11" for="time" class="detail">Start Time:</label></td>
				<td align="left"><input type="time" id="starttime"
					name="starttime" size="25" title="Enter Time" required></td>
				<td align="right"><span id="time" class="form"></span><label
					id="label12" for="time" class="detail">End Time:</label></td>
				<td align="left"><input type="time" id="endtime" name="endtime"
					size="25" title="Enter Time" required></td>
				<td align="left"><input type="button" value="Add Row"
					onclick="add()" /></td>

			</tr>
			
		</table>
		<br>
		
			   	<table align="center"> 
			     <tr>
				<td align="right"> <input type="reset" name="reset" value="Reset"> </td>
				 <td align="left"><input type="submit" name="Courseinfo" value="Submit"> </td>
				</tr> 
		
			</table>

</form>
</div>

<%@include file="footer.jsp"%>