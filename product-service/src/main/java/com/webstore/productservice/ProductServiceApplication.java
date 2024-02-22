package com.webstore.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages = "com.webstore.productservice.Controller.ProductController")
@ComponentScan("com.webstore.productservice")
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}