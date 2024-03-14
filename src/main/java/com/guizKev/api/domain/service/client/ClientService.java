package com.guizKev.api.domain.service.client;

import java.util.List;

import com.guizKev.api.persistence.entity.Client;



public interface ClientService {
    List<Client> getAllClient();
    List<String>getAllCLientFromSpain();
    List<Integer> clientCodesWithPaymentsIn2008();
    List<Object[]> clientsFromMadridWithSalesRepresentatives11Or30();
} 
    
    

