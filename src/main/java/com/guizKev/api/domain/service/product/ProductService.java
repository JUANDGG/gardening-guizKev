package com.guizKev.api.domain.service.product;
import java.util.List;
import java.util.Optional;

import com.guizKev.api.persistence.entity.Product;

public interface ProductService {
    List<Product> findProductsByRangeAndStock(String range, int quantity);
    List<Product> findProductsNotInOrders(Long orderId);
    List<Object[]> findProductsNotInOrdersWithDetails(Long orderId);
    Optional<Object[]> findMaxAndMinSalesPrice(String range);
    List<Object[]> findTopProductsByUnitsSold(String range);
}