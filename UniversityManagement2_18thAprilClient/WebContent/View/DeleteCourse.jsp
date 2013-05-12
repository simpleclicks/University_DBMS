
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
 --><script type="text/javascript">


function isnotsplchar(element,alerttxt)
{
	var val = element.value;
	var regexpr =/[^A-Za-z0-9]/;
	result= regexpr.test(val);
	if(result == true)
	{
		alert(alerttxt);
		element.value="";
		return false;
		
	}
	return true;
}



function isallfieldsfilled()
{
	//alert("allfield");
	var flag = 0,cflag=0;
	
	eid = document.form1.eid.value;

	if (courseid == "" || courseid == null )
	{
		alert("You have not filled the Course Id field");
		return false;
	}

	
	return true;

}

</script>
<div id="div1" class="form">
		<form name="form1" id="form1" class="form" method="post" action="DeleteCourse">
			<table align="center" class="form" width="100%">
				<tr>
				<td align="right"><h3>Enter Course Id</h3></td>
				</tr>
				<tr/>
				
			     <tr>
				<td align="right"> <span id="cid" class="form" ></span><label id="label1" for="courseid" class="detail">Course Id:</label></td>			
			    <td align="left"><input type="text" id="courseid" name="courseid" size="25" title="Enter id"></td>
			    
			    </tr>
			    <tr>
				<td align="right"> <span id="csec" class="form" ></span><label id="label1" for="coursesec" class="detail">Course Section:</label></td>			
			    <td align="left"><input type="text" id="coursesec" name="coursesec" size="25" title="Enter Section"></td>
			    
			    </tr>
			    
			    <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>
			    
			    
			    <tr>
				<td align="right"> <input type="reset" name="reset" value="Reset"> </td>
				 <td align="left"><input type="submit" name="courseinfo" value="Submit" onclick=" return isallfieldsfilled()"> </td>
				</tr> 
		
			</table>

</form>
</div>

<%@include file="footer.jsp"%>