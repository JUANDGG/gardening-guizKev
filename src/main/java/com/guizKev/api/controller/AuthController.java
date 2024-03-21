package com.guizKev.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.auth.AuthServiceImpl;
import com.guizKev.api.util.auth.AuthResponse;
import com.guizKev.api.util.login.BodyRequest;


import lombok.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Getter @Setter
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private  AuthServiceImpl authService;

    
     @PostMapping(value = "/login")
     public ResponseEntity<AuthResponse> login(@RequestBody BodyRequest bodyRequest) {
         return ResponseEntity.ok(authService.login(bodyRequest)); 
     }
     
     @PostMapping(value = "/register")
     public ResponseEntity<AuthResponse> register(@RequestBody BodyRequest bodyRequest) {
        return ResponseEntity.ok(authService.register(bodyRequest));
    
     }
     
}
