package com.jao.example.jaoArcHexa.infra.adapter.out.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jao.example.jaoArcHexa.infra.adapter.out.db.entities.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {


}
