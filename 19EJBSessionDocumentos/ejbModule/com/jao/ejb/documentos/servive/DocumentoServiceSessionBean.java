package com.jao.ejb.documentos.servive;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

//import javax.xml.ws.Service;

import org.modelmapper.ModelMapper;

//import com.jao.ejb.documentos.modelDTO.DocumentoDTO;
import com.jao.contentmanager.documentos.model.DocumentoDTO;
import com.jao.ejb.documentos.entitys.Documento;
import com.jao.ejb.documentos.storageStratregy.DocumentoStorageFactory;
import com.jao.ejb.documentos.storageStratregy.DocumentoStorageStrategy;





/**
 * Session Bean implementation class DocumentoServiceSessionBean
 */
@Stateless(name="DocumentoServiceSessionBean" ,mappedName = "ejb/cargaDocumentos")
public class DocumentoServiceSessionBean implements DocumentoServiceSessionBeanLocal, DocumentoServiceSessionBeanRemote {

	private static final Logger logger = LogManager.getLogger(DocumentoServiceSessionBean.class);
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public DocumentoServiceSessionBean() {
    	// Constructor por defecto
    }
    /*@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
     * Esto indica que cada llamada al motodo debe ejecutarse en una nueva transaccion. El contenedor de aplicaciones manejaro automoticamente la creacion y gestion de la transaccion para ti.(non-Javadoc)
     * @see com.jao.ejb.documentos.servive.DocumentoServiceSessionBeanLocal#insertarDocumentos()
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int insertarDocumentos() {
        int numActualizaciones = 0;
        //System.out.println("EJB INI:::DocumentoServiceSessionBean.insertarDocumentos---> ");
        //System.out.println("====================================================================");
        logger.info("EJB INI:::DocumentoServiceSessionBean.insertarDocumentos---> ");
        logger.info("====================================================================");
        try {
            List<Documento> docusListEnt = this.buscarDocumentosDeHoy();
            
            for (Documento documento : docusListEnt) {
                ModelMapper modelMapper = new ModelMapper();
                DocumentoDTO documDTO = modelMapper.map(documento, DocumentoDTO.class);

                DocumentoStorageStrategy estrategia = DocumentoStorageFactory.crearEstrategia(documDTO.getTipo());
                estrategia.almacenarDocumento(documDTO, entityManager);
                
                /*
   		      * 3.- llamamos al SW para subir los documentos al servidor
   		      * ========================================================
   		      * */
                //System.out.println("EJB INI:::DocumentoServiceSessionBean.insertarDocumentos---> llamamos al SW SOAP GestorDocumental");
                //System.out.println("=================================================================================================");
                logger.info("EJB INI:::DocumentoServiceSessionBean.insertarDocumentos---> llamamos al SW SOAP GestorDocumental");
                logger.info("=================================================================================================");
                //MODO DOS:
                //===========
                String endpoint = "http://localhost:8089/19ContentManagerSOAP/services/Documentos";
                Service service = new Service();
                Call call = (Call) service.createCall();
                call.setTargetEndpointAddress(new java.net.URL(endpoint));
                call.setOperationName(new QName("http://service.documentos.contentmanager.jao.com", "uploadFile"));
                
                QName soapElementName = new QName("http://service.documentos.contentmanager.jao.com", "documento");
                
                 call.addParameter("documento", new QName("http://model.documentos.contentmanager.jao.com", "DocumentoDTO"), DocumentoDTO.class, javax.xml.rpc.ParameterMode.IN);
                // Llamar al servicio web
                 Object[] params = new Object[]{documDTO};
                 String result = (String) call.invoke(params);

                // Manejar la respuesta
                 System.out.println("Resultado: " + result);

                
                
	   		  	// URL del servicio web SOAP 19ContentManagerSOAP/services/Documentos?wsdl
	   	         //URL url = new URL("http://localhost:8089/19ContentManagerSOAP/Documentos?wsdl");
                //URL url = new URL("http://localhost:8089/19ContentManagerSOAP/services/Documentos?wsdl");
                
                //MODO UNO ERROR:
                //================
                //javax.xml.ws.WebServiceException: org.apache.cxf.service.factory.ServiceConstructionException: Failed to create service.
                
                /*URL url = new URL("http://localhost:8089/19ContentManagerSOAP/services/Documentos");
	   	
	   	         // Nombre del servicio web SOAP y su namespace
	   	         QName qname = new QName("http://service.documentos.contentmanager.jao.com/", "Documentos");
	   	
	   	         // Crear una conexion al servicio web SOAP
	   	         Service service = Service.create(url, qname);
	   	
	   	         // Obtener el puerto del servicio web SOAP
	   	         Documentos port = service.getPort(Documentos.class);
	   	
	   	         // Llamar al motodo del servicio web SOAP         
	   	         String response = port.uploadFile(DocumentoMapper.convertToDtoDocumentosSW(documento));*/
	   	
	   		     // Otras operaciones necesarias, como actualizar la BD con informacion del documento procesado

                numActualizaciones++;
            }

        } catch (Exception e) {
        	
            //e.printStackTrace(); // Manejo adecuado de la excepcion, esto puede variar segon tu aplicacion
            logger.error("EJB ERROR:::DocumentoServiceSessionBean.insertarDocumentos"+e.getMessage());
            
        }
        
        logger.info("EJB FIN:::DocumentoServiceSessionBean.insertarDocumentos---> se han cargado "+numActualizaciones+" ficheros en total");
        logger.info("=================================================================================================================");
        
        return numActualizaciones;
    }

    
    public List<Documento> buscarDocumentosDeHoy() {
        TypedQuery<Documento> query = entityManager.createNamedQuery("Documento.findByTodayDate", Documento.class);
        System.out.println("DocumentoServiceSessionBean.buscarDocumentosDeHoy---> "+query.getResultList().size() +" documentos de hoy a cargar");
        System.out.println("===============================================================================");
        return query.getResultList();
    }
    

}
