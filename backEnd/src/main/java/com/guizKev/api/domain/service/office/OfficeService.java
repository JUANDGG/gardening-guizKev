package com.guizKev.api.domain.service.office;

import java.util.List;

import com.guizKev.api.persistence.entity.Office;
import com.guizKev.api.persistence.entity.ProductRange;

public interface OfficeService {
    List<Office> getAllOffice();
    List<Object[]> findAllOfficeCodesAndCities();
    List<Object[]> findCitiesAndPhonesInCountry(String country);
    List<Object[]> findOfficeAddressesWithClientsInCity(String city);
        List<Office> findOfficesWithoutSalesRepsForFruitsProducts(ProductRange range);
}