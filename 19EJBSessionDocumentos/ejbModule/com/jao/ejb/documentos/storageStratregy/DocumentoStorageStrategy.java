package com.jao.ejb.documentos.storageStratregy;

import javax.persistence.EntityManager;

//import com.jao.ejb.documentos.modelDTO.DocumentoDTO;
import com.jao.contentmanager.documentos.model.DocumentoDTO;


//Interfaz para la estrategia de almacenamiento de documentos
public interface DocumentoStorageStrategy {
 void almacenarDocumento(DocumentoDTO documento, EntityManager entityManager);
}
