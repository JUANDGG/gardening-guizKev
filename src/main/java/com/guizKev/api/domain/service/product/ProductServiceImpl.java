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
    public List<Product> findProductsByRangeAndStock(String range, int quantity) {
        return productRepository.findProductsByRangeAndStock(range, quantity);
    }

    @Override
    public List<Product> findProductsNotInOrders(Long orderId) {
        return productRepository.findProductsNotInOrders(orderId);
    }

    @Override
    public List<Object[]> findProductsNotInOrdersWithDetails(Long orderId) {
        return productRepository.findProductsNotInOrdersWithDetails(orderId);
    }

    @Override
    public Optional<Object[]> findMaxAndMinSalesPrice(String range) {
        return productRepository.findMaxAndMinSalesPrice(range);
    }

    @Override
    public List<Object[]> findTopProductsByUnitsSold(String range) {
        return productRepository.findTopProductsByUnitsSold(range);
    }
}