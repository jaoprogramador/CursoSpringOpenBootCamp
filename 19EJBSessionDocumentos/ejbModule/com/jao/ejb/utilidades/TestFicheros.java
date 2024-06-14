package com.jao.ejb.utilidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jao.ejb.documentos.entitys.Documento;

public class TestFicheros {
	// EntityManagerFactory se crea una vez por aplicacion
    //private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jaoPersistDocumentos");
	@PersistenceContext
	private EntityManager entityManager;
    public static void main(String[] args) {
    	TestFicheros app = new TestFicheros();
        app.mostrarBytesDocumentosDeHoy();
    }

    private void mostrarBytesDocumentosDeHoy() {
        List<Documento> documentosDeHoy = buscarDocumentosDeHoy();
        for (Documento documento : documentosDeHoy) {
            //byte[] bytesDocumento = obtenerBytesDesdeDocumento(documento);
        	byte[] bytesDocumento = documento.getContenido();
            System.out.println("Bytes del documento " + documento.getId() + ": " + bytesDocumento);
        }
    }

    
	public List<Documento> buscarDocumentosDeHoy() {
        TypedQuery<Documento> query = entityManager.createNamedQuery("Documento.findByTodayDate", Documento.class);
        return query.getResultList();
    };
    

   /* private byte[] obtenerBytesDesdeDocumento(Documento documento) {
        // Aquo deberoas implementar la logica para obtener los bytes del documento.
        // Puede ser leer el archivo correspondiente si el contenido esto en un archivo,
        // o cualquier otra fuente de datos de bytes segon la estructura de tu aplicacion.
        // Por ahora, simplemente devolveremos una cadena de bytes fija.
        return "Bytes del documento " + documento.getNombre() + ". Esto es solo un ejemplo.".getBytes();
    }*/

   
	
	
	

}
