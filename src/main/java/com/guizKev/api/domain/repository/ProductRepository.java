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

    // 1 -Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio.

    @Query("SELECT p FROM Product p WHERE p.productRange.range = :range AND p.quantityInStock > :quantity ORDER BY p.salesPrice DESC")
    List<Product> findProductsByRangeAndStock(@Param("range") String range, @Param("quantity") int quantity);

    //2 -Devuelve un listado de los productos que nunca han aparecido en un pedido.
    @Query("SELECT p FROM Product p " +
            "LEFT JOIN OrderDetail od ON p.id = od.product.id " +
            "WHERE od.product IS NULL")
    List<Product> findProductsWithoutOrderDetails();


    // //3 -Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto. 
    
    // @Query("SELECT p.nombre, p.descripcion, gp.imagen " +
    // "FROM Product p " +
    // "JOIN ProductLine gp ON p.productLine = gp.productLine " +
    // "WHERE p.id NOT IN (SELECT DISTINCT od.product.id FROM OrderDetail od)")
    // List<Object[]> findProductsNotInOrderDetails();

    // //4 -Calcula el precio de venta del producto más caro y más barato en una misma consulta.
   
    // @Query("SELECT MAX(p.precioVenta) AS precio_mas_caro, MIN(p.precioVenta) AS precio_mas_barato FROM Product p")
    // Object[] findMaxAndMinPrice();


    // //5 -Devuelve un listado de los 20 productos más vendidos y el número total de unidades que se han vendido de cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.
    // @Query("SELECT p.codigoProducto, p.nombre, SUM(dp.quantity) AS totalUnidadesVendidas " +
    // "FROM Product p " +
    // "JOIN OrderDetail dp ON p.codigoProducto = dp.product.codigoProducto " +
    // "GROUP BY p.codigoProducto, p.nombre " +
    // "ORDER BY totalUnidadesVendidas DESC")
    // List<Object[]> findTop20BestSellingProducts();
} 
