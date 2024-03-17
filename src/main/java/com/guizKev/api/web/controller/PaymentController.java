package com.guizKev.api.web.controller;

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

    @GetMapping("/year2008/paypal")
    public List<Payment> findPaymentsInYear2008WithPayPal() {
        return paymentService.findPaymentsInYear2008WithPayPal();
    }

    @GetMapping("/forms")
    public List<String> findAllPaymentForms() {
        return paymentService.findAllPaymentForms();
    }

    @GetMapping("/average/2009")
    public Double findAveragePaymentInYear2009() {
        return paymentService.findAveragePaymentInYear2009();
    }

    @GetMapping("/totalperyear")
    public List<Object[]> findTotalPaymentsPerYear() {
        return paymentService.findTotalPaymentsPerYear();
    }
    
}
