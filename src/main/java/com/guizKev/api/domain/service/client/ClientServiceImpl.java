package com.guizKev.api.domain.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.ClientRepository;
import com.guizKev.api.persistence.entity.Client;

import lombok.*;

@Service
@Getter @Setter 
public class ClientServiceImpl implements ClientService {

    @Autowired
    private  ClientRepository clientRepository ;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<String> getClientNamesFromCountry(String country) {
        return clientRepository.clientFromCountry(country);
    }

    @Override
    public List<Integer> getClientCodesWithPaymentsInYear(int year) {
        return clientRepository.clientCodesWithPaymentsInYear(year);
    }

    @Override
    public List<Object[]> getClientsFromMadridWithSalesRepresentatives11Or30() {
        return clientRepository.clientsFromMadridWithSalesRepresentatives11Or30();
    }

    @Override
    public List<Object[]> getClientsWithSalesRepresentatives() {
        return clientRepository.getClientsWithSalesRepresentatives();
    }

    @Override
    public List<Object[]> getClientsWithPaymentsAndSalesRepresentatives() {
        return clientRepository.getClientsWithPaymentsAndSalesRepresentatives();
    }

    @Override
    public List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives() {
        return clientRepository.getClientsWithoutPaymentsAndWithSalesRepresentatives();
    }

    @Override
    public List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity() {
        return clientRepository.getClientsWithPaymentsAndRepresentativeOfficeCity();
    }

    @Override
    public List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity() {
        return clientRepository.getClientsWithoutPaymentsAndRepresentativeOfficeCity();
    }

    @Override
    public List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity() {
        return clientRepository.getClientsAndSalesRepresentativesWithOfficeCity();
    }

    @Override
    public List<String> getClientsWithLateOrders() {
        return clientRepository.getClientsWithLateOrders();
    }

    @Override
    public List<Client> getClientsWithoutPayments() {
        return clientRepository.getClientsWithoutPayments();
    }

    @Override
    public List<Client> getClientsWithoutOrders() {
        return clientRepository.getClientsWithoutOrders();
    }

    @Override
    public List<Client> getClientsWithoutPaymentsAndOrders() {
        return clientRepository.getClientsWithoutPaymentsAndOrders();
    }

    @Override
    public List<Client> getClientsWithOrdersWithoutPayments() {
        return clientRepository.getClientsWithOrdersWithoutPayments();
    }

    @Override
    public List<Object[]> getClientCountByCountry() {
        return clientRepository.getClientCountByCountry();
    }

    @Override
    public Long getClientCount() {
        return clientRepository.getClientCount();
    }

    @Override
    public Long getClientCountInCity(String city) {
        return clientRepository.getClientCountInCity(city);
    }

    @Override
    public List<Object[]> getClientCountByCityStartingWith(String letter) {
        return clientRepository.getClientCountByCityStartingWith(letter);
    }

    @Override
    public Long getClientCountWithoutSalesRepresentative() {
        return clientRepository.getClientCountWithoutSalesRepresentative();
    }

    @Override
    public List<Object[]> getFirstAndLastPaymentDatesByClient() {
        return clientRepository.getFirstAndLastPaymentDatesByClient();
    }

   
    @Override
    public List<Object[]> findClientAndProductRange() {
        return clientRepository.findClientAndProductRange();
    }

    


    
}
