package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Payment;
import com.guizKev.api.persistence.entity.PaymentId;
@Repository
public interface PaymentRepository  extends JpaRepository<Payment ,PaymentId>{
    // 1. Retrieve a list of all payments made in a specific year via a specific payment form, ordered from highest to lowest.
    @Query("SELECT p FROM Payment p WHERE YEAR(p.paymentDate) = :year AND lower(p.paymentForm) = lower(:paymentForm) ORDER BY p.total DESC")
    List<Payment> findPaymentsInYearWithPaymentForm(@Param("year") int year, @Param("paymentForm") String paymentForm);

    // 2. Retrieve a list of all payment methods available in the payment table, without repeating payment methods.
    @Query("SELECT DISTINCT p.paymentForm FROM Payment p")
    List<String> findAllPaymentForms();

    // 3. What was the average payment in a specific year?
    @Query("SELECT AVG(p.total) FROM Payment p WHERE YEAR(p.paymentDate) = :year")
    Double findAveragePaymentInYear(@Param("year") int year);

    // 4. Display the total sum of all payments made for each of the years present in the payment table.
    @Query("SELECT YEAR(p.paymentDate) AS year, SUM(p.total) AS totalSum FROM Payment p GROUP BY YEAR(p.paymentDate) ORDER BY YEAR(p.paymentDate)")
    List<Object[]> findTotalPaymentsPerYear();
    
} 
