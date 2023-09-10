package com.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class ShoppingCartPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartPaymentServiceApplication.class, args);
	}

}
