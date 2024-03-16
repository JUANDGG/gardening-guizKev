package com.guizKev.api.domain.service.client;

import java.util.List;

import com.guizKev.api.persistence.entity.Client;





public interface ClientService {

    List<Client> getALLCLIENT ();

    List<String> getClientNamesFromSpain();

    List<Integer> getClientCodesWithPaymentsIn2008();

    List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30();

    //List<Object[]> getClientsWithSalesRepresentatives();

    /* 
    List<Object[]> getClientsWithPaymentsAndSalesRepresentatives();

    List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives();

    List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity();

    List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity();

    //List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity();

    List<String> getClientsWithLateOrders();

    /* 
    List<Object[]> getPurchasedProductRangesByClient();

    List<Client> getClientsWithoutPayments();

    List<Client> getClientsWithoutOrders();

    List<Client> getClientsWithoutPaymentsAndOrders();

    List<Client> getClientsWithOrdersWithoutPayments();

    List<Object[]> getClientCountByCountry();

    Long getClientCount();

    Long getClientCountInMadrid();

    List<Object[]> getClientCountByCityStartingWithM();

    Long getClientCountWithoutSalesRepresentative();

    List<Object[]> getFirstAndLastPaymentDatesByClient();
    */
}

    
    

