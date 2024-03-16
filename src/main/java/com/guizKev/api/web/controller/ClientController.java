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


    /*  */
    @GetMapping("/all")
    public List<Client> getallClient() {
        return clientService.getALLCLIENT();
    }
    

    /* 1 Perfect */
    @GetMapping("/spain")
    public List<String> getClientNamesFromSpain() {
        return clientService.getClientNamesFromSpain();
    }

    /* 2 Perfect */
    @GetMapping("/payments/2008")
    public List<Integer> getClientCodesWithPaymentsIn2008() {
        return clientService.getClientCodesWithPaymentsIn2008();
    }

    /* 3 Perfect */
    @GetMapping("/madrid/representatives")
    public List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30() {
        return clientService.getClientsFromMadridWithSalesRepresentatives11Or30();
    }
    
    /* 4 Perfect */
    @GetMapping("/sales-representatives")
    public List<Object[]> getClientsWithSalesRepresentatives() {
        return clientService.getClientsWithSalesRepresentatives();
    }


    /* 5 Good, in MySQL repeat data */
    @GetMapping("/payments-representatives")
    public List<Object[]> getClientsWithPaymentsAndSalesRepresentatives() {
        return clientService.getClientsWithPaymentsAndSalesRepresentatives();
    }

    @GetMapping("/no-payments-representatives")
    public List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives() {
        return clientService.getClientsWithoutPaymentsAndWithSalesRepresentatives();
    }

    /* 7 Perfect */
    @GetMapping("/payments-office-city")
    public List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithPaymentsAndRepresentativeOfficeCity();
    }

    /* 8 Perfect */
    @GetMapping("/no-payments-office-city")
    public List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity() {
        return clientService.getClientsWithoutPaymentsAndRepresentativeOfficeCity();
    }

    
    
    @GetMapping("/clients-sales-representatives-office-city")
    public List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity() {
        return clientService.getClientsAndSalesRepresentativesWithOfficeCity();
    }
    

    /* 9 Perfect */
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

    /* 11 Perfect */
    @GetMapping("/no-payments")
    public List<Client> getClientsWithoutPayments() {
        return clientService.getClientsWithoutPayments();
    }

    /* 12 Perfect */
    @GetMapping("/no-orders")
    public List<Client> getClientsWithoutOrders() {
        return clientService.getClientsWithoutOrders();
    }

    /* 13 Perfect */
    @GetMapping("/no-payments-orders")
    public List<Client> getClientsWithoutPaymentsAndOrders() {
        return clientService.getClientsWithoutPaymentsAndOrders();
    }

    /* 14 Perfect */
    @GetMapping("/orders-no-payments")
    public List<Client> getClientsWithOrdersWithoutPayments() {
        return clientService.getClientsWithOrdersWithoutPayments();
    }

    /* 15 Perfect */
    @GetMapping("/client-count-country")
    public List<Object[]> getClientCountByCountry() {
        return clientService.getClientCountByCountry();
    }

    /* 16 Perfect */
    @GetMapping("/client-count")
    public Long getClientCount() {
        return clientService.getClientCount();
    }

    /* 17 Perfect */
    @GetMapping("/client-count-madrid")
    public Long getClientCountInMadrid() {
        return clientService.getClientCountInMadrid();
    }

    /* 18 Perfect */
    @GetMapping("/client-count-starting-m")
    public List<Object[]> getClientCountByCityStartingWithM() {
        return clientService.getClientCountByCityStartingWithM();
    }

    /* 19 Perfect */
    @GetMapping("/client-count-no-sales-rep")
    public Long getClientCountWithoutSalesRepresentative() {
        return clientService.getClientCountWithoutSalesRepresentative();
    }

    /* 20 Good, 18 queries with Null and 18 without Null */
    @GetMapping("/first-last-payment-dates")
    public List<Object[]> getFirstAndLastPaymentDatesByClient() {
        return clientService.getFirstAndLastPaymentDatesByClient();
    }
   
    
    
    
}
