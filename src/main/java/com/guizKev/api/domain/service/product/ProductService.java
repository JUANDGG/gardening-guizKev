package com.guizKev.api.domain.service.product;
import java.util.List;
import java.util.Optional;

import com.guizKev.api.persistence.entity.Product;

public interface ProductService {
    List<Product> findOrnamentalProductsByStock();
    List<Product> findProductsNotInOrders();
    List<Object[]> findProductsNotInOrdersWithDetails();
    Optional<Object[]> findMaxAndMinSalesPrice();
    List<Object[]> findTop20ProductsByUnitsSold();
}