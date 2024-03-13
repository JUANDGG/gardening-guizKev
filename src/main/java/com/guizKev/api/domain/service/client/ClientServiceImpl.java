package com.guizKev.api.domain.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.ClientRepository;
import com.guizKev.api.persistence.entity.Client;




@Service
public class ClientServiceImpl implements ClientService {

    
    private  ClientRepository clientRepository ;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository ;
    }

    @Override
    public List<Client> getAllClient() {
        return  clientRepository.findAll() ;
    }
    
}
