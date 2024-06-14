/**
 * DocumentosServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jao.contentmanager.documentos.service;

public class DocumentosServiceLocator extends org.apache.axis.client.Service implements com.jao.contentmanager.documentos.service.DocumentosService {

    public DocumentosServiceLocator() {
    }


    public DocumentosServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DocumentosServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Documentos
    private java.lang.String Documentos_address = "http://localhost:10931/19ContentManagerSOAP/services/Documentos";

    public java.lang.String getDocumentosAddress() {
        return Documentos_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DocumentosWSDDServiceName = "Documentos";

    public java.lang.String getDocumentosWSDDServiceName() {
        return DocumentosWSDDServiceName;
    }

    public void setDocumentosWSDDServiceName(java.lang.String name) {
        DocumentosWSDDServiceName = name;
    }

    public com.jao.contentmanager.documentos.service.Documentos getDocumentos() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Documentos_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDocumentos(endpoint);
    }

    public com.jao.contentmanager.documentos.service.Documentos getDocumentos(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.jao.contentmanager.documentos.service.DocumentosSoapBindingStub _stub = new com.jao.contentmanager.documentos.service.DocumentosSoapBindingStub(portAddress, this);
            _stub.setPortName(getDocumentosWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDocumentosEndpointAddress(java.lang.String address) {
        Documentos_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.jao.contentmanager.documentos.service.Documentos.class.isAssignableFrom(serviceEndpointInterface)) {
                com.jao.contentmanager.documentos.service.DocumentosSoapBindingStub _stub = new com.jao.contentmanager.documentos.service.DocumentosSoapBindingStub(new java.net.URL(Documentos_address), this);
                _stub.setPortName(getDocumentosWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Documentos".equals(inputPortName)) {
            return getDocumentos();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.documentos.contentmanager.jao.com", "DocumentosService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.documentos.contentmanager.jao.com", "Documentos"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Documentos".equals(portName)) {
            setDocumentosEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
