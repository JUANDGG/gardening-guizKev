package com.guizKev.api.segurity.authController;



import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.UserRepository;
import com.guizKev.api.persistence.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private  UserRepository userRepository ;
    private  JwtService jwtService ;

    public AuthResponse login(LoginRequest request) {
        return null ;
    }

    public AuthResponse register(LoginRequest request) {
        User  user =User.builder()
        .userName(request.getUserName())
        .passwordHash(request.getPassword())
        .build();

        userRepository.save(user) ;

        return AuthResponse.builder()
        .token(jwtService.getToken(user)).build();
        
    }

}
