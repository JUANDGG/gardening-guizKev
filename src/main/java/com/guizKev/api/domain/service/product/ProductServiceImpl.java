package com.guizKev.api.domain.service.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.ProductRepository;
import com.guizKev.api.persistence.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

 

    @Override
    public List<Product> findProductsByRangeAndStock(String range, int quantity) {
        return productRepository.findProductsByRangeAndStock(range, quantity);
    }

    @Override
    public List<Product> findProductsWithoutOrderDetails() {
        return productRepository.findProductsWithoutOrderDetails();
    }

    @Override
    public List<Object[]> findProductsNotInOrderDetails() {
        return productRepository.findProductsNotInOrderDetails();
    }

    @Override
    public Object[] findMaxAndMinPrice() {
        return productRepository.findMaxAndMinPrice();
    }

    @Override
    public List<Object[]> findTop20BestSellingProducts() {
        return productRepository.findTop20BestSellingProducts();
    }
}