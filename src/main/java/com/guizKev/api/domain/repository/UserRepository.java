package com.guizKev.api.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.guizKev.api.persistence.entity.User;
import java.util.List;




public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); 
    Optional<User> findByPasswordHash(String passwordHash);    
} 
