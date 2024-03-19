package com.guizKev.api.domain.service.product;
import java.util.List;


import com.guizKev.api.persistence.entity.Product;

public interface ProductService {
    List<Product> findProductsByRangeAndStock(String range, int quantity);
    List<Product> findProductsWithoutOrderDetails();
    // List<Object[]> findProductsNotInOrderDetails();
    // Object[] findMaxAndMinPrice();
    // List<Object[]> findTop20BestSellingProducts();
}