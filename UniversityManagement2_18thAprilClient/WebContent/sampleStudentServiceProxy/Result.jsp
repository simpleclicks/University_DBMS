<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleStudentServiceProxyid" scope="session" class="edu.service.StudentServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleStudentServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleStudentServiceProxyid.getEndpoint();
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
        sampleStudentServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        edu.service.StudentService getStudentService10mtemp = sampleStudentServiceProxyid.getStudentService();
if(getStudentService10mtemp == null){
%>
<%=getStudentService10mtemp %>
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
        String studentId_1id=  request.getParameter("studentId18");
            java.lang.String studentId_1idTemp = null;
        if(!studentId_1id.equals("")){
         studentId_1idTemp  = studentId_1id;
        }
        String firstname_2id=  request.getParameter("firstname20");
            java.lang.String firstname_2idTemp = null;
        if(!firstname_2id.equals("")){
         firstname_2idTemp  = firstname_2id;
        }
        String lastname_3id=  request.getParameter("lastname22");
            java.lang.String lastname_3idTemp = null;
        if(!lastname_3id.equals("")){
         lastname_3idTemp  = lastname_3id;
        }
        String address_4id=  request.getParameter("address24");
            java.lang.String address_4idTemp = null;
        if(!address_4id.equals("")){
         address_4idTemp  = address_4id;
        }
        String city_5id=  request.getParameter("city26");
            java.lang.String city_5idTemp = null;
        if(!city_5id.equals("")){
         city_5idTemp  = city_5id;
        }
        String state_6id=  request.getParameter("state28");
            java.lang.String state_6idTemp = null;
        if(!state_6id.equals("")){
         state_6idTemp  = state_6id;
        }
        String zipCode_7id=  request.getParameter("zipCode30");
            java.lang.String zipCode_7idTemp = null;
        if(!zipCode_7id.equals("")){
         zipCode_7idTemp  = zipCode_7id;
        }
        String password_8id=  request.getParameter("password32");
            java.lang.String password_8idTemp = null;
        if(!password_8id.equals("")){
         password_8idTemp  = password_8id;
        }
        java.lang.String addStudent15mtemp = sampleStudentServiceProxyid.addStudent(studentId_1idTemp,firstname_2idTemp,lastname_3idTemp,address_4idTemp,city_5idTemp,state_6idTemp,zipCode_7idTemp,password_8idTemp);
if(addStudent15mtemp == null){
%>
<%=addStudent15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addStudent15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 34:
        gotMethod = true;
        String attribute_9id=  request.getParameter("attribute37");
            java.lang.String attribute_9idTemp = null;
        if(!attribute_9id.equals("")){
         attribute_9idTemp  = attribute_9id;
        }
        String keyword_10id=  request.getParameter("keyword39");
            java.lang.String keyword_10idTemp = null;
        if(!keyword_10id.equals("")){
         keyword_10idTemp  = keyword_10id;
        }
        java.lang.String searchStudent34mtemp = sampleStudentServiceProxyid.searchStudent(attribute_9idTemp,keyword_10idTemp);
if(searchStudent34mtemp == null){
%>
<%=searchStudent34mtemp %>
<%
}else{
        String tempResultreturnp35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(searchStudent34mtemp));
        %>
        <%= tempResultreturnp35 %>
        <%
}
break;
case 41:
        gotMethod = true;
        String studentId_11id=  request.getParameter("studentId44");
            java.lang.String studentId_11idTemp = null;
        if(!studentId_11id.equals("")){
         studentId_11idTemp  = studentId_11id;
        }
        String firstname_12id=  request.getParameter("firstname46");
            java.lang.String firstname_12idTemp = null;
        if(!firstname_12id.equals("")){
         firstname_12idTemp  = firstname_12id;
        }
        String lastname_13id=  request.getParameter("lastname48");
            java.lang.String lastname_13idTemp = null;
        if(!lastname_13id.equals("")){
         lastname_13idTemp  = lastname_13id;
        }
        String address_14id=  request.getParameter("address50");
            java.lang.String address_14idTemp = null;
        if(!address_14id.equals("")){
         address_14idTemp  = address_14id;
        }
        String city_15id=  request.getParameter("city52");
            java.lang.String city_15idTemp = null;
        if(!city_15id.equals("")){
         city_15idTemp  = city_15id;
        }
        String state_16id=  request.getParameter("state54");
            java.lang.String state_16idTemp = null;
        if(!state_16id.equals("")){
         state_16idTemp  = state_16id;
        }
        String zip_17id=  request.getParameter("zip56");
            java.lang.String zip_17idTemp = null;
        if(!zip_17id.equals("")){
         zip_17idTemp  = zip_17id;
        }
        java.lang.String updateStudent41mtemp = sampleStudentServiceProxyid.updateStudent(studentId_11idTemp,firstname_12idTemp,lastname_13idTemp,address_14idTemp,city_15idTemp,state_16idTemp,zip_17idTemp);
if(updateStudent41mtemp == null){
%>
<%=updateStudent41mtemp %>
<%
}else{
        String tempResultreturnp42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateStudent41mtemp));
        %>
        <%= tempResultreturnp42 %>
        <%
}
break;
case 58:
        gotMethod = true;
        String studentId_18id=  request.getParameter("studentId61");
            java.lang.String studentId_18idTemp = null;
        if(!studentId_18id.equals("")){
         studentId_18idTemp  = studentId_18id;
        }
        java.lang.String getEnrolledCoursesForStudent58mtemp = sampleStudentServiceProxyid.getEnrolledCoursesForStudent(studentId_18idTemp);
