package com.jao.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;


/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
*/
@Entity
public class PeliculaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String genero;
    private Double duracion;

    @JsonIgnoreProperties(value = "peliculas", allowSetters = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductoraEntity productora;

    @JsonIgnoreProperties(value = "pelicula", allowSetters = true)
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ActorEntity> actores;

    public PeliculaEntity() {
        this.actores = new HashSet<>();
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public ProductoraEntity getProductora() {
        return productora;
    }

    public void setProductora(ProductoraEntity productora) {
        this.productora = productora;
    }

    public Set<ActorEntity> getActores() {
        return actores;
    }

    public void setActores(Set<ActorEntity> actores) {
        this.actores.clear();
        actores.forEach(this::addActor);
    }

    public void addActor(ActorEntity actor) {
        this.actores.add(actor);
        actor.setPelicula(this);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    private static final long serialVersionUID = 1L;
}



