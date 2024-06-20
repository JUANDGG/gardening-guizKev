package com.guizKev.api.domain.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.PaymentRepository;
import com.guizKev.api.persistence.entity.Payment;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> findPaymentsInYearWithPaymentForm(int year, String paymentForm) {
        return paymentRepository.findPaymentsInYearWithPaymentForm(year, paymentForm);
    }

    @Override
    public List<String> findAllPaymentForms() {
        return paymentRepository.findAllPaymentForms();
    }

    @Override
    public Double findAveragePaymentInYear(int year) {
        return paymentRepository.findAveragePaymentInYear(year);
    }

    @Override
    public List<Object[]> findTotalPaymentsPerYear() {
        return paymentRepository.findTotalPaymentsPerYear();
    }
}