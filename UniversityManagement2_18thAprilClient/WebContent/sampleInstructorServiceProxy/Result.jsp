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
        java.lang.String getEnrolledCoursesForInstructor15mtemp = sampleInstructorServiceProxyid.getEnrolledCoursesForInstructor(instructorId_1idTemp);
if(getEnrolledCoursesForInstructor15mtemp == null){
%>
<%=getEnrolledCoursesForInstructor15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEnrolledCoursesForInstructor15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 20:
        gotMethod = true;
        java.lang.String getAllInstructor20mtemp = sampleInstructorServiceProxyid.getAllInstructor();
if(getAllInstructor20mtemp == null){
%>
<%=getAllInstructor20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllInstructor20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 23:
        gotMethod = true;
        String instructorId_2id=  request.getParameter("instructorId26");
            java.lang.String instructorId_2idTemp = null;
        if(!instructorId_2id.equals("")){
         instructorId_2idTemp  = instructorId_2id;
        }
        java.lang.String deleteInstructor23mtemp = sampleInstructorServiceProxyid.deleteInstructor(instructorId_2idTemp);
if(deleteInstructor23mtemp == null){
%>
<%=deleteInstructor23mtemp %>
<%
}else{
        String tempResultreturnp24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteInstructor23mtemp));
        %>
        <%= tempResultreturnp24 %>
        <%
}
break;
case 28:
        gotMethod = true;
        String instructorId_3id=  request.getParameter("instructorId31");
            java.lang.String instructorId_3idTemp = null;
        if(!instructorId_3id.equals("")){
         instructorId_3idTemp  = instructorId_3id;
        }
        String firstname_4id=  request.getParameter("firstname33");
            java.lang.String firstname_4idTemp = null;
        if(!firstname_4id.equals("")){
         firstname_4idTemp  = firstname_4id;
        }
        String lastname_5id=  request.getParameter("lastname35");
            java.lang.String lastname_5idTemp = null;
        if(!lastname_5id.equals("")){
         lastname_5idTemp  = lastname_5id;
        }
        String address_6id=  request.getParameter("address37");
            java.lang.String address_6idTemp = null;
        if(!address_6id.equals("")){
         address_6idTemp  = address_6id;
        }
        String city_7id=  request.getParameter("city39");
            java.lang.String city_7idTemp = null;
        if(!city_7id.equals("")){
         city_7idTemp  = city_7id;
        }
        String state_8id=  request.getParameter("state41");
            java.lang.String state_8idTemp = null;
        if(!state_8id.equals("")){
         state_8idTemp  = state_8id;
        }
        String zipCode_9id=  request.getParameter("zipCode43");
        int zipCode_9idTemp  = Integer.parseInt(zipCode_9id);
        String department_10id=  request.getParameter("department45");
            java.lang.String department_10idTemp = null;
        if(!department_10id.equals("")){
         department_10idTemp  = department_10id;
        }
        String days_11id=  request.getParameter("days47");
            java.lang.String days_11idTemp = null;
        if(!days_11id.equals("")){
         days_11idTemp  = days_11id;
        }
        String timings_12id=  request.getParameter("timings49");
            java.lang.String timings_12idTemp = null;
        if(!timings_12id.equals("")){
         timings_12idTemp  = timings_12id;
        }
        java.lang.String addInstructor28mtemp = sampleInstructorServiceProxyid.addInstructor(instructorId_3idTemp,firstname_4idTemp,lastname_5idTemp,address_6idTemp,city_7idTemp,state_8idTemp,zipCode_9idTemp,department_10idTemp,days_11idTemp,timings_12idTemp);
if(addInstructor28mtemp == null){
%>
<%=addInstructor28mtemp %>
<%
}else{
        String tempResultreturnp29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addInstructor28mtemp));
        %>
        <%= tempResultreturnp29 %>
        <%
}
break;
case 51:
        gotMethod = true;
        String instructorId_13id=  request.getParameter("instructorId54");
            java.lang.String instructorId_13idTemp = null;
        if(!instructorId_13id.equals("")){
         instructorId_13idTemp  = instructorId_13id;
        }
        java.lang.String getInstructorById51mtemp = sampleInstructorServiceProxyid.getInstructorById(instructorId_13idTemp);
if(getInstructorById51mtemp == null){
%>
<%=getInstructorById51mtemp %>
<%
}else{
        String tempResultreturnp52 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getInstructorById51mtemp));
        %>
        <%= tempResultreturnp52 %>
        <%
}
break;
case 56:
        gotMethod = true;
        String courseId_14id=  request.getParameter("courseId59");
            java.lang.String courseId_14idTemp = null;
        if(!courseId_14id.equals("")){
         courseId_14idTemp  = courseId_14id;
        }
        String instructorId_15id=  request.getParameter("instructorId61");
            java.lang.String instructorId_15idTemp = null;
        if(!instructorId_15id.equals("")){
         instructorId_15idTemp  = instructorId_15id;
        }
        java.lang.String assignInstructor56mtemp = sampleInstructorServiceProxyid.assignInstructor(courseId_14idTemp,instructorId_15idTemp);
