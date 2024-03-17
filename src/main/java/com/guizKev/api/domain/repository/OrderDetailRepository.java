package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.OrderDetail;
import com.guizKev.api.persistence.entity.OrderDetailId;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>{
   // 1. Calculate the number of different products in each order.
    @Query("SELECT od.order.id, COUNT(DISTINCT od.product.id) " +
    "FROM OrderDetail od " +
    "GROUP BY od.order.id")
    List<Object[]> countDistinctProductsInEachOrder();

    // 2. Calculate the sum of the total quantity of all products in each order.
    @Query("SELECT od.order.id, SUM(od.quantity) " +
    "FROM OrderDetail od " +
    "GROUP BY od.order.id")
    List<Object[]> sumTotalQuantityOfProductsInEachOrder();

    /*
    // 3. Total billing of the company throughout its history.
    @Query("SELECT SUM(od.quantity * p.unitPrice), " +
    "SUM(od.quantity * p.unitPrice) * 0.21, " +
    "SUM(od.quantity * p.unitPrice) + (SUM(od.quantity * p.unitPrice) * 0.21) " +
    "FROM OrderDetail od " +
    "JOIN od.product p")
    Object[] calculateBilling();
    */

    /*
    // 4. The same information as the previous question, but grouped by product code.
    @Query("SELECT p.id, p.name, SUM(od.quantity * p.unitPrice), " +
    "SUM(od.quantity * p.unitPrice) * 0.21, " +
    "SUM(od.quantity * p.unitPrice) + (SUM(od.quantity * p.unitPrice) * 0.21) " +
    "FROM OrderDetail od " +
    "JOIN od.product p " +
    "GROUP BY p.id, p.name")
    List<Object[]> calculateBillingByProduct();
    */

    
    /*
    // 5. The same information as the previous question, but grouped by product code filtered by codes starting with 'OR'.
        @Query("SELECT p.id, p.name, SUM(od.quantity * p.unitPrice), " +
        "SUM(od.quantity * p.unitPrice) * 0.21, " +
        "SUM(od.quantity * p.unitPrice) + (SUM(od.quantity * p.unitPrice) * 0.21) " +
        "FROM OrderDetail od " +
        "JOIN od.product p " +
        "WHERE p.id LIKE 'OR%' " +  // Filtrado por códigos que comienzan con 'OR'
        "GROUP BY p.id, p.name")
        List<Object[]> calculateBillingByProductStartingWith();
    */


    /* 

    // 6. List total sales of products that have billed more than 3000 euros. Show name, units sold, total billed, and total billed with taxes (21% VAT).
    @Query("SELECT p.id, p.name, SUM(od.quantity), " +
       "SUM(od.quantity * p.unitPrice), " +
       "SUM(od.quantity * p.unitPrice) * 0.21 " +
       "FROM OrderDetail od " +
       "JOIN od.product p " +
       "GROUP BY p.id, p.name " +
       "HAVING SUM(od.quantity * p.unitPrice) > 3000")
List<Object[]> calculateTotalSalesForProductsOver3000Euros();
*/  

} 
