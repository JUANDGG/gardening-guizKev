package com.guizKev.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.orderDetail.OrderDetailService;
import com.guizKev.api.persistence.entity.OrderDetail;

@RestController
@RequestMapping(value = "/orderDetail")
public class OrderDetailController {
    
    @Autowired
    private OrderDetailService  orderDetailService ;


    @GetMapping("/all")
    public List<OrderDetail> getAllOrder(){
        return orderDetailService.getAllOrder() ;
    }


      @GetMapping("/distinct-products")
    public List<Object[]> countDistinctProductsInEachOrder() {
        return orderDetailService.countDistinctProductsInEachOrder();
    }

    @GetMapping("/total-quantity")
    public List<Object[]> sumTotalQuantityOfProductsInEachOrder() {
        return orderDetailService.sumTotalQuantityOfProductsInEachOrder();
    }

    /*

    @GetMapping("/total-billing")
    public Object[] calculateBilling() {
        return orderDetailService.calculateBilling();
    }

    */

    /* 
    @GetMapping("/billing-by-product")
    public List<Object[]> calculateBillingByProduct() {
        return orderDetailService.calculateBillingByProduct();
    }

    */


    /* 
    
    @GetMapping("/billing-by-product")
    public List<Object[]> calculateBillingByProductStartingWith() {
        return orderDetailService.calculateBillingByProductStartingWith();
    }

    @GetMapping("/total-sales-over-3000")
    public List<Object[]> calculateTotalSalesForProductsOver3000Euros() {
        return orderDetailService.calculateTotalSalesForProductsOver3000Euros();
    }

    */

}
