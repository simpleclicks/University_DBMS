
<%@include file="home.jsp"%>
<!-- <style type="text/css">
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
 --><script type="text/javascript">
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

	function isallfieldsfilled() {
		//alert("allfield");
		var flag = 0, cflag = 0;

		course = document.form1.course.value;
		eid = document.form1.eid.value;

		if (course == "" || course == null || eid == "" || eid == null) {
			alert("You have not filled all the fields");
			return false;
		}

		return true;

	}
</script>
<!--  </head>
<body style="background:#C9B2DA;">
	-->
<div id="div1" class="form">
<table align="center" class="form" width="100%">
	<tr>
<%
			if (request.getAttribute("assignResult") != null) {
				out.print("<td align="); out.print("center>");
				out.print(request.getAttribute("assignResult"));
				out.print("</td>");
			} else { %>
	</tr>
	<tr />

	
	<form name="form1" id="form1" class="form" method="post"
		action="AssignStudent">
		
			<tr>
				<td align="right"><h3>Enroll Student to a course</h3></td>
			</tr>
			<tr />
			<tr>
				<td align="right">Student Id:</td>
				<td align="left"><select id="sid" name="sid">
						<option selected="selected" value="">Select Student Id</option>
						<%
						if (request.getAttribute("numStudent") != null) {
							String strStudent = request.getAttribute("numStudent").toString();
							int numStudent = Integer.parseInt(strStudent);
							
							for (int i = 0; i < numStudent; i++) {
								out.print("<option value=");
								out.print(request.getAttribute("sid"+i)); out.print(">");
								out.print(request.getAttribute("sid"+i));
								out.print("</option>");
							}
						}
						%>

				</select></td>
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
				<td align="right">Course:</td>
				<td align="left"><select id="cid" name="cid"
					multiple="multiple">
						<option selected="selected" value="">Select Course</option>
						<%
						if (request.getAttribute("numCourses") != null) {
							String numCrs = request.getAttribute("numCourses").toString();
							int numcourse = Integer.parseInt(numCrs);
							
							for (int i = 0; i < numcourse; i++) {
								out.print("<option value=");
								out.print(request.getAttribute("cid"+i)); out.print(">");
								out.print(request.getAttribute("cid"+i));
								out.print("</option>");
							}
						}
						%>


				</select></td>
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
				<td align="right"><input type="reset" name="reset"
					value="Reset"></td>
				<td align="left"><input type="submit" name="instructorinfo"
					value="Submit" onclick=" return isallfieldsfilled()"></td>
			</tr>

		</table>

	</form>
	<% } %>
</div>

<%@include file="footer.jsp"%>