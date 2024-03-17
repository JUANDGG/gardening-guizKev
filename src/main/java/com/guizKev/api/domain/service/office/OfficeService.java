package com.guizKev.api.domain.service.office;

import java.util.List;

import com.guizKev.api.persistence.entity.Office;

public interface OfficeService {
    List<Office> getAllOffice();
    List<Object[]> findAllOfficeCodesAndCities();
    List<Object[]> findCitiesAndPhonesInSpain();
    List<Object[]> findOfficeAddressesWithClientsInFuenlabrada();
    //List<Office> findOfficesWithoutSalesRepsForFruitsProducts();
}
