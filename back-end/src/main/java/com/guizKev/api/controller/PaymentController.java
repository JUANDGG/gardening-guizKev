package com.guizKev.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.payment.PaymentService;
import com.guizKev.api.exeptions.ErrorResponses;
import com.guizKev.api.exeptions.NotFoundEndPoint;
import com.guizKev.api.persistence.entity.Payment;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/payment")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class PaymentController {
    @Autowired
    private PaymentService paymentService ;

    @GetMapping("/all")
    public List<Payment> getAllPayment(){
        return paymentService.getAllPayment();
    }

    //PERFECT
    @GetMapping("/year/{year}/paymentForm/{paymentForm}")
    public List<Payment> findPaymentsInYearWithPaymentForm(@PathVariable int year, @PathVariable String paymentForm) {
        return paymentService.findPaymentsInYearWithPaymentForm(year, paymentForm);
    }
    //PERFECT

    @GetMapping("/forms")
    public List<String> findAllPaymentForms() {
        return paymentService.findAllPaymentForms();
    }

    //PERFECT
    @GetMapping("/average/{year}")
    public Double findAveragePaymentInYear(@PathVariable int year) {
        return paymentService.findAveragePaymentInYear(year);
    }

    //PERFECT
    @GetMapping("/totalperyear")
    public List<Object[]> findTotalPaymentsPerYear() {
        return paymentService.findTotalPaymentsPerYear();
    }
    
   
}