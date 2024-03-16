package com.guizKev.api.web.controller;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.client.ClientService;
import com.guizKev.api.persistence.entity.Client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping("/client")
public class ClientController {
        
    @Autowired
    private ClientService  clientService ;


    @GetMapping("/all")
    public List<Client> getallClient() {
        return clientService.getALLCLIENT();
    }
    

    @GetMapping("/spain")
    public List<String> getClientNamesFromSpain() {
        return clientService.getClientNamesFromSpain();
    }

    @GetMapping("/payments/2008")
    public List<Integer> getClientCodesWithPaymentsIn2008() {
        return clientService.getClientCodesWithPaymentsIn2008();
    }

    @GetMapping("/madrid/representatives")
    public List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30() {
        return clientService.getClientsFromMadridWithSalesRepresentatives11Or30();
    }
    
    @GetMapping("/sales-representatives")
    public List<Object[]> getClientsWithSalesRepresentatives() {
        return clientService.getClientsWithSalesRepresentatives();
    }


    @GetMapping("/payments-representatives")
    public List<Object[]> getClientsWithPaymentsAndSalesRepresentatives() {
        return clientService.getClientsWithPaymentsAndSalesRepresentatives();
    }

    @GetMapping("/no-payments-representatives")
    public List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives() {
        return clientService.getClientsWithoutPaymentsAndWithSalesRepresentatives();
    }

    @GetMapping("/payments-office-city")
    public List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithPaymentsAndRepresentativeOfficeCity();
    }

    @GetMapping("/no-payments-office-city")
    public List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithoutPaymentsAndRepresentativeOfficeCity();
    }

    
    
    @GetMapping("/clients-sales-representatives-office-city")
    public List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity() {
        return clientService.getClientsAndSalesRepresentativesWithOfficeCity();
    }
    

    @GetMapping("/late-orders")
    public List<String> getClientsWithLateOrders() {
        return clientService.getClientsWithLateOrders();
    }

     /* 
    @GetMapping("/purchased-product-ranges")
    public List<Object[]> getPurchasedProductRangesByClient() {
        return clientService.getPurchasedProductRangesByClient();
    }

    */

    @GetMapping("/no-payments")
    public List<Client> getClientsWithoutPayments() {
        return clientService.getClientsWithoutPayments();
    }

    @GetMapping("/no-orders")
    public List<Client> getClientsWithoutOrders() {
        return clientService.getClientsWithoutOrders();
    }

    @GetMapping("/no-payments-orders")
    public List<Client> getClientsWithoutPaymentsAndOrders() {
        return clientService.getClientsWithoutPaymentsAndOrders();
    }

    @GetMapping("/orders-no-payments")
    public List<Client> getClientsWithOrdersWithoutPayments() {
        return clientService.getClientsWithOrdersWithoutPayments();
    }

    @GetMapping("/client-count-country")
    public List<Object[]> getClientCountByCountry() {
        return clientService.getClientCountByCountry();
    }

    @GetMapping("/client-count")
    public Long getClientCount() {
        return clientService.getClientCount();
    }

    @GetMapping("/client-count-madrid")
    public Long getClientCountInMadrid() {
        return clientService.getClientCountInMadrid();
    }

    @GetMapping("/client-count-starting-m")
    public List<Object[]> getClientCountByCityStartingWithM() {
        return clientService.getClientCountByCityStartingWithM();
    }

    @GetMapping("/client-count-no-sales-rep")
    public Long getClientCountWithoutSalesRepresentative() {
        return clientService.getClientCountWithoutSalesRepresentative();
    }

    @GetMapping("/first-last-payment-dates")
    public List<Object[]> getFirstAndLastPaymentDatesByClient() {
        return clientService.getFirstAndLastPaymentDatesByClient();
    }
   
    
    
    
}
