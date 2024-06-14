package com.jao.ejb.client;

import java.util.Date;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jao.ejb.documentos.servive.DocumentoServiceSessionBean;
import com.jao.ejb.documentos.servive.DocumentoServiceSessionBeanRemote;


public class TestDocumentosEJBClienteEAR {
	public static void main(String[] args) {
		Context context;
        try {
            Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
            properties.put("jboss.naming.client.ejb.context", true);
            context = new InitialContext(properties);

            String appName = "";
            String moduleName = "19EJBSessionDocumentos";
            String distinctName = "";
            String beanName = DocumentoServiceSessionBean.class.getSimpleName();
            String viewClassName = DocumentoServiceSessionBeanRemote.class.getName();

            String ejbString = "ejb:19EJBSessionDocumentosEAR/19EJBSessionDocumentos/DocumentoServiceSessionBean!com.jao.ejb.documentos.servive.DocumentoServiceSessionBeanRemote";

            System.out.println(ejbString);

            DocumentoServiceSessionBeanRemote remote = (DocumentoServiceSessionBeanRemote) context.lookup(ejbString);
            String res = "Nom Documentos insertados a " + new Date() + "---->"+remote.insertarDocumentos();
            //System.out.println("Nom Documentos insertados a " + new Date() + "---->");
            System.out.println(res);

        } catch (NamingException e) {
            e.printStackTrace();
        }

	}
}
