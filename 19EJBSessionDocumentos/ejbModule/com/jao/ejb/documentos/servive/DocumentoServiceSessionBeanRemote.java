package com.jao.ejb.documentos.servive;

import java.util.List;

import javax.ejb.Remote;

import com.jao.ejb.documentos.entitys.Documento;

@Remote
public interface DocumentoServiceSessionBeanRemote {
	public int insertarDocumentos();
	public List<Documento> buscarDocumentosDeHoy();
}