if(assignInstructor56mtemp == null){
%>
<%=assignInstructor56mtemp %>
<%
}else{
        String tempResultreturnp57 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(assignInstructor56mtemp));
        %>
        <%= tempResultreturnp57 %>
        <%
}
break;
case 63:
        gotMethod = true;
        String instructorId_16id=  request.getParameter("instructorId66");
            java.lang.String instructorId_16idTemp = null;
        if(!instructorId_16id.equals("")){
         instructorId_16idTemp  = instructorId_16id;
        }
        java.lang.String unAssignInstructor63mtemp = sampleInstructorServiceProxyid.unAssignInstructor(instructorId_16idTemp);
if(unAssignInstructor63mtemp == null){
%>
<%=unAssignInstructor63mtemp %>
<%
}else{
        String tempResultreturnp64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(unAssignInstructor63mtemp));
        %>
        <%= tempResultreturnp64 %>
        <%
}
break;
case 68:
        gotMethod = true;
        String instructorEmpId_17id=  request.getParameter("instructorEmpId71");
            java.lang.String instructorEmpId_17idTemp = null;
        if(!instructorEmpId_17id.equals("")){
         instructorEmpId_17idTemp  = instructorEmpId_17id;
        }
        String firstname_18id=  request.getParameter("firstname73");
            java.lang.String firstname_18idTemp = null;
        if(!firstname_18id.equals("")){
         firstname_18idTemp  = firstname_18id;
        }
        String lastname_19id=  request.getParameter("lastname75");
            java.lang.String lastname_19idTemp = null;
        if(!lastname_19id.equals("")){
         lastname_19idTemp  = lastname_19id;
        }
        String address_20id=  request.getParameter("address77");
            java.lang.String address_20idTemp = null;
        if(!address_20id.equals("")){
         address_20idTemp  = address_20id;
        }
        String city_21id=  request.getParameter("city79");
            java.lang.String city_21idTemp = null;
        if(!city_21id.equals("")){
         city_21idTemp  = city_21id;
        }
        String state_22id=  request.getParameter("state81");
            java.lang.String state_22idTemp = null;
        if(!state_22id.equals("")){
         state_22idTemp  = state_22id;
        }
        String zip_23id=  request.getParameter("zip83");
        int zip_23idTemp  = Integer.parseInt(zip_23id);
        String department_24id=  request.getParameter("department85");
            java.lang.String department_24idTemp = null;
        if(!department_24id.equals("")){
         department_24idTemp  = department_24id;
        }
        String days_25id=  request.getParameter("days87");
            java.lang.String days_25idTemp = null;
        if(!days_25id.equals("")){
         days_25idTemp  = days_25id;
        }
        String timings_26id=  request.getParameter("timings89");
            java.lang.String timings_26idTemp = null;
        if(!timings_26id.equals("")){
         timings_26idTemp  = timings_26id;
        }
        java.lang.String updateInstructor68mtemp = sampleInstructorServiceProxyid.updateInstructor(instructorEmpId_17idTemp,firstname_18idTemp,lastname_19idTemp,address_20idTemp,city_21idTemp,state_22idTemp,zip_23idTemp,department_24idTemp,days_25idTemp,timings_26idTemp);
if(updateInstructor68mtemp == null){
%>
<%=updateInstructor68mtemp %>
<%
}else{
        String tempResultreturnp69 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateInstructor68mtemp));
        %>
        <%= tempResultreturnp69 %>
        <%
}
break;
case 91:
        gotMethod = true;
        String attribute_27id=  request.getParameter("attribute94");
            java.lang.String attribute_27idTemp = null;
        if(!attribute_27id.equals("")){
         attribute_27idTemp  = attribute_27id;
        }
        String keyword_28id=  request.getParameter("keyword96");
            java.lang.String keyword_28idTemp = null;
        if(!keyword_28id.equals("")){
         keyword_28idTemp  = keyword_28id;
        }
        java.lang.String searchInstructor91mtemp = sampleInstructorServiceProxyid.searchInstructor(attribute_27idTemp,keyword_28idTemp);
if(searchInstructor91mtemp == null){
%>
<%=searchInstructor91mtemp %>
<%
}else{
        String tempResultreturnp92 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(searchInstructor91mtemp));
        %>
        <%= tempResultreturnp92 %>
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