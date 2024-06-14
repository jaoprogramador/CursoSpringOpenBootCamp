package com.jao.ejb.documentos.servive;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jao.contentmanager.documentos.service.Documentos;
import com.jao.ejb.documentos.entitys.Documento;
//import com.jao.ejb.documentos.modelDTO.DocumentoDTO;
import com.jao.ejb.documentos.storageStratregy.DocumentoStorageFactory;
import com.jao.ejb.documentos.storageStratregy.DocumentoStorageStrategy;
import com.jao.ejb.utilidades.DocumentoMapper;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Session Bean implementation class DocumentoService
 */
//EJB de sesion para la logica de negocio
@Stateless
public class DocumentoService {
	private static final Logger logger = LogManager.getLogger(Documentos.class);
	@PersistenceContext
	private EntityManager entityManager;

	public int procesarDocumento(Documento documento1) {//9:30-11
	     // Logica para consultar la tabla de BD usando Hibernate y determinar el tipo de documento
		 int numActualizaciones=0;
		try{
		 	/*
			  * 1.- Consultamos los documentos del doa actual
			  * ===============================================
			  * */
		 
			 List<Documento> docusATratar = this.buscarDocumentosDeHoy();
				 /*
				  * 2.- Aplicamos un patron Strategy para almacenarlos en la tabla correspondiente en funcion de si es DOC o IMG
				  * */
			 for (Documento documento : docusATratar) {
				 
				// Obtener la estrategia de almacenamiento adecuada
			     DocumentoStorageStrategy estrategia = DocumentoStorageFactory.crearEstrategia(DocumentoMapper.convertToDtoDocumentos(documento).getTipo());
		
			     // Almacenar el documento usando la estrategia adecuada
			     estrategia.almacenarDocumento(DocumentoMapper.convertToDtoDocumentos(documento), entityManager);
			     
			     /*
			      * 3.- llamamos al SW para subir los documentos al servidor
			      * ========================================================
			      * */
			  // URL del servicio web SOAP 19ContentManagerSOAP/services/Documentos?wsdl
		         URL url = new URL("http://localhost:8089/19ContentManagerSOAP/Documentos?wsdl");
		
		         // Nombre del servicio web SOAP y su namespace
		         QName qname = new QName("http://service.documentos.contentmanager.jao.com/", "Documentos");
		
		         // Crear una conexion al servicio web SOAP
		         Service service = Service.create(url, qname);
		
		         // Obtener el puerto del servicio web SOAP
		         Documentos port = service.getPort(Documentos.class);
		
		         // Llamar al motodo del servicio web SOAP         
		         String response = port.uploadFile(DocumentoMapper.convertToDtoDocumentosSW(documento));
		
			     // Otras operaciones necesarias, como actualizar la BD con informacion del documento procesado
			     numActualizaciones++;
			}
		} catch (MalformedURLException e) {
	        e.printStackTrace();
	        System.out.print("Error al llamar al servicio web SOAP: " + e.getMessage());
	        return numActualizaciones;
	    } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Error al llamar al servicio web SOAP: " + e.getMessage());
	        return numActualizaciones;
		}
	
		 return numActualizaciones;

     
 }
 public List<Documento> buscarDocumentosDeHoy() {
     TypedQuery<Documento> query = entityManager.createNamedQuery("DocumentoDTO.findByTodayDate", Documento.class);
     return query.getResultList();
 }

}
