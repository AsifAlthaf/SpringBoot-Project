package com.codepsace.FreshMart;

import org.springframework.stereotype.Service;

@Service("cardPayment")
public class CardPayment implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card");
    }
}