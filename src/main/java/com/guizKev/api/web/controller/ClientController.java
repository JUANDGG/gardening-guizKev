package com.guizKev.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.client.ClientService;
import com.guizKev.api.persistence.entity.Client;

@RestController
@RequestMapping(value = "/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService ;

    @GetMapping("/all")
    public List<Client> getAllClientController (){
        return clientService.getAllClient() ;
    }
}
