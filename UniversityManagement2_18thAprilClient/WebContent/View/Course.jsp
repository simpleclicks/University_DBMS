

<%@include file="home.jsp"%>

<!-- <style type="text/css">
.form {
	font: Lucida Handwriting;
	color: #2554C7;
	background-color: #C9B2DA;
	size: 5;
}
</style>
 -->
 <marquee behaviour="alternate"><font face="Lucida Handwriting" color="#357EC7" size="6">Welcome To Course Database</font></marquee>

        <br /><br /><br /><br />
         
            <div align="center" class="form">
            <table>
                 <tr>
                     <td>
                       <font face="Lucida Handwriting" color="#2554C7" size="5"><b>Select a function to perform from the following List</b></font>
                     </td>
                 </tr>
                 <% if (session.getAttribute("user").toString().equals("admin"))  { %>
                 <tr>
                     <td>
                 <a href="AddCourse.jsp"><h2>Add Course Information</h2></a>
                 </td></tr>
                  <tr>
			<td><a href="DeleteCourse.jsp"><h2>Delete
						Course Information</h2></a></td>
				</tr>
			<tr>
			<td><a href="UpdateCourseId.jsp"><h2>Update
						Course Information</h2></a></td>
			</tr>
			<% }%>
			<tr>
			
				<td><a href="<%=request.getContextPath()%>/View/ListCourse"><h2>List all
							Courses</h2></a></td>
			
		</tr>
		<tr>
			<td><a href="SearchCourse.jsp"><h2>Search
						Course Information</h2></a></td>
		</tr>
            
            </table>
                    </div>

<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />

<%@include file="footer.jsp"%>