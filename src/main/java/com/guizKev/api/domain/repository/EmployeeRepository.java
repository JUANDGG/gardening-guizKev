package com.guizKev.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer>{

    
} 
