package com.guizKev.api.domain.service.auth;




import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.UserRepository;
import com.guizKev.api.domain.service.jwt.JwtService;
import com.guizKev.api.persistence.entity.User;
import com.guizKev.api.util.auth.AuthResponse;
import com.guizKev.api.util.login.BodyRequest;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AuthServiceImpl  implements  AuthService{
    
    
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
 
    @Override
    public AuthResponse login(BodyRequest bodyRequest) {
        /* 
        // Buscar el usuario por nombre de usuario en la base de datos
        Optional<User> userOptional = userRepository.findByUserName(bodyRequest.getUserName());
    
        // Verificar si el usuario existe
        if (!userOptional.isPresent()) {
            // Si el usuario no existe, lanzar una excepción
            throw new RuntimeException("El usuario no está registrado");
        }
    
        // Obtener el usuario de la base de datos
        User user = userOptional.get();
    
        // Verificar si la contraseña proporcionada coincide con la contraseña almacenada
        if (!passwordEncoder.matches(bodyRequest.getPassword(), user.getPassword())) {
            // Si la contraseña no coincide, lanzar una excepción
            throw new RuntimeException("La contraseña es incorrecta");
        }
    
        // Si el usuario existe y la contraseña coincide, generar y retornar el token JWT
        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();

            */
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(bodyRequest.getUserName(), bodyRequest.getPassword()));
        UserDetails user=userRepository.findByUserName(bodyRequest.getUserName()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }
    




    @Override
    public AuthResponse register(BodyRequest bodyRequest) {
        
        Optional<User> userNameOptional  = userRepository.findByUserName(bodyRequest.getUserName()) ;

        //validations 

        if (userNameOptional.isPresent()) {
            throw new RuntimeException("user name is already exists");
        } 


        if(bodyRequest.getUserName().length() > 10){
            throw new RuntimeException("the user name is too long");
        }
        
        else {
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
}