package com.guizKev.api.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.product.ProductService;
import com.guizKev.api.persistence.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //PERFECT
    //EXAMPLE :GET /products/byRangeAndStock?range={range}&quantity={quantity}
    @GetMapping("/byRangeAndStock")
    public List<Product> findProductsByRangeAndStock(@RequestParam String range, @RequestParam int quantity) {
        return productService.findProductsByRangeAndStock(range, quantity);
    }

    ////////////NOTA ERROR MASIVO EN LAS QUERIS POR FAVOR REVISAR////////////////

    @GetMapping("/notInOrders")
    public List<Product> findProductsNotInOrders() {
        return productService.findProductsWithoutOrderDetails();
    }

    @GetMapping("/notInOrdersWithDetails")
    public List<Object[]> findProductsNotInOrdersWithDetails() {
        return productService.findProductsNotInOrderDetails();
    }

    @GetMapping("/maxAndMinSalesPrice")
    public Object[] findMaxAndMinSalesPrice(@RequestParam String range) {
        return productService.findMaxAndMinPrice();
    }

    @GetMapping("/topByUnitsSold")
    public List<Object[]> findTopProductsByUnitsSold(@RequestParam String range) {
        return productService.findTop20BestSellingProducts();
    }
}