package com.webstore.inventoryservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String productID;
    private boolean isInStock;

    @Override
    public String toString() {
        return "InventoryResponse{" +
                "productID='" + productID + '\'' +
                ", isInStock=" + isInStock +
                '}';
    }
}