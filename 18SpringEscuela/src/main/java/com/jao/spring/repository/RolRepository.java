package com.jao.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jao.spring.domain.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
