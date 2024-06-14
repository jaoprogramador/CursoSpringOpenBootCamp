package com.jao.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.spring.domain.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
