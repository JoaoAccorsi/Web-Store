package com.webstore.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages = "com.webstore.orderservice.Controller.OrderController")
@SpringBootApplication // (scanBasePackages = "com.webstore.orderservice.Controller.OrderController")
@ComponentScan("com.webstore.orderservice")
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}