package com.jao.spring.ejemplo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jao.spring.ejemplo.entities.Disco;

@Repository
public interface DiscoMngRepository extends MongoRepository<Disco, Long> {
}
