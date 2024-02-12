package com.webstore.inventoryservice.Entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "web_store_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String productTile;
    private Integer quantity;

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productTile='" + productTile + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}