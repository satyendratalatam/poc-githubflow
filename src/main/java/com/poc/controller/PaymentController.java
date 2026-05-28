package com.poc.controller;

import com.poc.entity.Payment;
import com.poc.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment process(@RequestBody Payment payment) {
        return paymentService.process(payment);
    }
}
