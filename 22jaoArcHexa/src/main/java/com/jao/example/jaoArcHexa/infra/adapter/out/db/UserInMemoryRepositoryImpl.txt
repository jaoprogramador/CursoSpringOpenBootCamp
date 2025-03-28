package com.jao.example.jaoArcHexa.infra.adapter.out.db;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jao.example.jaoArcHexa.application.ports.UserRepository;
import com.jao.example.jaoArcHexa.domain.pojos.User;
@Repository
public class UserInMemoryRepositoryImpl implements UserRepository{
	
	
	
	private static Map <Long, User> users = new HashMap<>();
	
	@Override
	public User getUserById(Long id) {
		
		users.put(
				1L, User.builder() .id(1) .name("jao") .email("jao@mail.es") .activo("A")
				  .fechaAlta(new Date()) .build() 
				);
		users.put(
				2L, User.builder() .id(2) .name("ale") .email("alejandra@mail.es") .activo("A")
				  .fechaAlta(new Date()) .build() 
				);
		users.put(
				3L, User.builder() .id(3) .name("guillermo") .email("guigui@mail.es") .activo("A")
				  .fechaAlta(new Date()) .build() 
				);
		users.put(
				4L, User.builder() .id(4) .name("joseba") .email("jow@mail.es") .activo("A")
				  .fechaAlta(new Date()) .build() 
				);
		return users.get(id);
	}
	@Override
	public List <User> getUsers() {
		
		return users.values().stream().toList();
		//return (List<User>) users.values();
	}
	
	@Override
	public User createUser(User user) {
		
		Long id = (long) users.keySet().size() +1;
		users.put(id, user);
		return user;
	}
	@Override
	 public User updateUser(User user) {
        //if (users.containsKey(user.getId())) {
		if (users.containsKey((long) user.getId())) {
            users.put((long) user.getId(), user);
            return user;
        }
        return null; // Devuelve null si el usuario no existe
    }

    @Override
    public void deleteUser(Long id) {
        users.remove(id);
    }
	
	
	

}
