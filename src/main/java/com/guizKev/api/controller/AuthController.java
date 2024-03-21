package com.guizKev.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.auth.AuthService;
import com.guizKev.api.util.auth.AuthResponse;
import com.guizKev.api.util.login.LoginRequest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
@Data
@RequiredArgsConstructor
public class AuthController {


    @Autowired
    private  AuthService authService;

    
     @PostMapping("/login")
     public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
         return ResponseEntity.ok(authService.login(request)); //
     }
     
     @PostMapping("/register")
     public ResponseEntity<AuthResponse> register(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.register(request));
    
     }
     
}
