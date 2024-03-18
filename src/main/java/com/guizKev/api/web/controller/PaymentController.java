package com.guizKev.api.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.payment.PaymentService;
import com.guizKev.api.persistence.entity.Payment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService ;

    @GetMapping("/all")
    public List<Payment> getAllPayment(){
        return paymentService.getAllPayment();
    }

    @GetMapping("/year/{year}/paymentForm/{paymentForm}")
    public List<Payment> findPaymentsInYearWithPaymentForm(@PathVariable int year, @PathVariable String paymentForm) {
        return paymentService.findPaymentsInYearWithPaymentForm(year, paymentForm);
    }

    @GetMapping("/forms")
    public List<String> findAllPaymentForms() {
        return paymentService.findAllPaymentForms();
    }

    @GetMapping("/average/{year}")
    public Double findAveragePaymentInYear(@PathVariable int year) {
        return paymentService.findAveragePaymentInYear(year);
    }

    @GetMapping("/totalperyear")
    public List<Object[]> findTotalPaymentsPerYear() {
        return paymentService.findTotalPaymentsPerYear();
    }
    
}