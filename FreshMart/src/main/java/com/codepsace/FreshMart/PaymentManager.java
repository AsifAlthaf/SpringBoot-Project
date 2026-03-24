package com.codepsace.FreshMart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentManager {

    private PaymentService paymentService;

    @Autowired
    public PaymentManager(@Qualifier("netBankingPayment") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processPayment(double amount) {
        paymentService.pay(amount);
    }
}