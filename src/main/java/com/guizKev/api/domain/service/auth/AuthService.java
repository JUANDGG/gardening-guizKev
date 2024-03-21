package com.guizKev.api.domain.service.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.UserRepository;
import com.guizKev.api.domain.service.jwt.JwtService;
import com.guizKev.api.persistence.entity.User;
import com.guizKev.api.util.auth.AuthResponse;
import com.guizKev.api.util.login.LoginRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(LoginRequest request) {
        User user = User.builder()
                        .userName(request.getUserName())
                        .password(request.getPassword())
                        .build();

        userRepository.save(user);

        return AuthResponse.builder()
                           .token(jwtService.getToken(user))
                           .build();
    }
}