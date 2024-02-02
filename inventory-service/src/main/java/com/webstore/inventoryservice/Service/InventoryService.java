package com.webstore.inventoryservice.Service;

import com.webstore.inventoryservice.Entity.Inventory;
import com.webstore.inventoryservice.Repository.InventoryRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String productNumber){
        List<Inventory> inventoryAll = inventoryRepository.findAll();

        for (int i = 0; i < inventoryAll.size(); i ++)
            if (productNumber.trim().equals(inventoryAll.get(i).getProductNumber().trim()))
                return true;
        return false;
    }
}