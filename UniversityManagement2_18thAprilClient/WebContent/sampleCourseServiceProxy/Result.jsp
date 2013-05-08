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
        java.lang.String getCourseById15mtemp = sampleCourseServiceProxyid.getCourseById(courseId_1idTemp);
if(getCourseById15mtemp == null){
%>
<%=getCourseById15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCourseById15mtemp));
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
        String section_3id=  request.getParameter("section25");
            java.lang.String section_3idTemp = null;
        if(!section_3id.equals("")){
         section_3idTemp  = section_3id;
        }
        java.lang.String getEnrolledStudentForCourse20mtemp = sampleCourseServiceProxyid.getEnrolledStudentForCourse(courseId_2idTemp,section_3idTemp);
if(getEnrolledStudentForCourse20mtemp == null){
%>
<%=getEnrolledStudentForCourse20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEnrolledStudentForCourse20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 27:
        gotMethod = true;
        java.lang.String getAllCourses27mtemp = sampleCourseServiceProxyid.getAllCourses();
if(getAllCourses27mtemp == null){
%>
<%=getAllCourses27mtemp %>
<%
}else{
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllCourses27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
}
break;
case 30:
        gotMethod = true;
        String courseId_4id=  request.getParameter("courseId33");
            java.lang.String courseId_4idTemp = null;
        if(!courseId_4id.equals("")){
         courseId_4idTemp  = courseId_4id;
        }
        String section_5id=  request.getParameter("section35");
            java.lang.String section_5idTemp = null;
        if(!section_5id.equals("")){
         section_5idTemp  = section_5id;
        }
        java.lang.String getAssignedInstructorForCourse30mtemp = sampleCourseServiceProxyid.getAssignedInstructorForCourse(courseId_4idTemp,section_5idTemp);
if(getAssignedInstructorForCourse30mtemp == null){
%>
<%=getAssignedInstructorForCourse30mtemp %>
<%
}else{
        String tempResultreturnp31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAssignedInstructorForCourse30mtemp));
        %>
        <%= tempResultreturnp31 %>
        <%
}
break;
case 37:
        gotMethod = true;
        String attribute_6id=  request.getParameter("attribute40");
            java.lang.String attribute_6idTemp = null;
        if(!attribute_6id.equals("")){
         attribute_6idTemp  = attribute_6id;
        }
        String keyword_7id=  request.getParameter("keyword42");
            java.lang.String keyword_7idTemp = null;
        if(!keyword_7id.equals("")){
         keyword_7idTemp  = keyword_7id;
        }
        java.lang.String searchCourse37mtemp = sampleCourseServiceProxyid.searchCourse(attribute_6idTemp,keyword_7idTemp);
if(searchCourse37mtemp == null){
%>
<%=searchCourse37mtemp %>
<%
}else{
        String tempResultreturnp38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(searchCourse37mtemp));
        %>
        <%= tempResultreturnp38 %>
        <%
}
break;
case 44:
        gotMethod = true;
        String courseId_8id=  request.getParameter("courseId47");
            java.lang.String courseId_8idTemp = null;
        if(!courseId_8id.equals("")){
         courseId_8idTemp  = courseId_8id;
        }
        String courseSection_9id=  request.getParameter("courseSection49");
            java.lang.String courseSection_9idTemp = null;
        if(!courseSection_9id.equals("")){
         courseSection_9idTemp  = courseSection_9id;
        }
        String courseName_10id=  request.getParameter("courseName51");
            java.lang.String courseName_10idTemp = null;
        if(!courseName_10id.equals("")){
         courseName_10idTemp  = courseName_10id;
        }
        String courseLocation_11id=  request.getParameter("courseLocation53");
            java.lang.String courseLocation_11idTemp = null;
        if(!courseLocation_11id.equals("")){
         courseLocation_11idTemp  = courseLocation_11id;
        }
        String days_12id=  request.getParameter("days55");
            java.lang.String days_12idTemp = null;
        if(!days_12id.equals("")){
         days_12idTemp  = days_12id;
        }
        String timing_13id=  request.getParameter("timing57");
            java.lang.String timing_13idTemp = null;
        if(!timing_13id.equals("")){
         timing_13idTemp  = timing_13id;
        }
        java.lang.String updateCourse44mtemp = sampleCourseServiceProxyid.updateCourse(courseId_8idTemp,courseSection_9idTemp,courseName_10idTemp,courseLocation_11idTemp,days_12idTemp,timing_13idTemp);
if(updateCourse44mtemp == null){
%>
<%=updateCourse44mtemp %>
<%
}else{
        String tempResultreturnp45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateCourse44mtemp));
        %>
        <%= tempResultreturnp45 %>
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
        java.lang.String deleteCourse59mtemp = sampleCourseServiceProxyid.deleteCourse(courseId_14idTemp);
if(deleteCourse59mtemp == null){
%>
<%=deleteCourse59mtemp %>
<%
}else{
        String tempResultreturnp60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteCourse59mtemp));
        %>
        <%= tempResultreturnp60 %>
        <%
}
break;
case 64:
        gotMethod = true;
        String search_15id=  request.getParameter("search67");
            java.lang.String search_15idTemp = null;
        if(!search_15id.equals("")){
         search_15idTemp  = search_15id;
        }
        java.lang.String findCourse64mtemp = sampleCourseServiceProxyid.findCourse(search_15idTemp);
if(findCourse64mtemp == null){
%>
<%=findCourse64mtemp %>
<%
}else{
        String tempResultreturnp65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(findCourse64mtemp));
        %>
        <%= tempResultreturnp65 %>
        <%
}
break;
case 69:
        gotMethod = true;
        String courseId_16id=  request.getParameter("courseId72");
            java.lang.String courseId_16idTemp = null;
        if(!courseId_16id.equals("")){
         courseId_16idTemp  = courseId_16id;
        }
        String courseName_17id=  request.getParameter("courseName74");
            java.lang.String courseName_17idTemp = null;
        if(!courseName_17id.equals("")){
         courseName_17idTemp  = courseName_17id;
        }
        String courseSection_18id=  request.getParameter("courseSection76");
            java.lang.String courseSection_18idTemp = null;
        if(!courseSection_18id.equals("")){
         courseSection_18idTemp  = courseSection_18id;
        }
        String location_19id=  request.getParameter("location78");
            java.lang.String location_19idTemp = null;
        if(!location_19id.equals("")){
         location_19idTemp  = location_19id;
        }
        String day_20id=  request.getParameter("day80");
            java.lang.String day_20idTemp = null;
        if(!day_20id.equals("")){
         day_20idTemp  = day_20id;
        }
        String timing_21id=  request.getParameter("timing82");
            java.lang.String timing_21idTemp = null;
        if(!timing_21id.equals("")){
         timing_21idTemp  = timing_21id;
        }
        java.lang.String addCourse69mtemp = sampleCourseServiceProxyid.addCourse(courseId_16idTemp,courseName_17idTemp,courseSection_18idTemp,location_19idTemp,day_20idTemp,timing_21idTemp);
if(addCourse69mtemp == null){
%>
<%=addCourse69mtemp %>
<%
}else{
        String tempResultreturnp70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addCourse69mtemp));
        %>
        <%= tempResultreturnp70 %>
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