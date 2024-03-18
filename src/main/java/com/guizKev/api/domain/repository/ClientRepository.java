package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client , Integer>{

       // 1. Retrieves a list with the names of all Spanish clients.
       @Query("SELECT c.clientName FROM Client c WHERE c.country = :country")
       List<String> clientFromCountry(@Param("country") String country);
   
     // 2. Retrieves a list with the client codes of those clients who made a payment in 2008. Removes duplicate client codes.
        @Query("SELECT DISTINCT c.clientCode FROM Client c JOIN c.payment p WHERE FUNCTION('YEAR', p.paymentDate) = :year GROUP BY c.clientCode")
        List<Integer> clientCodesWithPaymentsInYear(@Param("year") int year);
   
      // 3. Retrieves a list of all clients who are from the city of Madrid and whose sales representative has the employee code 11 or 30.
        @Query("SELECT c.clientCode, c.clientName, c.city, c.employee.employeeCode FROM Client c WHERE c.city = 'Madrid' AND c.employee.employeeCode IN (11, 30)")
        List<Object[]> clientsFromMadridWithSalesRepresentatives11Or30();
   
       // 4. Obtains a list with the name of each client and the name and last name of their sales representative.
        @Query("SELECT c.clientName, CONCAT(e.firstName, ' ', e.lastName1) AS SalesRepresentative FROM Client c JOIN c.employee e GROUP BY c.clientName, e.firstName, e.lastName1")
        List<Object[]> getClientsWithSalesRepresentatives();
              
        // 5. Shows the names of clients who have made payments along with the name of their sales representatives.
        @Query("SELECT c.clientCode, c.clientName, CONCAT(e.firstName, ' ', e.lastName1) AS SalesRepresentative FROM Client c JOIN c.payment p JOIN c.employee e WHERE p.client.clientCode = c.clientCode GROUP BY c.clientCode, c.clientName, e.firstName, e.lastName1")
        List<Object[]> getClientsWithPaymentsAndSalesRepresentatives();

        // 6. Shows the names of clients who haven't made payments along with the name of their sales representatives.
      
        @Query("SELECT c.clientCode AS codigoCliente, c.clientName AS nombreCliente, e.firstName AS nombreRepresentanteVentas FROM Client c LEFT JOIN c.payment p LEFT JOIN c.employee e GROUP BY c.clientCode")
        List<Object[]> getClientsWithoutPaymentsAndWithSalesRepresentatives();

        // 7. Returns the names of clients who have made payments and the name of their sales representatives along with the city of the office to which the representative belongs.
        @Query("SELECT c.clientName, CONCAT(e.firstName, ' ', e.lastName1) AS SalesRepresentative, o.city AS RepresentativeOfficeCity FROM Client c JOIN c.payment p JOIN c.employee e JOIN e.office o GROUP BY c.clientName, e.firstName, e.lastName1, o.city")
        List<Object[]> getClientsWithPaymentsAndRepresentativeOfficeCity();

        // 8. Returns the names of clients who haven't made payments and the name of their sales representatives along with the city of the office to which the representative belongs.
        @Query("SELECT c.clientName, CONCAT(e.firstName, ' ', e.lastName1) AS SalesRepresentative, o.city AS RepresentativeOfficeCity FROM Client c LEFT JOIN c.payment p JOIN c.employee e JOIN e.office o WHERE p.client.clientCode IS NULL GROUP BY c.clientName, e.firstName, e.lastName1, o.city")
        List<Object[]> getClientsWithoutPaymentsAndRepresentativeOfficeCity();

        // 9. Returns the names of clients and the name of their sales representatives along with the city of the office to which the representative belongs.
        @Query("SELECT c.clientName, CONCAT(e.firstName, ' ', e.lastName1) AS salesRepresentative, o.city AS representativeOfficeCity FROM Client c JOIN c.employee e JOIN e.office o GROUP BY c.clientName, e.firstName, e.lastName1, o.city")
        List<Object[]> getClientsAndSalesRepresentativesWithOfficeCity();

        //10. Returns the names of clients to whom orders haven't been delivered on time.
        @Query("SELECT DISTINCT c.clientName FROM Client c JOIN c.order o WHERE o.deliveryDate IS NULL OR o.deliveryDate > o.expectedDate GROUP BY c.clientName")
        List<String> getClientsWithLateOrders();
              
        //11
        /* 
        @Query("SELECT c.firstName, pr.productRange.range " +
        "FROM Client c " +
        "JOIN c.orders p " +
        "JOIN p.orderDetail dp " +
        "JOIN dp.product pr")
        List<Object[]> findClientAndProductRange();

        */

      
       
    
       // 12. Returns a list showing only clients who haven't made any payments.
       @Query("SELECT c FROM Client c LEFT JOIN c.payment p WHERE p.client.clientCode IS NULL")
       List<Client> getClientsWithoutPayments();
   
       // 13. Returns a list showing only clients who haven't placed any orders.
       @Query("SELECT c FROM Client c LEFT JOIN c.order o WHERE o.client.clientCode IS NULL")
       List<Client> getClientsWithoutOrders();
   
       // 14. Returns a list showing clients who haven't made any payments and clients who haven't placed any orders.
       @Query("SELECT c FROM Client c LEFT JOIN c.payment p LEFT JOIN c.order o WHERE p.client.clientCode IS NULL AND o.client.clientCode IS NULL")
       List<Client> getClientsWithoutPaymentsAndOrders();
   
       // 15. Returns a list showing clients who have placed orders but haven't made any payments.
       @Query("SELECT DISTINCT c FROM Client c JOIN c.order o LEFT JOIN c.payment p WHERE p.client.clientCode IS NULL")
       List<Client> getClientsWithOrdersWithoutPayments();
      
       
       // 16. Returns the count of clients for each country.
       @Query("SELECT c.country, COUNT(c) FROM Client c GROUP BY c.country")
       List<Object[]> getClientCountByCountry();
   
       // 17. Calculates the total number of clients in the company.
       @Query("SELECT COUNT(c) FROM Client c")
       Long getClientCount();
   
       // 18. Returns the count of clients with an address in the city of Madrid.
       @Query("SELECT COUNT(c) FROM Client c WHERE LOWER(c.city) = LOWER(:city)")
       Long getClientCountInCity(@Param("city") String city);
       
      
       // 19. Calculates the count of clients in each city starting with a specific letter.
      @Query("SELECT c.city, COUNT(c) FROM Client c WHERE c.city LIKE :letter% GROUP BY c.city")
      List<Object[]> getClientCountByCityStartingWith(@Param("letter") String letter);


       // 20. Calculates the number of clients without a sales representative assigned.
       @Query("SELECT COUNT(c) FROM Client c WHERE c.employee IS NULL")
       Long getClientCountWithoutSalesRepresentative();
   
       // 21. Calculates the date of the first and last payment made by each client. The list will show the name and last name of each client.
       @Query("SELECT c.clientName, MIN(p.paymentDate) AS firstPaymentDate, MAX(p.paymentDate) AS lastPaymentDate FROM Client c JOIN c.payment p GROUP BY c.clientName")
       List<Object[]> getFirstAndLastPaymentDatesByClient();

    
    
} 
