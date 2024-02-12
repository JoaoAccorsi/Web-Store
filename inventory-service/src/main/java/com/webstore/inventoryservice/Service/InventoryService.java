package com.webstore.inventoryservice.Service;

import com.webstore.inventoryservice.DTO.InventoryResponse;
import com.webstore.inventoryservice.Entity.Inventory;
import com.webstore.inventoryservice.Repository.InventoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> allProductsIdsOfTheOrder){

        List<Inventory> allProductsAvailableInStock = inventoryRepository.findAll();

        List<InventoryResponse> allProductsAvailableInStockInventoryResponse = convertInventoryToInventoryResponse(allProductsAvailableInStock);

        List<InventoryResponse> productsOfTheOrderAvailableInStock = new ArrayList<>();

            // Returns one ProductResponse List with the products of the Order in format {productId = 6, isInStock = true}
        for (int i = 0; i < allProductsAvailableInStockInventoryResponse.size(); i ++){
            for (int j = 0; j < allProductsIdsOfTheOrder.size(); j ++) {
                if (allProductsAvailableInStockInventoryResponse.get(i).getProductId().equals(allProductsIdsOfTheOrder.get(j)))
                    productsOfTheOrderAvailableInStock.add(allProductsAvailableInStockInventoryResponse.get(i));
            }
        }
        return productsOfTheOrderAvailableInStock;
    }

    public List<InventoryResponse> convertInventoryToInventoryResponse(List<Inventory> InventoryList){

        return InventoryList.stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .productId(inventory.getProductId())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}