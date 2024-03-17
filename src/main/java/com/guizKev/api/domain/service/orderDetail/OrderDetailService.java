package com.guizKev.api.domain.service.orderDetail;

import java.util.List;

import com.guizKev.api.persistence.entity.OrderDetail;

public interface OrderDetailService {
    List<OrderDetail> getAllOrder ();
    List<Object[]> countDistinctProductsInEachOrder();
    List<Object[]> sumTotalQuantityOfProductsInEachOrder();
    //Object[] calculateBilling();
    //List<Object[]> calculateBillingByProduct();
    //List<Object[]> calculateBillingByProductStartingWith();
    //List<Object[]> calculateTotalSalesForProductsOver3000Euros();
} 