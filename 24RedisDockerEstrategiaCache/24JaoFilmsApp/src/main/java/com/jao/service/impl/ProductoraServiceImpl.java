package com.jao.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jao.entity.ProductoraEntity;
import com.jao.repository.ProductoraRepository;
import com.jao.service.IProductoraService;

@Service
@Transactional
public class ProductoraServiceImpl implements IProductoraService {
	@Autowired
	private ProductoraRepository repository;
	@Override
	public Set<ProductoraEntity> getAll() {
		Set<ProductoraEntity> response = new HashSet<>();
		this.repository.findAll().forEach(response::add);
		return response;
	}

	@Override
	public ProductoraEntity save(ProductoraEntity entity) {
		return this.repository.save(entity);
	}

}
