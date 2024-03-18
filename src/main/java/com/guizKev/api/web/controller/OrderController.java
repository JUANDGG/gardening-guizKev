package com.guizKev.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.order.OrderService;
import com.guizKev.api.persistence.entity.Order;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired 
    private OrderService orderService ;

    @GetMapping("/all")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder() ;
    }

    //PERFECT
    @GetMapping("/distinct-states")
    public List<String> findDistinctOrderStates() {
        return orderService.findDistinctOrderStates();
    }

    //PERFECT
    @GetMapping("/not-delivered-on-time")
    public List<Object[]> findOrdersNotDeliveredOnTime() {
        return orderService.findOrdersNotDeliveredOnTime();
    }


    //PERFECT EXAMPLE :http://localhost:8080/api/orders/delivered-days-before-expected/-2
    @GetMapping("/delivered-days-before-expected/{daysBefore}")
    public List<Object[]> findOrdersDeliveredDaysBeforeExpectedDate(@PathVariable int daysBefore) {
        return orderService.findOrdersDeliveredDaysBeforeExpectedDate(daysBefore);
    }


    //PERFECT
    @GetMapping("/rejected-in-year/{year}")
    public List<Object[]> findRejectedOrdersInYear(@PathVariable int year) {
        return orderService.findRejectedOrdersInYear(year);
    }

    //PERFECT
    @GetMapping("/delivered-in-month/{month}")
    public List<Object[]> findOrdersDeliveredInMonth(@PathVariable int month) {
        return orderService.findOrdersDeliveredInMonth(month);
    }

    //PERFECT
    @GetMapping("/count-by-state")
    public List<Object[]> countOrdersByState() {
        return orderService.countOrdersByState();
    }
}
