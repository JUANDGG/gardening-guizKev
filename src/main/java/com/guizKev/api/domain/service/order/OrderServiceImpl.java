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
    public List<Object[]> findOrdersDeliveredDaysBeforeExpectedDate(int daysBefore) {
        return orderRepository.findOrdersDeliveredDaysBeforeExpectedDate(daysBefore);
    }

    @Override
    public List<Object[]> findRejectedOrdersInYear(int year) {
        return orderRepository.findRejectedOrdersInYear(year);
    }

    @Override
    public List<Object[]> findOrdersDeliveredInMonth(int month) {
        return orderRepository.findOrdersDeliveredInMonth(month);
    }

    @Override
    public List<Object[]> countOrdersByState() {
        return orderRepository.countOrdersByState();
    }
}
