package com.jao.spring.security.SecurityCSRF.controller;

import com.jao.spring.security.SecurityCSRF.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    // urls permitidas
    @GetMapping("/api/hola")
	//@GetMapping("/hola")
    public String hola(){
        return "Hola mundo";
    }

    // Urls autenticadas
    @GetMapping("/api/adios")
    public String adios(){
        return "Adios mundo";
    }

    @PostMapping("/api/users")
    public String save(@RequestBody UserDTO user){
        System.out.println(user);
        return "OK";
    }

}
