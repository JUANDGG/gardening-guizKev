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
    
    @Override
    public List<String> findDistinctOrderStates() {
        return orderRepository.findDistinctOrderStates();
    }

    @Override
    public List<Object[]> findOrdersNotDeliveredOnTime() {
        return orderRepository.findOrdersNotDeliveredOnTime();
    }

    @Override
    public List<Object[]> findOrdersDeliveredTwoDaysBeforeExpectedDate() {
        return orderRepository.findOrdersDeliveredTwoDaysBeforeExpectedDate();
    }

    @Override
    public List<Object[]> findRejectedOrdersIn2009() {
        return orderRepository.findRejectedOrdersIn2009();
    }

    @Override
    public List<Object[]> findOrdersDeliveredInJanuary() {
        return orderRepository.findOrdersDeliveredInJanuary();
    }

    @Override
    public List<Object[]> countOrdersByState() {
        return orderRepository.countOrdersByState();
    }
}
