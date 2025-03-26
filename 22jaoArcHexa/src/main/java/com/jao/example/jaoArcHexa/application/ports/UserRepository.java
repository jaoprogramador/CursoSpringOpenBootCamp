package com.jao.example.jaoArcHexa.application.ports;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jao.example.jaoArcHexa.domain.pojos.User;
import com.jao.example.jaoArcHexa.infra.adapter.out.db.entities.UserEntity;

public interface UserRepository /* extends JpaRepository<UserEntity, Long> */ {
	User getUserById(Long id);

	User createUser(User user);
	
	List <User> getUsers();
	
	User updateUser(User user) ;
    
    void deleteUser(Long id);
}
