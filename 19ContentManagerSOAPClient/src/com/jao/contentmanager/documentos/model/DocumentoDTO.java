/**
 * DocumentoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jao.contentmanager.documentos.model;

public class DocumentoDTO  implements java.io.Serializable {
    private byte[] contenido;

    private java.lang.String extension;

    private java.util.Calendar fecha_creacion;

    private java.lang.Long id;

    private java.lang.String nombre;

    private java.lang.String tipo;

    public DocumentoDTO() {
    }

    public DocumentoDTO(
           byte[] contenido,
           java.lang.String extension,
           java.util.Calendar fecha_creacion,
           java.lang.Long id,
           java.lang.String nombre,
           java.lang.String tipo) {
           this.contenido = contenido;
           this.extension = extension;
           this.fecha_creacion = fecha_creacion;
           this.id = id;
           this.nombre = nombre;
           this.tipo = tipo;
    }


    /**
     * Gets the contenido value for this DocumentoDTO.
     * 
     * @return contenido
     */
    public byte[] getContenido() {
        return contenido;
    }


    /**
     * Sets the contenido value for this DocumentoDTO.
     * 
     * @param contenido
     */
    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }


    /**
     * Gets the extension value for this DocumentoDTO.
     * 
     * @return extension
     */
    public java.lang.String getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this DocumentoDTO.
     * 
     * @param extension
     */
    public void setExtension(java.lang.String extension) {
        this.extension = extension;
    }


    /**
     * Gets the fecha_creacion value for this DocumentoDTO.
     * 
     * @return fecha_creacion
     */
    public java.util.Calendar getFecha_creacion() {
        return fecha_creacion;
    }


    /**
     * Sets the fecha_creacion value for this DocumentoDTO.
     * 
     * @param fecha_creacion
     */
    public void setFecha_creacion(java.util.Calendar fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }


    /**
     * Gets the id value for this DocumentoDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this DocumentoDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the nombre value for this DocumentoDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DocumentoDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the tipo value for this DocumentoDTO.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this DocumentoDTO.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoDTO)) return false;
        DocumentoDTO other = (DocumentoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contenido==null && other.getContenido()==null) || 
             (this.contenido!=null &&
              java.util.Arrays.equals(this.contenido, other.getContenido()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension()))) &&
            ((this.fecha_creacion==null && other.getFecha_creacion()==null) || 
             (this.fecha_creacion!=null &&
              this.fecha_creacion.equals(other.getFecha_creacion()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo())));
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
        if (getContenido() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContenido());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContenido(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        if (getFecha_creacion() != null) {
            _hashCode += getFecha_creacion().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.documentos.contentmanager.jao.com", "DocumentoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.documentos.contentmanager.jao.com", "contenido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.documentos.contentmanager.jao.com", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_creacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.documentos.contentmanager.jao.com", "fecha_creacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.documentos.contentmanager.jao.com", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.documentos.contentmanager.jao.com", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.documentos.contentmanager.jao.com", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
