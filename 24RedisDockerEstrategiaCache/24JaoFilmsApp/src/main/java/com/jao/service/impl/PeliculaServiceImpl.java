package com.jao.service.impl;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jao.entity.PeliculaEntity;
import com.jao.repository.PeliculaRepository;
import com.jao.service.IPeliculaService;

@Service
@Transactional
public class PeliculaServiceImpl implements IPeliculaService {
	
	@Autowired
	private PeliculaRepository repository;
	
	@Override
	public Set<PeliculaEntity> getAll() {
		Set<PeliculaEntity> response = new HashSet<>();
		this.repository.findAll().forEach(response::add);
		return response;
	}

	@Override
	public PeliculaEntity save(PeliculaEntity entity) {
		if(entity.getTitulo().equalsIgnoreCase("Exception")) {
			throw new IllegalArgumentException("El nombre de la pelicula no puede ser  " + entity.getTitulo());
		}
		return this.repository.save(entity);
	}
}
