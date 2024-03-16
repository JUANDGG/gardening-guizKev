package com.guizKev.api.domain.service.orderDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.OrderDetailRepository;
import com.guizKev.api.persistence.entity.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    private OrderDetailRepository  orderDetailRepository ;

    @Override
    public List<OrderDetail> getAllOrder() {
        return orderDetailRepository.findAll();
    }
    
}
