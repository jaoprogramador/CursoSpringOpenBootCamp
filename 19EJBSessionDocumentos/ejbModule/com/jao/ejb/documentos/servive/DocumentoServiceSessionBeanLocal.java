package com.jao.ejb.documentos.servive;

import java.util.List;

import javax.ejb.Local;

import com.jao.ejb.documentos.entitys.Documento;

@Local
public interface DocumentoServiceSessionBeanLocal {
	public int insertarDocumentos();
	public List<Documento> buscarDocumentosDeHoy();
}
