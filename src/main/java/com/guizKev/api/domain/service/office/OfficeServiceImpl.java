package com.guizKev.api.domain.service.office;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.OfficeRepository;
import com.guizKev.api.persistence.entity.Office;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired 
    private OfficeRepository  officeRepository  ;

    @Override
    public List<Office> getAllOffice() {
        return officeRepository.findAll();
    }
    

    @Override
    public List<Object[]> findAllOfficeCodesAndCities() {
        return officeRepository.findAllOfficeCodesAndCities();
    }

    @Override
    public List<Object[]> findCitiesAndPhonesInCountry(String country) {
        return officeRepository.findCitiesAndPhonesInCountry(country);
    }

    @Override
    public List<Object[]> findOfficeAddressesWithClientsInCity(String city) {
        return officeRepository.findOfficeAddressesWithClientsInCity(city);
    }

    /* 
    @Override
    public List<Office> findOfficesWithoutSalesRepsForFruitsProducts() {
        return officeRepository.findOfficesWithoutSalesRepsForFruitsProducts();
    }
    */

}
