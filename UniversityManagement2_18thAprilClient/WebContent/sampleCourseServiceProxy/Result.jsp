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
        String section_2id=  request.getParameter("section20");
            java.lang.String section_2idTemp = null;
        if(!section_2id.equals("")){
         section_2idTemp  = section_2id;
        }
        java.lang.String getAssignedInstructorForCourse15mtemp = sampleCourseServiceProxyid.getAssignedInstructorForCourse(courseId_1idTemp,section_2idTemp);
if(getAssignedInstructorForCourse15mtemp == null){
%>
<%=getAssignedInstructorForCourse15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAssignedInstructorForCourse15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 22:
        gotMethod = true;
        String courseId_3id=  request.getParameter("courseId25");
            java.lang.String courseId_3idTemp = null;
        if(!courseId_3id.equals("")){
         courseId_3idTemp  = courseId_3id;
        }
        String section_4id=  request.getParameter("section27");
            java.lang.String section_4idTemp = null;
        if(!section_4id.equals("")){
         section_4idTemp  = section_4id;
        }
        java.lang.String getEnrolledStudentForCourse22mtemp = sampleCourseServiceProxyid.getEnrolledStudentForCourse(courseId_3idTemp,section_4idTemp);
if(getEnrolledStudentForCourse22mtemp == null){
%>
<%=getEnrolledStudentForCourse22mtemp %>
<%
}else{
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEnrolledStudentForCourse22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
}
break;
case 29:
        gotMethod = true;
        java.lang.String getAllCourses29mtemp = sampleCourseServiceProxyid.getAllCourses();
if(getAllCourses29mtemp == null){
%>
<%=getAllCourses29mtemp %>
<%
}else{
        String tempResultreturnp30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllCourses29mtemp));
        %>
        <%= tempResultreturnp30 %>
        <%
}
break;
case 32:
        gotMethod = true;
        String search_5id=  request.getParameter("search35");
            java.lang.String search_5idTemp = null;
        if(!search_5id.equals("")){
         search_5idTemp  = search_5id;
        }
        java.lang.String findCourse32mtemp = sampleCourseServiceProxyid.findCourse(search_5idTemp);
if(findCourse32mtemp == null){
%>
<%=findCourse32mtemp %>
<%
}else{
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(findCourse32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
}
break;
case 37:
        gotMethod = true;
        String courseId_6id=  request.getParameter("courseId40");
            java.lang.String courseId_6idTemp = null;
        if(!courseId_6id.equals("")){
         courseId_6idTemp  = courseId_6id;
        }
        String courseSection_7id=  request.getParameter("courseSection42");
            java.lang.String courseSection_7idTemp = null;
        if(!courseSection_7id.equals("")){
         courseSection_7idTemp  = courseSection_7id;
        }
        String courseName_8id=  request.getParameter("courseName44");
            java.lang.String courseName_8idTemp = null;
        if(!courseName_8id.equals("")){
         courseName_8idTemp  = courseName_8id;
        }
        String courseLocation_9id=  request.getParameter("courseLocation46");
            java.lang.String courseLocation_9idTemp = null;
        if(!courseLocation_9id.equals("")){
         courseLocation_9idTemp  = courseLocation_9id;
        }
        String days_10id=  request.getParameter("days48");
            java.lang.String days_10idTemp = null;
        if(!days_10id.equals("")){
         days_10idTemp  = days_10id;
        }
        String timing_11id=  request.getParameter("timing50");
            java.lang.String timing_11idTemp = null;
        if(!timing_11id.equals("")){
         timing_11idTemp  = timing_11id;
        }
        java.lang.String updateCourse37mtemp = sampleCourseServiceProxyid.updateCourse(courseId_6idTemp,courseSection_7idTemp,courseName_8idTemp,courseLocation_9idTemp,days_10idTemp,timing_11idTemp);
if(updateCourse37mtemp == null){
%>
<%=updateCourse37mtemp %>
<%
}else{
        String tempResultreturnp38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateCourse37mtemp));
        %>
        <%= tempResultreturnp38 %>
        <%
}
break;
case 52:
        gotMethod = true;
        String attribute_12id=  request.getParameter("attribute55");
            java.lang.String attribute_12idTemp = null;
        if(!attribute_12id.equals("")){
         attribute_12idTemp  = attribute_12id;
        }
        String keyword_13id=  request.getParameter("keyword57");
            java.lang.String keyword_13idTemp = null;
        if(!keyword_13id.equals("")){
         keyword_13idTemp  = keyword_13id;
        }
        java.lang.String searchCourse52mtemp = sampleCourseServiceProxyid.searchCourse(attribute_12idTemp,keyword_13idTemp);
