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
 -->
<table align="center" class="form" width="100%">
	<tr>
		<td>Instructor ID</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Address</td>
		<td>City</td>
		<td>State</td>
		<td>Zip Code</td>
		<td>Department</td>
		<td>Days</td>
		<td>Time</td>
	</tr>
	<%
		if (request.getAttribute("numInstr") != null) {
			String strIns = request.getAttribute("numInstr").toString();
			int numIns = Integer.parseInt(strIns);
			
			for (int i = 0; i < numIns; i++) {
				out.print("<tr>");
				out.print("<td>"); out.print(request.getAttribute("eid"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("fname"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("lname"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("address"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("city"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("state"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("zipcode"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("dept"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("day"+i+","+0)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("time"+i+","+0)); out.print("</td>");
				out.print("</tr>");
				int numdays = Integer.parseInt(request.getAttribute("numdays"+i).toString());
				if (numdays > 1) {
					for(int j = 1; j < numdays; j++) {
						out.print("<tr>");
						out.print("<td>");
						out.print("<td>");
						out.print("<td>");
						out.print("<td>");
						out.print("<td>");
						out.print("<td>");
						out.print("<td>");
						out.print("<td>");
						out.print("<td>"); out.print(request.getAttribute("day"+i+","+j)); out.print("</td>");
						out.print("<td>"); out.print(request.getAttribute("time"+i+","+j)); out.print("</td>");
					}
					
				}
			}

		}
	%>
</table>


<%@include file="footer.jsp"%>