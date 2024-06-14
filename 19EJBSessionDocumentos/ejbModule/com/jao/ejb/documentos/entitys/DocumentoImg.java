package com.jao.ejb.documentos.entitys;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Lob;
//import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_DocumentoImg")
public class DocumentoImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;

    //@Lob
    private byte[] contenido;
    
    private Date fecha_creacion;

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

	public byte[] getContenido() {
		return contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
}
