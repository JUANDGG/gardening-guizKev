package com.guizKev.api.util.login;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String userName ;
    private String password ;
}
