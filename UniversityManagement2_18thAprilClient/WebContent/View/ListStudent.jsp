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

<table align="center" class="form" width="100%">
	<tr>
		<td>Student ID</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Address</td>
		<td>City</td>
		<td>State</td>
		<td>Zip Code</td>
	</tr>
	<%
		if (request.getAttribute("numStudent") != null) {
			String strStudents = request.getAttribute("numStudent").toString();
			int numStudents = Integer.parseInt(strStudents);
			
			for (int i = 0; i < numStudents; i++) {
				out.print("<tr>");
				out.print("<td>"); out.print(request.getAttribute("sid"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("fname"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("lname"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("address"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("city"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("state"+i)); out.print("</td>");
				out.print("<td>"); out.print(request.getAttribute("zipcode"+i)); out.print("</td>");
				out.print("</tr>");
			}

		}
	%>
</table>


<%@include file="footer.jsp"%>