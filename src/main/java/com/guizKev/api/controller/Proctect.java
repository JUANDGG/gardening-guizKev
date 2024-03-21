package com.guizKev.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class Proctect {
    @PostMapping(value = "demo")
    public String demo() {
        return "intento de acceder a ruta protegida" ;
    }
}
