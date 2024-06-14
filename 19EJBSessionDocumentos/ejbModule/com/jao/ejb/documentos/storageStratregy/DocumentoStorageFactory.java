package com.jao.ejb.documentos.storageStratregy;

//Fobrica para crear instancias de las estrategias de almacenamiento de documentos
public class DocumentoStorageFactory {
 public static DocumentoStorageStrategy crearEstrategia(String tipoDocumento) {
     if (tipoDocumento.equalsIgnoreCase("imagen")) {
         return new ImagenStorageStrategy();
     } else if (tipoDocumento.equalsIgnoreCase("doc")) {
         return new DocStorageStrategy();
     } else {
    	 return new RestNoStorageStrategy();
     }
 }
}
