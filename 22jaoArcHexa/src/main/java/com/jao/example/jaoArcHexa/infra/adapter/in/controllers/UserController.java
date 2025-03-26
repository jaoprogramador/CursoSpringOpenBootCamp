package com.jao.example.jaoArcHexa.infra.adapter.in.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jao.example.jaoArcHexa.application.services.UserService;
import com.jao.example.jaoArcHexa.domain.pojos.User;
import com.jao.example.jaoArcHexa.infra.adapter.in.controllers.dto.UserDto;
import com.jao.example.jaoArcHexa.infra.adapter.in.controllers.mapper.UserMapper;

@RestController
//@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public ResponseEntity<List <UserDto>> getUser() {
    	List <User> users = userService.getUsers();
    	
    	List<UserDto> userDto = users.stream().map(UserMapper::toUserDto).collect(Collectors.toList());
        return ResponseEntity.ok( userDto);
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id); // Suponiendo que tienes un servicio para obtener usuarios

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // Convertimos User a UserDto (suponiendo que tienes un mapper)
        UserDto userDto = UserMapper.toUserDto(user);

        return ResponseEntity.ok(userDto);
    }

    

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        
        User user = UserMapper.toAppObject(userDto);
        User createdUser = userService.createUser(user);
        
        return ResponseEntity.ok(UserMapper.toUserDto(createdUser));
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto usrDto) {
    	User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Usamos 'usrDto' en lugar de 'userDto' para que coincida con el parámetro del método
        User updatedUser = UserMapper.toAppObject(usrDto); // Convertir UserDto a User
        updatedUser.setId((int) id.longValue()); // Usamos 'id' directamente sin el cast a 'int' ya que es un Long
        
        updatedUser = userService.updateUser(updatedUser);
        
        return ResponseEntity.ok(UserMapper.toUserDto(updatedUser));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
	 
	 
}
