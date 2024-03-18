package com.guizKev.api.web.controller;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.client.ClientService;
import com.guizKev.api.persistence.entity.Client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/client")
public class ClientController {
        
    @Autowired
    private ClientService  clientService ;

    
    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    //PERFET 1
    @GetMapping("/names/{country}")
    public List<String> getClientNamesFromCountry(@PathVariable String country) {
        return clientService.getClientNamesFromCountry(country);
    }


    //PERFET 2
    @GetMapping("/codes/payments/{year}")
    public List<Integer> getClientCodesWithPaymentsInYear(@PathVariable int year) {
        return clientService.getClientCodesWithPaymentsInYear(year);
    }

     //PERFECT 3
    @GetMapping("/employee-city-code")
    public List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30() {
        return clientService.getClientsFromMadridWithSalesRepresentatives11Or30();
    }

     //PERFET 4
    @GetMapping("/sales-representatives")
    public List<Object[]> getClientsWithSalesRepresentatives() {
        return clientService.getClientsWithSalesRepresentatives();
    }

    //PERFET 5
    @GetMapping("/payments-sales-representatives")
    public List<Object[]> getClientsWithPaymentsAndSalesRepresentatives() {
        return clientService.getClientsWithPaymentsAndSalesRepresentatives();
    }

    //PERFET 6
    @GetMapping("/no-payments-sales-representatives")
    public List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives() {
        return clientService.getClientsWithoutPaymentsAndWithSalesRepresentatives();
    }

    //PERFET 7
    @GetMapping("/payments-representative-office-city")
    public List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithPaymentsAndRepresentativeOfficeCity();
    }


    //PERFET 8
    @GetMapping("/no-payments-representative-office-city")
    public List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithoutPaymentsAndRepresentativeOfficeCity();
    }
    
    //PERFET 9
    @GetMapping("/late-orders")
    public List<String> getClientsWithLateOrders() {
        return clientService.getClientsWithLateOrders();
    }

    // error 10 
      /* 
    @GetMapping("/purchased-product-ranges")
    public List<Object[]> getPurchasedProductRangesByClient() {
        return clientService.getPurchasedProductRangesByClient();
    }

    */

    //PERFECT 11
    @GetMapping("/no-payments")
    public List<Client> getClientsWithoutPayments() {
        return clientService.getClientsWithoutPayments();
    }


    //PERFECT 12
    @GetMapping("/no-orders")
    public List<Client> getClientsWithoutOrders() {
        return clientService.getClientsWithoutOrders();
    }

    //PERFECT 13
    @GetMapping("/no-payments-no-orders")
    public List<Client> getClientsWithoutPaymentsAndOrders() {
        return clientService.getClientsWithoutPaymentsAndOrders();
    }

    
    
    //PERFECT 14
    @GetMapping("/orders-no-payments")
    public List<Client> getClientsWithOrdersWithoutPayments(){
        return clientService.getClientsWithOrdersWithoutPayments();
    }

    
    
    

    //PERFETC 15
    @GetMapping("/count-by-country")
    public List<Object[]> getClientCountByCountry() {
        return clientService.getClientCountByCountry();
    }


    //PERFETC 16
    @GetMapping("/count")
    public Long getClientCount() {
        return clientService.getClientCount();
    }



    //PERFETC 17
    @GetMapping("/count-in-city/{city}")
    public Long getClientCountInCity(@PathVariable String city) {
        return clientService.getClientCountInCity(city);
    }

    //PERFETC 18
    @GetMapping("/count-by-city-starting-with/{letter}")
    public List<Object[]> getClientCountByCityStartingWith(@PathVariable String letter) {
        return clientService.getClientCountByCityStartingWith(letter);
    }


    //PERFETC 19
    @GetMapping("/count-without-sales-representative")
    public Long getClientCountWithoutSalesRepresentative() {
        return clientService.getClientCountWithoutSalesRepresentative();
    }

    //PERFETC 20
    @GetMapping("/first-and-last-payment-dates")
    public List<Object[]> getFirstAndLastPaymentDatesByClient() {
        return clientService.getFirstAndLastPaymentDatesByClient();
    }


    //PERFETC 21
    @GetMapping("/clients-sales-representatives-office-city")
    public List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity() {
        return clientService.getClientsAndSalesRepresentativesWithOfficeCity();
    }

  

    

   

    
    
    
}
