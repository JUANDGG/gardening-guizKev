package com.guizKev.api.domain.service.order;

import java.util.List;

import com.guizKev.api.persistence.entity.Order;



public interface OrderService {
    List<Order> getAllOrder();
}
