package com.jao.ejb.client;


import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jao.ejb.msgServer.ExampleServer;
import com.jao.ejb.msgServer.ExampleServerRemote;
public class TestEAR {

	public static void main(String[] args) {
		Context context;
        try {
            Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
            properties.put("jboss.naming.client.ejb.context", true);
            context = new InitialContext(properties);

            String appName = "";
            String moduleName = "MsgFromServerEJB";
            String distinctName = "";
            String beanName = ExampleServer.class.getSimpleName();
            String viewClassName = ExampleServerRemote.class.getName();

            String ejbString = "ejb:MsgFromServerEAR/MsgFromServerEJB/ExampleServer!com.jao.ejb.msgServer.ExampleServerRemote";
            //desde cliente sin estar en el contenedor de EJB wildfly
            //=========================================================
            //java:global/MsgFromServerEAR/MsgFromServerEJB/ExampleServer!com.jao.ejb.msgServer.ExampleServer
            //
            System.out.println("TestEAR::llamada desde cliente al EAR-EJB:::"+ejbString);

            ExampleServerRemote remote = (ExampleServerRemote) context.lookup(ejbString);
            System.out.println(remote.getMngFromServer());

        } catch (NamingException e) {
            e.printStackTrace();
        }

	}

}
