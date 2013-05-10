<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleInstructorServiceProxyid" scope="session" class="edu.service.InstructorServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleInstructorServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleInstructorServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleInstructorServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        edu.service.InstructorService getInstructorService10mtemp = sampleInstructorServiceProxyid.getInstructorService();
if(getInstructorService10mtemp == null){
%>
<%=getInstructorService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String instructorId_1id=  request.getParameter("instructorId18");
            java.lang.String instructorId_1idTemp = null;
        if(!instructorId_1id.equals("")){
         instructorId_1idTemp  = instructorId_1id;
        }
        java.lang.String getAssignedCoursesForInstructor15mtemp = sampleInstructorServiceProxyid.getAssignedCoursesForInstructor(instructorId_1idTemp);
if(getAssignedCoursesForInstructor15mtemp == null){
%>
<%=getAssignedCoursesForInstructor15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAssignedCoursesForInstructor15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 20:
        gotMethod = true;
        String attribute_2id=  request.getParameter("attribute23");
            java.lang.String attribute_2idTemp = null;
        if(!attribute_2id.equals("")){
         attribute_2idTemp  = attribute_2id;
        }
        String keyword_3id=  request.getParameter("keyword25");
            java.lang.String keyword_3idTemp = null;
        if(!keyword_3id.equals("")){
         keyword_3idTemp  = keyword_3id;
        }
        java.lang.String searchInstructor20mtemp = sampleInstructorServiceProxyid.searchInstructor(attribute_2idTemp,keyword_3idTemp);
if(searchInstructor20mtemp == null){
%>
<%=searchInstructor20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(searchInstructor20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 27:
        gotMethod = true;
        String instructorEmpId_4id=  request.getParameter("instructorEmpId30");
            java.lang.String instructorEmpId_4idTemp = null;
        if(!instructorEmpId_4id.equals("")){
         instructorEmpId_4idTemp  = instructorEmpId_4id;
        }
        String firstname_5id=  request.getParameter("firstname32");
            java.lang.String firstname_5idTemp = null;
        if(!firstname_5id.equals("")){
         firstname_5idTemp  = firstname_5id;
        }
        String lastname_6id=  request.getParameter("lastname34");
            java.lang.String lastname_6idTemp = null;
        if(!lastname_6id.equals("")){
         lastname_6idTemp  = lastname_6id;
        }
        String address_7id=  request.getParameter("address36");
            java.lang.String address_7idTemp = null;
        if(!address_7id.equals("")){
         address_7idTemp  = address_7id;
        }
        String city_8id=  request.getParameter("city38");
            java.lang.String city_8idTemp = null;
        if(!city_8id.equals("")){
         city_8idTemp  = city_8id;
        }
        String state_9id=  request.getParameter("state40");
            java.lang.String state_9idTemp = null;
        if(!state_9id.equals("")){
         state_9idTemp  = state_9id;
        }
        String zip_10id=  request.getParameter("zip42");
            java.lang.String zip_10idTemp = null;
        if(!zip_10id.equals("")){
         zip_10idTemp  = zip_10id;
        }
        String department_11id=  request.getParameter("department44");
            java.lang.String department_11idTemp = null;
        if(!department_11id.equals("")){
         department_11idTemp  = department_11id;
        }
        String days_12id=  request.getParameter("days46");
            java.lang.String days_12idTemp = null;
        if(!days_12id.equals("")){
         days_12idTemp  = days_12id;
        }
        String timings_13id=  request.getParameter("timings48");
            java.lang.String timings_13idTemp = null;
        if(!timings_13id.equals("")){
         timings_13idTemp  = timings_13id;
        }
        java.lang.String updateInstructor27mtemp = sampleInstructorServiceProxyid.updateInstructor(instructorEmpId_4idTemp,firstname_5idTemp,lastname_6idTemp,address_7idTemp,city_8idTemp,state_9idTemp,zip_10idTemp,department_11idTemp,days_12idTemp,timings_13idTemp);
if(updateInstructor27mtemp == null){
%>
<%=updateInstructor27mtemp %>
<%
}else{
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateInstructor27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
}
break;
case 50:
        gotMethod = true;
        String instructorId_14id=  request.getParameter("instructorId53");
            java.lang.String instructorId_14idTemp = null;
        if(!instructorId_14id.equals("")){
         instructorId_14idTemp  = instructorId_14id;
        }
        String courseId_15id=  request.getParameter("courseId55");
            java.lang.String courseId_15idTemp = null;
        if(!courseId_15id.equals("")){
         courseId_15idTemp  = courseId_15id;
        }
        String section_16id=  request.getParameter("section57");
            java.lang.String section_16idTemp = null;
        if(!section_16id.equals("")){
         section_16idTemp  = section_16id;
        }
        java.lang.String unAssignInstructor50mtemp = sampleInstructorServiceProxyid.unAssignInstructor(instructorId_14idTemp,courseId_15idTemp,section_16idTemp);
if(unAssignInstructor50mtemp == null){
%>
<%=unAssignInstructor50mtemp %>
<%
}else{
        String tempResultreturnp51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(unAssignInstructor50mtemp));
        %>
        <%= tempResultreturnp51 %>
        <%
}
break;
case 59:
        gotMethod = true;
        String courseId_17id=  request.getParameter("courseId62");
            java.lang.String courseId_17idTemp = null;
        if(!courseId_17id.equals("")){
         courseId_17idTemp  = courseId_17id;
        }
        String section_18id=  request.getParameter("section64");
            java.lang.String section_18idTemp = null;
        if(!section_18id.equals("")){
         section_18idTemp  = section_18id;
        }
        String instructorId_19id=  request.getParameter("instructorId66");
            java.lang.String instructorId_19idTemp = null;
        if(!instructorId_19id.equals("")){
         instructorId_19idTemp  = instructorId_19id;
        }
        java.lang.String assignInstructor59mtemp = sampleInstructorServiceProxyid.assignInstructor(courseId_17idTemp,section_18idTemp,instructorId_19idTemp);
if(assignInstructor59mtemp == null){
%>
<%=assignInstructor59mtemp %>
<%
}else{
        String tempResultreturnp60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(assignInstructor59mtemp));
        %>
        <%= tempResultreturnp60 %>
        <%
}
break;
case 68:
        gotMethod = true;
        java.lang.String getAllInstructor68mtemp = sampleInstructorServiceProxyid.getAllInstructor();
if(getAllInstructor68mtemp == null){
%>
<%=getAllInstructor68mtemp %>
<%
}else{
        String tempResultreturnp69 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllInstructor68mtemp));
        %>
        <%= tempResultreturnp69 %>
        <%
}
break;
case 71:
        gotMethod = true;
        String instructorId_20id=  request.getParameter("instructorId74");
            java.lang.String instructorId_20idTemp = null;
        if(!instructorId_20id.equals("")){
         instructorId_20idTemp  = instructorId_20id;
        }
        java.lang.String deleteInstructor71mtemp = sampleInstructorServiceProxyid.deleteInstructor(instructorId_20idTemp);
