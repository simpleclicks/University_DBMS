<%@include file="home.jsp"%>

<!-- <style type="text/css">
.form {
	font: Lucida Handwriting;
	color: #2554C7;
	background-color: #C9B2DA;
	size: 5;
}
</style>

 --><div align="center" class="form">
 <marquee behaviour="alternate"><font face="Lucida Handwriting" color="#357EC7" size="6">Welcome To Student Database</font></marquee>

        <br /><br /><br /><br />
         
            
            <table>
                 <tr>
                     <td>
                       <font face="Lucida Handwriting" color="#2554C7" size="5"><b>Select a function to perform from the following List</b></font>
                     </td>
                 </tr>
                  <% if (session.getAttribute("user").toString().equals("admin"))  { %>
                 <tr>
                     <td>
                 <a href="AddStudent.jsp"><h2>Add Student Information</h2></a>
                 </td></tr>
                 <tr>
                     <td>
                 <a href="DeleteStudent.jsp"><h2>Delete Student Information</h2></a>
                 </td></tr>
                 <tr>
                 <tr>
			
				<td><a href="<%=request.getContextPath()%>/View/ListStudent"><h2>List all
							Students</h2></a></td>
			
				</tr>
				<tr>
				<td><a href="SearchStudent.jsp"><h2>Search
						Student Information</h2></a></td>
				</tr>
                 <%} %>
                     <td>
                 <a href="updateStudentId.jsp"><h2>Update Student Information</h2></a>
                 </td></tr>
                  <tr>
				<td><a href="<%=request.getContextPath()%>/View/AssignStudent"><h2>Enroll 
							Student in a Course</h2></a></td>
		</tr>
            <tr>
			<td><a href="UnenrollStudentId.jsp"><h2>Unenroll
						Student from course</h2></a></td>
		</tr>
            
            </table>
                  

<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />

  </div>
<%@include file="footer.jsp"%>