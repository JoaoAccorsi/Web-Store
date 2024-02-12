package com.webstore.orderservice.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient webClient(){
        // Create a bean of type WebClient and defines its name as webClient
        return WebClient.builder().build();
    }
}