<%@include file="home.jsp"%>
<!-- <style type="text/css">

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
 --><<script type="text/javascript">


</script>

<div id="div1" class="form">
		<form name="form1" id="form1" class="form" method="get" action="ListInstructor">
			<table align="center" class="form" width="100%">
				<tr>
				<td align="right"><h3>Search Instructor Information</h3></td>
				</tr>
				
				<tr>
				<td align="right"> <span id="select" class="form" ></span><label id="label1" for="select" class="detail">Select Any Attribute:</label></td>			
			    <td align="left"><select id="instructor" name="instructor" required>
			    	<option selected="selected" value="">Select one attribute </option>
			    	<option value="First Name">First Name </option>
			    	<option value="Last Name">Last Name </option>
			    	<option value="Address">Address </option>
			    	<option value="City">City </option>
			    	<option value="State">State </option>
			    	<option value="Zip Code">Zip Code </option>
			    	<option value="Instructor Id">Instructor Id</option>
			    	<option value="Department">Department </option>
			    	<option value="Office Hours(Day)">Office Hours(Day)</option>
			    	<option value="Office Hours(Timing)">Office Hours(Timing)</option>
			    </select>
			    </td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="val" class="form" ></span><label id="label2" for="val" class="detail">Enter the Value:</label></td>			
			    <td align="left"><input type="text" id="value" name="value" size="25" title="Enter value" required></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    </tr>
			    <tr>
				<td align="right"> <input type="reset" name="reset" value="Reset"> </td>
				 <td align="left"><input type="submit" name="instructorinfo" value="Submit"> </td>
				</tr> 
			    
			    </table>
			    

</form>
</div>

<%@include file="footer.jsp"%>