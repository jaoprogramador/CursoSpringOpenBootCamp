package com.jao.ejb.documentos.entitys;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Lob;
//import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Documento")
@NamedQuery(
	    name = "Documento.findByTodayDate",
	    query = "SELECT d FROM Documento d WHERE d.fecha_creacion >= CURRENT_DATE AND d.fecha_creacion < CURRENT_DATE + 1"
	)
/*
@NamedNativeQuery(
	    name = "DocumentoDTO.findByTodayDate",
	    query = "SELECT * FROM DocumentoDTO WHERE fecha_creacion >= CURRENT_DATE AND fecha_creacion < CURRENT_DATE + INTERVAL '1 day'",
	    resultClass = DocumentoDTO.class
	)*/
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    Date fecha_creacion;

    

	//@Lob
    private byte[] contenido;

    // Getters y Setters
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

	public byte[] getContenido() {
		return contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
}

