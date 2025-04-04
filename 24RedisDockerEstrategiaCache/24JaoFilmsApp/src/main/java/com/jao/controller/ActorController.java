package com.jao.controller;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jao.entity.ActorEntity;
import com.jao.model.ResponseModel;
import com.jao.service.IActorService;

@RestController
@RequestMapping(path = "v1/actor")
public class ActorController {
	
	@Autowired
	private IActorService service;
	
	@GetMapping
	public ResponseEntity<ResponseModel> getAll(){
		Set<ActorEntity> result = this.service.getAll();
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success::GETALL ACTORS");
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseModel> save(@RequestBody ActorEntity track) {
		ActorEntity result = this.service.save(track);
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success::SAVE ACTOR");
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
