package com.webstore.inventoryservice.Repository;

import com.webstore.inventoryservice.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    List<Inventory> findAll();

}