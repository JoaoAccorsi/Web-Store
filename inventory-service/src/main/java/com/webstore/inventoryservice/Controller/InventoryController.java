package com.webstore.inventoryservice.Controller;

import com.webstore.inventoryservice.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/inventory/{productNumber}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable String productNumber) {
        log.info("Inventory consulted");
        return inventoryService.isInStock(productNumber.trim());
    }
}