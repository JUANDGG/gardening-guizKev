package com.guizKev.api.domain.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.ProductRepository;
import com.guizKev.api.persistence.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findOrnamentalProductsByStock() {
        return productRepository.findOrnamentalProductsByStock();
    }

    @Override
    public List<Product> findProductsNotInOrders() {
        return productRepository.findProductsNotInOrders();
    }

    @Override
    public List<Object[]> findProductsNotInOrdersWithDetails() {
        return productRepository.findProductsNotInOrdersWithDetails();
    }

    @Override
    public Optional<Object[]> findMaxAndMinSalesPrice() {
        return productRepository.findMaxAndMinSalesPrice();
    }

    @Override
    public List<Object[]> findTop20ProductsByUnitsSold() {
        return productRepository.findTop20ProductsByUnitsSold();
    }
}