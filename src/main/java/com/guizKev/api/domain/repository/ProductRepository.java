package com.guizKev.api.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product ,String>{
       @Query("SELECT p FROM Product p WHERE p.productRange.range = 'Ornamentales' AND p.quantityInStock > 100 ORDER BY p.salesPrice DESC")
    List<Product> findOrnamentalProductsByStock();

    @Query("SELECT p FROM Product p WHERE p NOT IN (SELECT dp.product FROM OrderDetail dp)")
    List<Product> findProductsNotInOrders();

    @Query("SELECT p.name, p.description, pr.image FROM Product p JOIN p.productRange pr WHERE p NOT IN (SELECT dp.product FROM OrderDetail dp)")
    List<Object[]> findProductsNotInOrdersWithDetails();

    @Query("SELECT MAX(p.salesPrice) AS maxPrice, MIN(p.salesPrice) AS minPrice FROM Product p")
    Optional<Object[]> findMaxAndMinSalesPrice();

    @Query("SELECT p.productCode, p.name, SUM(od.quantity) AS totalUnitsSold FROM Product p JOIN p.orderDetail od GROUP BY p.productCode, p.name ORDER BY totalUnitsSold DESC")
    List<Object[]> findTop20ProductsByUnitsSold();
} 
