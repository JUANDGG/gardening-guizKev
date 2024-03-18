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

    //ESTA MAL ESTA  NO DEBE TENER PARAMETRO
    //EXAMPLE :GET /products/notInOrders/{orderId}
    @GetMapping("/notInOrders/{orderId}")
    public List<Product> findProductsNotInOrders(@PathVariable Long orderId) {
        return productService.findProductsNotInOrders(orderId);
    }

    //ESTA MAL ESTA  NO DEBE TENER PARAMETRO
    //EXAMPLE :GET /products/notInOrdersWithDetails/{orderId} 
    @GetMapping("/notInOrdersWithDetails/{orderId}")
    public List<Object[]> findProductsNotInOrdersWithDetails(@PathVariable Long orderId) {
        return productService.findProductsNotInOrdersWithDetails(orderId);
    }


    //ESTA MAL ESTA  NO DEBE TENER PARAMETRO
    //EXAMPLE :GET /products/maxAndMinSalesPrice?range={range}
    @GetMapping("/maxAndMinSalesPrice")
    public Optional<Object[]> findMaxAndMinSalesPrice(@RequestParam String range) {
        return productService.findMaxAndMinSalesPrice(range);
    }

    //EXAMPLE :GET /products/topByUnitsSold?range={range}
    //ESTA MAL ESTA  NO DEBE TENER PARAMETRO
    @GetMapping("/topByUnitsSold")
    public List<Object[]> findTopProductsByUnitsSold(@RequestParam String range) {
        return productService.findTopProductsByUnitsSold(range);
    }
}