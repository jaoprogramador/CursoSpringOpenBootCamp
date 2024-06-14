package com.jao.ejb.client;

import java.util.Properties;


import javax.naming.*;
import javax.naming.NamingException;
import java.util.*;
import com.jao.ejb.msgServer.ExampleServer;
import com.jao.ejb.msgServer.ExampleServerRemote;

public class ClientApp {

	public static void main(String[] args) {
		
		
		
		
		
		// TODO Auto-generated method stub
		System.out.println("Client App Started");
		System.out.println("===================");
		try {
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	        System.setProperty(Context.PROVIDER_URL, "http-remoting://localhost:8080"); // URL del servidor de WildFly

	        // Crea el contexto inicial
	        Context context = new InitialContext();

	        // Busca el EJB utilizando el nombre JNDI adecuado
	        ExampleServerRemote ejb = (ExampleServerRemote) context.lookup("ejb:/MsgFromServerEJB/ExampleServerImpl!com.jao.ejb.msgServer.ExampleServerRemote");

	        // Ahora puedes usar el EJB como lo desees
	        // Por ejemplo, llamar a un método del EJB
	        String msn = ejb.getMngFromServer();
	        System.out.println("CLIENTE::::::"+msn);

			/*Properties props = new Properties();
			props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
			
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	        InitialContext context = new InitialContext(props);
			
			String appName = "";        	 
	        String moduleName = "MsgFromServerEJB";
	        String distinctName = "";        	 
	        String beanName = ExampleServer.class.getSimpleName();        	 
	        String interfaceName = ExampleServerRemote.class.getName();
	        String name = "ejb:" + appName + "/" + moduleName + "/" +  distinctName    + "/" + beanName + "!" + interfaceName;
	        //String name = "ejb:" + appName + "/" + moduleName + "/" +  distinctName    + "/" + beanName + "!" + interfaceName;
	        //String name = "ejb:MsgFromServerEJB/ExampleServer!com.jao.ejb.msgServer.ExampleServer";
	        //String name = "ejb:MsgFromServerEJB/ExampleServer!com.jao.ejb.msgServer.ExampleServerRemote";
	        //String name = "ejb:MsgFromServerEJB/ExampleServer!com.jao.ejb.msgServer.ExampleServer";
	        //String name = "ejb:MsgFromServerEJB/ExampleServer!com.jao.ejb.msgServer.ExampleServerLocal";
			System.out.println(name);
			System.out.println("===================");
			System.out.println("===LLAMADA EJB ====");
			//ExampleServerRemote bean = (ExampleServerRemote) context.lookup("ejb:MsgFromServerEJB//ExampleServer!com.jao.ejb.msgServer.ExampleServerRemote");
			ExampleServerRemote bean = (ExampleServerRemote) context.lookup("java:global/MsgFromServerEJB/ExampleServerImpl!com.jao.ejb.msgServer.ExampleServerRemote");
			String mensaje =bean.getMngFromServer();
			System.out.println("===================");
			System.out.println("====RESPUESTA======");
			System.out.println(mensaje);*/
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
