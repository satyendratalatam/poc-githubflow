package com.poc.service;

import com.poc.entity.Payment;
import com.poc.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment process(Payment payment) {
        payment.setStatus("PROCESSED");
        return paymentRepository.save(payment);
    }
}
