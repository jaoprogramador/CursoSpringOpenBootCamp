package com.jao.ejb.msgServer;

import javax.ejb.Remote;

@Remote
public interface ExampleServerRemote {

	String getMngFromServer();

}
