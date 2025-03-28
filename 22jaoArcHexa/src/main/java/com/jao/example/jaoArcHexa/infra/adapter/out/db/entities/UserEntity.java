package com.jao.example.jaoArcHexa.infra.adapter.out.db.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

@Entity // Indica que esta clase es una entidad JPA
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "users")  
public class UserEntity {
    @Id // Marca el campo id como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el ID automáticamente (autoincremental en la DB)
    private Long id; // Cambié el tipo de int a Long para adaptarlo a JPA

    private String name;
    private String email;
    private String activo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Version
    private Long version = 0L;  
    
 // Constructor vacío (necesario para Hibernate)
    public UserEntity() {
    	this.version = 0L;  
    }

}
