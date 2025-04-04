package com.jao.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
@Entity
public class ActorEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Integer edad;

    @JsonIgnoreProperties(value = "actores", allowSetters = true)
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "pelicula_id")
    private PeliculaEntity pelicula;

    public ActorEntity() {}

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public PeliculaEntity getPelicula() {
        return pelicula;
    }

    public void setPelicula(PeliculaEntity pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    private static final long serialVersionUID = 1L;
}
