package com.jao.controller;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jao.entity.PeliculaEntity;
import com.jao.model.ResponseModel;
import com.jao.service.IPeliculaService;

@RestController
@RequestMapping(path = "v1/pelicula")
public class PeliculaController {
	
	@Autowired
	private IPeliculaService service;
	
	@GetMapping
	public ResponseEntity<ResponseModel> getAll(){
		Set<PeliculaEntity> result = this.service.getAll();
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success Film::GETALL");
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseModel> save(@RequestBody PeliculaEntity album) {
		PeliculaEntity result = this.service.save(album);
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success Filme::SAVE");
		return ResponseEntity.ok().body(response);
	}

}
