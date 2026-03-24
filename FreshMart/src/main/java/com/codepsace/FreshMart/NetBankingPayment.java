package com.codepsace.FreshMart;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("netBankingPayment")
public class NetBankingPayment implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using NetBanking");
    }
}