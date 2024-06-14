package com.jao.ws.soap.validardni.service;

public class ValidarDNIWSProxy implements com.jao.ws.soap.validardni.service.ValidarDNIWS {
  private String _endpoint = null;
  private com.jao.ws.soap.validardni.service.ValidarDNIWS validarDNIWS = null;
  
  public ValidarDNIWSProxy() {
    _initValidarDNIWSProxy();
  }
  
  public ValidarDNIWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initValidarDNIWSProxy();
  }
  
  private void _initValidarDNIWSProxy() {
    try {
      validarDNIWS = (new com.jao.ws.soap.validardni.service.ValidarDNIWSServiceLocator()).getValidarDNIWS();
      if (validarDNIWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)validarDNIWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)validarDNIWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (validarDNIWS != null)
      ((javax.xml.rpc.Stub)validarDNIWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.jao.ws.soap.validardni.service.ValidarDNIWS getValidarDNIWS() {
    if (validarDNIWS == null)
      _initValidarDNIWSProxy();
    return validarDNIWS;
  }
  
  public java.lang.Object validarDNI(java.lang.String numeroDNI) throws java.rmi.RemoteException{
    if (validarDNIWS == null)
      _initValidarDNIWSProxy();
    return validarDNIWS.validarDNI(numeroDNI);
  }
  
  public boolean valDNI(java.lang.String dni) throws java.rmi.RemoteException{
    if (validarDNIWS == null)
      _initValidarDNIWSProxy();
    return validarDNIWS.valDNI(dni);
  }
  
  
}