if(searchCourse52mtemp == null){
%>
<%=searchCourse52mtemp %>
<%
}else{
        String tempResultreturnp53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(searchCourse52mtemp));
        %>
        <%= tempResultreturnp53 %>
        <%
}
break;
case 59:
        gotMethod = true;
        String courseId_14id=  request.getParameter("courseId62");
            java.lang.String courseId_14idTemp = null;
        if(!courseId_14id.equals("")){
         courseId_14idTemp  = courseId_14id;
        }
        String courseName_15id=  request.getParameter("courseName64");
            java.lang.String courseName_15idTemp = null;
        if(!courseName_15id.equals("")){
         courseName_15idTemp  = courseName_15id;
        }
        String courseSection_16id=  request.getParameter("courseSection66");
            java.lang.String courseSection_16idTemp = null;
        if(!courseSection_16id.equals("")){
         courseSection_16idTemp  = courseSection_16id;
        }
        String location_17id=  request.getParameter("location68");
            java.lang.String location_17idTemp = null;
        if(!location_17id.equals("")){
         location_17idTemp  = location_17id;
        }
        String day_18id=  request.getParameter("day70");
            java.lang.String day_18idTemp = null;
        if(!day_18id.equals("")){
         day_18idTemp  = day_18id;
        }
        String timing_19id=  request.getParameter("timing72");
            java.lang.String timing_19idTemp = null;
        if(!timing_19id.equals("")){
         timing_19idTemp  = timing_19id;
        }
        java.lang.String addCourse59mtemp = sampleCourseServiceProxyid.addCourse(courseId_14idTemp,courseName_15idTemp,courseSection_16idTemp,location_17idTemp,day_18idTemp,timing_19idTemp);
if(addCourse59mtemp == null){
%>
<%=addCourse59mtemp %>
<%
}else{
        String tempResultreturnp60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addCourse59mtemp));
        %>
        <%= tempResultreturnp60 %>
        <%
}
break;
case 74:
        gotMethod = true;
        String courseId_20id=  request.getParameter("courseId77");
            java.lang.String courseId_20idTemp = null;
        if(!courseId_20id.equals("")){
         courseId_20idTemp  = courseId_20id;
        }
        String section_21id=  request.getParameter("section79");
            java.lang.String section_21idTemp = null;
        if(!section_21id.equals("")){
         section_21idTemp  = section_21id;
        }
        java.lang.String deleteCourse74mtemp = sampleCourseServiceProxyid.deleteCourse(courseId_20idTemp,section_21idTemp);
if(deleteCourse74mtemp == null){
%>
<%=deleteCourse74mtemp %>
<%
}else{
        String tempResultreturnp75 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteCourse74mtemp));
        %>
        <%= tempResultreturnp75 %>
        <%
}
break;
case 81:
        gotMethod = true;
        String courseId_22id=  request.getParameter("courseId84");
            java.lang.String courseId_22idTemp = null;
        if(!courseId_22id.equals("")){
         courseId_22idTemp  = courseId_22id;
        }
        String courseSec_23id=  request.getParameter("courseSec86");
            java.lang.String courseSec_23idTemp = null;
        if(!courseSec_23id.equals("")){
         courseSec_23idTemp  = courseSec_23id;
        }
        java.lang.String getCourseById81mtemp = sampleCourseServiceProxyid.getCourseById(courseId_22idTemp,courseSec_23idTemp);
if(getCourseById81mtemp == null){
%>
<%=getCourseById81mtemp %>
<%
}else{
        String tempResultreturnp82 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCourseById81mtemp));
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