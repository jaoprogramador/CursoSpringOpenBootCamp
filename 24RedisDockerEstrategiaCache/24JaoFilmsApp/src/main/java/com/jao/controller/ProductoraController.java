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

import com.jao.entity.ProductoraEntity;
import com.jao.model.ResponseModel;
import com.jao.service.IProductoraService;

@RestController
@RequestMapping(path = "v1/productora")
public class ProductoraController {
	
	@Autowired
	private IProductoraService service;
	
	@GetMapping
	public ResponseEntity<ResponseModel> getAll(){
		Set<ProductoraEntity> result = this.service.getAll();
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success productora:::GETALL");
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseModel> save(@RequestBody ProductoraEntity record) {
		ProductoraEntity result = this.service.save(record);
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success productora:::SAVE");
		return ResponseEntity.ok().body(response);
	}

}
