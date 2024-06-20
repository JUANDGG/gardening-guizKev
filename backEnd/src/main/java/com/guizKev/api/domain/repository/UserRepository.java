package com.guizKev.api.domain.repository ;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName); 
    Optional<User> findByPassword(String password);    
} 
