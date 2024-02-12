package com.webstore.orderservice.Service;

import com.webstore.orderservice.DTO.InventoryResponse;
import com.webstore.orderservice.DTO.OrderLineItemsDTO;
import com.webstore.orderservice.DTO.OrderRequest;
import com.webstore.orderservice.Entity.Order;
import com.webstore.orderservice.Entity.OrderLineItems;
import com.webstore.orderservice.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.UUID;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient webClient;
    private final WebClient.Builder webClientBuilder;


    public void createOrder(OrderRequest orderRequest){

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTOList()
                                                .stream()
                                                .map(orderLineItemsDTO -> mapOrderLineItemsDTOToOrderLineItems(orderLineItemsDTO)).toList();

        order.setOrderLineItemsList(orderLineItems);

        // List with the productIds of all the products of the Order
        List<String> listOfProductsIdsOfTheOrder =
                order.getOrderLineItemsList().stream().map(orderLineItem -> orderLineItem.getProductId()).toList();

        // Calls Inventory Service to check whether the product is in stock or not
        // Returns an Inventory Response Array with the products of the order that are in stock
        InventoryResponse[] productInStockArray = webClient.get()
                                                            .uri("http://localhost:8082/webstore/inventory?",
                                                               uriBuilder -> uriBuilder.queryParam("productId", listOfProductsIdsOfTheOrder).build())
                                                            .retrieve()
                                                            .bodyToMono(InventoryResponse[].class)
                                                            .block(); // asynchronous request

            // Only returns true if all products are in stock
        boolean allProductsOfTheOrderAreInStock = false;

        if (listOfProductsIdsOfTheOrder.size() == productInStockArray.length)
            allProductsOfTheOrderAreInStock = true;

        if (allProductsOfTheOrderAreInStock) {
            log.info("Order created: productId {} ", listOfProductsIdsOfTheOrder);
            orderRepository.save(order); // Save the Order into the database
        }
        else
            log.info("Order cancelled - Not all product(s) is(are) available in stock");
    }

    public OrderLineItems mapOrderLineItemsDTOToOrderLineItems(OrderLineItemsDTO orderLineItemsDTO){

        OrderLineItems orderLineItems = new OrderLineItems();

        orderLineItems.setId(orderLineItemsDTO.getId());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        orderLineItems.setProductId(orderLineItemsDTO.getProductId());

        return orderLineItems;
    }
}