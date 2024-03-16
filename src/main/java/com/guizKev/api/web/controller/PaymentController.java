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
    
}
