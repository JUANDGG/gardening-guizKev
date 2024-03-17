package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Office;
@Repository
public interface OfficeRepository  extends JpaRepository<Office ,String>{
    // 1: Get office codes and cities for all offices.
    @Query("SELECT o.officeCode, o.city FROM Office o")
    List<Object[]> findAllOfficeCodesAndCities();

    // 2: Retrieve cities and phone numbers of offices in Spain.
    @Query("SELECT o.city, o.phone FROM Office o WHERE o.country = 'Spain'")
    List<Object[]> findCitiesAndPhonesInSpain();

    // 3: List addresses of offices with clients in Fuenlabrada.
    @Query("SELECT DISTINCT o.addressLine1, o.addressLine2, o.city, o.region, o.country, o.postalCode " +
           "FROM Office o " +
           "JOIN o.employee e " +
           "JOIN e.client c " +
           "WHERE c.city = 'Fuenlabrada'")
    List<Object[]> findOfficeAddressesWithClientsInFuenlabrada();


    /*
    // 4: Retrieve offices without sales representatives for Fruits products.
    @Query("SELECT DISTINCT o " +
       "FROM Office o " +
       "WHERE NOT EXISTS (" +
       "    SELECT e " +
       "    FROM Employee e " +
       "    JOIN e.Client c " +
       "    JOIN c.Order pd " +
       "    JOIN pd.OrderDetail dp " +
       "    JOIN dp.Product p " +
       "    WHERE e.office = o AND p.productRange.name = 'Fruits')")
List<Office> findOfficesWithoutSalesRepsForFruitsProducts();

*/

    
}
