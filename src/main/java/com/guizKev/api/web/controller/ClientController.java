package com.guizKev.api.web.controller;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.client.ClientService;
import com.guizKev.api.persistence.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/client")
public class ClientController {
        
    @Autowired
    private ClientService  clientService ;


   @GetMapping("/clientFromSpain")
    public List<String> getAllClientsFromSpain() {
        return clientService.getAllCLientFromSpain() ;
    }

    @GetMapping("/clientCodesWithPaymentsIn2008")
    public List<Integer> clientCodesWithPaymentsIn2008() {
        return clientService.clientCodesWithPaymentsIn2008();
    }
    
    @GetMapping("/clientsFromMadridWithSalesRepresentatives11Or30")
    public List<Object[]> clientsFromMadridWithSalesRepresentatives11Or30(){
        return  clientService.clientsFromMadridWithSalesRepresentatives11Or30() ;
    }
   

    
    
}
