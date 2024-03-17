package com.guizKev.api.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.product.ProductService;
import com.guizKev.api.persistence.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
      @Autowired
    private ProductService productService;

    @GetMapping("/ornamental")
    public List<Product> findOrnamentalProductsByStock() {
        return productService.findOrnamentalProductsByStock();
    }

    @GetMapping("/notInOrders")
    public List<Product> findProductsNotInOrders() {
        return productService.findProductsNotInOrders();
    }

    @GetMapping("/notInOrdersWithDetails")
    public List<Object[]> findProductsNotInOrdersWithDetails() {
        return productService.findProductsNotInOrdersWithDetails();
    }

    @GetMapping("/maxAndMinSalesPrice")
    public Optional<Object[]> findMaxAndMinSalesPrice() {
        return productService.findMaxAndMinSalesPrice();
    }

    @GetMapping("/top20ByUnitsSold")
    public List<Object[]> findTop20ProductsByUnitsSold() {
        return productService.findTop20ProductsByUnitsSold();
    }
}
