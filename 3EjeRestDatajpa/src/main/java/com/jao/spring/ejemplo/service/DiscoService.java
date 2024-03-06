package com.jao.spring.ejemplo.service;

import com.jao.spring.ejemplo.entities.Disco;

public class DiscoService {
	public String infoDisco(Disco disco){
		return "El album "+disco.getTitulo() +" fuen lanzado en el año "+disco.getAnioLanzamiento()+" por la banda "+disco.getAutor();
	}

}
