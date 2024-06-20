package com.guizKev.api.domain.service.client;

import java.util.List;

import com.guizKev.api.persistence.entity.Client;





public interface ClientService {

    List<Client> getAllClients();
    List<String> getClientNamesFromCountry(String country);
    List<Integer> getClientCodesWithPaymentsInYear(int year);
    List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30();
    List<Object[]> getClientsWithSalesRepresentatives();
    List<Object[]> getClientsWithPaymentsAndSalesRepresentatives();
    List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives();
    List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity();
    List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity();
    List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity();
    List<String> getClientsWithLateOrders();
   List<Object[]> findClientAndProductRange();  
    List<Client> getClientsWithoutPayments();
    List<Client> getClientsWithoutOrders();
    List<Client> getClientsWithoutPaymentsAndOrders();
    List<Client> getClientsWithOrdersWithoutPayments();
    List<Object[]> getClientCountByCountry();
    Long getClientCount();
    Long getClientCountInCity(String city);
    List<Object[]> getClientCountByCityStartingWith(String letter);
    Long getClientCountWithoutSalesRepresentative();
    List<Object[]> getFirstAndLastPaymentDatesByClient();
    
}

    
    

