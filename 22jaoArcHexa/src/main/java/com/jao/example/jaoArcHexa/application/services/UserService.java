package com.jao.example.jaoArcHexa.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jao.example.jaoArcHexa.application.ports.UserRepository;
import com.jao.example.jaoArcHexa.application.userCases.user.CreateUser;
import com.jao.example.jaoArcHexa.application.userCases.user.DeleteUser;
import com.jao.example.jaoArcHexa.application.userCases.user.GetUser;
import com.jao.example.jaoArcHexa.application.userCases.user.UpdateUser;
import com.jao.example.jaoArcHexa.domain.pojos.User;

@Service
public class UserService implements GetUser, CreateUser, UpdateUser, DeleteUser {
	
	private final  UserRepository userRepository ;
	
	public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	// Obtener todos los usuarios
	/*
	 * public List<User> getUsers() { return userRepository.findAll(); // Usa el
	 * método findAll de JpaRepository }
	 * 
	 * // Obtener un usuario por ID public User getUserById(Long id) {
	 * Optional<User> user = userRepository.findById(id); // Usa el método findById
	 * return user.orElse(null); // Devuelve null si no se encuentra el usuario }
	 * 
	 * // Crear un nuevo usuario public User createUser(User user) { return
	 * userRepository.save(user); // Usa el método save para crear un usuario }
	 * 
	 * // Actualizar un usuario existente public User updateUser(User user) { if
	 * (userRepository.existsById((long)user.getId())) { return
	 * userRepository.save(user); // Usa save para actualizar el usuario } return
	 * null; // Devuelve null si el usuario no existe }
	 * 
	 * // Eliminar un usuario public void deleteUser(Long id) {
	 * userRepository.deleteById(id); // Usa el método deleteById de JpaRepository }
	 */
	// EN MEORIA CON UserInMemoryRepositoryImpl
	  @Override public User getUserById(Long id) {
	  
	  return userRepository.getUserById(id); }
	  
	  @Override public List <User> getUsers() {
	  
	  return userRepository.getUsers(); }
	  
	  @Override public User createUser(User user) { return
	  userRepository.createUser(user); }
	  
	  @Override public User updateUser(User user) { return
	  userRepository.updateUser(user); }
	  
	  @Override public void deleteUser(Long id) { userRepository.deleteUser(id); }
	 

}
