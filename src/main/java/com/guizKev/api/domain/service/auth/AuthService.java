package com.guizKev.api.domain.service.auth;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.UserRepository;
import com.guizKev.api.domain.service.jwt.JwtService;
import com.guizKev.api.persistence.entity.User;
import com.guizKev.api.util.auth.AuthResponse;
import com.guizKev.api.util.login.BodyRequest;




@Service

public class AuthService {

    @Autowired    
    private  UserRepository userRepository;
    @Autowired
    private  JwtService jwtService;
    @Autowired
    private  PasswordEncoder passwordEncoder; 

 

    public AuthResponse login(BodyRequest bodyRequest) {
        return null;
    }

    public AuthResponse register(BodyRequest bodyRequest) {
    
        

        String encodedPassword = passwordEncoder.encode(bodyRequest.getPassword()); 

        User user = User.builder()
        .userName(bodyRequest.getUserName())
        .password(encodedPassword) 
        .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }
}