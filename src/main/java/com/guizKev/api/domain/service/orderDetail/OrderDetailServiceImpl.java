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
    
    @Override
    public List<Object[]> countDistinctProductsInEachOrder() {
        return orderDetailRepository.countDistinctProductsInEachOrder();
    }

    @Override
    public List<Object[]> sumTotalQuantityOfProductsInEachOrder() {
        return orderDetailRepository.sumTotalQuantityOfProductsInEachOrder();
    }

    /*
    
    @Override
    public Object[] calculateBilling() {
        return orderDetailRepository.calculateBilling();
    }
    */

    /* 
    @Override
    public List<Object[]> calculateBillingByProduct() {
        return orderDetailRepository.calculateBillingByProduct();
    }

    */

    /*
    @Override
    public List<Object[]> calculateBillingByProductStartingWith() {
        return orderDetailRepository.calculateBillingByProductStartingWith();
    }

    


    @Override
    public List<Object[]> calculateTotalSalesForProductsOver3000Euros() {
        return orderDetailRepository.calculateTotalSalesForProductsOver3000Euros();
    }

    */
    
}
