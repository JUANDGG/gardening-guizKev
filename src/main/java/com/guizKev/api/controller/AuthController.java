package com.guizKev.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.auth.AuthServiceImpl;
import com.guizKev.api.util.auth.AuthResponse;
import com.guizKev.api.util.login.BodyRequest;

import org.springframework.http.MediaType;

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

    
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<AuthResponse> login(@RequestBody BodyRequest bodyRequest) {
         return ResponseEntity.ok(authService.login(bodyRequest)); 
     }
     
     @PostMapping(value = "/register")
     public ResponseEntity<AuthResponse> register(@RequestBody BodyRequest bodyRequest) {
        return ResponseEntity.ok(authService.register(bodyRequest));
    
     }
     
}
