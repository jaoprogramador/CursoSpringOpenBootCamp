package com.jao.spring.ejemplo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "discos")
public class Disco {

    
	// atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Integer numCanciones;
    private Double precio;
    private Integer anioLanzamiento;
    
    public Disco() {
		
	}
	public Disco(Long id, String titulo, String autor, Integer numCanciones, Double precio, Integer anioLanzamiento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.numCanciones = numCanciones;
		this.precio = precio;
		this.anioLanzamiento = anioLanzamiento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getNumCanciones() {
		return numCanciones;
	}
	public void setNumCanciones(Integer numCanciones) {
		this.numCanciones = numCanciones;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getAnioLanzamiento() {
		return anioLanzamiento;
	}
	public void setAnioLanzamiento(Integer anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}
	@Override
	public String toString() {
		return "Disco [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", numCanciones=" + numCanciones
				+ ", precio=" + precio + ", anioLanzamiento=" + anioLanzamiento + "]";
	} 
    

    // constructores

   

}
