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
    public List<Object[]> findCitiesAndPhonesInSpain() {
        return officeRepository.findCitiesAndPhonesInSpain();
    }

    @Override
    public List<Object[]> findOfficeAddressesWithClientsInFuenlabrada() {
        return officeRepository.findOfficeAddressesWithClientsInFuenlabrada();
    }

    /* 
    @Override
    public List<Office> findOfficesWithoutSalesRepsForFruitsProducts() {
        return officeRepository.findOfficesWithoutSalesRepsForFruitsProducts();
    }
    */

}
