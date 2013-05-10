<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="samplePersonServiceProxyid" scope="session" class="edu.service.PersonServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
samplePersonServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = samplePersonServiceProxyid.getEndpoint();
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
        samplePersonServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        edu.service.PersonService getPersonService10mtemp = samplePersonServiceProxyid.getPersonService();
if(getPersonService10mtemp == null){
%>
<%=getPersonService10mtemp %>
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
        String firstname_1id=  request.getParameter("firstname18");
            java.lang.String firstname_1idTemp = null;
        if(!firstname_1id.equals("")){
         firstname_1idTemp  = firstname_1id;
        }
        String lastname_2id=  request.getParameter("lastname20");
            java.lang.String lastname_2idTemp = null;
        if(!lastname_2id.equals("")){
         lastname_2idTemp  = lastname_2id;
        }
        String address_3id=  request.getParameter("address22");
            java.lang.String address_3idTemp = null;
        if(!address_3id.equals("")){
         address_3idTemp  = address_3id;
        }
        String city_4id=  request.getParameter("city24");
            java.lang.String city_4idTemp = null;
        if(!city_4id.equals("")){
         city_4idTemp  = city_4id;
        }
        String state_5id=  request.getParameter("state26");
            java.lang.String state_5idTemp = null;
        if(!state_5id.equals("")){
         state_5idTemp  = state_5id;
        }
        String zipCode_6id=  request.getParameter("zipCode28");
            java.lang.String zipCode_6idTemp = null;
        if(!zipCode_6id.equals("")){
         zipCode_6idTemp  = zipCode_6id;
        }
        String password_7id=  request.getParameter("password30");
            java.lang.String password_7idTemp = null;
        if(!password_7id.equals("")){
         password_7idTemp  = password_7id;
        }
        java.lang.String addPerson15mtemp = samplePersonServiceProxyid.addPerson(firstname_1idTemp,lastname_2idTemp,address_3idTemp,city_4idTemp,state_5idTemp,zipCode_6idTemp,password_7idTemp);
if(addPerson15mtemp == null){
%>
<%=addPerson15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addPerson15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 32:
        gotMethod = true;
        String personId_8id=  request.getParameter("personId35");
            java.lang.String personId_8idTemp = null;
        if(!personId_8id.equals("")){
         personId_8idTemp  = personId_8id;
        }
        java.lang.String deletePerson32mtemp = samplePersonServiceProxyid.deletePerson(personId_8idTemp);
if(deletePerson32mtemp == null){
%>
<%=deletePerson32mtemp %>
<%
}else{
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deletePerson32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
}
break;
case 37:
        gotMethod = true;
        String personId_9id=  request.getParameter("personId40");
            java.lang.String personId_9idTemp = null;
        if(!personId_9id.equals("")){
         personId_9idTemp  = personId_9id;
        }
        String firstname_10id=  request.getParameter("firstname42");
            java.lang.String firstname_10idTemp = null;
        if(!firstname_10id.equals("")){
         firstname_10idTemp  = firstname_10id;
        }
        String lastname_11id=  request.getParameter("lastname44");
            java.lang.String lastname_11idTemp = null;
        if(!lastname_11id.equals("")){
         lastname_11idTemp  = lastname_11id;
        }
        String address_12id=  request.getParameter("address46");
            java.lang.String address_12idTemp = null;
        if(!address_12id.equals("")){
         address_12idTemp  = address_12id;
        }
        String city_13id=  request.getParameter("city48");
            java.lang.String city_13idTemp = null;
        if(!city_13id.equals("")){
         city_13idTemp  = city_13id;
        }
        String state_14id=  request.getParameter("state50");
            java.lang.String state_14idTemp = null;
        if(!state_14id.equals("")){
         state_14idTemp  = state_14id;
        }
        String zip_15id=  request.getParameter("zip52");
            java.lang.String zip_15idTemp = null;
        if(!zip_15id.equals("")){
         zip_15idTemp  = zip_15id;
        }
        java.lang.String updatePerson37mtemp = samplePersonServiceProxyid.updatePerson(personId_9idTemp,firstname_10idTemp,lastname_11idTemp,address_12idTemp,city_13idTemp,state_14idTemp,zip_15idTemp);
if(updatePerson37mtemp == null){
%>
<%=updatePerson37mtemp %>
<%
}else{
        String tempResultreturnp38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updatePerson37mtemp));
        %>
        <%= tempResultreturnp38 %>
        <%
}
break;
case 54:
        gotMethod = true;
        java.lang.String getAllPerson54mtemp = samplePersonServiceProxyid.getAllPerson();
if(getAllPerson54mtemp == null){
%>
<%=getAllPerson54mtemp %>
<%
}else{
        String tempResultreturnp55 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllPerson54mtemp));
        %>
        <%= tempResultreturnp55 %>
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