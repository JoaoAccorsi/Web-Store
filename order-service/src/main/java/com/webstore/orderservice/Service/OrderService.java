package com.webstore.orderservice.Service;

import com.webstore.orderservice.DTO.OrderLineItemsDTO;
import com.webstore.orderservice.DTO.OrderRequest;
import com.webstore.orderservice.Entity.Order;
import com.webstore.orderservice.Entity.OrderLineItems;
import com.webstore.orderservice.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(OrderRequest orderRequest){

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTOList()
                                                .stream()
                                                .map(orderLineItemsDTO -> mapOrderLineItemsToOrderLineItemsDTO(orderLineItemsDTO)).toList();

        order.setOrderLineItemsList(orderLineItems);

            // Save the Order into the database
        orderRepository.save(order);
    }

    public OrderLineItems mapOrderLineItemsToOrderLineItemsDTO(OrderLineItemsDTO orderLineItemsDTO){

        OrderLineItems orderLineItems = new OrderLineItems();

        orderLineItems.setId(orderLineItemsDTO.getId());
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        orderLineItems.setProductNumber(orderLineItemsDTO.getProductNumber());

        return orderLineItems;
    }
}