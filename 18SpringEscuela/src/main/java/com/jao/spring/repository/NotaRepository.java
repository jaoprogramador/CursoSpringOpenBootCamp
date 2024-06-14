package com.jao.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.spring.domain.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
}
