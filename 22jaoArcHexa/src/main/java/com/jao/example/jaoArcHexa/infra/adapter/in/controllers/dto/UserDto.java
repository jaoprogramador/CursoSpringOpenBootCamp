package com.jao.example.jaoArcHexa.infra.adapter.in.controllers.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class UserDto {
	private int id;
    private String name;
    private String email;
    private String activo;
    private Date fechaAlta;
}
