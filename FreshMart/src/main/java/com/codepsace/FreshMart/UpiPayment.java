package com.codepsace.FreshMart;

import org.springframework.stereotype.Service;

@Service
public class UpiPayment implements PaymentService {
    public void pay(double amount) {
        System.out.println("Paid using UPI");
    }
}