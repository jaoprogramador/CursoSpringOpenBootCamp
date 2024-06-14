<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleValidarDNIWSProxyid" scope="session" class="com.jao.ws.soap.validardni.service.ValidarDNIWSProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleValidarDNIWSProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleValidarDNIWSProxyid.getEndpoint();
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
        sampleValidarDNIWSProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.jao.ws.soap.validardni.service.ValidarDNIWS getValidarDNIWS10mtemp = sampleValidarDNIWSProxyid.getValidarDNIWS();
if(getValidarDNIWS10mtemp == null){
%>
<%=getValidarDNIWS10mtemp %>
<%
}else{
        if(getValidarDNIWS10mtemp!= null){
        String tempreturnp11 = getValidarDNIWS10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String numeroDNI_1id=  request.getParameter("numeroDNI16");
            java.lang.String numeroDNI_1idTemp = null;
        if(!numeroDNI_1id.equals("")){
         numeroDNI_1idTemp  = numeroDNI_1id;
        }
        java.lang.Object validarDNI13mtemp = sampleValidarDNIWSProxyid.validarDNI(numeroDNI_1idTemp);
if(validarDNI13mtemp == null){
%>
<%=validarDNI13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(validarDNI13mtemp.toString());
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 18:
        gotMethod = true;
        String dni_2id=  request.getParameter("dni21");
            java.lang.String dni_2idTemp = null;
        if(!dni_2id.equals("")){
         dni_2idTemp  = dni_2id;
        }
        boolean valDNI18mtemp = sampleValidarDNIWSProxyid.valDNI(dni_2idTemp);
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(valDNI18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
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