if(getEnrolledCoursesForStudent58mtemp == null){
%>
<%=getEnrolledCoursesForStudent58mtemp %>
<%
}else{
        String tempResultreturnp59 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEnrolledCoursesForStudent58mtemp));
        %>
        <%= tempResultreturnp59 %>
        <%
}
break;
case 63:
        gotMethod = true;
        String studentId_19id=  request.getParameter("studentId66");
            java.lang.String studentId_19idTemp = null;
        if(!studentId_19id.equals("")){
         studentId_19idTemp  = studentId_19id;
        }
        String courseId_20id=  request.getParameter("courseId68");
            java.lang.String courseId_20idTemp = null;
        if(!courseId_20id.equals("")){
         courseId_20idTemp  = courseId_20id;
        }
        String section_21id=  request.getParameter("section70");
            java.lang.String section_21idTemp = null;
        if(!section_21id.equals("")){
         section_21idTemp  = section_21id;
        }
        java.lang.String unEnrollStudent63mtemp = sampleStudentServiceProxyid.unEnrollStudent(studentId_19idTemp,courseId_20idTemp,section_21idTemp);
if(unEnrollStudent63mtemp == null){
%>
<%=unEnrollStudent63mtemp %>
<%
}else{
        String tempResultreturnp64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(unEnrollStudent63mtemp));
        %>
        <%= tempResultreturnp64 %>
        <%
}
break;
case 72:
        gotMethod = true;
        String courseId_22id=  request.getParameter("courseId75");
            java.lang.String courseId_22idTemp = null;
        if(!courseId_22id.equals("")){
         courseId_22idTemp  = courseId_22id;
        }
        String section_23id=  request.getParameter("section77");
            java.lang.String section_23idTemp = null;
        if(!section_23id.equals("")){
         section_23idTemp  = section_23id;
        }
        String studentId_24id=  request.getParameter("studentId79");
            java.lang.String studentId_24idTemp = null;
        if(!studentId_24id.equals("")){
         studentId_24idTemp  = studentId_24id;
        }
        java.lang.String enrollStudent72mtemp = sampleStudentServiceProxyid.enrollStudent(courseId_22idTemp,section_23idTemp,studentId_24idTemp);
if(enrollStudent72mtemp == null){
%>
<%=enrollStudent72mtemp %>
<%
}else{
        String tempResultreturnp73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(enrollStudent72mtemp));
        %>
        <%= tempResultreturnp73 %>
        <%
}
break;
case 81:
        gotMethod = true;
        java.lang.String getAllStudent81mtemp = sampleStudentServiceProxyid.getAllStudent();
if(getAllStudent81mtemp == null){
%>
<%=getAllStudent81mtemp %>
<%
}else{
        String tempResultreturnp82 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllStudent81mtemp));
        %>
        <%= tempResultreturnp82 %>
        <%
}
break;
case 84:
        gotMethod = true;
        String studentId_25id=  request.getParameter("studentId87");
            java.lang.String studentId_25idTemp = null;
        if(!studentId_25id.equals("")){
         studentId_25idTemp  = studentId_25id;
        }
        java.lang.String deleteStudent84mtemp = sampleStudentServiceProxyid.deleteStudent(studentId_25idTemp);
if(deleteStudent84mtemp == null){
%>
<%=deleteStudent84mtemp %>
<%
}else{
        String tempResultreturnp85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteStudent84mtemp));
        %>
        <%= tempResultreturnp85 %>
        <%
}
break;
case 89:
        gotMethod = true;
        String studentId_26id=  request.getParameter("studentId92");
            java.lang.String studentId_26idTemp = null;
        if(!studentId_26id.equals("")){
         studentId_26idTemp  = studentId_26id;
        }
        java.lang.String getStudentById89mtemp = sampleStudentServiceProxyid.getStudentById(studentId_26idTemp);
if(getStudentById89mtemp == null){
%>
<%=getStudentById89mtemp %>
<%
}else{
        String tempResultreturnp90 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getStudentById89mtemp));
        %>
        <%= tempResultreturnp90 %>
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