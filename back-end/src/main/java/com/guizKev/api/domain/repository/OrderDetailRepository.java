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
     @Query("SELECT d.order.id, COUNT(DISTINCT d.product.id) " +
     "FROM OrderDetail d " +
     "GROUP BY d.order.id")
     List<Object[]> countDistinctProductsInEachOrder() ;
    
 
     // 2. Calculate the sum of the total quantity of all products in each order.
     @Query("SELECT od.order.id, SUM(od.quantity) " +
     "FROM OrderDetail od " +
     "GROUP BY od.order.id")
     List<Object[]> sumTotalQuantityOfProductsInEachOrder();
 
     
     // 3. Total facturado por la empresa a lo largo de su historia.
     @Query("SELECT SUM(od.quantity * od.unitPrice), " +
         "SUM(od.quantity * od.unitPrice) * 0.21, " +
         "SUM(od.quantity * od.unitPrice) + (SUM(od.quantity * od.unitPrice) * 0.21) " +
         "FROM OrderDetail od")
     Object[] calculateBilling();
             
 
     // 4. La misma información que la pregunta anterior, pero agrupada por código de producto.
         @Query("SELECT od.product.id, od.product.name, SUM(od.quantity * od.unitPrice), " +
         "SUM(od.quantity * od.unitPrice) * 0.21, " +
         "SUM(od.quantity * od.unitPrice) + (SUM(od.quantity * od.unitPrice) * 0.21) " +
         "FROM OrderDetail od " +
         "GROUP BY od.product.id, od.product.name")
     List<Object[]> calculateBillingByProduct();
 
     // 5. La misma información que la pregunta anterior, pero agrupada por código de producto filtrado por códigos que comienzan con 'OR'.
     @Query("SELECT od.product.id, od.product.name, SUM(od.quantity * od.unitPrice), " +
         "SUM(od.quantity * od.unitPrice) * 0.21, " +
         "SUM(od.quantity * od.unitPrice) + (SUM(od.quantity * od.unitPrice) * 0.21) " +
         "FROM OrderDetail od " +
         "WHERE od.product.id LIKE 'OR%' " +  // Filtrado por códigos que comienzan con 'OR'
         "GROUP BY od.product.id, od.product.name")
     List<Object[]> calculateBillingByProductStartingWith();
 
     // 6. Lista de ventas totales de productos que han facturado más de 3000 euros. Muestra el nombre, unidades vendidas, total facturado y total facturado con impuestos (IVA del 21%).
     @Query("SELECT od.product.id, od.product.name, SUM(od.quantity), " +
         "SUM(od.quantity * od.unitPrice), " +
         "SUM(od.quantity * od.unitPrice) * 0.21 " +
         "FROM OrderDetail od " +
         "GROUP BY od.product.id, od.product.name " +
         "HAVING SUM(od.quantity * od.unitPrice) > 3000")
     List<Object[]> calculateTotalSalesForProductsOver3000Euros();

} 
