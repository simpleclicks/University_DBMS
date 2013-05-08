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
.form {
	font: Lucida Handwriting;
	color: #2554C7;
	background-color: #C9B2DA;
	size: 5;
}

.detail {
	font: Lucida Handwriting;
	color: #254117;
	size: 4;
}
</style>
<script type="text/javascript">
	function isnotsplchar(element, alerttxt) {
		var val = element.value;
		var regexpr = /[^A-Za-z0-9]/;
		result = regexpr.test(val);
		if (result == true) {
			alert(alerttxt);
			element.value = "";
			return false;

		}
		return true;
	}

	function isstatevalid(element, alerttxt) {
		var stateArray = new Array("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
				"DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
				"KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
				"NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK",
				"OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA",
				"WA", "WV", "WI", "WY");
		var flag = 0;
		var val = element.value.toUpperCase();
		for ( var i = 0; i < stateArray.length; i++) {
			if (stateArray[i] == val) {
				flag = 1;
			}
		}
		if (flag == 0) {
			alert(alerttxt);
			element.value = "";
			return false;
		}

	}

	function isallfieldsfilled() {
		var flag = 0, cflag = 0;
		fname = document.form1.fname.value;
		lname = document.form1.lname.value;
		addr = document.form1.addr.value;
		city = document.form1.city.value;
		state = document.form1.state.value;
		zcode = document.form1.zcode.value;
		dept = document.form1.dept.value;
		eid = document.form1.eid.value;
		
		
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
		
		if (fname == "" || fname == null || lname == "" || lname == null
				|| addr == "" || addr == null || state == "" || state == null
				|| city == "" || city == null || zcode == "" || zcode == null
				 || dept == "" || dept == null
				|| eid == "" || eid == null){
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
	-->
<div id="div1" class="form">
	<form name="form1" id="form1" class="form" method="post"
		action="AddInstructor">
		<table id="insTable" align="center" class="form" width="100%">
			<tr>
				<td align="right"><h3>Enter Instructor Details</h3></td>
			</tr>
			<tr />
			<tr>
				<td align="right"><span id="fn" class="form"></span><label
					id="label1" for="fname" class="detail">First Name:</label></td>
				<td align="left"><input type="text" id="fname" name="fname"
					size="25" title="Enter your first name"
					onchange="isnotsplchar(this,'No special characters allowed') " required></td>
			</tr>

			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />

			<tr>
				<td align="right"><span id="ln" class="form"></span><label
					id="label2" for="lname" class="detail">Last Name:</label></td>
				<td align="left"><input type="text" id="lname" name="lname"
					size="25" title="Enter your last name" required></td>
			</tr>

			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />

			<tr>
				<td align="right"><span id="add" class="form"></span><label
					id="label3" for="address" class="detail">Address:</label></td>
				<td align="left"><input type="text" id="addr" name="addr"
					size="25" title="Enter your address" required></td>
			</tr>

			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />

			<tr>
				<td align="right"><span id="cityform" class="form"></span><label
					id="label4" for="city" class="detail">City:</label></td>
				<td align="left"><input type="text" id="city" name="city"
					size="25" title="Enter City" required></td>
			</tr>

			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />

			<tr>
				<td align="right"><span id="st" class="form"></span><label
					id="label5" for="state" class="detail">State:</label></td>
				<td align="left"><input type="text" id="state" name="state"
					size="25" title="Enter State"
					onchange="isstatevalid(this,'Invalid State')" required></td>
			</tr>

			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />

			<tr>
				<td align="right"><span id="zc" class="form"></span><label
					id="label6" for="zipcode" class="detail">Zip Code:</label></td>
				<td align="left"><input type="text" id="zcode" name="zcode"
					size="25" title="Enter Zip Code" required></td>
			</tr>


			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />

			<tr>
				<td align="right"><span id="dep" class="form"></span><label
					id="label8" for="department" class="detail">Department:</label></td>
				<td align="left"><input type="text" id="dept" name="dept"
					size="25" title="Enter your department" required></td>
			</tr>

			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />

			<tr>
				<td align="right"><span id="empid" class="form"></span><label
					id="label9" for="emplid" class="detail">Instructor Employee
						Id:</label></td>
				<td align="left"><input type="text" id="eid" name="eid"
					size="25" title="Enter id" required></td>
			</tr>

			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />
			<tr />

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
					<td align="left"><input type="time" id="endtime"
						name="endtime" size="25" title="Enter Time" required></td>
					<td align="left"><input type="button" value="Add Row"
						onclick="add()" /></td>

				</tr>

		</table>
		<br>

		<table align="center">
			<tr>
				<td align="right"><input type="reset" name="reset"
					value="Reset"></td>
				<td align="left"><input type="submit" name="instructorinfo"
					value="Submit" onclick=" return isallfieldsfilled()"></td>
			</tr>
		</table>

	</form>
</div>

<%@include file="footer.jsp"%>