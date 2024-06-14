package com.jao.contentmanager.documentos.model;

import java.io.Serializable;
import java.util.Date;

//Clase para representar un documento
public class DocumentoDTO implements Serializable{
	private Long id;
    private String nombre;
    private String tipo;
    Date fecha_creacion;
	private byte[] contenido;	
	private String extension;
	 // Getters y setters	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public byte[] getContenido() {
		return contenido;
	}
	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
 


 }
