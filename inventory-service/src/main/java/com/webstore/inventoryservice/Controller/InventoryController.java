package com.webstore.inventoryservice.Controller;

import com.webstore.inventoryservice.DTO.InventoryResponse;
import com.webstore.inventoryservice.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webstore/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/webstore/inventory?productId=4&productId=12
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam (name = "productId") List<String> allProductsIdsOfTheOrder) {
            log.info("Inventory check request for productId: {}", allProductsIdsOfTheOrder);
        return inventoryService.isInStock(allProductsIdsOfTheOrder);
    }
}