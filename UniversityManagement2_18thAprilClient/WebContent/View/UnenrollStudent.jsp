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
	
	<form name="form1" id="form1" class="form" method="post"
		action="UnenrollStudent">
		
			<tr>
				<td align="right"><h3>UnEnroll Student from a course</h3></td>
			</tr>
			<tr />
			<tr>
			<td></td>
		<td>Student ID</td>
		<td>Course Id</td>
		<td>CourseName</td>
		<td>Location</td>
		<td>Section</td>
		<td>Day</td>
		<td>Time</td>
	</tr>
			
				
				
						<%
						if (request.getAttribute("numStudent") != null) {
							String strStudent = request.getAttribute("numStudent").toString();
							int numStudent = Integer.parseInt(strStudent);
							
							for (int i = 0; i < numStudent; i++) {
								out.print("<tr>");
								out.print("<td>");
								if (i == 0)
									out.print(request.getAttribute("sid"+i));
								out.print("</td>");
								out.print("<td>"); 
								%>
								<input type="radio" name="cid">
								<%
								 String courseSection = request.getAttribute("cid"+i).toString() + "-" +
										 request.getAttribute("section"+i);
								 out.print(courseSection); 
								out.print("</td>");
								out.print("<td>"); out.print(request.getAttribute("cname"+i)); out.print("</td>");
								out.print("<td>"); out.print(request.getAttribute("location"+i)); out.print("</td>");
								out.print("<td>"); out.print(request.getAttribute("day"+i)); out.print("</td>");
								out.print("<td>"); out.print(request.getAttribute("time"+i)); out.print("</td>");
								out.print("</tr>");
								
						
							}
						}
						%>

				

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
	
</div>

<%@include file="footer.jsp"%>