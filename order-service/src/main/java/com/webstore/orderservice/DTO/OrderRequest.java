package com.webstore.orderservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDTO> orderLineItemsDTOList;

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderLineItemsDTOList=" + orderLineItemsDTOList +
                '}';
    }
}