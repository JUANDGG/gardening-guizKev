package com.guizKev.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order ,Integer>{

    
}
