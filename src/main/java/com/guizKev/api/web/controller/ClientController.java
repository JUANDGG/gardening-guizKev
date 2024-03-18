package com.guizKev.api.web.controller;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.client.ClientService;
import com.guizKev.api.persistence.entity.Client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping("/client")
public class ClientController {
        
    @Autowired
    private ClientService  clientService ;

    //PERFECT
    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    //PERFECT 
    @GetMapping("/names/{country}")
    public List<String> getClientNamesFromCountry(@PathVariable String country) {
        return clientService.getClientNamesFromCountry(country);
    }


    //PERFECT  
    @GetMapping("/codes/payments/{year}")
    public List<Integer> getClientCodesWithPaymentsInYear(@PathVariable int year) {
        return clientService.getClientCodesWithPaymentsInYear(year);
    }

    //PERFECT  
    @GetMapping("/orders-no-payments")
    public List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30() {
        return clientService.getClientsFromMadridWithSalesRepresentatives11Or30();
    }

    //PERFECT  
    @GetMapping("/sales-representatives")
    public List<Object[]> getClientsWithSalesRepresentatives() {
        return clientService.getClientsWithSalesRepresentatives();
    }

    //PERFECT  
    @GetMapping("/payments-sales-representatives")
    public List<Object[]> getClientsWithPaymentsAndSalesRepresentatives() {
        return clientService.getClientsWithPaymentsAndSalesRepresentatives();
    }

    //QUERY WITH JPQL ERROR QUERY NUMBER 6 MYSQL
    @GetMapping("/no-payments-sales-representatives")
    public List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives() {
        return clientService.getClientsWithoutPaymentsAndWithSalesRepresentatives();
    }

    //PERFECT 
    @GetMapping("/payments-representative-office-city")
    public List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithPaymentsAndRepresentativeOfficeCity();
    }

    //PERFECT 
    @GetMapping("/no-payments-representative-office-city")
    public List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithoutPaymentsAndRepresentativeOfficeCity();
    }
    
    
    //PERFECT 
    @GetMapping("/clients-sales-representatives-office-city")
    public List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity() {
        return clientService.getClientsAndSalesRepresentativesWithOfficeCity();
    }

    //PERFECT 
    @GetMapping("/late-orders")
    public List<String> getClientsWithLateOrders() {
        return clientService.getClientsWithLateOrders();
    }

    //PERFECT 
    @GetMapping("/no-payments")
    public List<Client> getClientsWithoutPayments() {
        return clientService.getClientsWithoutPayments();
    }


    //PERFECT 
    @GetMapping("/no-orders")
    public List<Client> getClientsWithoutOrders() {
        return clientService.getClientsWithoutOrders();
    }

     //PERFECT 
    @GetMapping("/no-payments-no-orders")
    public List<Client> getClientsWithoutPaymentsAndOrders() {
        return clientService.getClientsWithoutPaymentsAndOrders();
    }

    
     //PERFECT 
    @GetMapping("/count-by-country")
    public List<Object[]> getClientCountByCountry() {
        return clientService.getClientCountByCountry();
    }

    //PERFECT 
    @GetMapping("/count")
    public Long getClientCount() {
        return clientService.getClientCount();
    }

    //PERFECT 
    @GetMapping("/count-in-city/{city}")
    public Long getClientCountInCity(@PathVariable String city) {
        return clientService.getClientCountInCity(city);
    }


    //PERFET 
    @GetMapping("/count-by-city-starting-with/{letter}")
    public List<Object[]> getClientCountByCityStartingWith(@PathVariable String letter) {
        return clientService.getClientCountByCityStartingWith(letter);
    }

    //PERFET 
    @GetMapping("/count-without-sales-representative")
    public Long getClientCountWithoutSalesRepresentative() {
        return clientService.getClientCountWithoutSalesRepresentative();
    }

    //PERFET 

    @GetMapping("/first-and-last-payment-dates")
    public List<Object[]> getFirstAndLastPaymentDatesByClient() {
        return clientService.getFirstAndLastPaymentDatesByClient();
    }

     /* 
    @GetMapping("/purchased-product-ranges")
    public List<Object[]> getPurchasedProductRangesByClient() {
        return clientService.getPurchasedProductRangesByClient();
    }

    */

    
    
    
}
