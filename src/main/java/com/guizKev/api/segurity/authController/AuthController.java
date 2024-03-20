package com.guizKev.api.segurity.authController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/auth")
@Data
@RequiredArgsConstructor
public class AuthController {
    @PostMapping("/login")
    public String login() {
        return "intento de login" ;
    }
    
    @PostMapping("register")
    public String register() {
        //TODO: process POST request
        
        return "intento registro";
    }
    
}
