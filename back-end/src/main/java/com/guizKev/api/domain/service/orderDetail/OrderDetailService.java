package com.guizKev.api.domain.service.orderDetail;

import java.util.List;



public interface OrderDetailService {
    List<Object[]> countDistinctProductsInEachOrder();
    
    List<Object[]> sumTotalQuantityOfProductsInEachOrder();
    
    Object[] calculateBilling();
    
    List<Object[]> calculateBillingByProduct();
    
    List<Object[]> calculateBillingByProductStartingWith();
    
    List<Object[]> calculateTotalSalesForProductsOver3000Euros();
}