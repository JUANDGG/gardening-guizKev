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

    //PERFECT 1
    @GetMapping("/names/{country}")
    public List<String> getClientNamesFromCountry(@PathVariable String country) {
        return clientService.getClientNamesFromCountry(country);
    }


    //PERFECT  2
    @GetMapping("/codes/payments/{year}")
    public List<Integer> getClientCodesWithPaymentsInYear(@PathVariable int year) {
        return clientService.getClientCodesWithPaymentsInYear(year);
    }

    //PERFECT  3
    @GetMapping("/orders-no-payments")
    public List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30() {
        return clientService.getClientsFromMadridWithSalesRepresentatives11Or30();
    }

    //PERFECT  4
    @GetMapping("/sales-representatives")
    public List<Object[]> getClientsWithSalesRepresentatives() {
        return clientService.getClientsWithSalesRepresentatives();
    }

    //PERFECT  5
    @GetMapping("/payments-sales-representatives")
    public List<Object[]> getClientsWithPaymentsAndSalesRepresentatives() {
        return clientService.getClientsWithPaymentsAndSalesRepresentatives();
    }

    //QUERY WITH JPQL ERROR QUERY NUMBER 6 MYSQL
    @GetMapping("/no-payments-sales-representatives")
    public List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives() {
        return clientService.getClientsWithoutPaymentsAndWithSalesRepresentatives();
    }

    //PERFECT 7
    @GetMapping("/payments-representative-office-city")
    public List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithPaymentsAndRepresentativeOfficeCity();
    }

    //PERFECT 8
    @GetMapping("/no-payments-representative-office-city")
    public List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithoutPaymentsAndRepresentativeOfficeCity();
    }
    
    
    //PERFECT 9
    @GetMapping("/clients-sales-representatives-office-city")
    public List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity() {
        return clientService.getClientsAndSalesRepresentativesWithOfficeCity();
    }

    @GetMapping("/late-orders")
    public List<String> getClientsWithLateOrders() {
        return clientService.getClientsWithLateOrders();
    }

    @GetMapping("/no-payments")
    public List<Client> getClientsWithoutPayments() {
        return clientService.getClientsWithoutPayments();
    }

    @GetMapping("/no-orders")
    public List<Client> getClientsWithoutOrders() {
        return clientService.getClientsWithoutOrders();
    }

    @GetMapping("/no-payments-no-orders")
    public List<Client> getClientsWithoutPaymentsAndOrders() {
        return clientService.getClientsWithoutPaymentsAndOrders();
    }

    

    @GetMapping("/count-by-country")
    public List<Object[]> getClientCountByCountry() {
        return clientService.getClientCountByCountry();
    }

    @GetMapping("/count")
    public Long getClientCount() {
        return clientService.getClientCount();
    }

    @GetMapping("/count-in-city/{city}")
    public Long getClientCountInCity(@PathVariable String city) {
        return clientService.getClientCountInCity(city);
    }

    @GetMapping("/count-by-city-starting-with/{letter}")
    public List<Object[]> getClientCountByCityStartingWith(@PathVariable String letter) {
        return clientService.getClientCountByCityStartingWith(letter);
    }

    @GetMapping("/count-without-sales-representative")
    public Long getClientCountWithoutSalesRepresentative() {
        return clientService.getClientCountWithoutSalesRepresentative();
    }

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
