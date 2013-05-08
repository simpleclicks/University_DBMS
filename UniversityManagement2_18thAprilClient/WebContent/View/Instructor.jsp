<%@include file="Header.jsp"%>

	<style type="text/css">
.form {
	font: Lucida Handwriting;
	color: #2554C7;
	background-color: #C9B2DA;
	size: 5;
}
</style>

	<marquee behaviour="alternate">
		<font face="Lucida Handwriting" color="#357EC7" size="6">Welcome
			To Instructor Database</font>
	</marquee>

	<br />
	<br />
	<br />
	<br />

	<div align="center" class="form">
		<table>
			<tr>
				<td><font face="Lucida Handwriting" color="#2554C7" size="5"><b>Select
							a function to perform from the following List</b></font></td>
			</tr>
			<%
				if (session.getAttribute("user").toString().equals("admin")) {
			%>
			<tr>
				<td><a href="AddInstructor.jsp"><h2>Add Instructor
							Information</h2></a></td>
			</tr>
			<tr>
				<td><a href="DeleteInstructor.jsp"><h2>Delete
							Instructor Information</h2></a></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td><a href="UpdateInstructorById.jsp"><h2>Update
							Instructor Information</h2></a></td>
			</tr>
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/View/AssignInstructor"><h2>Assign
							Instructor to a Course</h2></a></td>
			</tr>
			<tr>

				<td><a href="<%=request.getContextPath()%>/View/ListInstructor"><h2>List
							all Instructors</h2></a></td>

			</tr>
			<tr>
				<td><a href="SearchInstructor.jsp"><h2>Search
							Instructor Information</h2></a></td>
			</tr>
		</table>
	</div>



	<%@include file="footer.jsp"%>