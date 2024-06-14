package com.jao.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.spring.domain.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
