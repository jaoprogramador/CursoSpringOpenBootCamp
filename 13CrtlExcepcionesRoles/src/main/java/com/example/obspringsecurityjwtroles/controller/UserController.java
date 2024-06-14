package com.example.obspringsecurityjwtroles.controller;

import com.example.obspringsecurityjwtroles.config.TokenProvider;
import com.example.obspringsecurityjwtroles.dto.AuthToken;
import com.example.obspringsecurityjwtroles.dto.ErrorResponse;
import com.example.obspringsecurityjwtroles.dto.LoginUser;
import com.example.obspringsecurityjwtroles.entities.User;
import com.example.obspringsecurityjwtroles.dto.UserDto;
import com.example.obspringsecurityjwtroles.exception.EmailAlreadyExistsException;
import com.example.obspringsecurityjwtroles.service.UserService;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    private AuthenticationManager authenticationManager;
    private TokenProvider jwtTokenUtil;
    private UserService userService;

    public UserController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    // @RequestMapping(value="/register", method = RequestMethod.POST)
    @PostMapping("/register")
    public User saveUser(@RequestBody UserDto user){
        // prueba a lanzar excepción customizada
        // throw new EmailAlreadyExistsException("Email ocupado");
        return userService.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello-admin")
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/hello-admin-user")
    public String adminUser(){
        return "Only Admins and Users Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello-user")
    public String userPing(){
        return "Any User Can Read This";
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id){
    	//return userService.findById(id);
    	return userService.findById(null);
         
    }
    /*
     * ======================
     * CONTROL DE EXCEPCIONES
     * ======================
    */
    /**
     * 
     * @param exception
     * @return NoSuchElementException
     */
    /*@ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception){
    	//return new ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());//CON MI VERSION DE MAVEN TENGO QUE PONER EL CÓDIGO COMO ABAJO
    	return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    */
    /*
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception){
    	return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    } */
    /**
     * 
     * @param exception
     * @return IllegalArgumentException
     */
    /*
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException exception){
    	ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());    
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    } */


}
