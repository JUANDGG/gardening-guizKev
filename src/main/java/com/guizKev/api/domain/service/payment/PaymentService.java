package com.guizKev.api.domain.service.payment;

import java.util.List;

import com.guizKev.api.persistence.entity.Payment;

public interface  PaymentService {
    
    List<Payment> getAllPayment();
    List<Payment> findPaymentsInYear2008WithPayPal();
    List<String> findAllPaymentForms();
    Double findAveragePaymentInYear2009();
    List<Object[]> findTotalPaymentsPerYear();
    
} 
