package com.jao.log.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/




public class TestLogg {
	private static final Logger logger = LogManager.getLogger(TestLogg.class);
	
	public static void main(String[] args) {		

		
		// TODO Auto-generated method stub
		logger.info("TestLogg INI:::TestLogg.iniciar---> ");
        logger.info("====================================================================");
        
        logger.info("TestLogg INI:::TestLogg.linea--->15 ");
        logger.info("TestLogg INI:::TestLogg.linea--->16 ");
        
        //logger.error("TestLogg INI:::TestLogg.linea--->23 ");
        //logger.warn("TestLogg INI:::TestLogg.linea--->24 ");
        
        logger.debug("TestLogg INI:::TestLogg.linea--->26 ");
        logger.info("TestLogg INI:::TestLogg.linea--->25 ");
        
        
        
        logger.info("TestLogg FIN:::TestLogg.fin---> ");
        logger.info("====================================================================");

	}
	

}
