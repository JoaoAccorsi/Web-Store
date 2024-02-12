package com.webstore.inventoryservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String productId;
    private boolean isInStock;

    @Override
    public String toString() {
        return "InventoryResponse{" +
                "productID='" + productId + '\'' +
                ", isInStock=" + isInStock +
                '}';
    }
}