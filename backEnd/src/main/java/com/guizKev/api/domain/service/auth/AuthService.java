package com.guizKev.api.domain.service.auth;

import com.guizKev.api.util.auth.AuthResponse;
import com.guizKev.api.util.login.BodyRequest;

public interface AuthService {


    AuthResponse login(BodyRequest bodyRequest);
    AuthResponse register(BodyRequest bodyRequest);
}
