package com.jao.ejb.documentos.storageStratregy;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

import com.jao.ejb.documentos.entitys.DocumentoDoc;
import com.jao.ejb.documentos.entitys.DocumentoImg;
//import com.jao.ejb.documentos.modelDTO.DocumentoDTO;
import com.jao.contentmanager.documentos.model.DocumentoDTO;
import com.jao.ejb.utilidades.DocumentoMapper;



//Implementacion concreta para almacenar documentos de tipo doc
@Stateless
public class DocStorageStrategy implements DocumentoStorageStrategy {
	// Logica para almacenar documento doc en tabla de documentos doc y subirlo al gestor documental	 
		 /* ESTO DA ERROR 
		  * =============== 
		  * javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist: com.jao.ejb.documentos.entitys.DocumentoDoc
		 entityManager.persist(DocumentoMapper.convertToEntityTypeDoc(documento));	
		 CORRECCION:
		 
 @Override
 public void almacenarDocumento(DocumentoDTO documento,EntityManager entityManager) {
     
	 
	 
 }
 
 @Override
 public void almacenarDocumento(DocumentoDTO documento, EntityManager entityManager) {
     EntityTransaction transaction = null;
     try {
         transaction = entityManager.getTransaction();
         transaction.begin();
         
         DocumentoDoc documentoDoc = DocumentoMapper.convertToEntityTypeDoc(documento);
         
         if (entityManager.contains(documentoDoc)) {
             entityManager.merge(documentoDoc); // Si ya esto en el contexto de persistencia, usa merge
         } else {
             entityManager.persist(documentoDoc); // Si no esto en el contexto de persistencia, usa persist
         }
         
         transaction.commit();
     } catch (Exception e) {
         if (transaction != null && transaction.isActive()) {
             transaction.rollback();
         }
         e.printStackTrace(); // Manejo adecuado de la excepcion, esto puede variar segon tu aplicacion
     }
 }*/

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void almacenarDocumento(DocumentoDTO documento, EntityManager entityManager) {
        try {
        	System.out.println("EJB:::STRATEGY DOC");
            System.out.println("=================================================================================================================");                       
            DocumentoDoc documentoDoc = DocumentoMapper.convertToEntityTypeDoc(documento);
            entityManager.merge(documentoDoc);
            System.out.println("EJB:::STRATEGY DOC ACTUALIZADA::: "+documento.getNombre());
            //entityManager.persist(documentoDoc);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo adecuado de la excepcion, esto puede variar segon tu aplicacion
        }
    }
 
}
