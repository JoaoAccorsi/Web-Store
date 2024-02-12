package com.webstore.inventoryservice.Service;

import com.webstore.inventoryservice.DTO.InventoryResponse;
import com.webstore.inventoryservice.Entity.Inventory;
import com.webstore.inventoryservice.Repository.InventoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> allProductsIdsOfTheOrder){

        return inventoryRepository.findByProductIdIn(allProductsIdsOfTheOrder).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                                    .productID(inventory.getProductId())
                                    .isInStock(inventory.getQuantity() > 0)
                                    .build()
                ).toList();
    }
}