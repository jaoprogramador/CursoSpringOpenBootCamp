/**
 * ValidarDNIWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jao.ws.soap.validardni.service;

public class ValidarDNIWSServiceLocator extends org.apache.axis.client.Service implements com.jao.ws.soap.validardni.service.ValidarDNIWSService {

    public ValidarDNIWSServiceLocator() {
    }


    public ValidarDNIWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ValidarDNIWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ValidarDNIWS
    private java.lang.String ValidarDNIWS_address = "http://localhost:10931/17ValidaDNIWSSOAP/services/ValidarDNIWS";

    public java.lang.String getValidarDNIWSAddress() {
        return ValidarDNIWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ValidarDNIWSWSDDServiceName = "ValidarDNIWS";

    public java.lang.String getValidarDNIWSWSDDServiceName() {
        return ValidarDNIWSWSDDServiceName;
    }

    public void setValidarDNIWSWSDDServiceName(java.lang.String name) {
        ValidarDNIWSWSDDServiceName = name;
    }

    public com.jao.ws.soap.validardni.service.ValidarDNIWS getValidarDNIWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ValidarDNIWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getValidarDNIWS(endpoint);
    }

    public com.jao.ws.soap.validardni.service.ValidarDNIWS getValidarDNIWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.jao.ws.soap.validardni.service.ValidarDNIWSSoapBindingStub _stub = new com.jao.ws.soap.validardni.service.ValidarDNIWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getValidarDNIWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setValidarDNIWSEndpointAddress(java.lang.String address) {
        ValidarDNIWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.jao.ws.soap.validardni.service.ValidarDNIWS.class.isAssignableFrom(serviceEndpointInterface)) {
                com.jao.ws.soap.validardni.service.ValidarDNIWSSoapBindingStub _stub = new com.jao.ws.soap.validardni.service.ValidarDNIWSSoapBindingStub(new java.net.URL(ValidarDNIWS_address), this);
                _stub.setPortName(getValidarDNIWSWSDDServiceName());
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
        if ("ValidarDNIWS".equals(inputPortName)) {
            return getValidarDNIWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.validardni.soap.ws.jao.com", "ValidarDNIWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.validardni.soap.ws.jao.com", "ValidarDNIWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ValidarDNIWS".equals(portName)) {
            setValidarDNIWSEndpointAddress(address);
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
