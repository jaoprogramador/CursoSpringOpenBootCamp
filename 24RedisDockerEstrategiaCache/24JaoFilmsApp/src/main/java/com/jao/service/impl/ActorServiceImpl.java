package com.jao.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jao.config.DBCacheConfig;
import com.jao.entity.ActorEntity;
import com.jao.repository.ActorRepository;
import com.jao.service.IActorService;

@Service
@Transactional
public class ActorServiceImpl implements IActorService {
	@Autowired
	private ActorRepository repository;
	
	@Override
	public ActorEntity save(ActorEntity entity) {
		return this.repository.save(entity);
	}
	
	@Override
	@CacheEvict(cacheNames = DBCacheConfig.CACHE_NAME, allEntries = true)
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	@Override
	@Cacheable(value = DBCacheConfig.CACHE_NAME)
	public Set<ActorEntity> getAll() {
		Set<ActorEntity> response = new HashSet<>();
		//SIMULAMOS CON UN TIMER DE 10segs antes de hacer la consulta
				//como si fuese la bd lenta
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		this.repository.findAll().forEach(response::add);
		return response;
	}
}
