<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCourseServiceProxyid" scope="session" class="edu.service.CourseServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCourseServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleCourseServiceProxyid.getEndpoint();
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
        sampleCourseServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        edu.service.CourseService getCourseService10mtemp = sampleCourseServiceProxyid.getCourseService();
if(getCourseService10mtemp == null){
%>
<%=getCourseService10mtemp %>
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
        String courseId_1id=  request.getParameter("courseId18");
            java.lang.String courseId_1idTemp = null;
        if(!courseId_1id.equals("")){
         courseId_1idTemp  = courseId_1id;
        }
        java.lang.String getEnrolledStudentForCourse15mtemp = sampleCourseServiceProxyid.getEnrolledStudentForCourse(courseId_1idTemp);
if(getEnrolledStudentForCourse15mtemp == null){
%>
<%=getEnrolledStudentForCourse15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEnrolledStudentForCourse15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 20:
        gotMethod = true;
        String courseId_2id=  request.getParameter("courseId23");
            java.lang.String courseId_2idTemp = null;
        if(!courseId_2id.equals("")){
         courseId_2idTemp  = courseId_2id;
        }
        String courseName_3id=  request.getParameter("courseName25");
            java.lang.String courseName_3idTemp = null;
        if(!courseName_3id.equals("")){
         courseName_3idTemp  = courseName_3id;
        }
        String courseSelection_4id=  request.getParameter("courseSelection27");
            java.lang.String courseSelection_4idTemp = null;
        if(!courseSelection_4id.equals("")){
         courseSelection_4idTemp  = courseSelection_4id;
        }
        String location_5id=  request.getParameter("location29");
            java.lang.String location_5idTemp = null;
        if(!location_5id.equals("")){
         location_5idTemp  = location_5id;
        }
        java.lang.String addCourse20mtemp = sampleCourseServiceProxyid.addCourse(courseId_2idTemp,courseName_3idTemp,courseSelection_4idTemp,location_5idTemp);
if(addCourse20mtemp == null){
%>
<%=addCourse20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addCourse20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 31:
        gotMethod = true;
        String search_6id=  request.getParameter("search34");
            java.lang.String search_6idTemp = null;
        if(!search_6id.equals("")){
         search_6idTemp  = search_6id;
        }
        java.lang.String findCourse31mtemp = sampleCourseServiceProxyid.findCourse(search_6idTemp);
if(findCourse31mtemp == null){
%>
<%=findCourse31mtemp %>
<%
}else{
        String tempResultreturnp32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(findCourse31mtemp));
        %>
        <%= tempResultreturnp32 %>
        <%
}
break;
case 36:
        gotMethod = true;
        String courseId_7id=  request.getParameter("courseId39");
            java.lang.String courseId_7idTemp = null;
        if(!courseId_7id.equals("")){
         courseId_7idTemp  = courseId_7id;
        }
        java.lang.String deleteCourse36mtemp = sampleCourseServiceProxyid.deleteCourse(courseId_7idTemp);
if(deleteCourse36mtemp == null){
%>
<%=deleteCourse36mtemp %>
<%
}else{
        String tempResultreturnp37 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteCourse36mtemp));
        %>
        <%= tempResultreturnp37 %>
        <%
}
break;
case 41:
        gotMethod = true;
        String courseId_8id=  request.getParameter("courseId44");
            java.lang.String courseId_8idTemp = null;
        if(!courseId_8id.equals("")){
         courseId_8idTemp  = courseId_8id;
        }
        java.lang.String getAssignedInstructorForCourse41mtemp = sampleCourseServiceProxyid.getAssignedInstructorForCourse(courseId_8idTemp);
if(getAssignedInstructorForCourse41mtemp == null){
%>
<%=getAssignedInstructorForCourse41mtemp %>
<%
}else{
        String tempResultreturnp42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAssignedInstructorForCourse41mtemp));
        %>
        <%= tempResultreturnp42 %>
        <%
}
break;
case 46:
        gotMethod = true;
        java.lang.String getAllCourses46mtemp = sampleCourseServiceProxyid.getAllCourses();
if(getAllCourses46mtemp == null){
%>
<%=getAllCourses46mtemp %>
<%
}else{
        String tempResultreturnp47 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllCourses46mtemp));
        %>
        <%= tempResultreturnp47 %>
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