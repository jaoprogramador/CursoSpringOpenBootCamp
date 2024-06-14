/**
 * ValDNIResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jao.ws.soap.validardni.service;

public class ValDNIResponse  implements java.io.Serializable {
    private boolean valDNIReturn;

    public ValDNIResponse() {
    }

    public ValDNIResponse(
           boolean valDNIReturn) {
           this.valDNIReturn = valDNIReturn;
    }


    /**
     * Gets the valDNIReturn value for this ValDNIResponse.
     * 
     * @return valDNIReturn
     */
    public boolean isValDNIReturn() {
        return valDNIReturn;
    }


    /**
     * Sets the valDNIReturn value for this ValDNIResponse.
     * 
     * @param valDNIReturn
     */
    public void setValDNIReturn(boolean valDNIReturn) {
        this.valDNIReturn = valDNIReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValDNIResponse)) return false;
        ValDNIResponse other = (ValDNIResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.valDNIReturn == other.isValDNIReturn();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isValDNIReturn() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValDNIResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.validardni.soap.ws.jao.com", ">valDNIResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valDNIReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.validardni.soap.ws.jao.com", "valDNIReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
