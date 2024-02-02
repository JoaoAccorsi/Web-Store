package com.webstore.orderservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDTO {
    private Long id;
    private String productNumber;
    private String price;
    private Integer quantity;
}