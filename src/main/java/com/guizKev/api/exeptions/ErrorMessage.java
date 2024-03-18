package com.guizKev.api.exeptions;

import org.springframework.http.HttpStatus;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
