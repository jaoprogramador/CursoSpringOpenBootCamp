package com.jao.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
@Entity
public class ProductoraEntity implements Serializable {
    @Id
    private String nombre;
    
    @JsonIgnoreProperties(value = "productora", allowSetters = true)
    @OneToMany(mappedBy = "productora")
    private Set<PeliculaEntity> peliculas = new HashSet<>();

    public ProductoraEntity() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<PeliculaEntity> getPeliculas() {
        return peliculas;
    }

    public void addPelicula(PeliculaEntity pelicula) {
        this.peliculas.add(pelicula);
        pelicula.setProductora(this);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    private static final long serialVersionUID = 1L;
}
