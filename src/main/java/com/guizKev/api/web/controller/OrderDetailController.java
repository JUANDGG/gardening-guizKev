package com.guizKev.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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




}
