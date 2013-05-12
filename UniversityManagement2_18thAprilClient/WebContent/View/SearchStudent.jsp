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


function isallfieldsfilled() {
	//alert("allfield");
	var flag = 0, cflag = 0;

	student = document.form1.student.value;
	value = document.form1.value.value;

	if (student == "" || student == null || value == "" || value == null) {
		alert("You have not filled all the fields");
		return false;
	}

	return true;

}


</script>

<div id="div1" class="form">
		<form name="form1" id="form1" class="form" method="get" action="ListStudent">
			<table align="center" class="form" width="100%">
				<tr>
				<td align="right"><h3>Search Student Information</h3></td>
				</tr>
				
				<tr>
				<td align="right"> <span id="select" class="form" ></span><label id="label1" for="select" class="detail">Select Any Attribute:</label></td>			
			    <td align="left"><select id="student" name="student">
			    	<option selected="selected" value="">Select one attribute </option>
			    	<option value="First Name">First Name </option>
			    	<option value="Last Name">Last Name </option>
			    	<option value="Address">Address </option>
			    	<option value="City">City </option>
			    	<option value="State">State </option>
			    	<option value="Zip Code">Zip Code </option>
			    	<option value="Student Id">Student Id</option>
			    	
			    </select>
			    </td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    <tr>
				<td align="right"> <span id="val" class="form" ></span><label id="label2" for="val" class="detail">Enter the Value:</label></td>			
			    <td align="left"><input type="text" id="value" name="value" size="25" title="Enter value"></td>
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    </tr>
			    <tr>
				<td align="right"> <input type="reset" name="reset" value="Reset"> </td>
				 <td align="left"><input type="submit" name="studentinfo" value="Submit" onclick=" return isallfieldsfilled()"> </td>
				</tr> 
			    
			    </table>
			    

</form>
</div>

<%@include file="footer.jsp"%>