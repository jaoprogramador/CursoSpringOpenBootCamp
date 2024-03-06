package com.jao.spring.ejemplo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Empresa {
	// atributos encapsulados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nif;
    private String sector;
    private Integer numTrabajadores;
    private Integer anioFundacion;
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
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public Integer getNumTrabajadores() {
		return numTrabajadores;
	}
	public void setNumTrabajadores(Integer numTrabajadores) {
		this.numTrabajadores = numTrabajadores;
	}
	public Integer getAnioFundacion() {
		return anioFundacion;
	}
	public void setAnioFundacion(Integer anioFundacion) {
		this.anioFundacion = anioFundacion;
	}
	public Empresa(Long id, String nombre, String nif, String sector, Integer numTrabajadores, Integer anioFundacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nif = nif;
		this.sector = sector;
		this.numTrabajadores = numTrabajadores;
		this.anioFundacion = anioFundacion;
	}
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", nif=" + nif + ", sector=" + sector + ", numTrabajadores="
				+ numTrabajadores + ", anioFundacion=" + anioFundacion + "]";
	}
    

}
