/**
 * Documentos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jao.contentmanager.documentos.service;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jao.contentmanager.documentos.model.DocumentoDTO;

@WebService
public class Documentos {
	private static final Logger logger = LogManager.getLogger(Documentos.class);
	@WebMethod
    public String uploadFile(DocumentoDTO documento) {
		logger.info("SWSOAP INI:::::carga de documentos");
		logger.info("=================================");
        try {
        	String filePath = "C:\\Users\\Guillermo\\ContentManager\\imagenes\\" + documento.getNombre();
        	if(documento.getTipo().equals("doc")){
        		filePath = "C:\\Users\\Guillermo\\ContentManager\\words\\" + documento.getNombre();
        	}else{
        		filePath = "C:\\Users\\Guillermo\\ContentManager\\restoDocs\\" + documento.getNombre();        		
        	}
            
            

            // Crear un flujo de salida para escribir el archivo en disco
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(documento.getContenido());
            fos.close();
            logger.info("SWSOAP FIN:::::carga de documento "+documento.getNombre());
            logger.info("=================================");
            return "Archivo guardado exitosamente en: " + filePath;
        } catch (IOException e) {
        	logger.error("SWSOAP ERROR:::::carga de documentos"+e.getMessage());
        	logger.error("=====================================================");
            e.printStackTrace();
            return "Error al guardar el archivo: " + e.getMessage();
        }
    }
	
}
