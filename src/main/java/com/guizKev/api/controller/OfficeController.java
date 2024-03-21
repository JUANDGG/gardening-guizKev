package com.guizKev.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.office.OfficeService;
import com.guizKev.api.persistence.entity.Office;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/office")
public class OfficeController {
    
    @Autowired
    private OfficeService  officeService ;

    @GetMapping("/all")
    public List<Office> getAllEmployee() {
        return officeService.getAllOffice();
    }

    //PERFECT
    @GetMapping("/codes")
    public List<Object[]> getAllCodesAndCities() {
        return officeService.findAllOfficeCodesAndCities();
    }

    //PERFECT
    @GetMapping("/cities/{country}")
    public List<Object[]> getCitiesAndPhonesInCountry(@PathVariable String country) {
        return officeService.findCitiesAndPhonesInCountry(country);
    }

    //PERFECT
    @GetMapping("/addresses/{city}")
    public List<Object[]> getOfficeAddressesWithClientsInCity(@PathVariable String city) {
        return officeService.findOfficeAddressesWithClientsInCity(city);
    }

    //ARREGLAR ESTA
    /* 
    @GetMapping("/withoutReps/fruits")
    public List<Office> getOfficesWithoutSalesRepsForFruitsProducts() {
        return officeService.findOfficesWithoutSalesRepsForFruitsProducts();
    }
    */
    
}