if(deleteInstructor71mtemp == null){
%>
<%=deleteInstructor71mtemp %>
<%
}else{
        String tempResultreturnp72 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteInstructor71mtemp));
        %>
        <%= tempResultreturnp72 %>
        <%
}
break;
case 76:
        gotMethod = true;
        String instructorId_21id=  request.getParameter("instructorId79");
            java.lang.String instructorId_21idTemp = null;
        if(!instructorId_21id.equals("")){
         instructorId_21idTemp  = instructorId_21id;
        }
        java.lang.String getInstructorById76mtemp = sampleInstructorServiceProxyid.getInstructorById(instructorId_21idTemp);
if(getInstructorById76mtemp == null){
%>
<%=getInstructorById76mtemp %>
<%
}else{
        String tempResultreturnp77 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getInstructorById76mtemp));
        %>
        <%= tempResultreturnp77 %>
        <%
}
break;
case 81:
        gotMethod = true;
        String instructorId_22id=  request.getParameter("instructorId84");
            java.lang.String instructorId_22idTemp = null;
        if(!instructorId_22id.equals("")){
         instructorId_22idTemp  = instructorId_22id;
        }
        String firstname_23id=  request.getParameter("firstname86");
            java.lang.String firstname_23idTemp = null;
        if(!firstname_23id.equals("")){
         firstname_23idTemp  = firstname_23id;
        }
        String lastname_24id=  request.getParameter("lastname88");
            java.lang.String lastname_24idTemp = null;
        if(!lastname_24id.equals("")){
         lastname_24idTemp  = lastname_24id;
        }
        String address_25id=  request.getParameter("address90");
            java.lang.String address_25idTemp = null;
        if(!address_25id.equals("")){
         address_25idTemp  = address_25id;
        }
        String city_26id=  request.getParameter("city92");
            java.lang.String city_26idTemp = null;
        if(!city_26id.equals("")){
         city_26idTemp  = city_26id;
        }
        String state_27id=  request.getParameter("state94");
            java.lang.String state_27idTemp = null;
        if(!state_27id.equals("")){
         state_27idTemp  = state_27id;
        }
        String zipCode_28id=  request.getParameter("zipCode96");
            java.lang.String zipCode_28idTemp = null;
        if(!zipCode_28id.equals("")){
         zipCode_28idTemp  = zipCode_28id;
        }
        String department_29id=  request.getParameter("department98");
            java.lang.String department_29idTemp = null;
        if(!department_29id.equals("")){
         department_29idTemp  = department_29id;
        }
        String days_30id=  request.getParameter("days100");
            java.lang.String days_30idTemp = null;
        if(!days_30id.equals("")){
         days_30idTemp  = days_30id;
        }
        String timings_31id=  request.getParameter("timings102");
            java.lang.String timings_31idTemp = null;
        if(!timings_31id.equals("")){
         timings_31idTemp  = timings_31id;
        }
        String password_32id=  request.getParameter("password104");
            java.lang.String password_32idTemp = null;
        if(!password_32id.equals("")){
         password_32idTemp  = password_32id;
        }
        java.lang.String addInstructor81mtemp = sampleInstructorServiceProxyid.addInstructor(instructorId_22idTemp,firstname_23idTemp,lastname_24idTemp,address_25idTemp,city_26idTemp,state_27idTemp,zipCode_28idTemp,department_29idTemp,days_30idTemp,timings_31idTemp,password_32idTemp);
if(addInstructor81mtemp == null){
%>
<%=addInstructor81mtemp %>
<%
}else{
        String tempResultreturnp82 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addInstructor81mtemp));
        %>
        <%= tempResultreturnp82 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>