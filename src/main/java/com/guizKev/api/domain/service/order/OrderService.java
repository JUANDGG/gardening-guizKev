package com.guizKev.api.domain.service.order;

import java.util.List;

import com.guizKev.api.persistence.entity.Order;



public interface OrderService {
    List<Order> getAllOrder();
    List<String> findDistinctOrderStates();
    List<Object[]> findOrdersNotDeliveredOnTime();
    List<Object[]> findOrdersDeliveredDaysBeforeExpectedDate(int daysBefore);
    List<Object[]> findRejectedOrdersInYear(int year);
    List<Object[]> findOrdersDeliveredInMonth(int month);
    List<Object[]> countOrdersByState();
}
