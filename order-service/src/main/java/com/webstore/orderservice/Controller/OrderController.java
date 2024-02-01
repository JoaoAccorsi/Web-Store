package com.webstore.orderservice.Controller;

import com.webstore.orderservice.DTO.OrderRequest;
import com.webstore.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Order created");
        orderService.createOrder(orderRequest);
        return "Order Created Successfully";
    }
}