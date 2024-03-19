package com.guizKev.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.orderDetail.OrderDetailService;


@RestController
@RequestMapping(value = "/orderDetail")
public class OrderDetailController {
    
    @Autowired
    private OrderDetailService  orderDetailService ;

    // REVISAR ESTA  ERROR DATOS INESACTOS
    @GetMapping("/distinct-products")
    public List<Object[]> countDistinctProductsInEachOrder() {
        return orderDetailService.countDistinctProductsInEachOrder();
    }

    // REVISAR ESTA  ERROR DATOS INESACTOS
    @GetMapping("/total-quantity")
    public List<Object[]> sumTotalQuantityOfProductsInEachOrder() {
        return orderDetailService.sumTotalQuantityOfProductsInEachOrder();
    }

    //PERFECT
    @GetMapping("/billing")
    public Object[] calculateBilling() {
        return orderDetailService.calculateBilling();
    }

    //PERFECT 147 ITEMS MORE
    @GetMapping("/billing-by-product")
    public List<Object[]> calculateBillingByProduct() {
        return orderDetailService.calculateBillingByProduct();
    }

    //PERFECT
    @GetMapping("/billing-by-product-starting-with")
    public List<Object[]> calculateBillingByProductStartingWith() {
        return orderDetailService.calculateBillingByProductStartingWith();
    }

    //PERFECT 9 ITEM OF 10
    @GetMapping("/total-sales-over-3000-euros")
    public List<Object[]> calculateTotalSalesForProductsOver3000Euros() {
        return orderDetailService.calculateTotalSalesForProductsOver3000Euros();
    }
}
    


