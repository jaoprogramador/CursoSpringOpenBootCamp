package com.jao.ejb.utilidades;
import org.modelmapper.ModelMapper;

//import springfox.documentation.swagger2.mappers.ModelMapper;
/*
 * Clase que se encarga de mapear la clase DocumentoDTO Entity a DocumentoDTO TDO
 * */
public class DocumentoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static com.jao.contentmanager.documentos.model.DocumentoDTO convertToDtoDocumentos(com.jao.ejb.documentos.entitys.Documento documento) {
        return modelMapper.map(documento, com.jao.contentmanager.documentos.model.DocumentoDTO.class);
    }
    public static com.jao.contentmanager.documentos.model.DocumentoDTO convertToDtoDocumentosSW(com.jao.ejb.documentos.entitys.Documento documento) {
        return modelMapper.map(documento, com.jao.contentmanager.documentos.model.DocumentoDTO.class);
    }
    public static com.jao.ejb.documentos.entitys.Documento convertToEntityDocumentos(com.jao.contentmanager.documentos.model.DocumentoDTO documentoDto) {
        return modelMapper.map(documentoDto, com.jao.ejb.documentos.entitys.Documento.class);
    }
    /*
    public static com.jao.contentmanager.documentos.model.DocumentoDTO convertToDtoDoc(com.jao.ejb.documentos.entitys.Documento documento) {
        return modelMapper.map(documento, com.jao.contentmanager.documentos.model.DocumentoDTO.class);
    }*/

    public static com.jao.ejb.documentos.entitys.DocumentoDoc convertToEntityTypeDoc(com.jao.contentmanager.documentos.model.DocumentoDTO documentoDto) {
        return modelMapper.map(documentoDto, com.jao.ejb.documentos.entitys.DocumentoDoc.class);
    }
/*
    public static com.jao.contentmanager.documentos.model.DocumentoDTO convertToDtoImg(com.jao.ejb.documentos.entitys.Documento documento) {
        return modelMapper.map(documento, com.jao.contentmanager.documentos.model.DocumentoDTO.class);
    }*/

    public static com.jao.ejb.documentos.entitys.DocumentoImg convertToEntityTypeImg(com.jao.contentmanager.documentos.model.DocumentoDTO documentoDto) {
        return modelMapper.map(documentoDto, com.jao.ejb.documentos.entitys.DocumentoImg.class);
    }

}

