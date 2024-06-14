package com.jao.contentmanager.documentos.service;

public class DocumentosProxy implements com.jao.contentmanager.documentos.service.Documentos {
  private String _endpoint = null;
  private com.jao.contentmanager.documentos.service.Documentos documentos = null;
  
  public DocumentosProxy() {
    _initDocumentosProxy();
  }
  
  public DocumentosProxy(String endpoint) {
    _endpoint = endpoint;
    _initDocumentosProxy();
  }
  
  private void _initDocumentosProxy() {
    try {
      documentos = (new com.jao.contentmanager.documentos.service.DocumentosServiceLocator()).getDocumentos();
      if (documentos != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)documentos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)documentos)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (documentos != null)
      ((javax.xml.rpc.Stub)documentos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.jao.contentmanager.documentos.service.Documentos getDocumentos() {
    if (documentos == null)
      _initDocumentosProxy();
    return documentos;
  }
  
  public java.lang.String uploadFile(com.jao.contentmanager.documentos.model.DocumentoDTO documento) throws java.rmi.RemoteException{
    if (documentos == null)
      _initDocumentosProxy();
    return documentos.uploadFile(documento);
  }
  
  
}