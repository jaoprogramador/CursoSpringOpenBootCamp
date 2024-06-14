package com.jao.ejb.msgServer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ExampleServer
 */
@Stateless
@LocalBean
public class ExampleServer implements ExampleServerRemote, ExampleServerLocal {

    /**
     * Default constructor. 
     */
    public ExampleServer() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public String getMngFromServer (){
    	return "JAO:::: Buenas tardes!!!!:)";
    }
}
