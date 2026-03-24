package com.codepsace.FreshMart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FreshMartApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FreshMartApplication.class, args);
		ApplicationContext context = SpringApplication.run(FreshMartApplication.class, args);
        PaymentManager manager = context.getBean(PaymentManager.class);
        manager.processPayment(5000);
	}
}
