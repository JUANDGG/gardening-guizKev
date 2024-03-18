package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Office;
@Repository
public interface OfficeRepository  extends JpaRepository<Office ,String>{
       // 1: Get office codes and cities for all offices.
       @Query("SELECT o.officeCode, o.city FROM Office o")
       List<Object[]> findAllOfficeCodesAndCities();

       // 2: Retrieve cities and phone numbers of offices in a specific country.
       @Query("SELECT o.city, o.phone FROM Office o WHERE o.country = :country")
       List<Object[]> findCitiesAndPhonesInCountry(@Param("country") String country);

       // 3: List addresses of offices with clients in a specific city.
       @Query("SELECT DISTINCT o.addressLine1, o.addressLine2, o.city, o.region, o.country, o.postalCode " +
              "FROM Office o " +
              "JOIN o.employee e " +
              "JOIN e.client c " +
              "WHERE c.city = :city")
       List<Object[]> findOfficeAddressesWithClientsInCity(@Param("city") String city);


       /* 
       // 4: Retrieve offices without sales representatives for Fruits products.
       @Query("SELECT DISTINCT o FROM Office o LEFT JOIN o.employees e LEFT JOIN e.client c LEFT JOIN c.order pd LEFT JOIN pd.orderDetails dp LEFT JOIN dp.product p WHERE p.productLine = 'Frutales' AND e IS NULL")
       List<Office> findOfficesWithoutSalesRepsForFruitsProducts();
       */

       

    
}
