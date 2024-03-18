package com.guizKev.api.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product ,String>{
    @Query("SELECT p FROM Product p WHERE p.productRange.range = :range AND p.quantityInStock > :quantity ORDER BY p.salesPrice DESC")
    List<Product> findProductsByRangeAndStock(@Param("range") String range, @Param("quantity") int quantity);

    @Query("SELECT p FROM Product p WHERE p NOT IN (SELECT dp.product FROM OrderDetail dp WHERE dp.order.id = :orderId)")
    List<Product> findProductsNotInOrders(@Param("orderId") Long orderId);

    @Query("SELECT p.name, p.description, pr.image FROM Product p JOIN p.productRange pr WHERE p NOT IN (SELECT dp.product FROM OrderDetail dp WHERE dp.order.id = :orderId)")
    List<Object[]> findProductsNotInOrdersWithDetails(@Param("orderId") Long orderId);

    @Query("SELECT MAX(p.salesPrice) AS maxPrice, MIN(p.salesPrice) AS minPrice FROM Product p WHERE p.productRange.range = :range")
    Optional<Object[]> findMaxAndMinSalesPrice(@Param("range") String range);

    @Query("SELECT p.productCode, p.name, SUM(od.quantity) AS totalUnitsSold FROM Product p JOIN p.orderDetail od WHERE p.productRange.range = :range GROUP BY p.productCode, p.name ORDER BY totalUnitsSold DESC")
    List<Object[]> findTopProductsByUnitsSold(@Param("range") String range);
} 
