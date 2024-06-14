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



//Implementacion concreta para almacenar documentos de tipo imagen
@Stateless
public class ImagenStorageStrategy implements DocumentoStorageStrategy {
 /*
  //version 1
 public void almacenarDocumento(DocumentoDTO documento,EntityManager entityManager) {
     // Logica para almacenar imagen en tabla de imogenes y subirla al gestor documental
	 entityManager.persist(DocumentoMapper.convertToEntityTypeImg(documento));	 
 }
 //version 2
	@Override
	 public void almacenarDocumento(DocumentoDTO documento, EntityManager entityManager) {
	     EntityTransaction transaction = null;
	     try {
	         transaction = entityManager.getTransaction();
	         transaction.begin();
	         
	         DocumentoImg documentoImg = DocumentoMapper.convertToEntityTypeImg(documento);
	         
	         if (entityManager.contains(documentoImg)) {
	             entityManager.merge(documentoImg); // Si ya esto en el contexto de persistencia, usa merge
	         } else {
	             entityManager.persist(documentoImg); // Si no esto en el contexto de persistencia, usa persist
	         }
	         
	         transaction.commit();
	     } catch (Exception e) {
	         if (transaction != null && transaction.isActive()) {
	             transaction.rollback();
	         }
	         e.printStackTrace(); // Manejo adecuado de la excepcion, esto puede variar segon tu aplicacion
	     }
	 }	*/
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void almacenarDocumento(DocumentoDTO documento, EntityManager entityManager) {
        try {
        	System.out.println("EJB:::STRATEGY IMG");
            System.out.println("=================================================================================================================");
            DocumentoImg documentoImg = DocumentoMapper.convertToEntityTypeImg(documento);
            entityManager.merge(documentoImg);
            System.out.println("EJB:::STRATEGY IMGEN ACTUALIZADA::: "+documento.getNombre());
            //uso merge porque me daba este error:javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist: com.jao.ejb.documentos.entitys.DocumentoDoc
            //entityManager.persist(documentoDoc);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo adecuado de la excepcion, esto puede variar segon tu aplicacion
        }
    }
	
}