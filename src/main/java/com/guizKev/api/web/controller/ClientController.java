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

    
    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    //PERFET
    @GetMapping("/names/{country}")
    public List<String> getClientNamesFromCountry(@PathVariable String country) {
        return clientService.getClientNamesFromCountry(country);
    }


    //PERFET
    @GetMapping("/codes/payments/{year}")
    public List<Integer> getClientCodesWithPaymentsInYear(@PathVariable int year) {
        return clientService.getClientCodesWithPaymentsInYear(year);
    }

     //PERFECT
    @GetMapping("/orders-no-payments")
    public List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30() {
        return clientService.getClientsFromMadridWithSalesRepresentatives11Or30();
    }

     //PERFET
    @GetMapping("/sales-representatives")
    public List<Object[]> getClientsWithSalesRepresentatives() {
        return clientService.getClientsWithSalesRepresentatives();
    }

    //PERFET
    @GetMapping("/payments-sales-representatives")
    public List<Object[]> getClientsWithPaymentsAndSalesRepresentatives() {
        return clientService.getClientsWithPaymentsAndSalesRepresentatives();
    }

    //QUERY WITH JPQL ERROR QUERY NUMBER 6 MYSQL FALTA QUERIS
    @GetMapping("/no-payments-sales-representatives")
    public List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives() {
        return clientService.getClientsWithoutPaymentsAndWithSalesRepresentatives();
    }

    //PERFET
    @GetMapping("/payments-representative-office-city")
    public List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithPaymentsAndRepresentativeOfficeCity();
    }


    //PERFET
    @GetMapping("/no-payments-representative-office-city")
    public List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithoutPaymentsAndRepresentativeOfficeCity();
    }
    
    //PERFET
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
    
    //FALTA 14 CONSULTA README ACA ..

    //PERFETC
    @GetMapping("/count-by-country")
    public List<Object[]> getClientCountByCountry() {
        return clientService.getClientCountByCountry();
    }


    //PERFETC
    @GetMapping("/count")
    public Long getClientCount() {
        return clientService.getClientCount();
    }



    //PERFETC
    @GetMapping("/count-in-city/{city}")
    public Long getClientCountInCity(@PathVariable String city) {
        return clientService.getClientCountInCity(city);
    }

    //PERFETC
    @GetMapping("/count-by-city-starting-with/{letter}")
    public List<Object[]> getClientCountByCityStartingWith(@PathVariable String letter) {
        return clientService.getClientCountByCityStartingWith(letter);
    }


    //PERFETC
    @GetMapping("/count-without-sales-representative")
    public Long getClientCountWithoutSalesRepresentative() {
        return clientService.getClientCountWithoutSalesRepresentative();
    }

    //PERFETC
    @GetMapping("/first-and-last-payment-dates")
    public List<Object[]> getFirstAndLastPaymentDatesByClient() {
        return clientService.getFirstAndLastPaymentDatesByClient();
    }


    //PERFETC
    @GetMapping("/clients-sales-representatives-office-city")
    public List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity() {
        return clientService.getClientsAndSalesRepresentativesWithOfficeCity();
    }

  

    

   

    
    
    
}
