package com.jao.ejb.documentos.invoquer;


import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jao.ejb.documentos.servive.DocumentoService;
import com.jao.ejb.documentos.servive.DocumentoServiceSessionBean;
import com.jao.ejb.documentos.servive.DocumentoServiceSessionBeanRemote;



public class MainEJBInvoker {
	public static void main(String[] args) {
		// Configurar las propiedades de conexión
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        props.put(Context.SECURITY_PRINCIPAL, "usuario1"); // Reemplazar con tu nombre de usuario
        props.put(Context.SECURITY_CREDENTIALS, "contrasenaa1"); // Reemplazar con tu contraseña

        try {
            // Crear el contexto inicial
            Context context = new InitialContext(props);

            // Realizar el lookup del EJB
            //String jndiName = "ejb/cargaDocumentos";
            //String jndiName = "ejb:/tu/aplicacion/NombreDelEJB!NombreDeInterfazRemota";
           String jndiName = "ejb:/19EJBSessionDocumentos/DocumentoServiceSessionBean!DocumentoServiceSessionBeanRemote";
            // Reemplazar "tu/aplicacion/NombreDelEJB!NombreDeInterfazRemota" con el JNDI correspondiente
            DocumentoServiceSessionBeanRemote ejb = (DocumentoServiceSessionBeanRemote) context.lookup(jndiName);

            // Realizar llamadas a métodos del EJB
            // ejb.metodo1();
            // ejb.metodo2();
            ejb.buscarDocumentosDeHoy();

            // Cerrar el contexto
            context.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
	
	public static void main4(String[] args) {
        try {
		     // Configurar las propiedades para el contexto de JNDI
		     Properties props = new Properties();
		     props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		     props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

		     // Crear el contexto inicial de JNDI
		     Context context = new InitialContext(props);

		     // Realizar el lookup del EJB de sesión
		     //DocumentoServiceSessionBean documentoService = (DocumentoServiceSessionBean) context.lookup("java:global/19EJBSessionDocumentos/DocumentoServiceSessionBean!com.jao.ejb.documentos.servive.DocumentoServiceSessionBean");
		     DocumentoServiceSessionBean documentoService = (DocumentoServiceSessionBean) context.lookup("ejb/cargaDocumentos");
		     
		     // Usa el EJB de sesión
		     // documentoService.metodo();

		     // Cerrar el contexto inicial de JNDI
		     context.close();
		 } catch (NamingException e) {
		     e.printStackTrace();
		 }
    }
	
	//EJEMPLO https://www.youtube.com/watch?v=W8Rt-mUltWQ
	public static void main2(String[] args) {
        try {
        	//Metodo 1 no tira
        	//=================
        	// Obtener el contexto de JNDI
           /* Context context = new InitialContext();
            DocumentoServiceSessionRemote remote = (DocumentoServiceSessionRemote) context.lookup("ejb/cargaDocumentos");
            remote.buscarDocumentosDeHoy();*/
        	
        	//Metodo 2 no tira
            // Inicializar el contenedor EJB
            /*EJBContainer container = EJBContainer.createEJBContainer();

            // Obtener el contexto de JNDI
            Context context = container.getContext();

            // Obtener una referencia al EJB de sesión
            DocumentoServiceSession mySessionBean = (DocumentoServiceSession) context.lookup("java:global/19EJBSessionDocumentos/DocumentoService");//
            //DocumentoServiceSession mySessionBean = (DocumentoServiceSession) context.lookup("cargaDocumentos");//
            //MySessionBean mySessionBean = (MySessionBean) context.lookup("java:global/my-quarkus-project/MySessionBean");

            // Llamar a un método del EJB de sesión
            mySessionBean.buscarDocumentosDeHoy();*/
            System.out.println("Resultado del EJB de sesión: ");
            /*String result = mySessionBean.toString();
            String result = mySessionBean.buscarDocumentosDeHoy()
            System.out.println("Resultado del EJB de sesión: " + result);*/

            // Cerrar el contenedor EJB
            //container.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
