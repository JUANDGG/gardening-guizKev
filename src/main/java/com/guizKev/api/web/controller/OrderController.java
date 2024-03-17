package com.guizKev.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.order.OrderService;
import com.guizKev.api.persistence.entity.Order;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired 
    private OrderService orderService ;

    @GetMapping("/all")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder() ;
    }

    
    @GetMapping("/distinct-states")
    public List<String> findDistinctOrderStates() {
        return orderService.findDistinctOrderStates();
    }

    @GetMapping("/not-delivered-on-time")
    public List<Object[]> findOrdersNotDeliveredOnTime() {
        return orderService.findOrdersNotDeliveredOnTime();
    }

    @GetMapping("/delivered-two-days-before-expected-date")
    public List<Object[]> findOrdersDeliveredTwoDaysBeforeExpectedDate() {
        return orderService.findOrdersDeliveredTwoDaysBeforeExpectedDate();
    }

    @GetMapping("/rejected-in-2009")
    public List<Object[]> findRejectedOrdersIn2009() {
        return orderService.findRejectedOrdersIn2009();
    }

    @GetMapping("/delivered-in-january")
    public List<Object[]> findOrdersDeliveredInJanuary() {
        return orderService.findOrdersDeliveredInJanuary();
    }

    @GetMapping("/count-by-state")
    public List<Object[]> countOrdersByState() {
        return orderService.countOrdersByState();
    }

}
