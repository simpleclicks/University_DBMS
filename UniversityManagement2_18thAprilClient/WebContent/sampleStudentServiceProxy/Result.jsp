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
        if(getStudentService10mtemp!= null){
        String tempreturnp11 = getStudentService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String studentId_1id=  request.getParameter("studentId16");
            java.lang.String studentId_1idTemp = null;
        if(!studentId_1id.equals("")){
         studentId_1idTemp  = studentId_1id;
        }
        String firstname_2id=  request.getParameter("firstname18");
            java.lang.String firstname_2idTemp = null;
        if(!firstname_2id.equals("")){
         firstname_2idTemp  = firstname_2id;
        }
        String lastname_3id=  request.getParameter("lastname20");
            java.lang.String lastname_3idTemp = null;
        if(!lastname_3id.equals("")){
         lastname_3idTemp  = lastname_3id;
        }
        String address_4id=  request.getParameter("address22");
            java.lang.String address_4idTemp = null;
        if(!address_4id.equals("")){
         address_4idTemp  = address_4id;
        }
        String city_5id=  request.getParameter("city24");
            java.lang.String city_5idTemp = null;
        if(!city_5id.equals("")){
         city_5idTemp  = city_5id;
        }
        String state_6id=  request.getParameter("state26");
            java.lang.String state_6idTemp = null;
        if(!state_6id.equals("")){
         state_6idTemp  = state_6id;
        }
        String zipCode_7id=  request.getParameter("zipCode28");
        int zipCode_7idTemp  = Integer.parseInt(zipCode_7id);
        String courseList_8id=  request.getParameter("courseList30");
            java.lang.String courseList_8idTemp = null;
        if(!courseList_8id.equals("")){
         courseList_8idTemp  = courseList_8id;
        }
        java.lang.String addStudent13mtemp = sampleStudentServiceProxyid.addStudent(studentId_1idTemp,firstname_2idTemp,lastname_3idTemp,address_4idTemp,city_5idTemp,state_6idTemp,zipCode_7idTemp,courseList_8idTemp);
if(addStudent13mtemp == null){
%>
<%=addStudent13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addStudent13mtemp));
        %>
        <%= tempResultreturnp14 %>
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