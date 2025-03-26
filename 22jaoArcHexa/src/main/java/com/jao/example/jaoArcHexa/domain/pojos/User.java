package com.jao.example.jaoArcHexa.domain.pojos;

import java.util.Date;

import lombok.AllArgsConstructor;

//import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
	private int id;
    private String name;
    private String email;
    private String activo;
    private Date fechaAlta;

}
