package com.jao.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.spring.domain.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
