package com.guizKev.api.domain.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.OrderRepository;
import com.guizKev.api.persistence.entity.Order;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired

    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
    
}
