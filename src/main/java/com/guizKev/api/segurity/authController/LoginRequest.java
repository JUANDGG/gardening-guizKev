package com.guizKev.api.segurity.authController;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String userName ;
    private String password ;
}
