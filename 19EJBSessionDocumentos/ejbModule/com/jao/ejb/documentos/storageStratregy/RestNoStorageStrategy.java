package com.jao.ejb.documentos.storageStratregy;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

import com.jao.contentmanager.documentos.model.DocumentoDTO;

public class RestNoStorageStrategy implements DocumentoStorageStrategy {
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void almacenarDocumento(DocumentoDTO documento, EntityManager entityManager) {

        	System.out.println("EJB:::STRATEGY RESTO DOCUMENTOS NO ALMACENABLES POR FORMATO INCORRECTO");
            System.out.println("=================================================================================================================");
            /*DocumentoImg documentoImg = DocumentoMapper.convertToEntityTypeImg(documento);
            entityManager.merge(documentoImg);*/
            System.out.println("EJB:::STRATEGY RESTO NO ACTUALIZADA::: "+documento.getNombre());


    }
}
