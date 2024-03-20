package com.guizKev.api.segurity.authController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/auth")
@Data
@RequiredArgsConstructor
public class AuthController {

    private  AuthService authService ;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request)) ;
    }
    
    @PostMapping("register")
    public ResponseEntity<AuthResponse>  register(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.register(request)) ;
    }
    
}
