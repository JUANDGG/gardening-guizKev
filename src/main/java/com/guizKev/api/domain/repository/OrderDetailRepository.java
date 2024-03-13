package com.guizKev.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.OrderDetail;
import com.guizKev.api.persistence.entity.OrderDetailId;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>{
    
} 
