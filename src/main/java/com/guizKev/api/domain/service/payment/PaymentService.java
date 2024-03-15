package com.guizKev.api.domain.service.payment;

import java.util.List;

import com.guizKev.api.persistence.entity.Payment;

public interface  PaymentService {
    
    List<Payment> getAllPayment();
    
} 
