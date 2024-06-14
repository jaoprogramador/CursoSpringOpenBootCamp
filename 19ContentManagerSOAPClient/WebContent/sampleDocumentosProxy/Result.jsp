<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleDocumentosProxyid" scope="session" class="com.jao.contentmanager.documentos.service.DocumentosProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleDocumentosProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleDocumentosProxyid.getEndpoint();
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
        sampleDocumentosProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.jao.contentmanager.documentos.service.Documentos getDocumentos10mtemp = sampleDocumentosProxyid.getDocumentos();
if(getDocumentos10mtemp == null){
%>
<%=getDocumentos10mtemp %>
<%
}else{
        if(getDocumentos10mtemp!= null){
        String tempreturnp11 = getDocumentos10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String fecha_creacion_2id=  request.getParameter("fecha_creacion18");
            java.util.Calendar fecha_creacion_2idTemp = null;
        if(!fecha_creacion_2id.equals("")){
        java.text.DateFormat dateFormatfecha_creacion18 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfecha_creacion18  = dateFormatfecha_creacion18.parse(fecha_creacion_2id);
         fecha_creacion_2idTemp = new java.util.GregorianCalendar();
        fecha_creacion_2idTemp.setTime(dateTempfecha_creacion18);
        }
        String tipo_3id=  request.getParameter("tipo20");
            java.lang.String tipo_3idTemp = null;
        if(!tipo_3id.equals("")){
         tipo_3idTemp  = tipo_3id;
        }
        String nombre_4id=  request.getParameter("nombre22");
            java.lang.String nombre_4idTemp = null;
        if(!nombre_4id.equals("")){
         nombre_4idTemp  = nombre_4id;
        }
        String id_5id=  request.getParameter("id24");
            java.lang.Long id_5idTemp = null;
        if(!id_5id.equals("")){
         id_5idTemp  = java.lang.Long.valueOf(id_5id);
        }
        String extension_6id=  request.getParameter("extension26");
            java.lang.String extension_6idTemp = null;
        if(!extension_6id.equals("")){
         extension_6idTemp  = extension_6id;
        }
        %>
        <jsp:useBean id="com1jao1contentmanager1documentos1model1DocumentoDTO_1id" scope="session" class="com.jao.contentmanager.documentos.model.DocumentoDTO" />
        <%
        com1jao1contentmanager1documentos1model1DocumentoDTO_1id.setFecha_creacion(fecha_creacion_2idTemp);
        com1jao1contentmanager1documentos1model1DocumentoDTO_1id.setTipo(tipo_3idTemp);
        com1jao1contentmanager1documentos1model1DocumentoDTO_1id.setNombre(nombre_4idTemp);
        com1jao1contentmanager1documentos1model1DocumentoDTO_1id.setId(id_5idTemp);
        com1jao1contentmanager1documentos1model1DocumentoDTO_1id.setExtension(extension_6idTemp);
        java.lang.String uploadFile13mtemp = sampleDocumentosProxyid.uploadFile(com1jao1contentmanager1documentos1model1DocumentoDTO_1id);
if(uploadFile13mtemp == null){
%>
<%=uploadFile13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(uploadFile13mtemp));
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