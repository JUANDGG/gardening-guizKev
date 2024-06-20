package com.guizKev.api.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.ProductRange;
@Repository
public  interface ProductRangeRepository extends JpaRepository<ProductRange ,String> {
     
}
