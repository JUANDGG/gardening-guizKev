package com.guizKev.api.domain.service.order;

import java.util.List;

import com.guizKev.api.persistence.entity.Order;



public interface OrderService {
    List<Order> getAllOrder();
    List<String> findDistinctOrderStates();
    List<Object[]> findOrdersNotDeliveredOnTime();
    List<Object[]> findOrdersDeliveredTwoDaysBeforeExpectedDate();
    List<Object[]> findRejectedOrdersIn2009();
    List<Object[]> findOrdersDeliveredInJanuary();
    List<Object[]> countOrdersByState();
}
