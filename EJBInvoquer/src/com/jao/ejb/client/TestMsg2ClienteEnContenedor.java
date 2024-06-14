package com.jao.ejb.client;

import javax.ejb.EJB;

import com.jao.ejb.msgServer.ExampleServerLocal;
import com.jao.ejb.msgServer.ExampleServerRemote;

public class TestMsg2ClienteEnContenedor {
	@EJB
	private ExampleServerLocal exampleServer;
	//private ExampleServerRemote exampleServerRemote;
	
	public static void main(String[] args) {
		System.out.println("MAIN @EJB 2.0");
		TestMsg2ClienteEnContenedor main= new TestMsg2ClienteEnContenedor();
		
		System.out.print("TestMsg2ClienteEnContenedor desde contenedor:::"+main.doSomethingWithEJB());
		
	}
	public String doSomethingWithEJB(){
		return exampleServer.getMngFromServer();
	}
}
