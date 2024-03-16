package com.guizKev.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Payment;
import com.guizKev.api.persistence.entity.PaymentId;
@Repository
public interface PaymentRepository  extends JpaRepository<Payment ,PaymentId>{

    
} 
