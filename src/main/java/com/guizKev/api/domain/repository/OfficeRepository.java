package com.guizKev.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Office;
@Repository
public interface OfficeRepository  extends JpaRepository<Office ,String>{

    
}
