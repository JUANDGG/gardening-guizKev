package com.guizKev.api.domain.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.ClientRepository;
import com.guizKev.api.persistence.entity.Client;

import lombok.*;




@Service
@Getter @Setter 
public class ClientServiceImpl implements ClientService {

    @Autowired
    private  ClientRepository clientRepository ;

    
   

    @Override
    public List<Client> getAllClient() {
        return  clientRepository.findAll() ;
    }

    @Override
    public List<String> getAllCLientFromSpain(){
        return   clientRepository.clientFromSpain();
    }

    @Override
    public List<Integer> clientCodesWithPaymentsIn2008() {
        return clientRepository.clientCodesWithPaymentsIn2008();
    }

    @Override
    public List<Object[]> clientsFromMadridWithSalesRepresentatives11Or30() {
        return clientRepository.clientsFromMadridWithSalesRepresentatives11Or30();
    }
    
}
