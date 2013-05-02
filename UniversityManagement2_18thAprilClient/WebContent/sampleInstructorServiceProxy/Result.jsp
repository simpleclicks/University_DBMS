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
        java.lang.String deleteInstructor15mtemp = sampleInstructorServiceProxyid.deleteInstructor(instructorId_1idTemp);
if(deleteInstructor15mtemp == null){
%>
<%=deleteInstructor15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteInstructor15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 20:
        gotMethod = true;
        String instructorId_2id=  request.getParameter("instructorId23");
            java.lang.String instructorId_2idTemp = null;
        if(!instructorId_2id.equals("")){
         instructorId_2idTemp  = instructorId_2id;
        }
        java.lang.String getInstructorById20mtemp = sampleInstructorServiceProxyid.getInstructorById(instructorId_2idTemp);
if(getInstructorById20mtemp == null){
%>
<%=getInstructorById20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getInstructorById20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 25:
        gotMethod = true;
        java.lang.String getAllInstructor25mtemp = sampleInstructorServiceProxyid.getAllInstructor();
if(getAllInstructor25mtemp == null){
%>
<%=getAllInstructor25mtemp %>
<%
}else{
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllInstructor25mtemp));
        %>
        <%= tempResultreturnp26 %>
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
        String meetingTime_11id=  request.getParameter("meetingTime47");
            java.lang.String meetingTime_11idTemp = null;
        if(!meetingTime_11id.equals("")){
         meetingTime_11idTemp  = meetingTime_11id;
        }
        java.lang.String addInstructor28mtemp = sampleInstructorServiceProxyid.addInstructor(instructorId_3idTemp,firstname_4idTemp,lastname_5idTemp,address_6idTemp,city_7idTemp,state_8idTemp,zipCode_9idTemp,department_10idTemp,meetingTime_11idTemp);
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
case 49:
        gotMethod = true;
        String instructorId_12id=  request.getParameter("instructorId52");
            java.lang.String instructorId_12idTemp = null;
        if(!instructorId_12id.equals("")){
         instructorId_12idTemp  = instructorId_12id;
        }
        java.lang.String unAssignInstructor49mtemp = sampleInstructorServiceProxyid.unAssignInstructor(instructorId_12idTemp);
if(unAssignInstructor49mtemp == null){
%>
<%=unAssignInstructor49mtemp %>
<%
}else{
        String tempResultreturnp50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(unAssignInstructor49mtemp));
        %>
        <%= tempResultreturnp50 %>
        <%
}
break;
case 54:
        gotMethod = true;
        String courseId_13id=  request.getParameter("courseId57");
            java.lang.String courseId_13idTemp = null;
        if(!courseId_13id.equals("")){
         courseId_13idTemp  = courseId_13id;
        }
        String instructorId_14id=  request.getParameter("instructorId59");
            java.lang.String instructorId_14idTemp = null;
        if(!instructorId_14id.equals("")){
         instructorId_14idTemp  = instructorId_14id;
        }
        java.lang.String assignInstructor54mtemp = sampleInstructorServiceProxyid.assignInstructor(courseId_13idTemp,instructorId_14idTemp);
if(assignInstructor54mtemp == null){
%>
<%=assignInstructor54mtemp %>
<%
}else{
        String tempResultreturnp55 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(assignInstructor54mtemp));
        %>
        <%= tempResultreturnp55 %>
        <%
}
break;
case 61:
        gotMethod = true;
        String instructorId_15id=  request.getParameter("instructorId64");
            java.lang.String instructorId_15idTemp = null;
        if(!instructorId_15id.equals("")){
         instructorId_15idTemp  = instructorId_15id;
        }
        java.lang.String getEnrolledCoursesForInstructor61mtemp = sampleInstructorServiceProxyid.getEnrolledCoursesForInstructor(instructorId_15idTemp);
if(getEnrolledCoursesForInstructor61mtemp == null){
%>
<%=getEnrolledCoursesForInstructor61mtemp %>
<%
}else{
        String tempResultreturnp62 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEnrolledCoursesForInstructor61mtemp));
        %>
        <%= tempResultreturnp62 %>
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