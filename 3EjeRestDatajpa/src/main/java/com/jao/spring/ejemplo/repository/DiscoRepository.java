package com.jao.spring.ejemplo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.spring.ejemplo.entities.Disco;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long> {
}
