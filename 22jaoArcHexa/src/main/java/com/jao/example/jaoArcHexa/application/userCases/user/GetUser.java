package com.jao.example.jaoArcHexa.application.userCases.user;

import java.util.List;

import com.jao.example.jaoArcHexa.domain.pojos.User;

public interface GetUser {
	User getUserById(Long id);
	List <User> getUsers();
	

}
