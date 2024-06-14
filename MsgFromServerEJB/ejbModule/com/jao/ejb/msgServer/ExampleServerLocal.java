package com.jao.ejb.msgServer;

import javax.ejb.Local;

@Local
public interface ExampleServerLocal {
	public String getMngFromServer ();

}
